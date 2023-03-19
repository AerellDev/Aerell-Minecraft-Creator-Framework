package amc;

import amc.utils.JsonFile;

public class Config {
    
    private JsonFile json;

    private String minecraft_bedrock_location;

    public Config() {
        this.json = new JsonFile("config.json");

        this.minecraft_bedrock_location = json.data.path("minecraft_bedrock_location").asText();
    }

    public String getMinecraftBedrockLocation() {
        return minecraft_bedrock_location;
    }

}
