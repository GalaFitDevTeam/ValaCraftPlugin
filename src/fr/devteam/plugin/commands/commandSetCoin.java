package fr.devteam.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.devteam.plugin.core.Coin;
import fr.devteam.plugin.core.scoresBoard;

public class commandSetCoin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] label) {
		
		Player player = (Player) sender;
		
		if (label.length == 2) {
			String nmtarget = label[0];
			Player target = Bukkit.getPlayer(nmtarget);
			String smoney = label[1];
			int money = Integer.parseInt(smoney);
			
			Coin.setCoin(target, money);
			player.sendMessage("§bTu a bien set §4" + money + " §bValaCoin a " + target.getName());
			
			if(!Bukkit.getOnlinePlayers().isEmpty())
	            for(Player online:Bukkit.getOnlinePlayers()) {
	            	scoresBoard.createBoard(online);
	            }
			
		}else {
			player.sendMessage("§4Tu doit metre 2 argument");
			player.sendMessage("§bessaye avec la command §6/setcoin \"Nom du player\" \"Nombre de coin a set\"");
		}
		
		return false;
	}

}
