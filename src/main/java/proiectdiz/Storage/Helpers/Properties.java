package proiectdiz.Storage.Helpers;

import org.apache.catalina.Server;
import proiectdiz.Storage.Log.Log;

import java.io.FileInputStream;
import java.io.InputStream;

public class Properties {
    private static final String CONFIG_FILE_PATH = "config.properties";

    public static String getName(){
        String servername="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            servername=properties.getProperty("server_name");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return servername;
    }
    public static String getDestination(char i){
        String destination="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            destination=properties.getProperty("destination"+i);
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return destination;
    }

}
