package fr.rolan.api.game;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.rolan.api.game.enums.GAMEMode;
import fr.rolan.tools.generation.Biome;

public class Settings {
	public static Inventory MENU;
	public static Inventory GAMEMODE_MENU;
	public static Inventory ARMOR_MENU;
	public static Inventory WEAPONS_MENU;
	public static Inventory IRON_ARMOR_MENU;
	public static Inventory DIAMOND_ARMOR_MENU;
	public static Inventory POTION_MENU;
	public static Inventory REGENERATION_MENU;
	public static Inventory SPEED_MENU;
	public static Inventory FIRE_RESISTANCE_MENU;
	public static Inventory POISON_MENU;
	public static Inventory HEAL_MENU;
	public static Inventory NIGHT_VISION_MENU;
	public static Inventory WEAKNESS_MENU;
	public static Inventory STRENGTH_MENU;
	public static Inventory SLOWNESS_MENU;
	public static Inventory JUMP_MENU;
	public static Inventory DAMAGE_MENU;
	public static Inventory WATER_MENU;
	public static Inventory INVISIBILITY_MENU;
	public static Inventory TIMER_MENU;
	public static Inventory BORDER_MENU;
	public static Inventory INVENTORY_MENU;
	public static Inventory SETTINGS_MENU;
	public static Inventory TEAM_MENU;
	public static Inventory WORLD_MENU;
	public static Inventory DROP_MENU;
	public static Inventory GENERATION_MENU;
	public static Inventory SCENARIO_MENU;
	public static Inventory FINALHEAL_MENU;
	public static Inventory DIAMONDLIMIT_MENU;
	public static Inventory GENERATION_ORE_MENU;
	public static Inventory DIAMOND_MENU;
	public static Inventory GOLD_MENU;
	public static Inventory IRON_MENU;
	public static Inventory LAPIS_MENU;
	public static Inventory COAL_MENU;
	public static Inventory REDSTONE_MENU;
	public static Inventory PREGENERATION_MENU;
	public static Inventory BIOME_MENU;
	public static Inventory BIOME_IN_MIDDLE_MENU;
	public static Inventory BANNER_TEAM_MENU;
	
	public static String NAME = "UHC";
	public static GAMEMode GAMEMODE = GAMEMode.UHC;
	public static int SLOT = 30;
	public static boolean ARENA = true;
	public static int STRENGTH_VALUE = 10;
	public static boolean TEAM = false;
	public static int TEAM_SIZE = 2;
	public static int TEAM_PLAYERS_SIZE = 2;
	public static boolean TEAM_FRIENDLY_FIRE = true;
	public static boolean TEAM_RANDOM = false;
	public static boolean TEAM_DIRECTION = true;
	public static int BORDER_TIMER = 5400;
	public static int PVP_TIMER = 1200;
	public static int INVINCIBILITY_TIMER = 30;
	public static double BORDER_SIZE = 1500;
	public static double BORDER_FINAL_SIZE = 100;
	public static double BORDER_SPEED = 1;
	public static ItemStack[] START_CONTENTS;
	public static ItemStack[] START_CONTENTS_ARMOR;
	public static ItemStack[] DEATH_CONTENTS;
	public static ItemStack[] DEATH_CONTENTS_ARMOR;
	public static Difficulty DIFFICULTY = Difficulty.HARD;
	public static boolean NETHER = false;
	public static boolean HORSE = false;
	public static int APPLE_DROP = 3;
	public static int FLINT_DROP = 30;
	public static int ENDER_PEARL_DROP = 40;
	public static boolean ABSORPTION = true;
	public static boolean F3 = true;
	public static boolean AUTORESPAWN = true;
	public static boolean PV_IN_TAB = false;
	public static boolean PV_ON_HEAD = false;
	
	public static int CHANCE_DIAMOND_ORE = 1;
	public static int VEINS_SIZE_DIAMOND_ORE = 8;
	public static int MAX_HEIGHT_DIAMOND_ORE = 16;
	public static int CHANCE_GOLD_ORE = 2;
	public static int VEINS_SIZE_GOLD_ORE = 9;
	public static int MAX_HEIGHT_GOLD_ORE = 32;
	public static int CHANCE_IRON_ORE = 20;
	public static int VEINS_SIZE_IRON_ORE = 9;
	public static int MAX_HEIGHT_IRON_ORE = 64;
	public static int CHANCE_REDSTONE_ORE = 8;
	public static int VEINS_SIZE_REDSTONE_ORE = 8;
	public static int MAX_HEIGHT_REDSTONE_ORE = 16;
	public static int CHANCE_LAPIS_ORE = 1;
	public static int VEINS_SIZE_LAPIS_ORE = 7;
	public static int MAX_HEIGHT_LAPIS_ORE = 16;
	public static int CHANCE_COAL_ORE = 20;
	public static int VEINS_SIZE_COAL_ORE = 17;
	public static int MAX_HEIGHT_COAL_ORE = 128;
	public static int PREGENERATION_VALUE = 1500;
	public static boolean PREGENERATION = false;
	public static Biome BIOME_IN_MIDDLE = Biome.PLAINS;
	public static boolean OCEAN = true;
	public static boolean PLAINS = true;
	public static boolean DESERT = true;
	public static boolean EXTREME_HILLS = true;
	public static boolean FOREST = true;
	public static boolean TAIGA = true;
	public static boolean SWAMPLAND = true;
	public static boolean RIVER = true;
	public static boolean ICE = true;
	public static boolean MUSHROOM = true;
	public static boolean JUNGLE = true;
	public static boolean ROOFED_FOREST = true;
	public static boolean SAVANNA = true;
	public static boolean MESA = true;
	public static boolean CAVE_BOOST = false;
	
	public static boolean CUTCLEAN = false;
	public static boolean HASTEY_BOYS = false;
	public static boolean HASTEY_BABIES = false;
	public static boolean FIRELESS = false;
	public static boolean SAFEMINERS = false;
	public static boolean RODLESS = false;
	public static boolean NO_EGG_NO_SNOW = false;
	public static boolean TIMBER = false;
	public static boolean FINALHEAL = false;
	public static int FINALHEAL_TIMER = 1200;
	public static boolean DIAMONDLIMIT = false;
	public static boolean DROP_GOLD_AFTER_LIMIT = true;
	public static int DIAMONDLIMIT_SIZE = 17;
	public static boolean CATEYES = false;
	public static boolean SUPER_HEROES = false;
	public static boolean GONEFISHING = false;
	public static boolean XENOPHOBIA = false;
	
	public static boolean ALLPOTION = false;
	public static boolean LENGTHEN = true;
	public static boolean AMPLIFIED = false;
	public static boolean SPLASH = true;
	public static boolean REGENERATION = false;
	public static boolean REGENERATION_LENGTHEN = false;
	public static boolean REGENERATION_AMPLIFIED = false;
	public static boolean REGENERATION_SPLASH = false;
	public static boolean SPEED = false;
	public static boolean SPEED_LENGTHEN = false;
	public static boolean SPEED_AMPLIFIED = false;
	public static boolean SPEED_SPLASH = false;
	public static boolean FIRE_RESISTANCE = false;
	public static boolean FIRE_RESISTANCE_LENGTHEN = false;
	public static boolean FIRE_RESISTANCE_AMPLIFIED = false;
	public static boolean FIRE_RESISTANCE_SPLASH = false;
	public static boolean POISON = false;
	public static boolean POISON_LENGTHEN = false;
	public static boolean POISON_AMPLIFIED = false;
	public static boolean POISON_SPLASH = false;
	public static boolean HEAL = false;
	public static boolean HEAL_LENGTHEN = false;
	public static boolean HEAL_AMPLIFIED = false;
	public static boolean HEAL_SPLASH = false;
	public static boolean NIGHT_VISION = false;
	public static boolean NIGHT_VISION_LENGTHEN = false;
	public static boolean NIGHT_VISION_AMPLIFIED = false;
	public static boolean NIGHT_VISION_SPLASH = false;
	public static boolean WEAKNESS = false;
	public static boolean WEAKNESS_LENGTHEN = false;
	public static boolean WEAKNESS_AMPLIFIED = false;
	public static boolean WEAKNESS_SPLASH = false;
	public static boolean STRENGTH = false;
	public static boolean STRENGTH_LENGTHEN = false;
	public static boolean STRENGTH_AMPLIFIED = false;
	public static boolean STRENGTH_SPLASH = false;
	public static boolean SLOWNESS = false;
	public static boolean SLOWNESS_LENGTHEN = false;
	public static boolean SLOWNESS_AMPLIFIED = false;
	public static boolean SLOWNESS_SPLASH = false;
	public static boolean JUMP = false;
	public static boolean JUMP_LENGTHEN = false;
	public static boolean JUMP_AMPLIFIED = false;
	public static boolean JUMP_SPLASH = false;
	public static boolean DAMAGE = false;
	public static boolean DAMAGE_LENGTHEN = false;
	public static boolean DAMAGE_AMPLIFIED = false;
	public static boolean DAMAGE_SPLASH = false;
	public static boolean WATER = false;
	public static boolean WATER_LENGTHEN = false;
	public static boolean WATER_AMPLIFIED = false;
	public static boolean WATER_SPLASH = false;
	public static boolean INVISIBILITY = false;
	public static boolean INVISIBILITY_LENGTHEN = false;
	public static boolean INVISIBILITY_AMPLIFIED = false;
	public static boolean INVISIBILITY_SPLASH = false;
	
	public static int ARMOR = 4;
	public static int PROTECTION_IRON_HELMET = 4;
	public static int PROTECTION_IRON_CHESTPLATE = 4;
	public static int PROTECTION_IRON_LEGGINGS = 4;
	public static int PROTECTION_IRON_BOOTS = 4;
	public static int PROJ_IRON_HELMET = 4;
	public static int PROJ_IRON_CHESTPLATE = 4;
	public static int PROJ_IRON_LEGGINGS = 4;
	public static int PROJ_IRON_BOOTS = 4;
	public static int UNBREAKING_IRON_HELMET = 3;
	public static int UNBREAKING_IRON_CHESTPLATE = 3;
	public static int UNBREAKING_IRON_LEGGINGS = 3;
	public static int UNBREAKING_IRON_BOOTS = 3;
	public static int THORNS_IRON_HELMET = 3;
	public static int THORNS_IRON_CHESTPLATE = 3;
	public static int THORNS_IRON_LEGGINGS = 3;
	public static int THORNS_IRON_BOOTS = 3;
	public static int PROTECTION_DIAMOND_HELMET = 4;
	public static int PROTECTION_DIAMOND_CHESTPLATE = 4;
	public static int PROTECTION_DIAMOND_LEGGINGS = 4;
	public static int PROTECTION_DIAMOND_BOOTS = 4;
	public static int PROJ_DIAMOND_HELMET = 4;
	public static int PROJ_DIAMOND_CHESTPLATE = 4;
	public static int PROJ_DIAMOND_LEGGINGS = 4;
	public static int PROJ_DIAMOND_BOOTS = 4;
	public static int UNBREAKING_DIAMOND_HELMET = 3;
	public static int UNBREAKING_DIAMOND_CHESTPLATE = 3;
	public static int UNBREAKING_DIAMOND_LEGGINGS = 3;
	public static int UNBREAKING_DIAMOND_BOOTS = 3;
	public static int THORNS_DIAMOND_HELMET = 3;
	public static int THORNS_DIAMOND_CHESTPLATE = 3;
	public static int THORNS_DIAMOND_LEGGINGS = 3;
	public static int THORNS_DIAMOND_BOOTS = 3;
	public static int SHARPNESS_DIAMOND_SWORD = 5;
	public static int FIRE_ASPECT_DIAMOND_SWORD = 2;
	public static int UNBREAKING_DIAMOND_SWORD = 3;
	public static int KNOCKBACK_DIAMOND_SWORD = 2;
	public static int SHARPNESS_IRON_SWORD = 5;
	public static int FIRE_ASPECT_IRON_SWORD = 2;
	public static int UNBREAKING_IRON_SWORD = 3;
	public static int KNOCKBACK_IRON_SWORD = 2;
	public static int POWER = 5;
	public static int PUNCH = 2;
	public static int UNBREAKING_BOW = 3;
	public static int INFINITY = 1;
	public static int FLAME = 1;
	
	public static ItemStack getArrowBack() {
		ItemStack it = new ItemStack(Material.ARROW);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§cRetour");
		meta.setLore(Arrays.asList("§7Retourner au menu précédent"));
		it.setItemMeta(meta);
		return it;
	}
	
	public static ItemStack getGlass() {
		ItemStack it = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName("§7");
		it.setItemMeta(meta);
		return it;
	}
	
	public static ItemStack setMetaInItem(ItemStack it, String name, List<String> lore) {
		return setMetaInItem(it, name, lore, false);
	}
	
	public static ItemStack setMetaInItem(ItemStack it, String name, List<String> lore, boolean enchant) {
		return setMetaInItem(it, name, lore, enchant, false);
	}
	
	public static ItemStack setMetaInItem(ItemStack it, String name, List<String> lore, boolean enchant, boolean unbreakble) {
		ItemMeta meta = it.getItemMeta();
		meta.setDisplayName(name);
		if(lore != null)
			meta.setLore(lore);
		if(enchant)
			meta.addEnchant(Enchantment.WATER_WORKER, 5, false);
		if(unbreakble)
			meta.spigot().setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		it.setItemMeta(meta);
		return it;
	}
}