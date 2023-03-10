package com.eDiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eDiary.services.FileHandlerService;

@Controller
@RequestMapping(path = "/")
public class UploadController {

	@Autowired
	private FileHandlerService fileHandlerService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "upload";
		// ko posalje get na root "/", dobija upload datoteku
	}

	@RequestMapping(method = RequestMethod.GET, path = "/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		return fileHandlerService.singeFileUpload(file, redirectAttributes);
		// pozovemo service i vratimo poruku
	}
}
