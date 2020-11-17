package fr.Maintenance;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import db.dbmanageur;

public class Main extends JavaPlugin{
	private static dbmanageur dbmanageur;
	private HashMap<String, Boolean> getplayermaintenance;
	public HashMap<String, String> Map;
	public HashMap<String, String> Map2;
	public EventsListener eventsListener;
	@Override
	public void onEnable() {
		System.out.println("Le plugin de maintenance vien de s'allumer !");
		dbmanageur = new dbmanageur();
		this.getplayermaintenance =  new HashMap<String, Boolean>();
		Map = new HashMap<String, String>();
		Map2 = new HashMap<String, String>();
		eventsListener = new EventsListener(this);
		getServer().getPluginManager().registerEvents(eventsListener,this);
	}
	@Override
	public void onDisable() {
		Main.dbmanageur.close();
		System.out.println("Le plugin de maintenance vien de s'etaindre !");
	}
	
	
	public static dbmanageur getdbDbmanageur() {
		return dbmanageur;
	}
	public HashMap<String, Boolean> getPlayermaintenance() {
		return getplayermaintenance;
	}
}
