package db;

import java.sql.SQLException;

public class dbmanageur {
	
	private connection pointcombatconnection;
	
	public dbmanageur() {
		this.pointcombatconnection = new connection(new DbCredentials("51.15.167.103", "plugin_kitfaction", "19As449BlMN9YQbk", "maintenance", 3306));
	}
	
	public connection getPointcombatconnetion() {
		return pointcombatconnection;
	}

	public void close() {
		try {
			this.pointcombatconnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
