package com.job5156.vo.file;

/**
 * 个人登陆数据
 * 
 * @author leo
 * 
 */
public class IcpPerLoginVo extends IcpBaseVo {

	private String icpCode; 	// ICP编码
	private String dataType; 	// 协议类型标识
	private String srcIp; 		// 源IP
	private Integer srcPort;	// 源端口
	private String dstIp; 		// 目的IP
	private Integer dstPort;	// 目的端口
	private String userId; 		// 用户ID
	private String userName;	// 用户账号
	private String nickName;	// 用户昵称
	private String password;	// 用户密码
	private String macAddress;	// 源MAC地址
	private String innerIp;		// 内网IP地址
	private String actionTime;	// 发生时间
	private String action;		// 动作

	public String getIcpCode() {
		return icpCode;
	}

	public void setIcpCode(String icpCode) {
		this.icpCode = icpCode;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSrcIp() {
		return srcIp;
	}

	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}

	public Integer getSrcPort() {
		return srcPort;
	}

	public void setSrcPort(Integer srcPort) {
		this.srcPort = srcPort;
	}

	public String getDstIp() {
		return dstIp;
	}

	public void setDstIp(String dstIp) {
		this.dstIp = dstIp;
	}

	public Integer getDstPort() {
		return dstPort;
	}

	public void setDstPort(Integer dstPort) {
		this.dstPort = dstPort;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getInnerIp() {
		return innerIp;
	}

	public void setInnerIp(String innerIp) {
		this.innerIp = innerIp;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
