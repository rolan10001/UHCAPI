package fr.rolan.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotation.NotNull;

public class SaveConfigurationEvent extends Event {
	
	private static final HandlerList HANDLERS_LIST = new HandlerList();
	private final String name;
	private final Player player;
	
	public SaveConfigurationEvent(Player player, String name) {
		this.player = player;
		this.name = name;
	}
	
	@NotNull
	public HandlerList getHandlers() {
		return HANDLERS_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}

	public String getName() {
		return name;
	}

	public Player getPlayer() {
		return player;
	}
}
