package fr.rolan.api.player;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import fr.rolan.api.database.IPlayerData;
import fr.rolan.api.game.scenario.superheroes.SuperHeroes;
import fr.rolan.api.game.team.Teams;

public interface IUser {
	
	public UUID getUUID();

	public boolean isInArena();

	public void setInArena(boolean arena);

	public int getKillStreak();

	public void setKillStreak(int killstreak);
	
	public IPlayerData getPlayerData();
	
	public int getKill();
	
	public int getDeath();
	
	public void addKill(int kill);
	
	public void addDeath(int death);
	
	public void addHighestKillStreak(int kill);
	
	public int getHighestKillStreak();

	public int getDiamondArmor();

	public void setDiamondArmor(int armor);

	public Teams getTeam();

	public void setTeam(Teams team);

	public int getDiamondlimit();

	public void addDiamondlimit(int diamondlimit);

	public boolean isDied();

	public void setDied(boolean died);

	public boolean isSpectator();

	public void setSpectator(boolean spectator);

	public SuperHeroes getSuperHeroes();

	public void setSuperHeroes(SuperHeroes superheroes);
	
	public ItemStack[] getDeathStuff();
	
	public ItemStack[] getDeathArmorStuff();
	
	public void setDeathStuff(ItemStack[] it);
	
	public void setDeathArmorStuff(ItemStack[] it);

	public Location getDeathLoc();
	
	public void setDeathLoc(Location deathLoc);
	
	public int getArmorDeath();
	
	public void setArmorDeath(int armorDeath);
}
