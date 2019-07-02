package de.ayley.goldenlobby.commands;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class ClearCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(LobbyTypeConfig.getLobbyType() == LobbyType.Server){
                for(World w : Bukkit.getServer().getWorlds()) {
                    for (Entity e : Bukkit.getWorld(w.getName()).getEntities()){
                        if(!(e instanceof Player)){
                            e.remove();
                        }
                    }
                }
                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().ClearMobs);
                return true;
            }
            if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
                SpawnLocation spawnLocation = new SpawnLocation();
                String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                for (int i = 0; i <= splitter.length - 1; i++) {
                    if (player.getWorld().getName().equals(splitter[i])) {
                        for(Entity e : Bukkit.getWorld(splitter[i]).getEntities()){
                            if(!(e instanceof Player)){
                                e.remove();
                            }
                        }
                    }
                }
                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().ClearMobs);
                return true;
            }
        }
        return false;
    }
}
