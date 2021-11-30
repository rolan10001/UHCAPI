package fr.rolan.api.game.game;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public interface IActifGameManager {
	
	public void unregisterListeners();
	
	public void newNoPvPState();
	
	public void newPvPState();
	
	public void newBorderState();
	
	public HashMap<UUID, Inventory> getInventories();
	
	public HashMap<UUID, Location> getDeathLocation();
}
