package fr.devteam.plugin.events;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.devteam.plugin.Main;

public class gunsEvent implements Listener {

	public gunsEvent(Main main) {}

	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Fireball) {
			Fireball s = (Fireball) e.getDamager();

			if(s.getShooter() instanceof Player) {
				Player shooter = (Player) s.getShooter();
				if(shooter.getItemInHand().getType() == Material.NETHERITE_HOE) {
					e.setDamage(1.0);
					
				}
			}
		}
	}
	@EventHandler
	public void onPInteract(PlayerInteractEvent e) {

		if(e.getItem().getType() == Material.NETHERITE_HOE) {
			Player player = e.getPlayer();
			if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				player.launchProjectile(Fireball.class);
			}
		}
	}

	
}
