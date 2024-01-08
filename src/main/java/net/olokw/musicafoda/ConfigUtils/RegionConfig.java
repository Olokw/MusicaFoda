package net.olokw.musicafoda.ConfigUtils;

import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import net.olokw.musicafoda.MusicaFoda;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class RegionConfig {
    private String regionName;
    private String regionWorld;
    private String music;
    private int loopTime;
    private int volume;
    private int pitch;

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setRegionWorld(String regionWorld) {
        this.regionWorld = regionWorld;
    }

    public ProtectedRegion getRegion(){
        return WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(Bukkit.getWorld(regionWorld))).getRegion(regionName);
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public void setLoopTime(int loopTime){
        this.loopTime = loopTime;
    }

    public int getLoopTime() {
        return loopTime;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }
}
