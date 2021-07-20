package fr.devteam.plugin.commands.competence;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandFly implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
        Player player;
      
        if (!(sender instanceof Player)){
            sender.sendMessage("Tu ne peut pas executé cette commande en console");
            return false;
            }
        player = (Player) sender;
            player.setAllowFlight(!(player.getAllowFlight()));
            return true;

     }

}
