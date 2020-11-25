package dev.laurenz.mcpaperretake.command;

import dev.laurenz.mcpaperretake.util.LocationUtils;
import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static dev.laurenz.mcpaperretake.McPaperRetake.CHUNK_SIZE;

public class ChestSpawner {

    public static final int CHUNK_MAX_SPAWN_AMOUNT = (int) Math.pow(CHUNK_SIZE, 2);
    public static final int CHUNK_MAX_DISTANCE = (int) Math.sqrt(Math.pow(CHUNK_SIZE, 2) * 2);

    public CompletableFuture<Void> spawnChests(Location center, int innerRadius, int outerRadius, float spawnPerChunkProbability, StructureGenerator chestGenerator) {

        Data data = new Data(center, innerRadius, outerRadius, spawnPerChunkProbability, chestGenerator);

        World world = center.getWorld();
        int centerX = (int) center.getX();
        int centerZ = (int) center.getZ();

        List<CompletableFuture<Void>> futures = new LinkedList<>();

        for (int x = centerX - outerRadius; x < centerX + outerRadius; x += 16) {
            for (int z = centerZ - outerRadius; z < centerZ + outerRadius; z += 16) {

                int distance = LocationUtils.distanceXZ(center, x, z);
                if (distance >= innerRadius - CHUNK_MAX_DISTANCE - 1 && distance <= outerRadius + CHUNK_MAX_DISTANCE) {
                    futures.add(
                        world.getChunkAtAsync(x, z)
                             .thenAccept(chunk -> this.spawnChestsForChunk(data, chunk))
                    );
                }

            }
        }

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

    }

    private CompletableFuture<Void> spawnChestsForChunk(Data data, Chunk chunk) {

        List<CompletableFuture<Boolean>> genFutures = new LinkedList<>();
        int minBlockX = chunk.getX();
        int minBlockZ = chunk.getZ();

        for (int i = 1; i <= CHUNK_MAX_SPAWN_AMOUNT && Math.random() <= data.spawnPerChunkProbability; i++) {

            int randomBlockX = (int) Math.round(Math.random() * CHUNK_SIZE + minBlockX);
            int randomBlockZ = (int) Math.round(Math.random() * CHUNK_SIZE + minBlockZ);
            int distance = LocationUtils.distanceXZ(data.center(), randomBlockX, randomBlockZ);
            if (distance > data.outerRadius() || distance < data.innerRadius()) {
                continue;
            }

            Block ground = data.world().getHighestBlockAt(randomBlockX, randomBlockZ, HeightMap.MOTION_BLOCKING_NO_LEAVES);
            CompletableFuture<Boolean> genFuture = data.generator().tryGenerate(ground.getLocation());
            genFuture.handle((aBoolean, throwable) -> {
                Bukkit.getServer().broadcastMessage("Failed to generate structure: " + throwable.getMessage());
                return false;
            });
            genFutures.add(genFuture);

        }

        return CompletableFuture.allOf(genFutures.toArray(new CompletableFuture[0]));

    }

    protected class Data {

        private Location center;
        private int innerRadius;
        private int outerRadius;
        private float spawnPerChunkProbability;
        private StructureGenerator generator;

        public Data(Location center, int innerRadius, int outerRadius, float spawnPerChunkProbability, StructureGenerator generator) {
            this.center = center;
            this.innerRadius = innerRadius;
            this.outerRadius = outerRadius;
            this.spawnPerChunkProbability = spawnPerChunkProbability;
            this.generator = generator;
        }

        public Location center() {
            return center;
        }

        public World world() {
            return center.getWorld();
        }

        public int innerRadius() {
            return innerRadius;
        }

        public int outerRadius() {
            return outerRadius;
        }

        public float spawnPerChunkProbability() {
            return spawnPerChunkProbability;
        }

        public StructureGenerator generator() {
            return generator;
        }

    }

}
