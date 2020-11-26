package dev.laurenz.mcpaperretake.command;

import dev.laurenz.mcpaperretake.util.ItemStackFactory;
import dev.laurenz.mcpaperretake.util.Utils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ChestFillerData {

    public final ItemStack[] ATK_TIER1_ITEMS;
    public final ItemStack[] DEF_TIER1_ITEMS;
    public final ItemStack[] RANDOM_TIER1_ITEMS;

    public final ItemStack[] ATK_TIER2_ITEMS;
    public final ItemStack[] DEF_TIER2_ITEMS;
    public final ItemStack[] RANDOM_TIER2_ITEMS;

    public final ItemStack[] ATK_TIER3_ITEMS;
    public final ItemStack[] DEF_TIER3_ITEMS;
    public final ItemStack[] RANDOM_TIER3_ITEMS;

    public ChestFillerData() {

        ATK_TIER1_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.LEATHER_BOOTS).get(),
                ItemStackFactory.create(Material.LEATHER_CHESTPLATE).get(),
                ItemStackFactory.create(Material.LEATHER_HELMET).get(),
                ItemStackFactory.create(Material.LEATHER_LEGGINGS).get(),
                ItemStackFactory.create(Material.BREAD, 5).get(),
                ItemStackFactory.create(Material.STONE_SWORD).get(),
                ItemStackFactory.create(Material.ARROW, 4).get(),
                ItemStackFactory.create(Material.TORCH, 2).get()
                
        };

        DEF_TIER1_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.GOLD_INGOT, 3).get()
                
        };

        RANDOM_TIER1_ITEMS = Utils.concatItemStacks(ATK_TIER1_ITEMS, DEF_TIER1_ITEMS);

        // --

        ATK_TIER2_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.STONE_SWORD).addEnchantment(Enchantment.KNOCKBACK, 1).get(),
                ItemStackFactory.create(Material.LEATHER_BOOTS).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).get(),
                ItemStackFactory.create(Material.LEATHER_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).get(),
                ItemStackFactory.create(Material.LEATHER_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).get(),
                ItemStackFactory.create(Material.LEATHER_LEGGINGS).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).get(),
                ItemStackFactory.create(Material.STONE_AXE).get(),
                ItemStackFactory.create(Material.BOW).get(),
                ItemStackFactory.create(Material.COOKED_MUTTON, 4).get(),
                ItemStackFactory.create(Material.SPECTRAL_ARROW, 4).get(),
                
        };

        DEF_TIER2_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.GOLD_INGOT, 9).get()
        };

        RANDOM_TIER2_ITEMS = Utils.concatItemStacks(ATK_TIER2_ITEMS, DEF_TIER2_ITEMS);



        // --

        ATK_TIER3_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.CHAINMAIL_CHESTPLATE).get(),
                ItemStackFactory.create(Material.CHAINMAIL_HELMET).get(),
                ItemStackFactory.create(Material.CHAINMAIL_LEGGINGS).get(),
                ItemStackFactory.create(Material.CHAINMAIL_BOOTS).get(),
                ItemStackFactory.create(Material.CROSSBOW).get(),
                ItemStackFactory.create(Material.COOKED_BEEF, 6).get(),
                ItemStackFactory.create(Material.BOW).addEnchantment(Enchantment.ARROW_FIRE, 1).get(),
                ItemStackFactory.create(Material.STONE_AXE).addEnchantment(Enchantment.KNOCKBACK, 1).get(),
                ItemStackFactory.create(Material.IRON_SWORD).get(),
                ItemStackFactory.create(Material.SHIELD).get(),
                ItemStackFactory.create(Material.LADDER, 3).get(),
                ItemStackFactory.create(Material.GOLDEN_APPLE).get(),
                ItemStackFactory.create(Material.BIRCH_BUTTON).get(),

        };

        DEF_TIER3_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.GOLD_INGOT, 27).get()
        };

        RANDOM_TIER3_ITEMS = Utils.concatItemStacks(ATK_TIER3_ITEMS, DEF_TIER3_ITEMS);

    }

}
