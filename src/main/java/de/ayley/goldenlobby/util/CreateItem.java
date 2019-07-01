package de.ayley.goldenlobby.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CreateItem {

    private ItemStack itemStack = null;
    private ItemMeta itemMeta = null;

    public CreateItem(Material material,short id){
        this.itemStack = new ItemStack(material, id);
        this.itemMeta = itemStack.getItemMeta();
    }

    public CreateItem(Material material){
        this.itemStack = new ItemStack(material, (short)0);
        this.itemMeta = itemStack.getItemMeta();
    }

    public CreateItem setName(String name){
        this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
        return this;
    }

    public CreateItem setLore(String... lore){
        this.itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public CreateItem setAmout(int amount){
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemStack create(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
