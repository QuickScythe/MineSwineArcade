package com.mineswine.arcade.utils;

import org.bukkit.event.Listener;

import com.mineswine.arcade.Main;

public class MSAAPI {
	
	MSAAPI instance;
	Game game;
	
	public MSAAPI(){
		instance = this;
	}
	
	public MSAAPI getInstance(){
		return instance;
	}
	
	public Game getGame(){
		return game;
		
	}

	

	public void createGame(Game game) {
		this.game = game;
		Utils.addGame(game);
				
	}

	public void registerNewListener(Listener listener) {
		Main.getPlugin().getServer().getPluginManager().registerEvents(listener, Main.getPlugin());
	}
}