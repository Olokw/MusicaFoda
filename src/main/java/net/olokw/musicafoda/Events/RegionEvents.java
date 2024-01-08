package net.olokw.musicafoda.Events;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import de.netzkronehd.wgregionevents.events.RegionEnterEvent;
import net.olokw.musicafoda.ConfigUtils.RegionConfig;
import net.olokw.musicafoda.MusicaFoda;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RegionEvents implements Listener {
    @EventHandler
    public void onRegionEnter(RegionEnterEvent e){

        for(ProtectedRegion region : WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(e.getPlayer().getWorld())).getApplicableRegions(BukkitAdapter.asBlockVector(e.getPlayer().getLocation()))){
            if (MusicaFoda.instance.getRegionManager().regions.containsKey(region)){
                RegionConfig regionConfig = MusicaFoda.instance.getRegionManager().regions.get(region);
                if (MusicaFoda.instance.getLoopManager().tasks.containsKey(e.getPlayer().getUniqueId())){
                    if (!MusicaFoda.instance.getLoopManager().tasks.get(e.getPlayer().getUniqueId()).getMusic().equalsIgnoreCase(regionConfig.getMusic())) {
                        e.getPlayer().stopSound(MusicaFoda.instance.getLoopManager().tasks.get(e.getPlayer().getUniqueId()).getMusic(), SoundCategory.RECORDS);
                        MusicaFoda.instance.getLoopManager().stopTimer(e.getPlayer());
                        MusicaFoda.instance.getLoopManager().tasks.remove(e.getPlayer().getUniqueId());
                    }
                }
                if (!MusicaFoda.instance.getLoopManager().tasks.containsKey(e.getPlayer().getUniqueId())){
                    MusicaFoda.instance.getLoopManager().startTimer(e.getPlayer(), regionConfig);
                }
            }
        }

    }

    @EventHandler
    public void onLogout(PlayerQuitEvent e){
        if (MusicaFoda.instance.getLoopManager().tasks.containsKey(e.getPlayer().getUniqueId())){
            if (!MusicaFoda.instance.getLoopManager().tasks.get(e.getPlayer().getUniqueId()).getBukkitTask().isCancelled()){
                MusicaFoda.instance.getLoopManager().stopTimer(e.getPlayer());
            }
            MusicaFoda.instance.getLoopManager().tasks.remove(e.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e){
        if (MusicaFoda.instance.getLoopManager().tasks.containsKey(e.getPlayer().getUniqueId())){
            if (!MusicaFoda.instance.getLoopManager().tasks.get(e.getPlayer().getUniqueId()).getBukkitTask().isCancelled()){
                MusicaFoda.instance.getLoopManager().stopTimer(e.getPlayer());
            }
            MusicaFoda.instance.getLoopManager().tasks.remove(e.getPlayer().getUniqueId());
        }
    }
}
