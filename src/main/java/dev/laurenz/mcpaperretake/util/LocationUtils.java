package dev.laurenz.mcpaperretake.util;

import org.bukkit.Location;

public class LocationUtils {

    public static int distanceXZ(Location a, int xb, int zb) {
        return distanceXZ(a.getBlockX(), a.getBlockZ(), xb, zb);
    }

    public static int distanceXZ(int xa, int za, int xb, int zb) {
        return (int) Math.round(Math.sqrt(Math.pow(xa - xb, 2) + Math.pow(za - zb, 2)));
    }

}
