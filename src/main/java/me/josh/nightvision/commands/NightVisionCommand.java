package me.josh.nightvision.commands;

import de.themoep.inventorygui.GuiStateElement;
import de.themoep.inventorygui.InventoryGui;
import de.themoep.inventorygui.StaticGuiElement;
import me.josh.nightvision.API;
import me.josh.nightvision.NightVision;
import me.josh.nightvision.utils.CC;
import me.josh.nightvision.utils.MetaUtil;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Josh Becconsall (https://github.com/ignJosh)
 * @Date 11/07/2021 19:38
 */

public class NightVisionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.PLAYER_ONLY);
        } else {
            Player player = (Player) sender;

            if (NightVision.getInstance().getConfig().getBoolean("gui.use")) {

                String title = CC.translate(NightVision.getInstance().getConfig().getString("gui.title"));

                boolean usePerm = NightVision.getInstance().getConfig().getBoolean("permission.require");

                String[] guiSetup = {
                        "    g    "
                };

                InventoryGui gui = new InventoryGui(NightVision.getInstance(), player, title, guiSetup);
                gui.setFiller(new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1));
                GuiStateElement element = new GuiStateElement('g',
                        new GuiStateElement.State(
                                change -> {
                                    API.takeNightVision(player, true);
                                    player.sendMessage(CC.translate(NightVision.getInstance().getConfig().getString("messages.disabled")));
                                },
                                "nightVisionEnabled",
                                new ItemStack(Material.RED_CONCRETE),
                                CC.GREEN + "Enable NightVision",
                                "",
                                CC.GRAY + "Click to enable night vision"
                        ),
                        new GuiStateElement.State(
                                change -> {
                                    API.giveNightVision(player, true);
                                    player.sendMessage(CC.translate(NightVision.getInstance().getConfig().getString("messages.enabled")));
                                },
                                "nightVisionDisabled",
                                new ItemStack(Material.GREEN_CONCRETE),
                                CC.RED + "Disable NightVision",
                                "",
                                CC.GRAY + "Click to disable night vision"
                        )
                );


                if (player.hasMetadata(API.nightVisionMeta)) {
                    element.setState("nightVisionDisabled");
                } else {
                    element.setState("nightVisionEnabled");
                }

                gui.addElement(element);


                gui.show(player);
            } else {
                /*
                if (player.hasMetadata(API.nightVisionMeta)) {
                    API.takeNightVision(player, true);
                    player.sendMessage(CC.translate(NightVision.getInstance().getConfig().getString("messages.disabled")));

                } else {
                    API.giveNightVision(player, true);
                    player.sendMessage(CC.translate(NightVision.getInstance().getConfig().getString("messages.enabled")));
                }
                */
                API.giveNightVision(player, !player.hasMetadata(API.nightVisionMeta)); // reversed
                player.sendMessage(player.hasMetadata(API.nightVisionMeta) ? CC.translate(NightVision.getInstance().getConfig().getString("messages.disabled") : CC.translate(NightVision.getInstance().getConfig().getString("messages.enabled"));
                
            }

        }

        return false;
    }
}
