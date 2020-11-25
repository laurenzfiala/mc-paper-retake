package dev.laurenz.mcpaperretake.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class ChestFiller {

    private Location center;
    private ChestFillerData data;

    public ChestFiller(Location center, ChestFillerData data) {
        this.center = center;
        this.data = data;
    }

    public CompletableFuture<Boolean> fillAsync(Chest chest) {

        Inventory inv = chest.getBlockInventory();
        HashMap<Integer, ItemStack> notAdded;
        if (inv.isEmpty()) {
            ItemStack[] randomItems;
            double random = Math.random();
            if (random <= 0.6) {
                randomItems = this.tier1Items(Mode.RANDOM);
            } else if (random <= 0.9) {
                randomItems = this.tier2Items(Mode.RANDOM);
            } else {
                randomItems = this.tier3Items(Mode.RANDOM);
            }
            notAdded = inv.addItem(randomItems);
        } else if (inv.contains(new ItemStack(Material.HORN_CORAL_BLOCK, 1))) {
            throw new UnsupportedOperationException();
        } else if (inv.contains(new ItemStack(Material.FIRE_CORAL_BLOCK, 1))) {
            throw new UnsupportedOperationException();
        } else {
            throw new UnsupportedOperationException();
        }

        return CompletableFuture.completedFuture(notAdded.size() == 0);

    }

    private ItemStack[] tier1Items(Mode mode) {

        ItemStack[] itemOptions;
        switch (mode) {
            case RANDOM:
                itemOptions = this.data.RANDOM_TIER1_ITEMS;
                break;

            case ATTACK:
                itemOptions = this.data.ATK_TIER1_ITEMS;
                break;

            case DEFENCE:
                itemOptions = this.data.DEF_TIER1_ITEMS;
                break;

            default:
                throw new UnsupportedOperationException("chest filler mode " + mode);
        }

        return this.choose(
                itemOptions,
                1,
                3,
                0.3f
        );

    }

    private ItemStack[] tier2Items(Mode mode) {

        ItemStack[] itemOptions;
        switch (mode) {
            case RANDOM:
                itemOptions = this.data.RANDOM_TIER2_ITEMS;
                break;

            case ATTACK:
                itemOptions = this.data.ATK_TIER2_ITEMS;
                break;

            case DEFENCE:
                itemOptions = this.data.DEF_TIER2_ITEMS;
                break;

            default:
                throw new UnsupportedOperationException("chest filler mode " + mode);
        }

        return this.choose(
                itemOptions,
                2,
                5,
                0.4f
        );

    }

    private ItemStack[] tier3Items(Mode mode) {

        ItemStack[] itemOptions;
        switch (mode) {
            case RANDOM:
                itemOptions = this.data.RANDOM_TIER3_ITEMS;
                break;

            case ATTACK:
                itemOptions = this.data.ATK_TIER3_ITEMS;
                break;

            case DEFENCE:
                itemOptions = this.data.DEF_TIER3_ITEMS;
                break;

            default:
                throw new UnsupportedOperationException("chest filler mode " + mode);
        }
        
        return this.choose(
                itemOptions,
                3,
                7,
                0.5f
        );

    }

    private ItemStack[] choose(ItemStack[] itemOptions, int minItems, int maxItems, float itemProbability) {

        List<ItemStack> chosenItems = new LinkedList<>();
        for (int i = 1; i <= maxItems && (i <= minItems || Math.random() <= itemProbability); i++) {

            int chosenIndex = (int) (Math.random() * (itemOptions.length - 1));
            ItemStack chosenItem = itemOptions[chosenIndex];

            chosenItems.add(chosenItem.clone());

        }

        return chosenItems.toArray(new ItemStack[0]);

    }

    private enum Mode {
        RANDOM,
        ATTACK,
        DEFENCE
    }

}
