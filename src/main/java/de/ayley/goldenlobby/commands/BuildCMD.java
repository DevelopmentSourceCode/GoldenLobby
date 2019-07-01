package de.ayley.goldenlobby.commands;

import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ArrayLists;
import de.ayley.goldenlobby.util.ConfigWerte;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("build")){
                if(player.hasPermission("Lobby.Build")) {
                    if (ArrayLists.getBuild().contains(player.getName())) {
                        player.setGameMode(GameMode.SURVIVAL);
                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().BuildOff);
                        ArrayLists.getBuild().remove(player.getName());
                    } else {
                        player.setGameMode(GameMode.CREATIVE);
                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().BuildOn);
                        ArrayLists.getBuild().add(player.getName());
                    }
                }
            }else
                ConfigWerte.playerMessage(player,GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().NoPerm);
        }
        return false;
    }
}
