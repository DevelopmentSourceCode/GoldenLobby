package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJump implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e){
        boolean activate = GoldenLobby.getPlugin().getConfig().getBoolean("DoubleJump.Activate");
        Player player = e.getPlayer();
        if(activate){
            if(LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
                player.setAllowFlight(true);
                player.setFlying(false);
            }
            if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
                SpawnLocation spawnLocation = new SpawnLocation();
                String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                for (int i = 0; i <= splitter.length - 1; i++) {
                    if (player.getWorld().getName().equals(splitter[i])) {
                        player.setAllowFlight(true);
                        player.setFlying(false);
                    }
                }
            }
        }
    }

    @EventHandler
    private void onFly(PlayerToggleFlightEvent e){
        Player player = e.getPlayer();
        boolean activate = GoldenLobby.getPlugin().getConfig().getBoolean("DoubleJump.Activate");
        if(activate){
            if(LobbyTypeConfig.getLobbyType() == LobbyType.Server){
                if(player.getGameMode() == GameMode.SURVIVAL){
                    double multiply = GoldenLobby.getPlugin().getConfig().getDouble("DoubleJump.Multiply");
                    double height = GoldenLobby.getPlugin().getConfig().getDouble("DoubleJump.Height");
                    e.setCancelled(true);
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    Vector v = player.getLocation().getDirection().multiply(multiply).setY(height);
                    player.setVelocity(v);
                }
            }
            if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
                SpawnLocation spawnLocation = new SpawnLocation();
                String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                for (int i = 0; i <= splitter.length - 1; i++) {
                    if (player.getWorld().getName().equals(splitter[i])) {
                        if(player.getGameMode() == GameMode.SURVIVAL){
                            double multiply = GoldenLobby.getPlugin().getConfig().getDouble("DoubleJump.Multiply");
                            double height = GoldenLobby.getPlugin().getConfig().getDouble("DoubleJump.Height");
                            e.setCancelled(true);
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            Vector v = player.getLocation().getDirection().multiply(multiply).setY(height);
                            player.setVelocity(v);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    private void onMove(PlayerMoveEvent e){
        boolean activate = GoldenLobby.getPlugin().getConfig().getBoolean("DoubleJump.Activate");
        Player player = e.getPlayer();
        if(activate){
            if(LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
                if(player.getLocation().subtract(0,1,0).getBlock().getType() != Material.AIR){
                    player.setAllowFlight(true);
                    player.setFlying(false);
                }
            }
            if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
                SpawnLocation spawnLocation = new SpawnLocation();
                String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
                for (int i = 0; i <= splitter.length - 1; i++) {
                    if (player.getWorld().getName().equals(splitter[i])) {
                        if(player.getLocation().subtract(0,1,0).getBlock().getType() != Material.AIR){
                            player.setAllowFlight(true);
                            player.setFlying(false);
                        }
                    }
                }
            }
        }
    }
}
