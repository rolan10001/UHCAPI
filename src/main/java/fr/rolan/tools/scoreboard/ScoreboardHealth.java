package fr.rolan.tools.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import fr.rolan.api.game.Settings;

public class ScoreboardHealth {
	
	private Settings s;
	private Scoreboard sb;
	private Objective objective_tab;
	private Objective objective_head;
	
	public ScoreboardHealth(Settings s, boolean tab, boolean head) {
		this.s = s;
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		if(s.PV_ON_HEAD) {
			objective_head = sb.registerNewObjective("§c❤", "dummy");
			objective_head.setDisplaySlot(DisplaySlot.BELOW_NAME);
		}
		if(s.PV_IN_TAB) {
			objective_tab = sb.registerNewObjective("tab", "dummy");
			objective_tab.setDisplaySlot(DisplaySlot.PLAYER_LIST);
		}
		Bukkit.getOnlinePlayers().forEach(player -> player.setScoreboard(sb));
	}
	
	@SuppressWarnings("deprecation")
	public void setObjectiveForPlayer(Player player) {
		if(s.PV_IN_TAB)
			objective_tab.getScore(player).setScore((int) (player.getHealth()*5+(((CraftPlayer) player).getHandle().getAbsorptionHearts()*5)));
		if(s.PV_ON_HEAD)
			objective_head.getScore(player).setScore((int) (player.getHealth()*5+(((CraftPlayer) player).getHandle().getAbsorptionHearts()*5)));
	}
	
	@SuppressWarnings("deprecation")
	public void removeScoreboard() {
		if(s.PV_IN_TAB)
			Bukkit.getOnlinePlayers().forEach(player -> objective_tab.getScore(player).getScoreboard().resetScores(player));
		if(s.PV_ON_HEAD)
			Bukkit.getOnlinePlayers().forEach(player -> objective_head.getScore(player).getScoreboard().resetScores(player));
	}

	public Scoreboard getScoreboard() {
		return sb;
	}
}