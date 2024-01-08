package net.olokw.musicafoda.ConfigUtils;

import net.olokw.musicafoda.MusicaFoda;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConfigLoader {
    public void load(){

        MusicaFoda.instance.getLoopManager().tasks.clear();
        MusicaFoda.instance.getRegionManager().clear();

        File file = new File(MusicaFoda.instance.getDataFolder(), "regions.yml");
        if(file.exists()){
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            for (String key : config.getKeys(false)) {

                String regionName = config.getString(key + ".region-name");

                String regionWorld = config.getString(key + ".region-world");

                String music = config.getString(key + ".music");

                int loopTime = config.getInt(key + ".loop-time");

                int volume = config.getInt(key + ".volume");

                int pitch = config.getInt(key + ".pitch");

                RegionConfig regionConfig = new RegionConfig();
                regionConfig.setRegionName(regionName);
                regionConfig.setRegionWorld(regionWorld);
                regionConfig.setMusic(music);
                regionConfig.setLoopTime(loopTime);
                regionConfig.setVolume(volume);
                regionConfig.setPitch(pitch);
                MusicaFoda.instance.getRegionManager().add(regionConfig.getRegion(), regionConfig);
            }
        }else{

            try {
                MusicaFoda.instance.getDataFolder().mkdir();
                Files.copy(MusicaFoda.instance.getResource("regions.yml"), file.getAbsoluteFile().toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
