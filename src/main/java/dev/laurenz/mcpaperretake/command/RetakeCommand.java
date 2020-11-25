package dev.laurenz.mcpaperretake.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

public class RetakeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Location center = ((Entity) sender).getWorld().getSpawnLocation();
        new ChestSpawner().spawnChests(
                center,
                101,
                105,
                1,
                new ChestGenerator(new ChestFiller(center, new ChestFillerData()))
        );

        return true;

    }

}
