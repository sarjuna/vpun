package application.database;

import org.postgresql.ds.PGPoolingDataSource;

public class DatabaseConnection {

	private String serverName="";
	private String dataBaseName="";
	private String user="";
	private String password="";
	
	private PGPoolingDataSource source=null;
	public void init(){
        source = new PGPoolingDataSource();
		source.setDataSourceName("A Data Source");
		source.setServerName(serverName);
		source.setDatabaseName(dataBaseName);
		source.setUser(user);
		source.setPassword(password);
		source.setMaxConnections(10);
	}
	
	
	
}
