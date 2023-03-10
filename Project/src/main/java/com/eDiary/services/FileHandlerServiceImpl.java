package com.eDiary.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class FileHandlerServiceImpl implements FileHandlerService {

	// Save the uploaded file to this folder
	private static String UPLOAD_DIRECTORY = "C:\\temp\\";
	// importujemo org.slf4j
	// napravimo novi loger i vezu za klasu
	private final Logger logger = LoggerFactory.getLogger(FileHandlerServiceImpl.class);

	// legacy nacin
	@Override
	public String singeFileUpload(MultipartFile file, RedirectAttributes redirectAttributes) {
		// 1. is file is empty, go to uploadStatus with error message
		// System.out.println("SingleFileUpload method invoked" +
		// file.getOriginalFilename());
		logger.info("SingleFileUpload method invoked" + file.getOriginalFilename());

		if (file.isEmpty()) {
			// korisnik je uploadovao prazan file?
			logger.warn("User uploaded an empty file");
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
			return "redirect:uploadStatus";
			// reci browseru da te redirektuje na stranicu uploadStatus
		}

		// 2. if file is not empty, save file to Upload DIR
		try {
			// file = niz bajtova, snimiti na disk
			byte[] bytes = file.getBytes();

			// putanja u koju upisemo niz bajtova
			Path path = Paths.get(UPLOAD_DIRECTORY + file.getOriginalFilename()); // regex
			// Paths utility method, class, Files also

			// utility class Files, sacuvamo niz bajtova
			Files.write(path, bytes);
			logger.info("File uploaded and stored successfully");
			redirectAttributes.addFlashAttribute("message",
					"You have successfully uploaded " + file.getOriginalFilename());

		} catch (IOException e) {
			// Auto-generated catch block
			logger.error("An exception ocurred while uploading a file.");
			e.printStackTrace();
		}

		// 3. go to uploadStatus and show success message
		return "redirect:uploadStatus";
	}
}
