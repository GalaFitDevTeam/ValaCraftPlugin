package fr.devteam.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.devteam.plugin.Main;

public class commandSpawn implements CommandExecutor {

	private Main main;

	public commandSpawn(Main main2) {
		this.main = main2;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Location spawn = new Location(
					Bukkit.getWorld(main.getConfig().getString("commands.spawn."+player.getWorld().getName()+".loc.world")),
					main.getConfig().getDouble("commands.spawn."+player.getWorld().getName()+".loc.x"),
					main.getConfig().getDouble("commands.spawn."+player.getWorld().getName()+".loc.y"),
					main.getConfig().getDouble("commands.spawn."+player.getWorld().getName()+".loc.z"),
					(float) main.getConfig().getDouble("commands.spawn."+player.getWorld().getName()+".loc.yaw"),
					(float) main.getConfig().getDouble("commands.spawn."+player.getWorld().getName()+".loc.pitch")
					);
			player.teleport(spawn);
			player.sendMessage(main.getConfig().getString("commands.spawn.message").replace("/e", "é").replace("&", "§"));
		}else {
			sender.sendMessage("Cette command ne peut pas etre executer en console !");
			sender.sendMessage("il n'y a pas de spawn set!!!");
		}
		return false;
	}

}
