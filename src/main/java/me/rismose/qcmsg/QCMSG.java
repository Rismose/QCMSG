package me.rismose.qcmsg;

import me.rismose.qcmsg.Menus.MainMenu;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class QCMSG extends JavaPlugin implements Listener {

    public static String ZombieNormalSpawn;
    public static String ZombieHelmetSpawn;
    public static String ZombieChestSpawn;
    public static String ZombieLeggingSpawn;
    public static String ZombieBootSpawn;

    public QCMSG() {
        ZombieNormalSpawn = this.getConfig().getString("ZombieNormalSpawn");
        ZombieHelmetSpawn = this.getConfig().getString("ZombieHelmetSpawn");
        ZombieChestSpawn = this.getConfig().getString("ZombieChestSpawn");
        ZombieLeggingSpawn = this.getConfig().getString("ZombieLeggingSpawn");
        ZombieBootSpawn = this.getConfig().getString("ZombieBootSpawn");
    }

    @Override
    public void onEnable() {

        this.saveDefaultConfig();
        this.reloadConfig();
        this.getServer().getPluginManager().registerEvents(this, this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Objects.requireNonNull(getCommand("qc")).setExecutor(new MainMenu());


        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7Plugin Shut Down Unexpectedly");
    }
}
