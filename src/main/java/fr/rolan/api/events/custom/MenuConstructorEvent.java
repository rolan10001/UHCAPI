package fr.rolan.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotation.NotNull;

public class MenuConstructorEvent extends Event {
	private static final HandlerList HANDLERS_LIST = new HandlerList();
	private final Inventory inv;
	
	public MenuConstructorEvent(Inventory inv) {
		this.inv = inv;
	}
	
	@NotNull
	public HandlerList getHandlers() {
		return HANDLERS_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}

	public Inventory getInventory() {
		return inv;
	}
}
