package de.ayley.goldenlobby.commands;

import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if (args[0].equalsIgnoreCase("setspawn")) {
                if (player.hasPermission("Lobby.Admin")) {
                    if (args.length == 1) {
                        SpawnLocation spawnLocation = new SpawnLocation(player.getLocation(), 0);
                        if (spawnLocation.exist()) {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnAlreadySet.replace("%SpawnNummer%", "0"));
                        } else {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnSet.replace("%SpawnNummer%", "0"));
                        }
                    }
                    if (args.length == 2) {
                        SpawnLocation spawnLocation = new SpawnLocation(player.getLocation(), Integer.parseInt(args[1]));
                        if (spawnLocation.exist()) {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnAlreadySet.replace("%SpawnNummer%", args[1]));
                        } else {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnSet.replace("%SpawnNummer%", args[1]));
                        }
                    }
                } else
                    ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().NoPerm);
            }
        }
        return false;
    }
}
