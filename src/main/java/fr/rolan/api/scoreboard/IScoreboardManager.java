package fr.rolan.api.scoreboard;

import java.util.Map;
import java.util.UUID;

public interface IScoreboardManager {
	public void setScoreboard(String title, Map<Integer, String> map);
	
	public void setPlayerScoreboard(UUID uuid, String title, Map<Integer, String> map);
	
	public void setReplaceValue(String replace, Object value);
	
	public void setTitle(String title);
	
	public void setPlayerTitle(UUID uuid, String title);
}
