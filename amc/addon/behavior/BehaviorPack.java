package amc.addon.behavior;

import amc.utils.Utility;

public class BehaviorPack {
    
    private String icon_pack;
    private String deskripsi;
    private String nama;
    private String uuid = Utility.buatUUID();
    private String uuidModule = Utility.buatUUID();
    private int[] versi;
    private int[] min_engine_version;
    private String type = "data";

    public BehaviorPack(String icon_pack, String nama, String deskripsi, int[] versi, int[] min_engine_version) {
        this.icon_pack = icon_pack;
        this.deskripsi = deskripsi;
        this.nama = nama;
        this.versi = versi;
        this.min_engine_version = min_engine_version;
    }

    public void create() {

      String folderName = nama + " - BP";
      Utility.buatFolder(folderName, "src/addon");

      String isiFileManifestBp = 
      "{\n" +
      " \"format_version\": 2,\n" +
      " \"header\": {\n" +
      "   \"description\": \"" + deskripsi + "\",\n" +
      "   \"name\": \"" + nama + "\",\n" +
      "   \"uuid\": \"" + uuid + "\",\n" +
      "   \"version\": [" + versi[0] + ", " + versi[1] + ", " + versi[2] + "],\n" +
      "   \"min_engine_version\": [" + min_engine_version[0] + ", " + min_engine_version[1] + ", " + min_engine_version[2] + "]\n" +
      "  },\n" +
      "   \"modules\": [\n" +
      "     {\n" +
      "     \"description\": \"" + deskripsi + "\",\n" +
      "     \"type\": \"" + type + "\",\n"+
      "     \"uuid\": \"" + uuidModule + "\",\n" +
      "     \"version\": [" + versi[0] + ", " + versi[1] + ", " + versi[2] + "]\n" +
      "     }\n" +
      "   ]\n" +
      "}";

      Utility.buatFile("src/addon/" + folderName + "/manifest.json", isiFileManifestBp);

      //Membuat Pack Icon Nya
      Utility.copyAndRenameFile(icon_pack, "src/addon/" + folderName + "/", "pack_icon.png");
    }

}
