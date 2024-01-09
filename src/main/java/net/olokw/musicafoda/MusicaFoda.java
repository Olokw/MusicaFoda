package net.olokw.musicafoda;

import net.olokw.musicafoda.Commands.MainCommand;
import net.olokw.musicafoda.Utils.ConfigLoader;
import net.olokw.musicafoda.Managers.LoopManager;
import net.olokw.musicafoda.Managers.RegionManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MusicaFoda extends JavaPlugin {

    public static MusicaFoda instance;
    private ConfigLoader configLoader;
    private RegionManager regionManager;
    private LoopManager loopManager;

    @Override
    public void onEnable() {

        instance = this;

        regionManager = new RegionManager();
        loopManager = new LoopManager();
        configLoader = new ConfigLoader();

        configLoader.load();
        // Plugin startup logic
        Listeners.register();

        this.getCommand("musicafoda").setExecutor(new MainCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ConfigLoader getConfigLoader() {
        return configLoader;
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }

    public LoopManager getLoopManager() {
        return loopManager;
    }
}
