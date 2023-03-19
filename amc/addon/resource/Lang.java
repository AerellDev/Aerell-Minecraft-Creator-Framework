package amc.addon.resource;

import amc.utils.FileOperation;
import amc.utils.Utility;



public class Lang {

    private String namaFileLang;
    private String projectName;
    private FileOperation file;
    
    public Lang(String nama, String projectName) {
        this.namaFileLang = nama;
        this.projectName = projectName;
        file = new FileOperation("src/addon/" + this.projectName + " - RP/texts/"  + namaFileLang + ".lang");
    }

    public void buat() {
        Utility.buatFolder("texts", "src/addon/" + this.projectName + " - RP");
        file.create();
    }

    //Menambahkan
    public void menambah(String indentifier, String value) {
        file.add(indentifier + "=" + value, true);
    }
}
