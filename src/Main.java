import amc.AMC;
import amc.addon.behavior.BehaviorPack;
import amc.addon.resource.Lang;
import amc.addon.resource.LangList;
import amc.addon.resource.ResourcePack;

public class Main extends AMC {
    
    public static void main(String[] args) {
        AddonWorkSpace();
    }

    //Addon Workspace
    public static void AddonWorkSpace() {
        //Membuat ResourcePack
        ResourcePack resourcePack = new ResourcePack(project.getIcon(), project.getName(), project.getDescription(), project.getVersion(), project.getMinMinecraftVersion());
        resourcePack.create();
        
        //Membuat BehaviorPack
        BehaviorPack behaviorPack = new BehaviorPack(project.getIcon(), project.getName(), project.getDescription(), project.getVersion(), project.getMinMinecraftVersion());
        behaviorPack.create();

        Lang en_US = new Lang(LangList.en_US, project.getName());
        en_US.buat();

        en_US.menambah("item.diamond.name", "Asep");
    }
}
