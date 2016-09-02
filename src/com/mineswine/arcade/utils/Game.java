package com.mineswine.arcade.utils;

public class Game {
	
	String name;
	public Game(String name){
		this.name = name;
	}

	public boolean tick() {
		return false;
	}
	
	public String getName(){
		return name;
	}	
}