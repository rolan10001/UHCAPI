package fr.rolan.api.game;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.rolan.api.game.enums.GameState;

public interface IGameManager {
	
	public void setGameState(GameState state);
	
	public boolean isState(GameState state);
	
	public int midDistance(Player player);
	
	public int playerDistance(Player player, Location loc);
	
	public String updateArrow(Player player, Location target);
	
	public void transportion(UUID playerUUID, String message);
	
	public String getProgressBar(int current, int max, int totalBars, String symbol, String completedColor, String notCompletedColor);
}
