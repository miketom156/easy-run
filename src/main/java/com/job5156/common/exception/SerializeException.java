package com.job5156.common.exception;

/**
 * 对象序列化异常
 * @author leo
 *
 */
public class SerializeException extends Exception {
	private static final long serialVersionUID = 1L;

	public SerializeException() {

	}

	public SerializeException(String msg) {
		super(msg);
	}

	public SerializeException(Throwable cause) {
		super(cause);
	}

	public SerializeException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
