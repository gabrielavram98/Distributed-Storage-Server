package proiectdiz.Storage.Helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

import java.util.Set;

public class ValidationCheck {
    public static int Validate(JsonNode request,String path) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonSchema schemaStream = SchemaLoader.LoadSchemaFromPath( path );
        Set<ValidationMessage> validationMessage = null;
        if (schemaStream != null) {

            validationMessage = schemaStream.validate(request);
        }
        if(validationMessage==null)
        {
            throw new Exception("Error validating the request");
        }
        return 0;


    }

}
