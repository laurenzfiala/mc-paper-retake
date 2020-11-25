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
                ItemStackFactory.create(Material.LEATHER_BOOTS).get()
        };

        DEF_TIER1_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.IRON_SWORD).addEnchantment(Enchantment.KNOCKBACK, 1).get()
        };

        RANDOM_TIER1_ITEMS = Utils.concatItemStacks(ATK_TIER1_ITEMS, DEF_TIER1_ITEMS);

        // --

        ATK_TIER2_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.CHAINMAIL_HELMET).get()
        };

        DEF_TIER2_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.IRON_SWORD).addEnchantment(Enchantment.VANISHING_CURSE, 1).get()
        };

        RANDOM_TIER2_ITEMS = Utils.concatItemStacks(ATK_TIER2_ITEMS, DEF_TIER2_ITEMS);



        // --

        ATK_TIER3_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.CHAINMAIL_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).get(),
                ItemStackFactory.create(Material.CHAINMAIL_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).get()
        };

        DEF_TIER3_ITEMS = new ItemStack[] {
                ItemStackFactory.create(Material.IRON_SWORD).addEnchantment(Enchantment.KNOCKBACK, 1).get()
        };

        RANDOM_TIER3_ITEMS = Utils.concatItemStacks(ATK_TIER3_ITEMS, DEF_TIER3_ITEMS);

    }

}
