package fr.Maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import db.connection;
import net.md_5.bungee.event.EventHandler;

public class EventsListener implements Listener{
	private Main main;
	Player player;
	public EventsListener(Main main) {
		this.main = main;
	}
	@EventHandler
	public void playerjoinevent(PlayerJoinEvent event) {
		System.out.println("playerjoinevent");
		String playername = event.getPlayer().getName();
		playername = event.getPlayer().getName();
		final connection pointcombat = Main.getdbDbmanageur().getPointcombatconnetion();
		
		try {
			final Connection connection = pointcombat.getConnection();
			System.out.println("connaction    "+ connection);
			String query = "SELECT Name, Maintenance FROM Maintenance WHERE Name="+ playername +"";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			final ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				final boolean maintenance = resultSet.getBoolean("Maintenance");
				main.getPlayermaintenance().put(playername, maintenance);
			}else {
				
				createuser(connection, playername);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void createuser(Connection connection, String playername) {
		System.out.println("create user");
		try {
			final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `maintenance`(`name`, `maintenance`) VALUES ("+ playername +",false");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
