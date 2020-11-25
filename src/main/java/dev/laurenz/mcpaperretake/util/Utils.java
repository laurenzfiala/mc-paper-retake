package dev.laurenz.mcpaperretake.util;

import org.bukkit.inventory.ItemStack;

public class Utils {

    public static ItemStack[] concatItemStacks(ItemStack[] a, ItemStack[] b) {

        ItemStack[] result = new ItemStack[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);

        return result;

    }

}
