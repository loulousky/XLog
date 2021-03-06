package com.ccwant.xlog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;
import android.provider.Contacts.Extensions;

public class XlogDiskCache {


	 /**
     * 保存到日志文件
     * @param content
     */ 
    public static synchronized void save(String dirName,String fileName,String content) 
    { 
        try 
        { 
            FileWriter writer = new FileWriter(getFile(dirName,fileName), true); 
            writer.write(content); 
            writer.close(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
    } 
   
    /**
     * 获取日志文件路径
     * @return
     */ 
    public static String getFile(String dirName,String fileName) 
    {
		String sdDir = null;
		if (Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			sdDir = Environment.getExternalStorageDirectory().toString();
		}
		File cacheDir = new File(sdDir + File.separator + dirName);
		if (!cacheDir.exists())
			cacheDir.mkdir();
		File filePath = new File(cacheDir + File.separator + fileName +".txt");
		return filePath.toString();
	} 
}
