package com.intern.file.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intern.file.constant.GlobalConstant;
import com.intern.file.response.BaseResponse;
import com.intern.file.response.UploadResponse;
import com.intern.file.service.FileService;

@RestController
public class FileController {
	Logger logger=LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	FileService fileService;
	
	 @PostMapping("file/upload")
	    public BaseResponse uploadFile(@RequestParam MultipartFile file, @RequestParam String location ) {
	        logger.debug("REST request to upload file {} to location {}", location);
	        UploadResponse response = null;

	
	        String pathFile = fileService.getFolderPath(location);
	        try {
	            fileService.saveFile(file, pathFile);
	            response = new UploadResponse();
	            response.setUrl(pathFile + "/" + file.getOriginalFilename());
	            response.setFileName(file.getOriginalFilename());
	            response.setStatus(true);
	            response.setFileContentType(file.getContentType());

	            logger.debug("Upload file {} success", file.getOriginalFilename());
	        } catch (IOException e) {

	            logger.warn("Upload file {} error", file.getOriginalFilename(), e);
	            e.printStackTrace();
	        }
	        return new BaseResponse(GlobalConstant.SUCCESS_CODE, response, GlobalConstant.Message.SUCCESS);
	    }


}
