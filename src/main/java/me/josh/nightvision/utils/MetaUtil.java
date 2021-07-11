package me.josh.nightvision.utils;


import me.josh.nightvision.NightVision;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * @author Dan Crewe (https://github.com/DanielCrewe)
 * @Created 17/01/2021
 */
public class MetaUtil {
    /**
     * Just to make life a bit easier ^o*
     *
     * @param player
     * @param metaData
     * @param value
     */
    public static void apply(Player player, String metaData, boolean value) {
        player.setMetadata(metaData, new FixedMetadataValue(NightVision.getInstance(), value));
    }



    /**
     * And a slightly bit more easier... lol
     * @param player
     * @param metaData
     */

    public static void remove(Player player, String metaData){
        player.removeMetadata(metaData, NightVision.getInstance());
    }
}
