package fr.devteam.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandFlyspeed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		
		Player player = (Player) sender;
		
		if(args.length == 0 || args.length > 1) {
			player.sendMessage("Nop!! 1 argument!!!!");
		}else if(args.length == 1) {
			String arg1 = String.valueOf(args);
			int flyspeed = Integer.parseInt(arg1); 
			player.setFlySpeed(flyspeed);
		}
		
		return false;
	}

}
