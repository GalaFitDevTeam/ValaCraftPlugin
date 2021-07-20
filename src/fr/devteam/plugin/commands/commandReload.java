package fr.devteam.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.devteam.plugin.Main;

public class commandReload implements CommandExecutor {
	
	private Main main;
	
	public commandReload(Main main) {
		this.main = main;
	}
	
	@SuppressWarnings({ "static-access" })
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		try {
			Bukkit.getPluginManager().disablePlugin(main.INSTANCE);
			Bukkit.getPluginManager().enablePlugin(main.INSTANCE);
			sender.sendMessage("plugin reload!");
		} catch (Exception e) {
			sender.sendMessage("il y a une erreur lors du reload: " + e);
		}
		return false;
	}

}
