package proiectdiz.Storage.Database;

import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.ShareObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHandler {


    private  String Username;
    private  String Password;

    private  String connectionString;


    public DatabaseHandler(String username, String password, String connectionString,String servernumber) {
        Username = username;
        Password = password;
        this.connectionString = connectionString+servernumber+";encrypt=false";
    }

    public List<ShareObject> ExecuteStoredProcedure(String stored_procedure, List<String> params) throws SQLException {

        try (Connection connection = DriverManager.getConnection(connectionString, Username, Password)) {
            String stored_procedure_string=Create_Stored_Procedure_Call_String(stored_procedure,params.size());
            try(CallableStatement callableStatement = connection.prepareCall(stored_procedure_string)){
                for(int i=1;i<=params.size();i++){
                    callableStatement.setString(i, params.get(i-1));
                }
                boolean isResultSet = callableStatement.execute();

                if(isResultSet){
                    ResultSet resultSet=callableStatement.getResultSet();
                    List<ShareObject> results= new ArrayList<>();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    List<String> columnNames = new ArrayList<>();
                   // for (int i = 1; i <= columnCount; i++) {
                   //     String columnName = metaData.getColumnName(i);
                   //     columnNames.add(columnName);
                   // }
                    while (resultSet.next()){
                        //for(String column:columnNames){
                            ShareObject row= new ShareObject(resultSet.getString("X"),resultSet.getString("Y"), resultSet.getString("GUID"));
                            //result.put(column,resultSet.getObject(column).toString());
                            results.add(row);

                        //}
                        //results.put("P",resultSet.getString("P"));
                        //results.put("PASSWORD_b64_hash",resultSet.getString("PASSWORD_b64_hash"));
                        //results.put("UUID_list",resultSet.getString("UUID_list"));
                    }

                    return results;
                }
                else{
                    int rows_affected=callableStatement.getUpdateCount();
                    Log.InfoLog("Rows affected on "+stored_procedure+":"+rows_affected);
                    return null;
                }
            }



        }
        catch (SQLException e){
            Log.ErrorLog(e.getMessage());
        }
        return null;

    }
    private String Create_Stored_Procedure_Call_String(String stored_proc,int len){
        String storedProcedure = "{CALL "+ stored_proc+"(";
        StringBuilder builder= new StringBuilder();
        builder.append(storedProcedure);
        for(int i=0;i<len;i++){
            builder.append("?,");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")}");
        return builder.toString();
    }



    //public List<ShareObject> populate_with_shares(List<ShareObject> empty_list){
    //    List<ShareObject> populated_list= new ArrayList<>();
//
 //    return populated_list;
   // }

}
