package fr.devteam.plugin.events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class tpGui implements Listener {

	
	public final Inventory inv;

    public tpGui() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 9, "Example");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.setItem(3, createGuiItem(Material.GRASS_BLOCK, "§bWorld", "§atp dans le World"));
        inv.setItem(5, createGuiItem(Material.NETHERRACK, "§bNether", "§atp dans le Nether"));
        inv.setItem(0, createGuiItem(Material.RED_STAINED_GLASS_PANE, "   "));
        inv.setItem(2, createGuiItem(Material.RED_STAINED_GLASS_PANE, "   "));
        inv.setItem(4, createGuiItem(Material.RED_STAINED_GLASS_PANE, "§bEnd", "§atp dans l'End"));
        inv.setItem(6, createGuiItem(Material.RED_STAINED_GLASS_PANE, "   "));
        inv.setItem(7, createGuiItem(Material.RED_STAINED_GLASS_PANE, "   "));
        inv.setItem(8, createGuiItem(Material.RED_STAINED_GLASS_PANE, "   "));
        inv.setItem(1, createGuiItem(Material.RED_STAINED_GLASS_PANE, "   "));
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
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != inv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR || clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) return;

        final Player player = (Player) e.getWhoClicked();

        if(clickedItem.getType() == Material.GRASS_BLOCK) {
        	player.performCommand("server julfit");
        	player.sendMessage("§b tu vas etre tp au World");
        }
        if(clickedItem.getType() == Material.NETHERRACK) {
        	player.performCommand("server nether");
        	player.sendMessage("§b tu vas etre tp au nether");
        }
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == inv) {
          e.setCancelled(true);
        }
    }
    
    @EventHandler
	public void onLeftClick(PlayerInteractEvent event) {

		Player player = event.getPlayer();

		if(event.getItem().getType() == Material.COMPASS) {
			if(event.getAction() == Action.RIGHT_CLICK_AIR) {
				player.openInventory(inv);
			}
		}
	}
}
