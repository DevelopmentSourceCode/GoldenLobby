package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.util.ConfigWerte;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherStormDay implements Listener {

    @EventHandler
    private void onWeather(WeatherChangeEvent e) {
        if (LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
            boolean rain = e.toWeatherState();
            if (rain)
                e.setCancelled(true);
        }

        if (LobbyTypeConfig.getLobbyType() == LobbyType.World) {
            SpawnLocation spawnLocation = new SpawnLocation();
            String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
            for (int i = 0; i <= splitter.length - 1; i++) {
                boolean rain = e.toWeatherState();
                if(e.getWorld().getName().equals(splitter[i])){
                    if(rain)
                        e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    private void onThunder(ThunderChangeEvent e){
        if (LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
            boolean storm = e.toThunderState();
            if (storm)
                e.setCancelled(true);
        }

        if (LobbyTypeConfig.getLobbyType() == LobbyType.World) {
            SpawnLocation spawnLocation = new SpawnLocation();
            String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
            for (int i = 0; i <= splitter.length - 1; i++) {
                boolean storm = e.toThunderState();
                if(e.getWorld().getName().equals(splitter[i])){
                    if(storm)
                        e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    private void onDay(PlayerMoveEvent e){
        if(LobbyTypeConfig.getLobbyType() == LobbyType.Server){
            for(World world : Bukkit.getServer().getWorlds()){
                if(world.getTime() < 12000)
                world.setTime(126584L);
            }
        }
        if (LobbyTypeConfig.getLobbyType() == LobbyType.World) {
            SpawnLocation spawnLocation = new SpawnLocation();
            String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
            for (int i = 0; i <= splitter.length - 1; i++) {
                for(World world : Bukkit.getWorlds()) {
                    if (world.getName().equals(splitter[i])) {
                        if (world.getTime() < 12000)
                            world.setTime(126584L);
                    }
                }
            }
        }
    }
}
