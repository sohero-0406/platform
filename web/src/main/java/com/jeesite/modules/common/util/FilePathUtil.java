package com.jeesite.modules.common.util;

import com.jeesite.common.cache.CacheUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.config.web.FileLocalConfig;
import org.hyperic.sigar.OperatingSystem;

import java.io.File;

public class FilePathUtil {

    public static String getFileSavePath(String folderName){
       // OperatingSystem OS = OperatingSystem.getInstance();
        String osName = System.getProperty("os.name");
        if(osName.contains("Windows")){
            String prefix = CacheUtils.get("picUrl");
            if(StringUtils.isBlank(prefix)){
                String url = FilePathUtil.class.getResource("").toString().replace("file:/", "");
                if (url.contains("/webapps")) {
                    url = url.substring(0, url.indexOf("/webapps"));
                    url = url.substring(0, url.lastIndexOf("/"));
                } else {
                    url = "C:/test001/";
                }
                //图片上传路径
                String picUrl = url + "/soHero/";

                String path = picUrl+folderName+"/";
                File p = new File(path);
                if(!p.exists()){
                    p.mkdirs();
                }
                CacheUtils.put("picUrl", path);
                return path;
            }else{
                return prefix;
            }


        }else{
            String path = "/home/hey/platform/"+folderName+"/";
            File p = new File(path);
            if(!p.exists()){
                p.mkdir();
            }
            return "/home/hey/platform/"+folderName+"/";
        }


    }

}
