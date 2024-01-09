package net.olokw.musicafoda.Utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitTask;

public class LoopConfig {
    private BukkitTask bukkitTask;
    private String music;

    public BukkitTask getBukkitTask() {
        return bukkitTask;
    }

    public void setBukkitTask(BukkitTask bukkitTask) {
        this.bukkitTask = bukkitTask;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
