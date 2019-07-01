package de.ayley.goldenlobby.commands;

        import de.ayley.goldenlobby.main.GoldenLobby;
        import de.ayley.goldenlobby.util.ConfigWerte;
        import de.ayley.goldenlobby.util.SpawnLocation;
        import org.bukkit.command.Command;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args[0].equalsIgnoreCase("setspawn")) {
                if (player.hasPermission("Lobby.Admin")) {
                    if (args.length == 0) {
                        SpawnLocation spawnLocation = new SpawnLocation(player.getLocation(), 0);
                        if (spawnLocation.exist()) {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnAlreadySet.replace("%SpawnNummer%", "0"));
                        } else {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnSet.replace("%SpawnNummer%", "0"));
                        }
                    }
                    if (args.length == 1) {
                        SpawnLocation spawnLocation = new SpawnLocation(player.getLocation(), Integer.parseInt(args[0]));
                        if (spawnLocation.exist()) {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnAlreadySet.replace("%SpawnNummer%", args[1]));
                        } else {
                            spawnLocation.setLocation();
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnSet.replace("%SpawnNummer%", args[1]));
                        }
                    }
                    if (args[0].equalsIgnoreCase("spawn")) {
                        if (args.length == 0) {
                            SpawnLocation spawnLocation = new SpawnLocation(0);
                            if (spawnLocation.exist()) {
                                player.teleport(spawnLocation.getLocation());
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnTP.replace("%spawnnummer%", "0"));
                            } else {
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnNotSet);
                            }
                        }
                        if (args.length == 1) {
                            SpawnLocation spawnLocation = new SpawnLocation(Integer.parseInt(args[0]));
                            if (spawnLocation.exist()) {
                                player.teleport(spawnLocation.getLocation());
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnTP.replace("%spawnnummer%", args[1]));
                            } else {
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnNotSet);
                            }
                        }
                    }
                }else
                    ConfigWerte.playerMessage(player,GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().NoPerm);
            }
        }
        return false;
    }
}
