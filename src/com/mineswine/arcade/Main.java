package com.mineswine.arcade;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.mineswine.arcade.commands.MSACommand;
import com.mineswine.arcade.utils.MSAAPI;
import com.mineswine.arcade.utils.Utils;

public class Main extends JavaPlugin {
	
	static Main plugin;
	static boolean ready = false;
	
	public void onEnable(){
		Bukkit.broadcastMessage("1");
		plugin = this;
		Bukkit.broadcastMessage("2");
		Utils.loadAddons();
		Bukkit.broadcastMessage("3");
		new MSACommand("msa", this);
		Bukkit.broadcastMessage("4");
		Utils.startGameTicks();
		Bukkit.broadcastMessage("5");
	}
	
	public static Main getPlugin(){ return plugin; }

}
