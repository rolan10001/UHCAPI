package fr.rolan.api.game.scenario.superheroes;

import java.util.Random;

import org.bukkit.entity.Player;

import fr.rolan.api.UHCAPI;

public class SuperHeroes {
	
	private Player player;
	private SuperHeroesType type;
	
	public SuperHeroes(Player player) {
		this.setPlayer(player);
		setType(SuperHeroesType.getTypeWithID(new Random().nextInt(5)));
		player.addPotionEffects(type.getEffects());
		player.setMaxHealth(type.getHealth());
		player.setHealth(player.getMaxHealth());
		UHCAPI.get().getUser(player).setSuperHeroes(this);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public SuperHeroesType getType() {
		return type;
	}

	public void setType(SuperHeroesType type) {
		this.type = type;
	}
	
}
