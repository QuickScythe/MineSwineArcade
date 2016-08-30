package com.mineswine.arcade.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.mineswine.arcade.Main;

public class Utils {
	
	public static List<String> addons = new ArrayList<>();
	
	public static void loadAddons(){
		File directory = new File(Main.getPlugin().getDataFolder().getPath() + "/addons");
		if(!directory.exists())
			directory.mkdirs();
		
		for (File file : directory.listFiles()) {
		  if (file.isDirectory()) {
		    continue;
		  }
		  if (!file.getName().endsWith(".jar")) {
		    continue;
		  }

		  
		  try {
		    URL url = new URL("jar", "", "file:" + file.getAbsolutePath() + "!/");
		    URLClassLoader loader = new URLClassLoader(new URL[]{url});
		    Class<?> clazz = loader.loadClass("addon.mineswine.arcade.Main");
		    
		    Object instance = clazz.newInstance();
		    Method open = clazz.getMethod("enable");
		    try{
		    	open.invoke(instance);
		    } catch (Exception ex){
		    	Bukkit.getConsoleSender().sendMessage(colorize("&4[ERROR] &e&lMSA&f > &7The method 'enable' couldn't be run. Below is the error."));
		    	ex.printStackTrace();
		    }
		    
		    loader.close();
		  } catch (Exception exception) {
		    exception.printStackTrace();
		  }
		  addons.add(file.getName().replaceAll(".jar", ""));
		  Bukkit.broadcastMessage(colorize("&e&lMSA &f>&7 Enabled addon &f" + file.getName().replaceAll(".jar", "") + "&7."));
		}
	}

	public static String colorize(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public static void sendAddonsList(CommandSender sender) {
		String s = "&e";
		for(String addon : addons){
			s = s+addon+"&7,&e";
		}
		s=s.substring(0, s.length()-3);
		sender.sendMessage(colorize("&e&lAddons &f> " + s));
	}

}
