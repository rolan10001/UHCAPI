package fr.rolan.api.gui;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiManager {
	public Inventory MENU;
	public Inventory GAMEMODE_MENU;
	public Inventory ARMOR_MENU;
	public Inventory WEAPONS_MENU;
	public Inventory IRON_ARMOR_MENU;
	public Inventory DIAMOND_ARMOR_MENU;
	public Inventory POTION_MENU;
	public Inventory REGENERATION_MENU;
	public Inventory SPEED_MENU;
	public Inventory FIRE_RESISTANCE_MENU;
	public Inventory POISON_MENU;
	public Inventory HEAL_MENU;
	public Inventory NIGHT_VISION_MENU;
	public Inventory WEAKNESS_MENU;
	public Inventory STRENGTH_MENU;
	public Inventory SLOWNESS_MENU;
	public Inventory JUMP_MENU;
	public Inventory DAMAGE_MENU;
	public Inventory WATER_MENU;
	public Inventory INVISIBILITY_MENU;
	public Inventory TIMER_MENU;
	public Inventory BORDER_MENU;
	public Inventory INVENTORY_MENU;
	public Inventory SETTINGS_MENU;
	public Inventory TEAM_MENU;
	public Inventory WORLD_MENU;
	public Inventory DROP_MENU;
	public Inventory GENERATION_MENU;
	public Inventory SCENARIO_MENU;
	public Inventory FINALHEAL_MENU;
	public Inventory DIAMONDLIMIT_MENU;
	public Inventory GENERATION_ORE_MENU;
	public Inventory DIAMOND_MENU;
	public Inventory GOLD_MENU;
	public Inventory IRON_MENU;
	public Inventory LAPIS_MENU;
	public Inventory COAL_MENU;
	public Inventory REDSTONE_MENU;
	public Inventory PREGENERATION_MENU;
	public Inventory BIOME_MENU;
	public Inventory BIOME_IN_MIDDLE_MENU;
	public Inventory BANNER_TEAM_MENU;
	public Inventory CONFIGURATION_MENU;
	
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
