package net.gamerservices.deathban;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathBanPlayerListener extends PlayerListener  {
	private final deathban plugin;
	 public DeathBanPlayerListener(deathban instance) {
	        plugin = instance;
	 }
	 
	 @Override
	 public void onPlayerRespawn(PlayerRespawnEvent event) {
		 if (event.getPlayer().isOp())
		 {
			 // skip
		 } else {
			 event.getPlayer().setBanned(true);
			 event.getPlayer().kickPlayer("Alas! After a wonderful life " + event.getPlayer().getDisplayName() + " has now died");
		     System.out.println(event.getPlayer().getName() + " died and was banned from the server!");
		 }
	 }
}
