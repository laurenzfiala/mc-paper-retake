package dev.laurenz.mcpaperretake.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class ChestGenerator extends StructureGenerator {

    public static final Material[] CHEST_GROUND_MATERIAL_CANDIDATES = new Material[] {
            Material.GRASS_BLOCK,
            Material.DIRT,
            Material.COARSE_DIRT,
            Material.SAND,
            Material.MYCELIUM,
            Material.STONE,
            Material.DIORITE,
            Material.ANDESITE,
            Material.COAL_ORE,
            Material.IRON_ORE
    };

    private ChestFiller filler;

    public ChestGenerator(ChestFiller filler) {
        this.filler = filler;
    }

    @Override
    public CompletableFuture<Boolean> tryGenerate(Location location) {

        Block ground = location.getBlock();
        if (Arrays.stream(CHEST_GROUND_MATERIAL_CANDIDATES)
                .anyMatch(m -> m == ground.getType())) {

            ground.setType(Material.SEA_LANTERN);

            Location groudLoc = ground.getLocation();

            Block chestBlock = groudLoc.clone().add(0, 1, 0).getBlock();
            chestBlock.setType(Material.CHEST);

            Block aboveChest = groudLoc.clone().add(0, 2, 0).getBlock();
            if (aboveChest.getType() != Material.WATER) {
                aboveChest.setType(Material.AIR);
            }

            return this.filler.fillAsync((Chest) chestBlock.getState());
        }
        return CompletableFuture.completedFuture(false);

    }

}
