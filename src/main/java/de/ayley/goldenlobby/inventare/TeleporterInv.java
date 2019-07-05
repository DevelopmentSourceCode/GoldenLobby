package de.ayley.goldenlobby.inventare;

import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.io.File;
import java.io.IOException;

public class TeleporterInv {

    private static File file = new File("plugins//GoldenLobby","TeleporterInv.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private static Inventory inventory = null;

    public static void createTeleportInvData(){
        if(!cfg.contains("Settings")){
            cfg.set("Settings.InvName", "&2&lTeleporter");
        }
        save();
    }

    public static void setTeleporterInv(Player player){
        ItemManager itemManager2 = new ItemManager(player);
        String InvName = cfg.getString("Settings.InvName");
        inventory = Bukkit.createInventory(null,9, ChatColor.translateAlternateColorCodes('&', InvName));

        for(int i = 0; i <= itemManager2.allItems() -1; i++){
            ItemManager itemManager = new ItemManager(i,player);
            inventory.setItem(itemManager.getSlot(),itemManager.getItem());
        }

    }

    public static Inventory getInventory() {
        return inventory;
    }

    public static FileConfiguration getCfg() {
        return cfg;
    }

    private static void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
