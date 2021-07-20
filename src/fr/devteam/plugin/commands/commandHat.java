package fr.devteam.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class commandHat implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		
		Player player = (Player) sender;
		
		ItemStack hatitem = (ItemStack) player.getInventory().getHelmet();
		
		player.getInventory().setHelmet(player.getItemInHand());
		
		player.setItemInHand(hatitem);
		
		return false;
	}

}
