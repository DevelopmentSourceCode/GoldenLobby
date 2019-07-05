package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.inventare.TeleporterInv;
import de.ayley.goldenlobby.util.ItemManager;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvHandlerTeleport implements Listener {

    @EventHandler
    private void onClick(InventoryClickEvent e){
        if(e.getWhoClicked() instanceof Player){
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() != null){
                if(LobbyTypeConfig.getLobbyType() == LobbyType.Server){

                }
                if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
                    String InvName = TeleporterInv.getCfg().getString("Settings.InvName");
                    if (e.getClickedInventory().getTitle().equals(ChatColor.translateAlternateColorCodes('&', InvName))) {
                        e.setCancelled(true);
                        ItemManager itemManager = new ItemManager(player);
                        for(int i = 0; i <= itemManager.allItems() -1;i++){
                            ItemManager itemManager1 = new ItemManager(i,player);
                            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', itemManager1.getName()))){
                                if(itemManager1.isSpawn()){
                                    SpawnLocation spawnLocation = new SpawnLocation(itemManager1.getLobby() -1);
                                    if(spawnLocation.exist()){
                                        player.teleport(spawnLocation.getLocation());
                                    }
                                }else{
                                    player.teleport(itemManager1.getLocation());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
