package com.mineswine.arcade.utils;

public class MSAAPI {
	
	MSAAPI instance;
	
	public MSAAPI(){
		instance = this;
		
	}
	
	public MSAAPI getInstance(){
		return instance;
	}
}