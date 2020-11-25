package dev.laurenz.mcpaperretake.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

public class RetakeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Bukkit.getServer().broadcastMessage("start");
        long start = System.currentTimeMillis();

        Location center = ((Entity) sender).getWorld().getSpawnLocation();
        new ChestSpawner().spawnChests(
                center,
                101,
                500,
                0.05f,
                new ChestGenerator(
                        new ChestFiller(
                                center,
                                new ChestFillerData()
                        )
                )
        ).thenRun(() -> {
            Bukkit.getServer().broadcastMessage("spawning took " + ((System.currentTimeMillis() - start) / 1000));
        });

        return true;

    }

}
