package dev.laurenz.mcpaperretake;

import dev.laurenz.mcpaperretake.command.RetakeCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class McPaperRetake extends JavaPlugin implements CommandExecutor, Listener {

    public static final int CHUNK_SIZE = 16;
    public static final int PLAYAREA_RADIUS = 500;

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.getCommand("retake").setExecutor(new RetakeCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
