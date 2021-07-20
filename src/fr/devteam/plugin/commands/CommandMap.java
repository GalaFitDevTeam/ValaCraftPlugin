package fr.devteam.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.devteam.plugin.Main;
import fr.devteam.plugin.core.TaskRenderImage;

public class CommandMap implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (sender instanceof Player) {
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("render")) {
						final Player player = (Player) sender;
						final String path = args[1];
						
						
						new TaskRenderImage(player, path).runTaskAsynchronously(Main.INSTANCE);
					}
				}else {
					sender.sendMessage("§6Nombre d'argument incorecte.");
				}
			}
		return false;
	}
	
	

}
