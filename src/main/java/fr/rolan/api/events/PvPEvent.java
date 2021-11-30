package fr.rolan.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotation.NotNull;

public class PvPEvent extends Event {
	
	private static final HandlerList HANDLERS_LIST = new HandlerList();
	
	@NotNull
	public HandlerList getHandlers() {
		return HANDLERS_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}
}