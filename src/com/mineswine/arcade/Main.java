package com.mineswine.arcade;

import org.bukkit.plugin.java.JavaPlugin;

import com.mineswine.arcade.commands.MSACommand;
import com.mineswine.arcade.utils.MSAAPI;
import com.mineswine.arcade.utils.Utils;

public class Main extends JavaPlugin {
	
	static Main plugin;
	
	public void onEnable(){
		plugin = this;
		Utils.loadAddons();
		
		new MSACommand("msa", this);
		
		Utils.startGameTicks();
		
	}
	
	public static Main getPlugin(){ return plugin; }

}
