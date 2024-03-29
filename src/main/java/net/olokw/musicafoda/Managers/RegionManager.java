package net.olokw.musicafoda.Managers;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import net.olokw.musicafoda.Utils.RegionConfig;

import java.util.HashMap;
import java.util.Map;

public class RegionManager {

    public Map<ProtectedRegion, RegionConfig> regions;

    public RegionManager() {
        this.regions = new HashMap<>();
    }

    public void clear() {
        regions.clear();
    }
    public void add(ProtectedRegion region, RegionConfig regionConfig) {
        regions.put(region, regionConfig);
    }

}
