package com.intern.file.constant;

public class GlobalConstant {
	
	   public static Integer SUCCESS_CODE = 0;
	    public static Integer FAIL_CODE = 1;
	    
	    public interface Message{
	    	String SUCCESS="SUCCESSFUL ";
	    	String FAIL = "FAIL";
	    }
	
	
	  public interface FolderLocation {

	        Integer LOCATION_NRC = 1;
	        Integer LOCATION_PROFILE = 2;
	     

	    }

	    public interface FolderName {


	        String FOLDER_ROOT = "upload";
	        String  NRC = "NRC";
	        String  PROFILE = "PROFILE";
	        String FOLDER_OTHER = "other";

	    }

}
