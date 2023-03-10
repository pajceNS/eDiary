package com.eDiary.services;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface FileHandlerService {
	public String singeFileUpload(MultipartFile file, RedirectAttributes redirectAttributes);
}
