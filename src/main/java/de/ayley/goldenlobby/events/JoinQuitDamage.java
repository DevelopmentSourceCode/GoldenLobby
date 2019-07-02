package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.items.SetLobbyItems;
import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ArrayLists;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.BufferedReader;

public class JoinQuitDamage implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.getInventory().clear();
        if(player.getExp() > 0){
            player.setExp(0f);
        }
        player.setGameMode(GameMode.SURVIVAL);
        SetLobbyItems slt = new SetLobbyItems(player);
        slt.setItems();
        LobbyTypeConfig ltc = new LobbyTypeConfig(LobbyTypeConfig.getLobbyType(),player);
        ltc.lobbyType();
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Join.replace("%player%",player.getDisplayName())));
        player.setFoodLevel(20);
        player.setHealthScale(20);
        if(!ArrayLists.getNoVanish().contains(player.getName())){
           ArrayLists.getNoVanish().add(player.getName());
        }
        if(!ArrayLists.getLobby1().contains(player.getName())){
            ArrayLists.getLobby1().add(player.getName());
        }
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        if(ArrayLists.getBuild().contains(player.getName())){
            ArrayLists.getBuild().remove(player.getName());
        }
        if(ArrayLists.getLobby1().contains(player.getName())){
            ArrayLists.getLobby1().remove(player.getName());
        }
        if(ArrayLists.getLobby2().contains(player.getName())){
            ArrayLists.getLobby2().remove(player.getName());
        }
        if(ArrayLists.getLobby3().contains(player.getName())){
            ArrayLists.getLobby3().remove(player.getName());
        }
        if(ArrayLists.getLobby4().contains(player.getName())){
            ArrayLists.getLobby4().remove(player.getName());
        }
        if(ArrayLists.getLobby5().contains(player.getName())){
            ArrayLists.getLobby5().remove(player.getName());
        }
        if(ArrayLists.getVanish().contains(player.getName())){
            ArrayLists.getVanish().remove(player.getName());
            for(Player p : Bukkit.getOnlinePlayers()){
                player.showPlayer(p);
            }
        }
        if(ArrayLists.getNoVanish().contains(player.getName())){
            ArrayLists.getNoVanish().remove(player.getName());
            for(Player p : Bukkit.getOnlinePlayers()){
                player.showPlayer(p);
            }
        }
        if(ArrayLists.getSeeVIPPremium().contains(player.getName())){
            ArrayLists.getSeeVIPPremium().remove(player.getName());
            for(Player p : Bukkit.getOnlinePlayers()){
                player.showPlayer(p);
            }
        }
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Quit.replace("%player%",player.getDisplayName())));
    }

    @EventHandler
    private void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
           if(LobbyTypeConfig.getLobbyType() == LobbyType.Server){
               e.setCancelled(true);
           }
           if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
               Player player = (Player) e.getEntity();
               SpawnLocation spawnLocation = new SpawnLocation();
               String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
               for (int i = 0; i <= splitter.length - 1; i++) {
                   if (player.getWorld().getName().equals(splitter[i])) {
                        e.setCancelled(true);
                   }
               }
           }
        }
    }

    @EventHandler
    private void onFood(FoodLevelChangeEvent e){
        if(e.getEntity() instanceof Player) {
            if(LobbyTypeConfig.getLobbyType() == LobbyType.Server){
                e.setCancelled(true);
            }
            if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
                Player player = (Player) e.getEntity();
                SpawnLocation spawnLocation = new SpawnLocation();
                String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                for (int i = 0; i <= splitter.length - 1; i++) {
                    if (player.getWorld().getName().equals(splitter[i])) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}