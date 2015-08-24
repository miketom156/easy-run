package com.job5156.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

/**
 * FTP组件
 * @author leo
 *
 */
public class FtpBean {
	private String hostname;  		//主机名称
	private int port;  		  		//端口
	private String username;  		//FTP账号
	private String password;  		//FTP密码
	private String remoteDir;		//远程目录远
	
	private FTPClient ftpClient;  	//FTP客户端
	
	public FtpBean(String hostname, int port, String username, String password, String remoteDir) {  
        this.hostname = hostname;  
        this.port = port;  
        this.username = username;  
        this.password = password;  
        this.remoteDir = remoteDir;  
        if (remoteDir == null) {  
        	this.remoteDir = "/";  
        }
    }
	
    /** 
     * FTP登陆 
     * @throws IOException 
     */  
    public void login() throws Exception {  
        ftpClient = new FTPClient();
        ftpClient.configure(getFTPClientConfig());
        ftpClient.setDefaultPort(port);
        ftpClient.setControlEncoding("UTF-8");
        ftpClient.connect(hostname);
        if (!ftpClient.login(username, password)) {
            throw new Exception("FTP login error");
        }
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        ftpClient.setBufferSize(64 * 1024);
        ftpClient.enterLocalActiveMode();
        ftpClient.changeWorkingDirectory(remoteDir);
    }  
  
    /** 
     * 获取配置 
     * @return 
     */  
    private FTPClientConfig getFTPClientConfig() {  
        // 创建配置对象  
        FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);  
        conf.setServerLanguageCode("zh");  
        return conf;  
    }  
  
    /** 
     * 关闭FTP服务器 
     */  
    public void closeServer() {  
        try {  
            if (ftpClient != null) {  
                ftpClient.logout();  
                ftpClient.disconnect();
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 链接是否已经打开 
     * @return 
     */  
    public boolean serverIsOpen() {  
        if (ftpClient == null) {  
            return false;  
        }  
        return ftpClient.isConnected();  
    }  
  
    /** 
     * 列表FTP文件 
     * @param regEx 
     * @return 
     */  
    public String[] listFiles(String regEx) {  
        String[] names;  
        try {  
            names = ftpClient.listNames(regEx);  
            if (names == null) {
            	return new String[0];
            }
            return names;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return new String[0];  
    }  
  
    /** 
     * 上传 
     * @throws Exception 
     */  
    public boolean upload(String localFilePath, String remoteFilePath) throws Exception {  
        boolean state = false;  
        File localFile = new File(localFilePath);  
        if (!localFile.isFile() || localFile.length() == 0) {  
            return state;  
        }  
        FileInputStream localIn = new FileInputStream(localFile);  
        state = this.upload(localIn, remoteFilePath);  
        localIn.close();
        return state;
    }  
  
    /** 
     * 上传 
     * @throws Exception 
     */  
    public boolean upload(InputStream localIn, String remoteFilePath) throws Exception {  
        this.createDir(new File(remoteFilePath).getParent());  
        return ftpClient.storeFile(remoteFilePath, localIn);
    }
  
    /** 
     * 是否存在FTP目录 
     * @param dir 
     * @param ftpClient 
     * @return 
     */  
    public boolean isDirExist(String dir) {  
        try {  
            int retCode = ftpClient.cwd(dir);  
            return FTPReply.isPositiveCompletion(retCode);  
        } catch (Exception e) {  
            return false;  
        }  
    }  
  
    /** 
     * 创建FTP多级目录 
     * @param remoteFilePath 
     * @throws IOException 
     */  
    public void createDir(String dir) throws IOException {  
        if (StringUtils.isNotBlank(dir) && !isDirExist(dir)) {  
            File file = new File(dir);  
            this.createDir(file.getParent());  
            ftpClient.makeDirectory(dir);  
        }  
    }  
  
    /** 
     * 删除文件 
     * @param remoteFilePath 
     */  
    public boolean delFile(String remoteFilePath) {  
        try {  
            return ftpClient.deleteFile(remoteFilePath);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return false;  
    }  
  
    /** 
     * 下载 
     * @throws Exception 
     */  
    public void download(String localFilePath, String remoteFilePath) throws Exception {  
        OutputStream localOut = new FileOutputStream(localFilePath);  
        this.download(localOut, remoteFilePath);  
        localOut.close();  
    }  
  
    /** 
     * 下载 
     * @throws Exception 
     */  
    public void download(OutputStream localOut, String remoteFilePath) throws Exception {  
        boolean result = ftpClient.retrieveFile(remoteFilePath, localOut);  
        if (!result) {  
            throw new Exception("ftp download fail!");  
        }  
    }  

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemoteDir() {
		return remoteDir;
	}

	public void setRemoteDir(String remoteDir) {
		this.remoteDir = remoteDir;
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
}
