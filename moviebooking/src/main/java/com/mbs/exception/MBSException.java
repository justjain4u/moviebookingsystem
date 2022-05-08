package com.mbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author vabhav.jain
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MBSException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MBSException(String message) {
		super(message);
	}
}
