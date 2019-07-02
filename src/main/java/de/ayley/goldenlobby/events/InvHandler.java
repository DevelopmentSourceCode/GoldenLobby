package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.inventare.VanishInv;
import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.ArrayLists;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InvHandler implements Listener {

    @EventHandler
    private void onOpen(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Material material1 = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("Items.Vanish.Material"));
        String vanish = GoldenLobby.getPlugin().getConfig().getString("Items.Vanish.Name");
        if(!ArrayLists.getBuild().contains(player.getName())) {
            if (LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (player.getItemInHand().getAmount() >= 0) {
                        if (player.getItemInHand().getType().equals(material1) && player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', vanish))) {
                            setInv();
                            player.openInventory(VanishInv.getInventory());
                        }
                    }
                }
            }
            if (LobbyTypeConfig.getLobbyType() == LobbyType.World) {
                SpawnLocation spawnLocation = new SpawnLocation();
                String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                for (int i = 0; i <= splitter.length - 1; i++) {
                    if (player.getWorld().getName().equals(splitter[i])) {
                        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            if (player.getItemInHand().getAmount() >= 0) {
                                if(e.getItem().hasItemMeta() && e.getItem() != null) {
                                    if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', vanish))) {
                                        setInv();
                                        player.openInventory(VanishInv.getInventory());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void setInv(){
        VanishInv.setVanishInv();
    }
}
