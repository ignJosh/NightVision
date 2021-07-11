package me.josh.nightvision;

import lombok.experimental.UtilityClass;
import me.josh.nightvision.utils.MetaUtil;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author Josh Becconsall (https://github.com/ignJosh)
 * @Date 11/07/2021 19:42
 */

@UtilityClass
public class API {

    public String nightVisionMeta = "hasNightVision";

    public void giveNightVision(Player player, boolean enabled){
        if (enabled){
            MetaUtil.apply(player, nightVisionMeta, true);
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1, true, false));
        }
    }

    public void takeNightVision(Player player, boolean enabled){
        if (enabled){
            MetaUtil.remove(player, nightVisionMeta);
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }

}
