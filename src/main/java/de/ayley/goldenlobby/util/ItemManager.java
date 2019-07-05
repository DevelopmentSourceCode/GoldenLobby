package de.ayley.goldenlobby.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class ItemManager {

    private static File file = new File("plugins//GoldenLobby","TeleporterInv.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private Player player = null;
    private String name = null;
    private int slot = 0;
    private String[] lore = null;
    private Location location = null;
    private boolean spawn = false;
    private static int item = 0;
    private static int lobby = 1;

    public ItemManager(Player player,String name,boolean spawn,int slot, int item,String... lore){
        this.player = player;
        this.name = name;
        this.slot = slot;
        this.lore = lore;
        this.location = player.getLocation();
        this.spawn = spawn;
        this.item = item;

        if(ArrayLists.getLobby1().contains(player.getName())){
            this.lobby = 1;
        }
        if(ArrayLists.getLobby2().contains(player.getName())){
            this.lobby = 2;
        }
        if(ArrayLists.getLobby3().contains(player.getName())){
            this.lobby = 3;
        }
        if(ArrayLists.getLobby4().contains(player.getName())){
            this.lobby = 4;
        }
        if(ArrayLists.getLobby5().contains(player.getName())){
            this.lobby = 5;
        }
    }

    public ItemManager(int item, Player player){
        this.item = item;
        this.player = player;

        if(ArrayLists.getLobby1().contains(player.getName())){
            this.lobby = 1;
        }
        if(ArrayLists.getLobby2().contains(player.getName())){
            this.lobby = 2;
        }
        if(ArrayLists.getLobby3().contains(player.getName())){
            this.lobby = 3;
        }
        if(ArrayLists.getLobby4().contains(player.getName())){
            this.lobby = 4;
        }
        if(ArrayLists.getLobby5().contains(player.getName())){
            this.lobby = 5;
        }
    }

    public ItemManager(Player player){
        this.player = player;

        if(ArrayLists.getLobby1().contains(player.getName())){
            this.lobby = 1;
        }
        if(ArrayLists.getLobby2().contains(player.getName())){
            this.lobby = 2;
        }
        if(ArrayLists.getLobby3().contains(player.getName())){
            this.lobby = 3;
        }
        if(ArrayLists.getLobby4().contains(player.getName())){
            this.lobby = 4;
        }
        if(ArrayLists.getLobby5().contains(player.getName())){
            this.lobby = 5;
        }
    }


    public void setItem(){
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Name", name);
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Slot", slot);
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Amout", player.getItemInHand().getAmount());
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Material", player.getItemInHand().getType().name());
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Lore", lore);
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Spawn", spawn);
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Location.World", location.getWorld().getName());
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Location.X", location.getX());
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Location.Y", location.getY());
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Location.Z", location.getZ());
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Location.Yaw", location.getYaw());
        cfg.set("InventoryItem.Lobby" + lobby + ".Item" + item + ".Location.Pitch", location.getPitch());
        save();
    }

    public static String getItemNames() {
        ConfigurationSection cs = cfg.getConfigurationSection("InventoryItem.Lobby" + lobby);
        int keys = cs.getKeys(false).size()-1;
        String out = " ";
        for(int i = 0; i <= keys;i++){
            out = cfg.getString("InventoryItem.Lobby" + i) + "," + out;
        }
        return out;
    }

    public int allItems(){
        ConfigurationSection cs = cfg.getConfigurationSection("InventoryItem.Lobby" + lobby);
        int keys = cs.getKeys(false).size();
        return keys;
    }

    public ItemStack getItem(){
        Material material1 = Material.getMaterial(cfg.getString("InventoryItem.Lobby" + lobby + ".Item" + item + ".Material"));
        String name1 = cfg.getString("InventoryItem.Lobby" + lobby + ".Item" + item + ".Name");
        int amout1 = cfg.getInt("InventoryItem.Lobby" + lobby + ".Item" + item + ".Amout");
        String[] lore1 = cfg.getStringList("InventoryItem.Lobby" + lobby + ".Item" + item + ".Lore").toArray(new String[0]);
        ItemStack item = new ItemStack(new CreateItem(material1).setName(name1).setAmout(amout1).setLore(lore1).create());
        return item;
    }

    public int getSlot() {
        return cfg.getInt("InventoryItem.Lobby" + lobby + ".Item" + item + ".Slot");
    }

    public String getName() {
        return cfg.getString("InventoryItem.Lobby" + lobby + ".Item" + item + ".Name");
    }

    public boolean isSpawn(){
        return cfg.getBoolean("InventoryItem.Lobby" + lobby + ".Item" + item + ".Spawn");
    }

    public Location getLocation(){
        boolean spawn = cfg.getBoolean("InventoryItem.Lobby" + lobby + ".Item" + item + ".Spawn");
        if(spawn){
            if(ArrayLists.getLobby1().contains(player.getName())){
                SpawnLocation spawnLocation = new SpawnLocation(0);
                return spawnLocation.getLocation();
            }
            if(ArrayLists.getLobby2().contains(player.getName())){
                SpawnLocation spawnLocation = new SpawnLocation(1);
                return spawnLocation.getLocation();
            }
            if(ArrayLists.getLobby3().contains(player.getName())){
                SpawnLocation spawnLocation = new SpawnLocation(2);
                return spawnLocation.getLocation();
            }
            if(ArrayLists.getLobby4().contains(player.getName())){
                SpawnLocation spawnLocation = new SpawnLocation(3);
                return spawnLocation.getLocation();
            }
            if(ArrayLists.getLobby5().contains(player.getName())){
                SpawnLocation spawnLocation = new SpawnLocation(4);
                return spawnLocation.getLocation();
            }
        }else{
            String path = "InventoryItem.Lobby" + lobby + ".Item" + item + ".Location";
            String w = cfg.getString(path + ".World");
            World World = Bukkit.getWorld(w);
            double X = cfg.getDouble(path + ".X");
            double Y = cfg.getDouble(path + ".Y");
            double Z = cfg.getDouble(path + ".Z");
            float Yaw = (float) cfg.getDouble(path + ".Yaw");
            float Pitch = (float) cfg.getDouble(path + ".Pitch");
            return new Location(World, X, Y, Z, Yaw, Pitch);
        }
        return null;
    }

    public static FileConfiguration getCfg() {
        return cfg;
    }

    public boolean exist(){
        if(cfg.contains("InventoryItem.Lobby" + lobby + ".Item" + item))
            return true;
        return false;
    }

    public int getLobby() {
        return lobby;
    }

    public int getItemInt() {
        return item;
    }

    private static void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
