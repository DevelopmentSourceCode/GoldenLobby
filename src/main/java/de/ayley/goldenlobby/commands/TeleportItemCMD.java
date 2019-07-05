package de.ayley.goldenlobby.commands;

import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ArrayLists;
import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportItemCMD implements CommandExecutor {

    private int lobby = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
                if (command.getName().equalsIgnoreCase("setitem")) {
                    if (player.hasPermission("Lobby.Admin")) {
                        if (args.length >= 3) {
                            if (ArrayLists.getLobby1().contains(player.getName())) {
                                this.lobby = 1;
                            }
                            if (ArrayLists.getLobby2().contains(player.getName())) {
                                this.lobby = 2;
                            }
                            if (ArrayLists.getLobby3().contains(player.getName())) {
                                this.lobby = 3;
                            }
                            if (ArrayLists.getLobby4().contains(player.getName())) {
                                this.lobby = 4;
                            }
                            if (ArrayLists.getLobby5().contains(player.getName())) {
                                this.lobby = 5;
                            }

                            ItemManager itemManager = new ItemManager(player);
                            if (itemManager.exist()) {
                                ItemManager itemManager1 = new ItemManager(player, args[0], Boolean.parseBoolean(args[1]), Integer.parseInt(args[2]), itemManager.allItems(), args[3]);
                                itemManager1.setItem();
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SetItem);
                            } else {
                                ItemManager itemManager1 = new ItemManager(player, args[0], Boolean.parseBoolean(args[1]), Integer.parseInt(args[2]), 0, args[3]);
                                itemManager1.setItem();
                                ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SetItem);
                            }
                        } else
                            ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SetItemCMD);
                    }
                }

        }
        return false;
    }
}
