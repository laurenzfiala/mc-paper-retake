package dev.laurenz.mcpaperretake.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemStackFactory {

    private ItemStack stack;

    public ItemStackFactory(ItemStack stack) {
        this.stack = stack;
    }

    public ItemStackFactory addEnchantment(Enchantment enchantment, int level) {
        try {
            this.stack.addEnchantment(enchantment, level);
        } catch (IllegalArgumentException e) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Error: tried to use illegal enchantment " + enchantment.getKey() + "(" + level + ")" + " on " + stack.getData().getItemType());
        }
        return this;
    }

    public ItemStack get() {
        return this.stack;
    }

    public static ItemStackFactory create(Material material) {
        return create(material, 1);
    }

    public static ItemStackFactory create(Material material, int amount) {
        return new ItemStackFactory(new ItemStack(material, amount));
    }

}
