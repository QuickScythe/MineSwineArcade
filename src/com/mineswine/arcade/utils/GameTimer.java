package com.mineswine.arcade.utils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

class GameTimer extends BukkitRunnable {

	@Override
	public void run() {
		for(Game game : Utils.getGames()){
			if(!game.tick()) Bukkit.getConsoleSender().sendMessage(Utils.colorize("&e&lMSA &f>&7 Couldn't load game '" + game.getName() + "'. tick() not defined."));
		}
	}

}
