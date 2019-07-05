package de.ayley.goldenlobby.inventare;

import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.CreateItem;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class VanishInv {

    private static Inventory inventory;
    private static File file = new File("plugins//GoldenLobby","VanishInv.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void createVanishItemData(){
        if(!cfg.contains("SeeAll")){
            cfg.set("SeeAll.Material", "INK_SACK");
            cfg.set("SeeAll.DyeColor", "GREEN");
            cfg.set("SeeAll.Amout", "1");
            cfg.set("SeeAll.Name", "&2Sichtbar");
            cfg.set("SeeAll.Slot", "0");
            cfg.set("SeeAll.Lore", new String[]{"eins","zwei"});
        }
        if(!cfg.contains("SeeNothing")){
            cfg.set("SeeNothing.Material", "INK_SACK");
            cfg.set("SeeNothing.DyeColor", "RED");
            cfg.set("SeeNothing.Amout", "1");
            cfg.set("SeeNothing.Name", "&4Versteckt");
            cfg.set("SeeNothing.Slot", "1");
            cfg.set("SeeNothing.Lore", new String[]{"eins","zwei"});
        }
        if(!cfg.contains("SeeVIPPremium")){
            cfg.set("SeeVIPPremium.Material", "INK_SACK");
            cfg.set("SeeVIPPremium.DyeColor", "PURPLE");
            cfg.set("SeeVIPPremium.Amout", "1");
            cfg.set("SeeVIPPremium.Name", "&5Nur Vip/Premium");
            cfg.set("SeeVIPPremium.Slot", "2");
            cfg.set("SeeVIPPremium.Lore", new String[]{"eins","zwei"});
        }
        if(!cfg.contains("Settings")){
            cfg.set("Settings.InvType", "Kommt bald!");
            cfg.set("Settings.InvName", "Player Hider");
        }
        save();
    }

    public static void setVanishInv(){
        String InvName = cfg.getString("Settings.InvName");
        inventory = Bukkit.createInventory(null, InventoryType.BREWING, ChatColor.translateAlternateColorCodes('&', InvName));

        //Slot
        int slot1 = Integer.parseInt(cfg.getString("SeeAll.Slot"));
        int slot2 = Integer.parseInt(cfg.getString("SeeNothing.Slot"));
        int slot3 = Integer.parseInt(cfg.getString("SeeVIPPremium.Slot"));

        //Material
        Material material1 = Material.getMaterial(cfg.getString("SeeAll.Material"));
        Material material2 = Material.getMaterial(cfg.getString("SeeNothing.Material"));
        Material material3 = Material.getMaterial(cfg.getString("SeeVIPPremium.Material"));
        //DyeColor
        String DyeColor1 = cfg.getString("SeeAll.DyeColor");
        String DyeColor2 = cfg.getString("SeeNothing.DyeColor");
        String DyeColor3 = cfg.getString("SeeVIPPremium.DyeColor");

        //Name
        String name1 = cfg.getString("SeeAll.Name");
        String name2 = cfg.getString("SeeNothing.Name");
        String name3= cfg.getString("SeeVIPPremium.Name");

        //Lore
        String[] lore1 = cfg.getStringList("SeeAll.Lore").toArray(new String[0]);
        String[] lore2 = cfg.getStringList("SeeNothing.Lore").toArray(new String[0]);
        String[] lore3 = cfg.getStringList("SeeVIPPremium.Lore").toArray(new String[0]);

        //ItemStack
        ItemStack SeeAll = new CreateItem(material1, 1,(short) DyeColor.valueOf(DyeColor1).getDyeData()).setName(name1).setLore(lore1).create();
        ItemStack SeeNothing = new CreateItem(material2,1,(short) DyeColor.valueOf(DyeColor2).getDyeData()).setName(name2).setLore(lore2).create();
        ItemStack SeeVIPPremium = new CreateItem(material3,1,(short) DyeColor.valueOf(DyeColor3).getDyeData()).setName(name3).setLore(lore3).create();

        //SetItem in Inventory
        inventory.setItem(slot1, SeeAll);
        inventory.setItem(slot2, SeeNothing);
        inventory.setItem(slot3, SeeVIPPremium);

    }

    public static Inventory getInventory() {
        return inventory;
    }

    private static void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileConfiguration getCfg() {
        return cfg;
    }
}
