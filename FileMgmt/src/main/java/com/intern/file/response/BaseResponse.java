package com.intern.file.response;

public class BaseResponse {
	
	 Integer errorCode;
	    Object result;
	    String message;

	    public BaseResponse() {
	    }

	    public BaseResponse(Integer errorCode, Object result, String message) {
	        this.errorCode = errorCode;
	        this.result = result;
	        this.message = message;
	    }

	    public int getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorCode(Integer errorCode) {
	        this.errorCode = errorCode;
	    }

	    public Object getResult() {
	        return result;
	    }

	    public void setResult(Object result) {
	        this.result = result;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

}
