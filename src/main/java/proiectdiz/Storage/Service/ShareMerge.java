package proiectdiz.Storage.Service;

import com.fasterxml.jackson.databind.JsonNode;
import proiectdiz.Storage.Database.DatabaseHandler;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Model.ShareObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShareMerge {


    public static String Gather(JsonNode guid_list_json , String servernumber) throws SQLException {
        DatabaseHandler db_handler= new DatabaseHandler(Properties.getUsername(),Properties.getPassword(),Properties.getConnectionString(),servernumber);
        List<String> guid_string_list= JsonHandler.getUUID_List_FromPile(guid_list_json);
        String guid_string=  String.join(",",guid_string_list);
        List<String>params= new ArrayList<>();
        params.add(guid_string);
        List<ShareObject> results= db_handler.ExecuteStoredProcedure(Properties.getReturnProc(),params);
        return JsonHandler.CreateSHARESJsonToSend(results,servernumber);



    }






}
