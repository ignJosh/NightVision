package me.josh.nightvision;

import lombok.Getter;
import me.josh.nightvision.commands.ConfigReloadCommand;
import me.josh.nightvision.commands.NightVisionCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class NightVision extends JavaPlugin {

    @Getter private static NightVision instance;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        registerCommands();

    }

    private void registerCommands(){
        getCommand("nightvision").setExecutor(new NightVisionCommand());
        getCommand("nvreload").setExecutor(new ConfigReloadCommand());
    }






}
