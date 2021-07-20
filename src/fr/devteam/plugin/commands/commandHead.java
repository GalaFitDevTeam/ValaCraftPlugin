package fr.devteam.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandHead implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(args.length == 0 || args.length > 1) {
				player.sendMessage("§cUtilise /skull <player>");
			}else if(args.length == 1) {
				String targetName = args[0];
					player.performCommand("give @s minecraft:player_head{SkullOwner:\"" + targetName + "\"}");
					
				}
		}
		
		return false;
	}

}