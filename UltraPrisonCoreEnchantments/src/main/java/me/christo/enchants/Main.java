package me.christo.enchants;

import me.christo.enchants.Enchantments.GemFinder;
import me.christo.enchants.Enchantments.TrophyFinder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private TrophyFinder trophy;
    private GemFinder gemFinder;

    @Override
    public void onEnable() {
        // Plugin startup logic


        if (Bukkit.getPluginManager().getPlugin("UltraPrisonCore") == null) {
            this.getLogger().warning("Unable to hook into UltraPrisonCore! Disabling...");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        this.gemFinder = new GemFinder();
        this.trophy = new TrophyFinder();

        this.gemFinder.register();
        this.trophy.register();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
