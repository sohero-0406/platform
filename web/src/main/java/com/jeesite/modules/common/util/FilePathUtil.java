package com.jeesite.modules.common.util;

import org.hyperic.sigar.OperatingSystem;

import java.io.File;

public class FilePathUtil {

    public static String getFileSavePath(String folderName){
       // OperatingSystem OS = OperatingSystem.getInstance();
        String osName = System.getProperty("os.name");
        if(osName.contains("Windows")){
            String path = "C:/test001/"+folderName+"/";
            File p = new File(path);
            if(!p.exists()){
                p.mkdir();
            }
            return "C:/test001/"+folderName+"/";
        }else{
            return "";
        }


    }

}
