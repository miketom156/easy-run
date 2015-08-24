package com.job5156.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 文件工具类
 * 
 * @author leo
 * 
 */
public class FileUtil {

	/**
	 * 压缩文件目录
	 * 
	 * @param fileDir
	 * @param dstFileName
	 * @throws Exception 
	 */
	public static void zipFileDir(String sourceFileDir, String dstFileDir, String dstFileName) throws Exception {
		File dstFile = new File(dstFileDir);
		if(!dstFile.exists()){
			dstFile.mkdirs();
		}
		String dstFilePath = dstFileDir + "/" + dstFileName;
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(dstFilePath));
		zipFile(out, new File(sourceFileDir), ""); 
        out.close();
	}
	
	/**
	 * 删除文件目录
	 * @param fileDir
	 * @throws IOException
	 */
	public static void delFileDir(String fileDir) throws IOException{
		File dstFileDir = new File(fileDir);
		if(dstFileDir.exists()){
			FileUtils.deleteDirectory(dstFileDir);
		}
	}
	
	/**
	 * 删除文件
	 * @param filePath
	 * @throws IOException
	 */
	public static void delFile(String filePath) throws IOException {
		File dstFile = new File(filePath);
		if(dstFile.exists()){
			dstFile.delete();
		}
	}
	
	/**
	 * 备份源目录
	 * @param sourceDir
	 * @param dstDir
	 * @throws Exception
	 */
	public static void bakFileDir(String sourceDir, String dstDir) throws Exception{
		File sourceFileDir = new File(sourceDir);
		File dstFileDir = new File(dstDir);

		if(sourceFileDir.exists()){
			FileUtils.copyDirectory(sourceFileDir, dstFileDir);
		}
	}
	
    private static void zipFile(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
           File[] fl = f.listFiles();
           out.putNextEntry(new ZipEntry(base + "/"));
           base = base.length() == 0 ? "" : base + "/";
           for (int i = 0; i < fl.length; i++) {
        	   zipFile(out, fl[i], base + fl[i].getName());
           }
        }else {
           out.putNextEntry(new ZipEntry(base));
           FileInputStream in = new FileInputStream(f);
           int b;
           while ((b = in.read()) != -1) {
        	   out.write(b);
           }
           in.close();
       }
    }
}
