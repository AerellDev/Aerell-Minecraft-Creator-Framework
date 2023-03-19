package tasks;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import amc.AMC;
import amc.utils.Utility;

public class TestAddon extends AMC {

    static int delay = 2000; // sama dengan 2 detik

    public static void main(String[] args) {

        Utility.copyFolder("src/addon/" + project.getName() + " - RP", config.getMinecraftBedrockLocation() + "\\development_resource_packs\\" +  project.getName() + " - RP");
        Utility.copyFolder("src/addon/" + project.getName() + " - BP", config.getMinecraftBedrockLocation() + "\\development_behavior_packs\\" + project.getName() + " - BP");

        //Jalankan Minecraft Bedrock
        try {
            Desktop.getDesktop().browse(new URI("minecraft:////"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        String processName = "Minecraft";
        Optional<ProcessHandle> minecraftProcess;

        do {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            minecraftProcess = ProcessHandle.allProcesses()
                    .filter(p -> p.info().command().isPresent())
                    .filter(p -> p.info().command().get().contains(processName))
                    .findFirst();
        } while (minecraftProcess.isPresent());

        System.out.println("Minecraft telah dihentikan");

        Utility.deleteFolder(config.getMinecraftBedrockLocation() + "\\development_resource_packs\\" +  project.getName() + " - RP");
        Utility.deleteFolder(config.getMinecraftBedrockLocation() + "\\development_behavior_packs\\" + project.getName() + " - BP");
    }
}
