package com.redis.cache.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2895920349642000976L;
	public ResourceNotFound (String message) {
		super(message);
	}
	

}
