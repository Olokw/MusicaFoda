package net.olokw.musicafoda;

import net.olokw.musicafoda.Commands.MainCommand;
import net.olokw.musicafoda.ConfigUtils.ConfigLoader;
import net.olokw.musicafoda.ConfigUtils.LoopManager;
import net.olokw.musicafoda.ConfigUtils.RegionManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

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
