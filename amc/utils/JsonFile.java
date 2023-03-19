package amc.utils;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFile {

    private ObjectMapper mapper = new ObjectMapper();
    
    public JsonNode data;

    public JsonFile(String path) {

        try {
            data =  mapper.readTree(new File("./" + path));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int[] getIntArray(String fieldName) {
        JsonNode versionNode = data.get(fieldName);
        int[] versionArray = new int[versionNode.size()];
        if (versionNode.isArray()) {
            for (int i = 0; i < versionNode.size(); i++) {
                versionArray[i] = versionNode.get(i).asInt();
            }
        }
        return versionArray;
    }

}
