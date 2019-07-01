package de.ayley.goldenlobby.util;

import de.ayley.goldenlobby.enums.LobbyType;
import de.ayley.goldenlobby.main.GoldenLobby;
import org.bukkit.entity.Player;

public class LobbyTypeConfig {

    private LobbyType lobbyType = null;
    private Player player = null;

    public LobbyTypeConfig(LobbyType lobbyType, Player player){
        this.lobbyType = lobbyType;
        this.player = player;
    }

    public static LobbyType getLobbyType(){
        String pfad = GoldenLobby.getPlugin().getConfig().getString("Settings.LobbyType");
        switch (pfad){
            case "World":
                return LobbyType.World;
            case "Server":
                return LobbyType.Server;
        }
        return null;
    }

    public void lobbyType(){
        if(lobbyType == LobbyType.World){
            SpawnLocation sl = new SpawnLocation(0);
            if(sl.exist()){
                player.teleport(sl.getLocation());
            }else {
                if(player.hasPermission("Lobby.Admin") || player.isOp()){
                    ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnNotSet);
                    ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().LobbyTypeInfo);
                    ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().LobbyType.replace("%type%", LobbyTypeConfig.getLobbyType().toString()));
                }
            }
        }
        if(lobbyType == LobbyType.Server){
            SpawnLocation sl = new SpawnLocation(0);
            if(sl.exist()){
                player.teleport(sl.getLocation());
            }else{
                if(player.hasPermission("Lobby.Admin") || player.isOp()) {
                    ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().SpawnNotSet);
                    ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().LobbyTypeInfo);
                    ConfigWerte.playerMessage(player, GoldenLobby.getConfigWerte().Prefix + GoldenLobby.getConfigWerte().LobbyType.replace("%type%", LobbyTypeConfig.getLobbyType().toString()));
                }
            }
        }
    }
}
