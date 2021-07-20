package fr.devteam.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class commandStat implements CommandExecutor {

	Inventory inv = Bukkit.createInventory(null, 45, "§bTes statistiques");
	
	@SuppressWarnings({"deprecation","unused"})
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

		Player player = (Player) sender;

		ItemStack it = player.getItemInHand();

		String pworld = player.getWorld().getName();
		String playerWorld = String.valueOf(pworld);
		double phealth = player.getHealth();
		String pHEALTH = String.valueOf(phealth);

		ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short)3);
		SkullMeta skMeta = (SkullMeta) skull.getItemMeta();
		skMeta.setOwner(player.getName());
		skMeta.setDisplayName(player.getName());
		skull.setItemMeta(skMeta);
		net.minecraft.server.v1_16_R3.ItemStack st = CraftItemStack.asNMSCopy(skull);

		

		inv.setItem(22, CraftItemStack.asBukkitCopy(st));
		inv.setItem(36, getItem(Material.GRASS_BLOCK, "Tu est dans le monde : " + playerWorld));
		inv.setItem(38, getItem(Material.PLAYER_HEAD, "§bTa vie est de :" + pHEALTH + "§cHP"));

		player.openInventory(inv);
		return false;

	}

	public ItemStack getItem(Material material, String customName) {
		ItemStack it = new ItemStack(material);
		ItemMeta itM = it.getItemMeta();
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		if(customName != null) itM.setDisplayName(customName);
		it.setItemMeta(itM);
		return it;

	}

	
	@EventHandler
	public void test(InventoryClickEvent event) {
		if (event.getInventory() != inv) return;

        event.setCancelled(true);

        final ItemStack clickedItem = event.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) event.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        p.sendMessage("You clicked at slot " + event.getRawSlot());
		
	}
	
	  @EventHandler
	    public void onInventoryClick(final InventoryDragEvent event) {
	        if (event.getInventory() == inv) {
	          event.setCancelled(true);
	        }
	    }

	
}