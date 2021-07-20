package fr.devteam.plugin.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class customItems implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();

		if(block.getType().equals(Material.SPAWNER)) {
			if(event.getItemInHand().getItemMeta().getCustomModelData() == 2) {
				event.setCancelled(true);
			}
		}

		if(block.getType().equals(Material.IRON_BARS)) {
			if(event.getItemInHand().getItemMeta().getCustomModelData() == 2) {
				event.setCancelled(true);
			}
		}
	}
	
	
}
