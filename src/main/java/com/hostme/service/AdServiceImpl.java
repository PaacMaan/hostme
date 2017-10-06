/**
 * 
 */
package com.hostme.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostme.entities.Ad;
import com.hostme.entities.User;
import com.hostme.repository.AdRepository;
import com.hostme.service.interfac.AdService;

/**
 * @author rmidi
 *
 */
@Service("adService")
@Transactional
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdRepository adRepository;
		
	/* (non-Javadoc)
	 * @see com.hostme.service.interfac.AdService#findAdById(java.lang.Long)
	 */
	@Override
	public Ad findAdById(Long id) {
		return adRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.hostme.service.interfac.AdService#findAdsByLocation(java.lang.String)
	 */
	@Override
	public List<Ad> findAdsByLocation(String location) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hostme.service.interfac.AdService#saveAd(com.hostme.entities.Ad)
	 */
	@Override
	public void saveAd(Ad ad) {
		/*set the publication date*/
		ad.setDate_pub(new Date());
		/*set the ad publisher from the session provided by spring security*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		ad.setPublisher((User) userDetail);
		/*save the ad*/
		System.out.println(ad);
		adRepository.save(ad);
	}

	/* (non-Javadoc)
	 * @see com.hostme.service.interfac.AdService#updateAd(com.hostme.entities.Ad)
	 */
	@Override
	public void updateAd(Ad ad) {
		saveAd(ad);
	}

	/* (non-Javadoc)
	 * @see com.hostme.service.interfac.AdService#deleteAdById(java.lang.Long)
	 */
	@Override
	public void deleteAdById(Long id) {
		adRepository.delete(id);
	}

	@Override
	public List<Ad> getMyAds() {
		/*set the ad publisher from the session provided by spring security*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		return adRepository.findAdsByPublisherUsername(userDetail.getUsername());
	}

	@Override
	public List<Ad> getAdsByPropertyLocation(String location) {
		return adRepository.findByPropertyVilleContainingIgnoreCase(location);
	}

	@Override
	public Page<Ad> getAllAds(int forPage, int withPageSize) {
		return adRepository.findAll(new PageRequest(forPage, withPageSize));
	}

	@Override
	public long getAllCount() {
		return adRepository.count();
	}
	
}
