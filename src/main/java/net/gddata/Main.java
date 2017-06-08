package net.gddata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by zhangzf on 17-6-8.
 */
public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        File file = new File("info.properties");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            try {
                properties.load(fis);
                String proPath = properties.getProperty("project.path");
                String proName = properties.getProperty("project.name");
                String proMavenDir = properties.getProperty("project.mavendir");
                String proDir = properties.getProperty("project.dir");

                List<String> list = new ArrayList();
                for (int i = 1; i <=10 ; i++) {
                    String dir = properties.getProperty("project.subdir"+i);
                    if(!"".equals(dir)&&null!=dir){
                        list.add(dir);
                    }
                }

                File file1 = new File(proPath);
                if("".equals(proDir)){
                    System.out.println("存放路径不能为空");
                    return;
                }
                if("".equals(proName)){
                    System.out.println("项目名不能为空");
                    return;
                }
                if("".equals(proMavenDir)){
                    System.out.println("Maven固定目录不能为空");
                    return;
                }
                if("".equals(proDir)){
                    System.out.println("包路径不能为空");
                    return;
                }


                System.out.println(list);

                System.out.println(proDir);
                System.out.println(proPath);
                System.out.println(proName);
                System.out.println(proMavenDir);


                fis.close();
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        } catch (FileNotFoundException var7) {
            var7.printStackTrace();
        }

    }
}
