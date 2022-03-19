package fwnet.loginspawn.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	
	public main plugin = this;
	
	public Boolean isEnabled = getConfig().getBoolean("plugin.enabled");
	public double x = getConfig().getDouble("plugin.x");
	public double y = getConfig().getDouble("plugin.y");
	public double z = getConfig().getDouble("plugin.z");
	public float yaw = getConfig().getInt("plugin.yaw");
	public float pitch = getConfig().getInt("plugin.pitch");
	
	
	@Override
	public void onEnable() {
		plugin = this;
		this.saveDefaultConfig();
		getLogger().info("Hello administrator! Plugin LoginSpawn enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (isEnabled == true) {
			Player p = e.getPlayer();
			p.teleport(new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch));
		}
	}
	

	@Override
	public void onDisable() {
		getLogger().info("Plugin LoginSpawn disabled! Goodbye!");
		plugin = null;
	}
	
	
}
