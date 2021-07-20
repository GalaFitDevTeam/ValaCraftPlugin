package fr.devteam.plugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.devteam.plugin.Main;
import fr.devteam.plugin.core.Coin;

public class commandShop implements CommandExecutor {

	public static Inventory inv = Main.SHOP.inv;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] label) {
		
		Player player = (Player) sender;
		
		Main.SHOP.openInventory(player);
		
		return false;
	}
	
	@EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
		
		
		if (e.getInventory() == inv) {
          e.setCancelled(true);
        }
    }
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != inv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR || clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) return;

        final Player player = (Player) e.getWhoClicked();

        if(e.getClick() == ClickType.RIGHT) {
        	player.sendMessage("test");
        	if (player.getInventory().contains(clickedItem)) {
				if (clickedItem.equals(Material.DIRT)) {
					player.getInventory().remove(Material.DIRT);
					Coin.addCoin(player, 0.5);
				}
			}
        }       
	}
}
