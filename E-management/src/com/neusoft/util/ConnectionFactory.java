package com.neusoft.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class ConnectionFactory {
	private ConnectionFactory() {
	}

	static DataSource ds = null;
	private static Properties ps = new Properties();

	static {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			ps.load(is);
			Class.forName(ps.getProperty("driver"));
			DataSource dataSource = DataSources.unpooledDataSource(ps.getProperty("url"), ps.getProperty("user"),
					ps.getProperty("psw"));
			ds = DataSources.pooledDataSource(dataSource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ds.getConnection();
		return conn;
	}

	/*public static void main(String[] args) {
		try {
			System.out.println(ConnectionFactory.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
