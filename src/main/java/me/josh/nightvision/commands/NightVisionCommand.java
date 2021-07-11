package me.josh.nightvision.commands;

import me.josh.nightvision.API;
import me.josh.nightvision.NightVision;
import me.josh.nightvision.utils.CC;
import me.josh.nightvision.utils.MetaUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Josh Becconsall (https://github.com/ignJosh)
 * @Date 11/07/2021 19:38
 */

public class NightVisionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage(CC.PLAYER_ONLY);
        }else{
            Player player = (Player) sender;

            if (NightVision.getInstance().getConfig().getBoolean("gui.enabled")){
                
            }else{
                if (player.hasMetadata(API.nightVisionMeta)){
                    API.takeNightVision(player, true);
                    player.sendMessage(CC.translate(NightVision.getInstance().getConfig().getString("messages.disabled")));

                }else{
                    API.giveNightVision(player, true);
                    player.sendMessage(CC.translate(NightVision.getInstance().getConfig().getString("messages.enabled")));
                }
            }

        }

        return false;
    }
}
