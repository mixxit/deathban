package net.gamerservices.deathban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Revive implements CommandExecutor {

	private final deathban plugin;

	public Revive(deathban plugin) {
		// TODO Constructor
        this.plugin = plugin;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		
		
		// TODO Auto-generated method stub
		Player player = deathban.getPlayer(sender, args, 1);
		if (player == null) {
		    return true;
		} else if (!(sender instanceof Player)) {
		    sender.sendMessage(ChatColor.RED + "I don't know where you are!");
		    return true;
		} else if (!player.isOp())
		{
		   	sender.sendMessage(ChatColor.RED + "Only an operator can revive dead players!");
		   	return true;
		}
		
		if (args.length < 1) {
			sender.sendMessage(ChatColor.RED + "You must provide a playername");
			return true;
		} else {
			
			Bukkit.getOfflinePlayer(args[0]).setBanned(false);
	        player.sendMessage(args[0] + " has been revived");
	        return true;
		}
		
	}
	
}
