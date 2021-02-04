package me.christo.enchants;

import me.christo.enchants.Enchantments.TrophyFinder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private TrophyFinder enchant;

    @Override
    public void onEnable() {
        // Plugin startup logic


        if (Bukkit.getPluginManager().getPlugin("UltraPrisonCore") == null) {
            this.getLogger().warning("Unable to hook into UltraPrisonCore! Disabling...");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        this.enchant = new TrophyFinder();

        this.enchant.register();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
