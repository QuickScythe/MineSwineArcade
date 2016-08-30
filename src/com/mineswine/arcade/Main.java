package com.mineswine.arcade;

import org.bukkit.plugin.java.JavaPlugin;

import com.mineswine.arcade.utils.Utils;

public class Main extends JavaPlugin {
	
	static Main plugin;
	
	public void onEnable(){
		plugin = this;
		Utils.loadAddons();
		
	}
	
	public static Main getPlugin(){ return plugin; }

}
