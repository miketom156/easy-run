package com.job5156.common.exception;

/**
 * 邮件服务器配置异常
 * 
 * @author leo
 * 
 */
public class EmailServerConfigException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmailServerConfigException() {

	}

	public EmailServerConfigException(String msg) {
		super(msg);
	}

	public EmailServerConfigException(Throwable cause) {
		super(cause);
	}

	public EmailServerConfigException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
