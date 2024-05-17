//package com.ssafy.alcohol.controller;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import jakarta.annotation.PostConstruct;
//
//@Controller
//public class FileUploadController {
//
//	@Value("${file.upload-dir}")
//	private String uploadDir;
//
//	private final Path rootLocation = Path.get(uploadDir);
//
//	@PostConstruct
//	public void init() {
//		try {
//			Files.createDirectories(rootLocation);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@PoatMapping("")
//	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttrivutes) {
//		String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//		try {
//			Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//
//		redirectAttrivutes.addFlashAttribute("message", "successfully uploaded" + file.getOriginalFilename() + "!");
//
//		return "redirect:/";
//	}
//
//	@GetMapping("files/{filename:.+}")
//	@ResponseBody
//	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//		try {
//			Path file = rootLocation.resolve(filename);
//			Resource resource = new UrlResource(file.toUri());
//
//			if (resource.exists() || resource.isReadable()) {
//				return ResponseEntity.ok()
//						.header(HttpHeaders.CONTENT_DISPOSITION, "; filename = \"" + resource.getFilename() + "\"")
//						.body(resource);
//			} else {
//				throw new RuntimeException("Can not read file : " + filename);
//			}
//		} catch (MalformedURLException e) {
//			throw new RuntimeException("Can not read file : " + filename);
//		}
//	}
//
//}
