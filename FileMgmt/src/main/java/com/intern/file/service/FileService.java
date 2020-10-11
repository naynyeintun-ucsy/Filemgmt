package com.intern.file.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.intern.file.constant.GlobalConstant;

@Service
public class FileService {
	Logger logger = org.slf4j.LoggerFactory.getLogger(FileService.class);
	
	   public String getFolderPath(String location) {

	        StringBuilder path = new StringBuilder();
	        // root folder: upload
	        path.append(GlobalConstant.FolderName.FOLDER_ROOT).append("/");
	        // choose next folder
	        String nextFolder;
	        Integer lo = Integer.parseInt(location);
	        if (lo.equals(GlobalConstant.FolderLocation.LOCATION_NRC)) {
	            nextFolder = GlobalConstant.FolderName.NRC;
	        } else if (lo.equals(GlobalConstant.FolderLocation.LOCATION_PROFILE)) {
	            nextFolder = GlobalConstant.FolderName.PROFILE;
	        }
	       else {
	            nextFolder = GlobalConstant.FolderName.FOLDER_OTHER;
	        }
	        // append next folder
	        path.append(nextFolder).append("/");
	        // append user

	
	        // append current time
	        Double ra = Math.random();
	        Long random=(long) (ra*10000);
	        logger.info("Random path ll is {}",random);
	        path.append(random);
	        path.append(System.currentTimeMillis());

	        return path.toString();
	    }
	   
	
	 public Long saveFile(MultipartFile file, String path) throws IOException {
	        if (file.isEmpty()) {
	            throw new RuntimeException("File is empty");
	        }
	        Path location = Paths.get(path);
	        if (Files.notExists(location)) {
	            new File(location.toString()).mkdirs();
	        }
	        return Files.copy(file.getInputStream(),
	                location.resolve(file.getOriginalFilename()),
	                StandardCopyOption.REPLACE_EXISTING);
	    }

}
