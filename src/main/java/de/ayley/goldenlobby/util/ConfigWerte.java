package de.ayley.goldenlobby.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ConfigWerte {
    //Settings
    public final String Prefix = MessagesConfig.getCfg().getString("Settings.Prefix");
    public final String LobbyTypeInfo = MessagesConfig.getCfg().getString("Settings.LobbyTypeInfo");
    public final String LobbyType = MessagesConfig.getCfg().getString("Settings.LobbyType");
    public final String NoPerm = MessagesConfig.getCfg().getString("Settings.NoPerm");

    //Spawn
    public final String SpawnTP = MessagesConfig.getCfg().getString("Spawn.Teleportation");
    public final String SpawnSet = MessagesConfig.getCfg().getString("Spawn.Set");
    public final String SpawnAlreadySet = MessagesConfig.getCfg().getString("Spawn.AlreadySet");
    public final String SpawnNotSet = MessagesConfig.getCfg().getString("Spawn.NotExist");

    //JoinQuitDeath
    public final String Join = MessagesConfig.getCfg().getString("JoinQuitDeath.Join");
    public final String Quit = MessagesConfig.getCfg().getString("JoinQuitDeath.Quit");

    //Build
    public final String BuildOn = MessagesConfig.getCfg().getString("Build.On");
    public final String BuildOff = MessagesConfig.getCfg().getString("Build.Off");

    //Vanish
    public final String Hide = MessagesConfig.getCfg().getString("Vanish.Hide");
    public final String Show = MessagesConfig.getCfg().getString("Vanish.Show");
    public final String HideVIPPremium = MessagesConfig.getCfg().getString("Vanish.HideVIPPremium");

    //Clear
    public final String ClearMobs = MessagesConfig.getCfg().getString("Clear.Lag");
    public final String ClearChat = MessagesConfig.getCfg().getString("Clear.Chat");

    //SetItem
    public final String SetItemCMD= MessagesConfig.getCfg().getString("SetItem.Command");
    public final String SetItem = MessagesConfig.getCfg().getString("SetItem.Set");

    public static void playerMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void consoleMessage(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void broadcastMessage(String message){
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',message));
    }
}