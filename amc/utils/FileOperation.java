package amc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

    private String fileName;

    public FileOperation(String filename) {
        this.fileName = filename;
    }

        
    public void create() {
        // membuat file baru
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File " + fileName + " berhasil dibuat.");
            } else {
                System.out.println("File " + fileName + " sudah ada.");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membuat file " + fileName + ".");
            e.printStackTrace();
        }
    }
        
    public void add(String value, boolean newline) {
        // menambahkan teks ke dalam file
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(value + ((newline) ? "\n" : ""));
            writer.close();
            System.out.println("Teks berhasil ditambahkan ke dalam file " + fileName + ".");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menambahkan teks ke dalam file " + fileName + ".");
            e.printStackTrace();
        }
    }
        
    public String read() {
        String output = "";
        // membaca file
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            System.out.println("Isi file " + fileName + ":");
            while ((line = bufferedReader.readLine()) != null) {
                output += line + "\n";
            }
            reader.close();
            return output;
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file " + fileName + ".");
            e.printStackTrace();
            return output;
        }
    }
        
    public void edit(String value) {
        // mengedit file
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(value);
            writer.close();
            System.out.println("File " + fileName + " berhasil diubah.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat mengedit file " + fileName + ".");
            e.printStackTrace();
        }
    }
        
    public void delete() {
        // menghapus file
        try {
            File file = new File(fileName);
            if (file.delete()) {
                System.out.println("File " + fileName + " berhasil dihapus.");
            } else {
                System.out.println("Terjadi kesalahan saat menghapus file " + fileName + ".");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus file " + fileName + ".");
            e.printStackTrace();
        }
    }
}
