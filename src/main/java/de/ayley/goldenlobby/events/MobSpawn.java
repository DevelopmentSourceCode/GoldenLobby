package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSpawn implements Listener {

    @EventHandler
    private void onMobSpawn(EntitySpawnEvent e) {
        if (e.getEntity() instanceof Monster || e.getEntity() instanceof Animals || e.getEntity() instanceof Villager) {
            if (LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
                e.setCancelled(true);
            }
            if (LobbyTypeConfig.getLobbyType() == LobbyType.World) {
                SpawnLocation spawnLocation = new SpawnLocation();

                String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                for (int i = 0; i <= splitter.length - 1; i++) {
                    if(e.getEntity().getWorld().getName().equals(splitter[i])){
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}