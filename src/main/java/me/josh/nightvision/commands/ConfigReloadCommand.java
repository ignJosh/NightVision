package me.josh.nightvision.commands;

import me.josh.nightvision.NightVision;
import me.josh.nightvision.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Josh Becconsall (https://github.com/ignJosh)
 * @Date 11/07/2021 20:13
 */

public class ConfigReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("nightvision.admin") || player.isOp()) {
                NightVision.getInstance().reloadConfig();
                player.sendMessage(CC.GREEN + "Reloaded config");
            }else{
                player.sendMessage(CC.RED + "No Permission");
            }
        } else {
            NightVision.getInstance().reloadConfig();
            sender.sendMessage(CC.GREEN + "Reloaded config");
        }

        return false;

    }
}
