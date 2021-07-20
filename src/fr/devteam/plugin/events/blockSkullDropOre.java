package fr.devteam.plugin.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.devteam.plugin.Main;

@SuppressWarnings("unused")
public class blockSkullDropOre extends BukkitRunnable{


	private Main main;
	private Skull s;
	private Random r;
	private Block b;

	public blockSkullDropOre(Main main, Skull s, Random r, Block b, Player player) {
		this.main = main;
		this.s = s;
		this.r = r;
		this.b = b;
	}

	@Override
	public void run() {
		Bukkit.broadcastMessage("sa marche ici");	

		int alea = r.nextInt(9);
		int aleaNumber = r.nextInt(9);
		switch (alea) {
		case 0:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.IRON_INGOT, aleaNumber));
			break;

		case 1:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.GOLD_INGOT, aleaNumber));
			break;

		case 2:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.DIAMOND, aleaNumber));
			break;

		case 3:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.EMERALD, aleaNumber));
			break;

		case 4:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.QUARTZ, aleaNumber));
			break;

		case 5:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.NETHERITE_INGOT, 1));
			break;

		case 6:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.REDSTONE, aleaNumber));
			break;

		case 7:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.LAPIS_LAZULI, aleaNumber));
			break;

		default:
			b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.COAL, aleaNumber));
			break;
		}

	}

}
