package amc;

import amc.utils.JsonFile;

public class Project {

    private JsonFile json;

    //Nama addon
    private String nama;
    //Lokasi pack_icon addon
    private String pack_Icon;
    //deskripsi addon
    private String deskripsi;
    //versi addon
    private int[] versi;
    //minimal versi minecraft
    private int[] min_versi_minecraft;

    public Project() {
        this.json = new JsonFile("project.json");

        this.nama = json.data.path("name").asText();

        this.pack_Icon = json.data.path("icon").asText();

        this.deskripsi = json.data.path("description").asText();

        this.versi = json.getIntArray("version");

        this.min_versi_minecraft = json.getIntArray("minecraft_min_version");
    }

    public String getName() {
        return nama;
    }
    
    public String getIcon() {
        return pack_Icon;
    }

    public String getDescription() {
        return deskripsi;
    }

    public int[] getVersion() {
        return versi;
    }

    public int[] getMinMinecraftVersion() {
        return min_versi_minecraft;
    }

}
