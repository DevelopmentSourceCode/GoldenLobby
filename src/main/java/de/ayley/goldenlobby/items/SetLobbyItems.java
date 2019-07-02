package de.ayley.goldenlobby.items;

import de.ayley.goldenlobby.main.GoldenLobby;
import de.ayley.goldenlobby.util.CreateItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SetLobbyItems {

    private Player player = null;

    public SetLobbyItems(Player player){
        this.player = player;
    }

    public void setItems(){
        //Slot
        int slot1 = GoldenLobby.getPlugin().getConfig().getInt("Items.Vanish.Slot");
        int slot2 = GoldenLobby.getPlugin().getConfig().getInt("Items.Compass.Slot");
        int slot3 = GoldenLobby.getPlugin().getConfig().getInt("Items.Gadges.Slot");
        int slot4 = GoldenLobby.getPlugin().getConfig().getInt("Items.Cosmetics.Slot");

        //Material
        Material material1 = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("Items.Vanish.Material"));
        Material material2 = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("Items.Compass.Material"));
        Material material3 = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("Items.Gadges.Material"));
        Material material4 = Material.getMaterial(GoldenLobby.getPlugin().getConfig().getString("Items.Cosmetics.Material"));

        //ID
        short id1 = (short) GoldenLobby.getPlugin().getConfig().getInt("Items.Vanish.ID");
        short id2 = (short) GoldenLobby.getPlugin().getConfig().getInt("Items.Compass.ID");
        short id3 = (short) GoldenLobby.getPlugin().getConfig().getInt("Items.Gadges.ID");
        short id4 = (short) GoldenLobby.getPlugin().getConfig().getInt("Items.Cosmetics.ID");

        //Name
        String name1 = GoldenLobby.getPlugin().getConfig().getString("Items.Vanish.Name");
        String name2 = GoldenLobby.getPlugin().getConfig().getString("Items.Compass.Name");
        String name3 = GoldenLobby.getPlugin().getConfig().getString("Items.Gadges.Name");
        String name4 = GoldenLobby.getPlugin().getConfig().getString("Items.Cosmetics.Name");

        //Amout
        int amout1 = GoldenLobby.getPlugin().getConfig().getInt("Items.Vanish.Amout");
        int amout2 = GoldenLobby.getPlugin().getConfig().getInt("Items.Compass.Amout");
        int amout3 = GoldenLobby.getPlugin().getConfig().getInt("Items.Gadges.Amout");
        int amout4 = GoldenLobby.getPlugin().getConfig().getInt("Items.Cosmetics.Amout");

        //Lore
        String[] lore1 = GoldenLobby.getPlugin().getConfig().getStringList("Items.Vanish.Lore").toArray(new String[0]);
        String[] lore2 = GoldenLobby.getPlugin().getConfig().getStringList("Items.Compass.Lore").toArray(new String[0]);
        String[] lore3 = GoldenLobby.getPlugin().getConfig().getStringList("Items.Gadges.Lore").toArray(new String[0]);
        String[] lore4 = GoldenLobby.getPlugin().getConfig().getStringList("Items.Cosmetics.Lore").toArray(new String[0]);

        ItemStack itemStack1 = new CreateItem(material1,id1).setName(name1).setAmout(amout1).setLore(lore1).create();
        ItemStack itemStack2 = new CreateItem(material2,id2).setName(name2).setAmout(amout2).setLore(lore2).create();
        ItemStack itemStack3 = new CreateItem(material3,id3).setName(name3).setAmout(amout3).setLore(lore3).create();
        ItemStack itemStack4 = new CreateItem(material4,id4).setName(name4).setAmout(amout4).setLore(lore4).create();

        player.getInventory().setItem(slot1,itemStack1);
        player.getInventory().setItem(slot2,itemStack2);
        player.getInventory().setItem(slot3,itemStack3);
        player.getInventory().setItem(slot4,itemStack4);
    }

}
