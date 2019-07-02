package de.ayley.goldenlobby.main;

import de.ayley.goldenlobby.commands.BuildCMD;
import de.ayley.goldenlobby.commands.ClearCMD;
import de.ayley.goldenlobby.commands.SpawnCMD;
import de.ayley.goldenlobby.events.*;
import de.ayley.goldenlobby.inventare.VanishInv;
import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.MessagesConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GoldenLobby extends JavaPlugin {

    private static GoldenLobby plugin;
    private static ConfigWerte configWerte;

    @Override
    public void onEnable() {
        Bukkit.getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
        MessagesConfig.setMessages();
        saveDefaultConfig();
        plugin = this;
        configWerte = new ConfigWerte();
        ConfigWerte.consoleMessage(getConfigWerte().Prefix);
        registerEvents(Bukkit.getPluginManager());
        registerCommands();
        initFiles();
    }

    private void registerEvents(PluginManager pm){
        pm.registerEvents(new JoinQuitDamage(),this);
        pm.registerEvents(new BuildDropProtection(),this);
        pm.registerEvents(new MobSpawn(),this);
        pm.registerEvents(new WeatherStormDay(), this);
        pm.registerEvents(new InvHandler(),this);
        pm.registerEvents(new InvHandlerVanish(), this);
        pm.registerEvents(new JumpPad(), this);
        pm.registerEvents(new SignTeleport(), this);
    }

    private void registerCommands(){
        getCommand("spawn").setExecutor(new SpawnCMD());
        getCommand("setspawn").setExecutor(new SpawnCMD());
        getCommand("build").setExecutor(new BuildCMD());
        getCommand("clearlag").setExecutor(new ClearCMD());
    }

    private void initFiles(){
        VanishInv.createVanishItemData();
    }

    public static GoldenLobby getPlugin() {
        return plugin;
    }

    public static ConfigWerte getConfigWerte() {
        return configWerte;
    }
}
