package net.gamerservices.deathban;

import java.util.List;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;

public class deathban extends JavaPlugin {
	private final DeathBanPlayerListener dbPlayerListener  = new DeathBanPlayerListener(this);

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		PluginDescriptionFile desc = getDescription();
		System.out.println(desc.getFullName() + " has been disabled");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		PluginDescriptionFile desc = getDescription();
		System.out.println(desc.getFullName() + " has been enabled");
		
		 PluginManager pm = getServer().getPluginManager();
	     pm.registerEvent(Event.Type.PLAYER_RESPAWN, dbPlayerListener, Priority.Normal, this);

	     getCommand("revive").setExecutor(new Revive(this));
		
	}

	public static Player getPlayer(CommandSender sender, String[] args, int index) {
		// TODO Auto-generated method stub
        if (args.length > index) {
            List<Player> players = sender.getServer().matchPlayer(args[index]);

            if (players.isEmpty()) {
                sender.sendMessage("I don't know who '" + args[index] + "' is!");
                return null;
            } else {
                return players.get(0);
            }
        } else {
            if (anonymousCheck(sender)) {
                return null;
            } else {
                return (Player)sender;
            }
        }
    }
	
	private static boolean anonymousCheck(CommandSender sender) {
		// TODO Auto-generated method stub
		if (!(sender instanceof Player)) {
            sender.sendMessage("Cannot execute that command, I don't know who you are!");
            return true;
        } else {
            return false;
        }
	}
	 
	 
}
