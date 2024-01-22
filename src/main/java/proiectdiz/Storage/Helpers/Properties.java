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

    public static String getDestination_(char i){
        String destination="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            destination=properties.getProperty("destination_"+i);
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return destination;
    }

    public static String getConnectionString(){
        String conn_string="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            conn_string=properties.getProperty("database_connection_string");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return conn_string;
    }

    public static String getUsername(){
        String username="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            username=properties.getProperty("db_username");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return username;
    }
    public static String getPassword(){
        String password="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            password=properties.getProperty("db_password");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return password;
    }
    public static String getInsertShareProc(){
        String insert_proc="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            insert_proc=properties.getProperty("insert_shares_proc");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return insert_proc;
    }
    public static String getInsertEncrShareProc(){
        String insert_proc="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            insert_proc=properties.getProperty("insert_encrypted_shares_proc");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return insert_proc;
    }
    public static String getReturnProc(){
        String return_proc="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            return_proc=properties.getProperty("get_shares_by_uuid_procedure");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return return_proc;
    }
    public static String getClientBaseUrl(){
        String client_url="";
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(input);
            client_url=properties.getProperty("client_base_url");
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
        }
        return client_url;
    }


}
