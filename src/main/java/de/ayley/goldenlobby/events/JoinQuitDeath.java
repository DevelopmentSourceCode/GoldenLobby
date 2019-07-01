package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.items.SetLobbyItems;
import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ArrayLists;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitDeath implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        SetLobbyItems slt = new SetLobbyItems(player);
        slt.setItems();
        LobbyTypeConfig ltc = new LobbyTypeConfig(LobbyTypeConfig.getLobbyType(),player);
        ltc.lobbyType();
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Join.replace("%player%",player.getDisplayName())));
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        if(ArrayLists.getBuild().contains(player.getName())){
            ArrayLists.getBuild().remove(player.getName());
        }
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Quit.replace("%player%",player.getDisplayName())));
    }

    @EventHandler
    private void onDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Death.replace("%player%",player.getDisplayName())));
    }
}
