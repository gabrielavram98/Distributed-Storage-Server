package proiectdiz.Storage.Helpers;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SchemaLoader {
    public static JsonSchema LoadSchemaFromPath(String filePath) throws IOException {

        ClassLoader classLoader = SchemaLoader.class.getClassLoader();
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        if (inputStream == null) {
            throw new IOException("Resource not found on classpath: " + filePath);
        }
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance( SpecVersion.VersionFlag.V201909 );
        return schemaFactory.getSchema(inputStream);


    }
}
