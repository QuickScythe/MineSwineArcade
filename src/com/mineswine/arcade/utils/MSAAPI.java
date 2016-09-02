package com.mineswine.arcade.utils;

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
		if(game == null){
			game = new Game();
			return game;
		} else {
			return game;
		}
	}
}