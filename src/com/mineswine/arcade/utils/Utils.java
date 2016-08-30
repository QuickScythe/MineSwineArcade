package com.mineswine.arcade.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.bukkit.Bukkit;

import com.mineswine.arcade.Main;

public class Utils {
	
	public static void loadAddons(){
		File directory = new File(Main.getPlugin().getDataFolder().getPath() + "/addons");
		Bukkit.broadcastMessage(Main.getPlugin().getDataFolder().getPath() + "/addons");
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
		    Class<?> clazz;
		    try{
		    	String s = Main.getPlugin().getConfig().getString("addons." + file.getName().split("jar") + "main");
		    	clazz = loader.loadClass(s);
		    } catch (Exception ex){ clazz = loader.loadClass("addon.mineswine.arcade.Main"); }
		    
		    Object instance = clazz.newInstance();
		    Method open = clazz.getMethod("enable");
		    open.invoke(instance);
		    
		    loader.close();
		  } catch (Exception exception) {
		    exception.printStackTrace();
		  }
		}
	}

}
