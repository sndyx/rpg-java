package net.aradiata;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {

    }

}
