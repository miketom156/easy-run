package com.job5156.beans.mail;

/**
 * 邮件服务器配置
 * @author leo
 *
 */
public class EmailServerConfig {

	private String mailHost; 		// 邮件服务器地址
	private String hostName;		// 邮件服务器名称
	private String port;		    // 邮件服务器的端口
	private String authKey; 		// 认证账号
	private String authVal; 		// 认证密码
	private boolean isAuth = true; 	// 是否需要认证[默认是]
	
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getMailHost() {
		return mailHost;
	}

	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthVal() {
		return authVal;
	}

	public void setAuthVal(String authVal) {
		this.authVal = authVal;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
