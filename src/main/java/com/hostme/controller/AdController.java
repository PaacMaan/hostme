/**
 * 
 */
package com.hostme.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostme.entities.Ad;
import com.hostme.entities.Categorie;
import com.hostme.entities.Photo;
import com.hostme.entities.User;
import com.hostme.service.interfac.AdService;
import com.hostme.service.interfac.CategorieService;
import com.hostme.validator.AdValidator;

/**
 * @author rmidi
 *
 */
@Controller
@SessionAttributes("adCategory")
public class AdController {
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private AdValidator adValidator;
	
	@RequestMapping(value="/add_ad", method=RequestMethod.GET)
	public String getAddAd(Model model) {
		model.addAttribute("ad", new Ad());
		model.addAttribute("whatToDo", "Add New Ad");
		return "add_ad";
	}
	
	@RequestMapping(value="/myads", method=RequestMethod.GET)
	public String getMyAds(Model model, @RequestParam(required = false) Integer page) {
		List<Ad> my_ads = adService.getMyAds();
		/*create the pagination object*/
		PagedListHolder<Ad> pagedListHolder = new PagedListHolder<>(my_ads);
		pagedListHolder.setPageSize(2);
		/*set the max page value and the page parameter*/
		model.addAttribute("maxPages", pagedListHolder.getPageCount());
		model.addAttribute("page",page);
		/*pagination logic*/
		if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addAttribute("ads_list", pagedListHolder.getPageList());
        }else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            model.addAttribute("ads_list", pagedListHolder.getPageList());
        }
		return "myads";
	}
	
	@ModelAttribute("adCategory")
	public List<Categorie> getAdCategory(){
		return new LinkedList<>(categorieService.findAllCategories());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/add_ad", method=RequestMethod.POST)
	public String addAd(@Valid @ModelAttribute("ad") Ad ad, BindingResult bindingResult, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		/*validate the ad fields*/
		adValidator.validate(ad, bindingResult);
		/*if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError());
			model.addAttribute("whatToDo", "Correct your Ad");
			return "add_ad";
		}*/
		/*creating the photos list object to embed it in ad*/
		List<String> pics  = (List<String>) request.getSession().getAttribute("pics");
		List<Photo> photos = new ArrayList<>();
		for (int i = 0; i < pics.size(); i++) {
			Photo p = new Photo();
			p.setUrl(pics.get(i).toString());
			p.setAd(ad);
			photos.add(p);
		}
		ad.setPhotos(photos);
		/*save the ad object*/
		adService.saveAd(ad);
		redirectAttributes.addFlashAttribute("addingMessage", "<strong>Done !</strong> Your ad will be listed once it is validated by our moderators");
		request.getSession().setAttribute("pics", null);
		return "redirect:/myads";
	}
	
	@RequestMapping(value="/ad/{id_ad}", method=RequestMethod.GET)
	public String getSingleAd(@PathVariable("id_ad") Long id_ad, Model model) {
		Ad ad = adService.findAdById(id_ad);
		if(ad == null) {
			return "redirect:/myads";
		}
		model.addAttribute("ad", ad);
		return "ad";
	}
	
	@RequestMapping(value="/edit_ad/{id_ad}", method=RequestMethod.GET)
	public String getUpdateAd(@PathVariable("id_ad") Long id_ad, Model model) {
		model.addAttribute("ad", adService.findAdById(id_ad));
		model.addAttribute("whatToDo", "Edit your Ad");
		return "add_ad";
	}
	
	@RequestMapping(value="/edit_ad/{id_ad}", method=RequestMethod.POST)
	public String doUpdateAd(@PathVariable("id_ad") Long id_ad, @Valid @ModelAttribute("ad") Ad ad, BindingResult bindingResult) {
		return null;
	}
	
	@RequestMapping(value="/delete_ad/{id_ad}", method=RequestMethod.GET)
	public String doDeleteAd(@PathVariable("id_ad") Long id_ad, RedirectAttributes redirectAttributes) {
		Ad ad = adService.findAdById(id_ad);
		if (ad == null) {
			redirectAttributes.addFlashAttribute("alert", "alert-danger");
			redirectAttributes.addFlashAttribute("messageDelete","<strong>Oops !</strong> no Ad founded with that id");
			return "redirect:/myads";
		}else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			User u = (User) userDetail;
			if (ad.getPublisher().getId_user() == u.getId_user()) {
				adService.deleteAdById(id_ad);
				redirectAttributes.addFlashAttribute("alert", "alert-success");
				redirectAttributes.addFlashAttribute("messageDelete", "<strong>Done !</strong> Ad deleted succesfully");
				return "redirect:/myads";
			}else {
				redirectAttributes.addFlashAttribute("alert", "alert-info");
				redirectAttributes.addFlashAttribute("messageDelete", "<strong>Opps !</strong> you are not the owner of the ad");
				return "redirect:/myads";
			}
		}
		
	}
	
	@RequestMapping(value = "/search/allads/", method=RequestMethod.GET)
	public String searchAllAdsBylocation(@RequestParam("location") String location, Model model, @RequestParam(required = false) Integer page) {
		List<Ad> ads = adService.getAdsByPropertyLocation(location);
		//model.addAttribute("ads_list", ads)
		model.addAttribute("location", location);
		/*create the pagination object*/
		PagedListHolder<Ad> pagedListHolder = new PagedListHolder<>(ads);
		pagedListHolder.setPageSize(2);
		/*set the max page value and the page parameter*/
		model.addAttribute("maxPages", pagedListHolder.getPageCount());
		model.addAttribute("page",page);
		/*pagination logic*/
		if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addAttribute("ads_list", pagedListHolder.getPageList());
        }else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            model.addAttribute("ads_list", pagedListHolder.getPageList());
        }
		return "list_ads";
	}
	
}
