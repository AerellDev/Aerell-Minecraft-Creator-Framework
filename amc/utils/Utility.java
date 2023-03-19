package amc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Utility
 */
public class Utility {

    public static void buatFolder(String nama, String path) {
      String folderName = nama;
      String directoryPath = "./" + path;

      // membuat objek File dengan direktori tujuan
      File directory = new File(directoryPath);

      // jika direktori tujuan tidak ada, maka buat direktori baru
      if (!directory.exists()) {
         directory.mkdirs();
         System.out.println("Direktori " + directoryPath + " berhasil dibuat.");
      }

      // membuat objek File dengan nama folder baru dan direktori tujuan
      File folder = new File(directoryPath + "/" + folderName);

      // jika folder baru belum ada, maka buat folder baru
      if (!folder.exists()) {
         folder.mkdir();
         System.out.println("Folder " + folderName + " berhasil dibuat di dalam direktori " + directoryPath);
      }
    }

    public static void buatFile(String namaFile, String content) {
      String filePath = "./" + namaFile; // Nama dan lokasi file
      String fileContent = content;
      File file = new File(filePath);
      try {
         boolean success = file.createNewFile(); // Buat file baru
         if (success) {
               FileWriter writer = new FileWriter(file);
               writer.write(fileContent);
               writer.close();
               System.out.println("File created and content written successfully.");
         } else {
               System.out.println("File already exists.");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
    }

    public static String buatUUID() {
      UUID uuid = UUID.randomUUID();
      return uuid.toString();
    }

    public static void copyAndRenameFile(String sourceFilePath, String targetDirectoryPath, String newFileName) {

      // Create Path objects for the source file, target directory, and the new file
      Path sourcePath = Paths.get(sourceFilePath);
      Path targetDirectory = Paths.get(targetDirectoryPath);
      Path newFilePath = targetDirectory.resolve(newFileName);
      
      // Check if the source file exists and is a file
      if (Files.exists(sourcePath) && Files.isRegularFile(sourcePath)) {
          try {
              // Copy the file to the target directory with the new name
              Files.copy(sourcePath, newFilePath);
              System.out.println("File copied to " + newFilePath.toString());
          } catch (IOException e) {
              System.err.println("Failed to copy file: " + e.getMessage());
          }
      } else {
          System.err.println("Source file does not exist or is not a file");
      }
    }

    public static void copyFolder(String sourcePath, String destinationPath) {
      Path sourcePathP = Paths.get(sourcePath);
      Path destinationPathP = Paths.get(destinationPath);

      try {
         Files.walk(sourcePathP)
                  .forEach(source -> {
                     Path destination = destinationPathP.resolve(sourcePathP.relativize(source));
                     try {
                           Files.copy(source, destination);
                     } catch (IOException e) {
                           e.printStackTrace();
                     }
                  });
      } catch (IOException e) {
         e.printStackTrace();
      }
    }

    public static void deleteFolder(String path) {
      File folder = new File(path);
      if (folder.exists() && folder.isDirectory()) {

         // Menghapus folder beserta isi nya
         File[] files = folder.listFiles();
         if (files != null) {
            for (File file : files) {
               if (file.isDirectory()) {
                     // Jika file adalah sebuah folder, panggil metode deleteFolder() secara rekursif
                     deleteFolder(file.getPath());
               } else {
                     // Jika file adalah sebuah file, hapus file tersebut
                     file.delete();
               }
            }
         }

         // Hapus folder setelah semua file di dalam nya sudah terhapus
         folder.delete();

         System.out.println("Folder berhasil dihapus.");
     } else {
         System.out.println("Folder tidak ditemukan.");
     }
   }

    public static String bacaFile(String pathFile) {
      String output = "";
      try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = br.readLine()) != null) {
               output += line + "\n";
            }
            return output;
      } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            return output;
      }
    }
}
