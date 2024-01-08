package net.olokw.musicafoda.ConfigUtils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import net.olokw.musicafoda.MusicaFoda;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoopManager {
    public Map<UUID, LoopConfig> tasks = new HashMap<>();

    public LoopManager() {
        this.tasks = new HashMap<>();
    }

    public void startTimer(Player player, RegionConfig regionConfig) {
        String music = regionConfig.getMusic();
        int volume = regionConfig.getVolume();
        int pitch = regionConfig.getPitch();
        int loopTime = regionConfig.getLoopTime();
        BukkitTask task = new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if (i > 0){
                    boolean canContinue = false;
                    for(ProtectedRegion r : WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(player.getWorld())).getApplicableRegions(BukkitAdapter.asBlockVector(player.getLocation()))){
                        if (MusicaFoda.instance.getRegionManager().regions.containsKey(r)){
                            if (MusicaFoda.instance.getRegionManager().regions.get(r).getMusic().equalsIgnoreCase(regionConfig.getMusic())){
                                canContinue = true;
                            }
                        }
                    }
                    if (!canContinue){
                        tasks.remove(player.getUniqueId());
                        this.cancel();
                        return;
                    }
                }
                player.playSound(player, music, SoundCategory.RECORDS, volume, pitch);
                i++;
            }
        }.runTaskTimer(MusicaFoda.instance, 0, loopTime);
        LoopConfig loopConfig = new LoopConfig();
        loopConfig.setMusic(regionConfig.getMusic());
        loopConfig.setBukkitTask(task);
        tasks.put(player.getUniqueId(), loopConfig);
    }

    public void stopTimer(Player player){
        if (tasks.get(player.getUniqueId()) != null) {
            tasks.get(player.getUniqueId()).getBukkitTask().cancel();
        }
    }


}
