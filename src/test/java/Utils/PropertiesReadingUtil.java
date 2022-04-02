package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileNotFoundException;

public class PropertiesReadingUtil {


        private static Properties properties=new Properties();


        static {
            String pathForPropertiesFile="configuration.properties";

            try{
                FileInputStream fileInputStream=new FileInputStream(pathForPropertiesFile);

                properties.load(fileInputStream);

            }  catch (IOException e) {
                e.printStackTrace();
                System.out.println("Properties File Not founded");
            }
        }

        public static String getProperties(String keyword){
            return properties.getProperty(keyword);
        }
    }
