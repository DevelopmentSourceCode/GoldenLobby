package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.inventare.VanishInv;
import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ArrayLists;
import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvHandlerVanish implements Listener {

    @EventHandler
    private void onClick(InventoryClickEvent e){
            Player player = (Player) e.getWhoClicked();
            if(LobbyTypeConfig.getLobbyType() == LobbyType.Server){
                String InvName = VanishInv.getCfg().getString("Settings.InvName");
                if(e.getWhoClicked().getInventory().getName().equals(ChatColor.translateAlternateColorCodes('&', InvName))){
                    String SeeAll = VanishInv.getCfg().getString("SeeAll.Name");
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&',SeeAll))){
                        if(ArrayLists.getNoVanish().contains(player.getName())){

                        }
                        if(ArrayLists.getSeeVIPPremium().contains(player.getName())){

                        }
                        if(ArrayLists.getVanish().contains(player.getName())){

                        }
                    }
                    String SeeNothing = VanishInv.getCfg().getString("SeeNothing.Name");
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', SeeNothing))){

                    }
                    String SeeVIPPremium = VanishInv.getCfg().getString("SeeVIPPremium.Name");
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&',SeeVIPPremium))){

                    }
                }
            }
            if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
                String InvName = VanishInv.getCfg().getString("Settings.InvName");
                if(e.getClickedInventory().getTitle().equals(ChatColor.translateAlternateColorCodes('&',InvName))) {
                    e.setCancelled(true);
                    SpawnLocation spawnLocation = new SpawnLocation();
                    String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                    for (int i = 0; i <= splitter.length - 1; i++) {
                        if (player.getWorld().getName().equals(splitter[i])) {
                            String SeeAll = VanishInv.getCfg().getString("SeeAll.Name");
                            if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem() != null) {
                                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', SeeAll))) {
                                    if (ArrayLists.getSeeVIPPremium().contains(player.getName())) {
                                        ArrayLists.getSeeVIPPremium().remove(player.getName());
                                        ArrayLists.getNoVanish().add(player.getName());
                                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Show);
                                        for(Player p : Bukkit.getOnlinePlayers()){
                                            player.showPlayer(p);
                                        }
                                        return;
                                    }
                                    if (ArrayLists.getVanish().contains(player.getName())) {
                                        ArrayLists.getVanish().remove(player.getName());
                                        ArrayLists.getNoVanish().add(player.getName());
                                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Show);
                                        for(Player p : Bukkit.getOnlinePlayers()){
                                            player.showPlayer(p);
                                        }
                                        return;
                                    }
                                }
                                String SeeNothing = VanishInv.getCfg().getString("SeeNothing.Name");
                                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', SeeNothing))) {
                                    if (ArrayLists.getNoVanish().contains(player.getName())) {
                                        ArrayLists.getNoVanish().remove(player.getName());
                                        ArrayLists.getVanish().add(player.getName());
                                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Hide);
                                        for(Player p : Bukkit.getOnlinePlayers()){
                                            player.hidePlayer(p);
                                        }
                                        return;
                                    }
                                    if (ArrayLists.getSeeVIPPremium().contains(player.getName())) {
                                        ArrayLists.getSeeVIPPremium().remove(player.getName());
                                        ArrayLists.getVanish().add(player.getName());
                                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().Hide);
                                        for(Player p : Bukkit.getOnlinePlayers()){
                                            player.hidePlayer(p);
                                        }
                                        return;
                                    }
                                }
                                String SeeVIPPremium = VanishInv.getCfg().getString("SeeVIPPremium.Name");
                                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', SeeVIPPremium))) {
                                    if (ArrayLists.getNoVanish().contains(player.getName())) {
                                        ArrayLists.getNoVanish().remove(player.getName());
                                        ArrayLists.getSeeVIPPremium().add(player.getName());
                                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().HideVIPPremium);
                                        for(Player p : Bukkit.getOnlinePlayers()){
                                            if(!p.hasPermission("Lobby.vip") || !p.hasPermission("Lobby.Premium")){
                                                player.hidePlayer(p);
                                            }
                                        }
                                        return;
                                    }
                                    if (ArrayLists.getVanish().contains(player.getName())) {
                                        ArrayLists.getVanish().remove(player.getName());
                                        ArrayLists.getSeeVIPPremium().add(player.getName());
                                        ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().HideVIPPremium);
                                        for(Player p : Bukkit.getOnlinePlayers()){
                                            if(!p.hasPermission("Lobby.vip") || !p.hasPermission("Lobby.Premium")){
                                                player.hidePlayer(p);
                                            }
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    }

                }
            }

    }
}