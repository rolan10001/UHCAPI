package fr.rolan.api.game.teleportation;

import java.util.Map;

public interface ITeleportationManager {
	public void unregisterListeners();
	
	public Map<Integer, String> setGameScoreboard();
}
