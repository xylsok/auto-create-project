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
                String proName = properties.getProperty("project.name");
                String proPath = properties.getProperty("project.path");
                String proMavenDir = properties.getProperty("project.mavendir");
                String proDir = properties.getProperty("project.dir");

                List<String> list = new ArrayList();
                for (int i = 1; i <=10 ; i++) {
                    String dir = properties.getProperty("project.subdir"+i);
                    if(!"".equals(dir)&&null!=dir){
                        list.add(dir);
                    }
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
