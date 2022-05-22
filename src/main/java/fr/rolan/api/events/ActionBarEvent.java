package fr.rolan.api.events;

import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotation.NotNull;

public class ActionBarEvent extends Event {
	private final UUID playerUUID;
	
	private String actionbar;
	
	private static final HandlerList HANDLERS_LIST = new HandlerList();
	
	public ActionBarEvent(UUID playerUUID, String actionBar) {
		this.playerUUID = playerUUID;
		this.actionbar = actionBar;
	}
	
	@NotNull
	public HandlerList getHandlers() {
		return HANDLERS_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}
	
	public UUID getPlayerUUID() {
		return this.playerUUID;
	}
	
	public String getActionBar() {
		return this.actionbar;
	}
	
	public void setActionBar(String actionBar) {
		this.actionbar = actionBar;
	}
}