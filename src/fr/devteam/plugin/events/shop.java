package fr.devteam.plugin.events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.devteam.plugin.core.Coin;

public class shop implements Listener{

	public final Inventory inv;

    public shop() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 54, "Shop");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(3, createGuiItem(Material.DIRT, "§4dirt", "vente 0.5 ValaCoin", "achat 1 ValaCoin"));
    }

    // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    
    public void openInventory(final Player player) {
        player.openInventory(inv);
    }

    // Check for clicks on items
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

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == inv) {
          e.setCancelled(true);
        }
    }
	
}
