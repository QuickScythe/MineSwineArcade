package com.mineswine.arcade.core;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.mineswine.arcade.Main;
import com.mineswine.arcade.utils.Utils;

public class GameListener implements Listener {
	
	Main plugin;
	
	public GameListener(Main plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	

	
}
