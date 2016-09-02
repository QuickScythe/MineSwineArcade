package com.mineswine.arcade.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.mineswine.arcade.Main;
import com.mineswine.arcade.utils.Game;
import com.mineswine.arcade.utils.MSAAPI;
import com.mineswine.arcade.utils.Utils;

public class MSACommand implements CommandExecutor {
	
	Main plugin;
	String cmd;
	
	public MSACommand(String cmd, Main plugin){
		this.plugin = plugin;
		this.cmd = cmd;
		plugin.getCommand(cmd).setExecutor(this);
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("MSA")){
			if(args.length == 0){
				sender.sendMessage(Utils.colorize(
						"&a------ &7MineSwine Arcade (MSA) &a------\n \n"
						+ "&7 > /msa - Shows this message.\n"
						+ "&7 > /msa reload - reloads all addons.\n"
						+ "&7 > /msa reload <addon> - reloads specified addon.\n"
						+ "&7 > /msa list - Lists all loaded addons\n \n"
						+ "&a---------------------------------"));
			}
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
					Utils.sendAddonsList(sender);
				}
				if(args[0].equalsIgnoreCase("reload")){
					Utils.reloadAddons();
				}
				
			}
			
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("reload")){
					if(Utils.addons.contains(args[1])){
						Utils.reloadAddon(args[1]);
					} else {
						sender.sendMessage("&e&lMSA &f>&7 Couldn't load addon. Reason:");
						sender.sendMessage("&c&lERROR &f>&7 Couldn't find addon '&f" + args[1] + "&7'.");
					}
				}
			}
		}
		return false;
	}

}
