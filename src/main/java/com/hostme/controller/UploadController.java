package com.hostme.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {
	
	private static String UPLOADED_FOLDER = "/home/rmidi/eclipse-workspace/hostMe/src/main/resources/static/upload/";
	public List<String> fileNames = new ArrayList<String>();
	
	private JSONObject getSuccessMessage() {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject("{\"success\":true}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	private JSONObject getErrorMessage() {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject("{\"success\":false}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody public Object uploadedFiles(@RequestParam("photos") MultipartFile[] uploadedFiles, HttpServletRequest request) {
		try {
			for (MultipartFile uploadedFile : uploadedFiles) {
				  File file = new File(UPLOADED_FOLDER + uploadedFile.getOriginalFilename());
				  BufferedOutputStream stream =
					        new BufferedOutputStream(new FileOutputStream(file));
				  stream.write(uploadedFile.getBytes());
				  fileNames.add(uploadedFile.getOriginalFilename());
				  stream.close();
			 }
			request.getSession().setAttribute("pics", fileNames);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return getErrorMessage().toString();
	  }
	  return getSuccessMessage().toString();
	} 

}
