package com.ssomar.blockpiglinstransformation;

import com.ssomar.blockpiglinstransformation.events.EventsHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockPiglinsTransformation extends JavaPlugin {

    public static BlockPiglinsTransformation plugin;

    public static final String NAME = "BlockPiglinsTranformation";

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getLogger().info("================ ["+NAME+"] ================");

        /* Events instance part */
        EventsHandler.getInstance().setup(this);

        /* BStats part */
        int pluginId = 13197;

        MetricsLite metrics = new MetricsLite(this, pluginId);
        plugin.getLogger().info("Tranformation of the Piglins blocked !");
        Bukkit.getServer().getLogger().info("================ ["+NAME+"] ================");

    }

}
