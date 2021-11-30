package fr.rolan.tools.scoreboard;

import static fr.rolan.api.game.Settings.*;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHealth {
	
	private Scoreboard sb;
	private Objective objective_tab;
	private Objective objective_head;
	
	public ScoreboardHealth(boolean tab, boolean head) {
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		if(PV_ON_HEAD) {
			objective_head = sb.registerNewObjective("§c❤", "dummy");
			objective_head.setDisplaySlot(DisplaySlot.BELOW_NAME);
		}
		if(PV_IN_TAB) {
			objective_tab = sb.registerNewObjective("tab", "dummy");
			objective_tab.setDisplaySlot(DisplaySlot.PLAYER_LIST);
		}
		Bukkit.getOnlinePlayers().forEach(player -> player.setScoreboard(sb));
	}
	
	@SuppressWarnings("deprecation")
	public void setObjectiveForPlayer(Player player) {
		if(PV_IN_TAB)
			objective_tab.getScore(player).setScore((int) (player.getHealth()*5+(((CraftPlayer) player).getHandle().getAbsorptionHearts()*5)));
		if(PV_ON_HEAD)
			objective_head.getScore(player).setScore((int) (player.getHealth()*5+(((CraftPlayer) player).getHandle().getAbsorptionHearts()*5)));
	}
	
	@SuppressWarnings("deprecation")
	public void removeScoreboard() {
		if(PV_IN_TAB)
			Bukkit.getOnlinePlayers().forEach(player -> objective_tab.getScore(player).getScoreboard().resetScores(player));
		if(PV_ON_HEAD)
			Bukkit.getOnlinePlayers().forEach(player -> objective_head.getScore(player).getScoreboard().resetScores(player));
	}

	public Scoreboard getScoreboard() {
		return sb;
	}
}