package fr.devteam.plugin.events;

import java.util.Random;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.devteam.plugin.Main;

public class blockSkullPlaced implements Listener {

	private Main main;

	public blockSkullPlaced(Main main2) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlaced(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		Block b = e.getBlock();
		BlockState bs = b.getState();

		Skull s = (Skull) bs;
		Random r = new Random();

		player.sendMessage("sa c'est good");

		if (bs instanceof Skull) {
			player.sendMessage("la fonction bs est appeler");
			if (s.getOwner().equalsIgnoreCase("teachdaire")) {
				new blockSkullDropOre(main, s, r, b, player).runTaskTimer(main, 0, 20);
				}
			if (s.getOwner().equalsIgnoreCase("MHF_Slime")) {
				new blockSkullDropMobs(main, s, r, b, player).runTaskTimer(main, 0, 20);
				}
			if (s.getOwner().equalsIgnoreCase("MHF_OakLog")) {
				new blockSkullDropWood(main, s, r, b, player).runTaskTimer(main, 0, 20);
				}
			
			
			

		}

	}

}