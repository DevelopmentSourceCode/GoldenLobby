package de.ayley.goldenlobby.main;

import de.ayley.goldenlobby.commands.BuildCMD;
import de.ayley.goldenlobby.commands.SpawnCMD;
import de.ayley.goldenlobby.events.BuildProtection;
import de.ayley.goldenlobby.events.JoinQuitDeath;
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
        MessagesConfig.setMessages();
        saveDefaultConfig();
        plugin = this;
        configWerte = new ConfigWerte();
        ConfigWerte.consoleMessage(getConfigWerte().Prefix);
        registerEvents(Bukkit.getPluginManager());
        registerCommands();
    }

    private void registerEvents(PluginManager pm){
        pm.registerEvents(new JoinQuitDeath(),this);
        pm.registerEvents(new BuildProtection(),this);
    }

    private void registerCommands(){
        getCommand("spawn").setExecutor(new SpawnCMD());
        getCommand("setspawn").setExecutor(new SpawnCMD());
        getCommand("build").setExecutor(new BuildCMD());
    }

    public static GoldenLobby getPlugin() {
        return plugin;
    }

    public static ConfigWerte getConfigWerte() {
        return configWerte;
    }
}
