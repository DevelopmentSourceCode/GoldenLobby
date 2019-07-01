package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.util.ArrayLists;
import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildProtection implements Listener {

    @EventHandler
    private void onBuild(BlockPlaceEvent e){
        Player player = e.getPlayer();
        if(LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
            if (!ArrayLists.getBuild().contains(player.getName())) {
                e.setCancelled(true);
            }
        }else
        if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
            SpawnLocation spawnLocation = new SpawnLocation();

            String[] splitter = spawnLocation.getWorld().substring(0,spawnLocation.getWorld().length()-1).split(",");
            ConfigWerte.playerMessage(player,"1");
            for(int i = 0; i <= splitter.length-1;i++){
                ConfigWerte.playerMessage(player,"2");
                if(player.getWorld().getName().equals(splitter[i])){
                    ConfigWerte.playerMessage(player,"3");
                    if(!ArrayLists.getBuild().contains(player.getName())){
                        ConfigWerte.playerMessage(player,"4");
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    private void onBreake(BlockBreakEvent e){
        Player player = e.getPlayer();
        if(!ArrayLists.getBuild().contains(player.getName())){
            e.setCancelled(true);
        }
    }
}
