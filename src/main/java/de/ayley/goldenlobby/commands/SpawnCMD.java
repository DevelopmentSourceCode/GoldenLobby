package de.ayley.goldenlobby.commands;

        import de.ayley.goldenlobby.main.GoldenLobby;
        import de.ayley.goldenlobby.util.ArrayLists;
        import de.ayley.goldenlobby.util.ConfigWerte;
        import de.ayley.goldenlobby.util.SpawnLocation;
        import org.bukkit.command.Command;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.configuration.ConfigurationSection;
        import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
                    if (cmd.getName().equalsIgnoreCase("spawn")) {
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
                                if(!args[0].equalsIgnoreCase("4") || args[0].equalsIgnoreCase("5")) {
                                    player.teleport(spawnLocation.getLocation());
                                    if(ArrayLists.getLobby1().contains(player.getName())){
                                        ArrayLists.getLobby1().remove(player.getName());
                                        switch (args[0]){
                                            case "2":
                                                ArrayLists.getLobby2().add(player.getName());
                                                break;
                                            case "3":
                                                ArrayLists.getLobby3().add(player.getName());
                                                break;
                                        }
                                    }
                                    if(ArrayLists.getLobby2().contains(player.getName())){
                                        ArrayLists.getLobby2().remove(player.getName());
                                        switch (args[0]){
                                            case "1":
                                                ArrayLists.getLobby1().add(player.getName());
                                                break;
                                            case "3":
                                                ArrayLists.getLobby3().add(player.getName());
                                                break;
                                        }
                                    }
                                    if(ArrayLists.getLobby3().contains(player.getName())){
                                        ArrayLists.getLobby3().remove(player.getName());
                                        switch (args[0]){
                                            case "2":
                                                ArrayLists.getLobby2().add(player.getName());
                                                break;
                                            case "1":
                                                ArrayLists.getLobby1().add(player.getName());
                                                break;
                                        }
                                    }
                                    if(ArrayLists.getLobby4().contains(player.getName())){
                                        ArrayLists.getLobby4().remove(player.getName());
                                        switch (args[0]){
                                            case "1":
                                                ArrayLists.getLobby1().add(player.getName());
                                                break;
                                            case "2":
                                                ArrayLists.getLobby2().add(player.getName());
                                                break;
                                            case "3":
                                                ArrayLists.getLobby3().add(player.getName());
                                                break;
                                        }
                                    }
                                    if(ArrayLists.getLobby5().contains(player.getName())){
                                        ArrayLists.getLobby5().remove(player.getName());
                                        switch (args[0]){
                                            case "1":
                                                ArrayLists.getLobby1().add(player.getName());
                                                break;
                                            case "2":
                                                ArrayLists.getLobby2().add(player.getName());
                                                break;
                                            case "3":
                                                ArrayLists.getLobby3().add(player.getName());
                                                break;
                                        }
                                    }
                                }else {
                                    if(player.hasPermission("Lobby.VIP")){
                                        player.teleport(spawnLocation.getLocation());
                                        if(ArrayLists.getLobby1().contains(player.getName())){
                                            ArrayLists.getLobby1().remove(player.getName());
                                            switch (args[0]){
                                                case "4":
                                                    ArrayLists.getLobby4().add(player.getName());
                                                    break;
                                                case "5":
                                                    ArrayLists.getLobby5().add(player.getName());
                                                    break;
                                            }
                                        }
                                        if(ArrayLists.getLobby2().contains(player.getName())){
                                            ArrayLists.getLobby2().remove(player.getName());
                                            switch (args[0]){
                                                case "4":
                                                    ArrayLists.getLobby4().add(player.getName());
                                                    break;
                                                case "5":
                                                    ArrayLists.getLobby5().add(player.getName());
                                                    break;
                                            }
                                        }
                                        if(ArrayLists.getLobby3().contains(player.getName())){
                                            ArrayLists.getLobby3().remove(player.getName());
                                            switch (args[0]){
                                                case "4":
                                                    ArrayLists.getLobby4().add(player.getName());
                                                    break;
                                                case "1":
                                                    ArrayLists.getLobby5().add(player.getName());
                                                    break;
                                            }
                                        }
                                    }else
                                        ConfigWerte.playerMessage(player,GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().NoPerm);
                                }
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnTP.replace("%spawnnummer%", args[0]));
                            } else {
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnNotSet);
                            }
                        }
                    }
            }
        return false;
    }
}
