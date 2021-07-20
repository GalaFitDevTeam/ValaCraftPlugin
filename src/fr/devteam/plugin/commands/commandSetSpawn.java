package fr.devteam.plugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.devteam.plugin.Main;

public class commandSetSpawn implements CommandExecutor {

	private Main main;

	public commandSetSpawn(Main main2) {
		this.main = main2;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {

		FileConfiguration conf = main.getConfig();
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Location loc = player.getLocation();
			conf.set("commands.spawn."+player.getWorld().getName()+".loc.x", loc.getX());
			conf.set("commands.spawn."+player.getWorld().getName()+".loc.y", loc.getY());
			conf.set("commands.spawn."+player.getWorld().getName()+".loc.z", loc.getZ());
			conf.set("commands.spawn."+player.getWorld().getName()+".loc.yaw", loc.getYaw());
			conf.set("commands.spawn."+player.getWorld().getName()+".loc.pitch", loc.getPitch());
			conf.set("commands.spawn."+player.getWorld().getName()+".loc.world", loc.getWorld().getName());
			main.saveConfig();
			player.sendMessage(main.getConfig().getString("commands.setspawn.message").replace("/e", "é").replace("&", "§"));
		}else {
			sender.sendMessage("Cette command ne peut pas etre executer en console !");
		}

		return false;
	}

}
