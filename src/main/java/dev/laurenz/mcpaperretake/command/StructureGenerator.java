package dev.laurenz.mcpaperretake.command;

import org.bukkit.Location;

import java.util.concurrent.CompletableFuture;

public abstract class StructureGenerator {

    public abstract CompletableFuture<Boolean> tryGenerate(Location location);

}
