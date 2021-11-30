package fr.rolan.api.game.scenario.superheroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum SuperHeroesType {
	STRENGTH(0, 20.0, Arrays.asList(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false))), 
	SPEED(1, 20.0, Arrays.asList(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false))), 
	RESISTANCE(2, 20.0, Arrays.asList(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0, false, false))), 
	JUMP(3, 20.0, Arrays.asList(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 3, false, false), new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, false, false), new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0, false, false))), 
	DOUBLE_HEALTH(4, 40.0, Arrays.asList());
	
	private int id;
	private double health;
	private List<PotionEffect> effects = new ArrayList<PotionEffect>();
	
	private SuperHeroesType(int id, double health, List<PotionEffect> effects) {
		this.setId(id);
		this.setHealth(health);
		this.setEffects(effects);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public static SuperHeroesType getTypeWithID(int id) {
		for(SuperHeroesType type : values())
			if(type.getId() == id) 
				return type;
		return null;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public List<PotionEffect> getEffects() {
		return effects;
	}

	public void setEffects(List<PotionEffect> effect) {
		this.effects = effect;
	}
}
