package de.ayley.goldenlobby.events;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SignTeleport implements Listener {

    @EventHandler
    private void onSignClick(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getClickedBlock().getType() == Material.WALL_SIGN){
                Sign s = (Sign) e.getClickedBlock().getState();
                String server = s.getLine(0).replace("[","").replace("]","");

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(byteArrayOutputStream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF(server);
                    player.sendMessage("Ja");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
