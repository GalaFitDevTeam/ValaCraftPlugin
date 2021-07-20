package fr.devteam.plugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class commandSkull implements CommandExecutor {

	@SuppressWarnings({ "deprecation" })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

		Player player = (Player) sender;

		ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();

		meta.setOwner("MHF_OakLog");
		meta.setDisplayName("Tête de pouvoir : Bois");
		skull.setItemMeta(meta);

		player.getInventory().addItem(skull);

		meta.setOwner("MHF_Slime");
		meta.setDisplayName("Tête de pouvoir : Mob");
		skull.setItemMeta(meta);

		player.getInventory().addItem(skull);

		meta.setOwner("teachdaire");
		meta.setDisplayName("Tête de pouvoir : Ore");
		skull.setItemMeta(meta);

		player.getInventory().addItem(skull);

		return false;
	}



}
