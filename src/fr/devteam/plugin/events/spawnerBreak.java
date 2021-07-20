package fr.devteam.plugin.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class spawnerBreak implements Listener {

	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();

		ItemStack bro = new ItemStack(Material.SPAWNER);
		ItemMeta bMeta = bro.getItemMeta();
		bMeta.setDisplayName("§cBrocken Spawner");
		bMeta.setCustomModelData(2);
		bro.setItemMeta(bMeta);
		net.minecraft.server.v1_16_R3.ItemStack gu = CraftItemStack.asNMSCopy(bro);

		if (block.getType().equals(Material.SPAWNER)) {
			if (player.getItemInHand().containsEnchantment(org.bukkit.enchantments.Enchantment.SILK_TOUCH)) {
				event.setCancelled(true);
				block.setType(Material.AIR);
				block.getWorld().dropItem(block.getLocation(), CraftItemStack.asBukkitCopy(gu));
			}
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();

		if(block.getType().equals(Material.SPAWNER)) {
			if(event.getItemInHand().getItemMeta().getCustomModelData() == 2) {
				event.setCancelled(true);
			}
		}
	}
	

}
