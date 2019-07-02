package de.ayley.goldenlobby.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessagesConfig {

    private static File file = new File("plugins//GoldenLobby","Messages.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static FileConfiguration getCfg() {
        return cfg;
    }

    public static void setMessages(){
        if(!cfg.contains("Settings")){
            cfg.set("Settings.Prefix", "&6[GoldenLobby] ");
            cfg.set("Settings.LobbyTypeInfo", "LobbyType World: Eine Welt wird als lobby genutzt\n LobbyType Server: Ein Server wird als Lobby genutzt.");
            cfg.set("Settings.LobbyType", "Akutueller LobbyType: %type%");
            cfg.set("Settings.NoPerm", "&cDazu hast du keine genügenden Rechte!");
        }
        if(!cfg.contains("Spawn")){
            cfg.set("Spawn.Teleportation", "&2Du wurdest zum Spawn &6%spawnnummer% &2Teleportiert!");
            cfg.set("Spawn.NotExist", "&4Der Spawnpunkt existiert nicht, bitte setze ihn mit &6/setspawn <Spawnnummer>!");
            cfg.set("Spawn.Set", "&2Du hast den Spawn &6%SpawnNummer% &2gesetzt!");
            cfg.set("Spawn.AlreadySet", "&2Du hast den Spawn &6%SpawnNummer% &2umgesetzt!");
        }
        if(!cfg.contains("JoinQuitDeath")){
            cfg.set("JoinQuitDeath.Join", "[+] %player%");
            cfg.set("JoinQuitDeath.Quit", "[-] %player%");
        }
        if(!cfg.contains("Build")){
            cfg.set("Build.On", "Du bist jetzt im Build Modus!");
            cfg.set("Build.Off", "Du bist jetzt nicht mehr im Build Modus");
        }
        if(!cfg.contains("Vanish")){
            cfg.set("Vanish.Hide", "&2Jetzt sind &6alle &2Spieler unsichtbar");
            cfg.set("Vanish.Show", "&2Jetzt sind &6alle &2Spieler nicht mehr unsichtbar");
            cfg.set("Vanish.HideVIPPremium", "&2Jetzt sind &6VIP/Premium &2Spieler unsichtbar");
        }
        if(!cfg.contains("Clear")){
            cfg.set("Clear.Lag", "Alle Monster/Items/Animals wurden entfernt!");
            cfg.set("Clear.Chat", "Der Chat wurde gelöscht!");
        }
        save();
    }

    private static void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
