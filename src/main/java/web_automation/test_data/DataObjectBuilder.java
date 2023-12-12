package web_automation.test_data;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObjectBuilder {
    public static <T> T buildDataObjectForm(String relativeDataLocation, Class<T> dataTypeClass){
        T data;
        String currentProjectLocation = System.getProperty("user.dir");
        String absolutePathLocation = currentProjectLocation + relativeDataLocation;

        try(
                Reader jsonContentReader = Files.newBufferedReader(Paths.get(absolutePathLocation));
                )
        {
            Gson gson = new Gson();
            data = gson.fromJson(jsonContentReader, dataTypeClass);
        } catch (Exception e){
            throw new RuntimeException("[ERR] Error while reading " + absolutePathLocation);
        }
        return data;
    }
}
