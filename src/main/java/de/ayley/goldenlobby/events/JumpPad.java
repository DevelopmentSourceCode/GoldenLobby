package de.ayley.goldenlobby.events;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.LobbyTypeConfig;
import de.ayley.goldenlobby.util.SpawnLocation;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class JumpPad implements Listener {

    @EventHandler
    private void onMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if(LobbyTypeConfig.getLobbyType() == LobbyType.Server) {
            Material plate = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("JumpPad.Plate"));
            Material block = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("JumpPad.Block"));
            Double multiply = GoldenLobby.getPlugin().getConfig().getDouble("JumpPad.Multiply");
            Double height = GoldenLobby.getPlugin().getConfig().getDouble("JumpPad.Height");
            if (player.getLocation().getBlock().getType().equals(plate)) {
                if (player.getLocation().subtract(0D, 1D, 0D).getBlock().getType().equals(block)) {
                    Vector v = player.getLocation().getDirection().multiply(multiply).setY(height);
                    player.setVelocity(v);
                }
            }
        }
        if(LobbyTypeConfig.getLobbyType() == LobbyType.World){
            SpawnLocation spawnLocation = new SpawnLocation();
            String[] splitter = spawnLocation.getWorld().substring(0, spawnLocation.getWorld().length() - 1).split(",");
            for (int i = 0; i <= splitter.length - 1; i++) {
                if (player.getWorld().getName().equals(splitter[i])) {
                    Material plate = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("JumpPad.Plate"));
                    Material block = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("JumpPad.Block"));
                    Double multiply = GoldenLobby.getPlugin().getConfig().getDouble("JumpPad.Multiply");
                    Double height = GoldenLobby.getPlugin().getConfig().getDouble("JumpPad.Height");
                    if (player.getLocation().getBlock().getType().equals(plate)) {
                        if (player.getLocation().subtract(0D, 1D, 0D).getBlock().getType().equals(block)) {
                            Vector v = player.getLocation().getDirection().multiply(multiply).setY(height);
                            player.setVelocity(v);
                        }
                    }
                }
            }
        }
    }
}
