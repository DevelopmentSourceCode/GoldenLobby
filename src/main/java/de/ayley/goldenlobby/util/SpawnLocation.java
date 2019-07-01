package de.ayley.goldenlobby.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SpawnLocation {

    private static File file = new File("plugins//GoldenLobby","Spawn.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private Location location = null;
    private int Spawn = 0;

    public SpawnLocation(Location location,int spawn){
        this.location = location;
        this.Spawn = spawn;
    }

    public SpawnLocation(int spawn){
        this.Spawn = spawn;
    }

    public SpawnLocation(){}

    public void setLocation(){
        if(!exist()) {
            cfg.set("Spawn" + Spawn + ".World", location.getWorld().getName());
            cfg.set("Spawn" + Spawn + ".X", location.getX());
            cfg.set("Spawn" + Spawn + ".Y", location.getY());
            cfg.set("Spawn" + Spawn + ".Z", location.getZ());
            cfg.set("Spawn" + Spawn + ".Yaw", location.getYaw());
            cfg.set("Spawn" + Spawn + ".Pitch", location.getPitch());
        }else {

        }
            save();
    }

    public boolean exist(){
        if(cfg.contains("Spawn" + Spawn))
            return true;
        return false;
    }

    public Location getLocation(){
        String world = cfg.getString("Spawn" + Spawn + ".World");
        World World = Bukkit.getWorld(world);
        double X = cfg.getDouble("Spawn" + Spawn + ".X");
        double Y = cfg.getDouble("Spawn" + Spawn + ".Y");
        double Z = cfg.getDouble("Spawn" + Spawn + ".Z");
        float Yaw = (float) cfg.getDouble("Spawn" + Spawn + ".Yaw");
        float Pitch = (float) cfg.getDouble("Spawn" + Spawn + ".Pitch");

        return new Location(World, X, Y, Z, Yaw, Pitch);
    }

    public String getWorld() {
        int keys = cfg.getKeys(false).size()-1;
        String out = " ";
        for(int i = 0; i <= keys;i++){
            out = cfg.getString("Spawn" + i + ".World") + "," + out;
        }
        out.trim();
        out.substring(0, out.length()-5);
        return out;
    }

    private static void save() {
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
