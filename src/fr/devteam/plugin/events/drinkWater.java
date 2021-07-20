package fr.devteam.plugin.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class drinkWater implements Listener {


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeftClick(PlayerInteractEvent event) {

		Player player = event.getPlayer();
		int feed = player.getFoodLevel();

		if(event.getItem().getType() == Material.WATER_BUCKET) {
			if(event.getAction() == Action.RIGHT_CLICK_AIR) {
				if(player.isSneaking()) {
							player.getItemInHand().setType(Material.BUCKET);
							player.setFoodLevel(feed + 5);

				}
			}
		}
	}
}
