package factory;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionBase {
	public DataSource dataSou;
	
	public ConexionBase() {
		ComboPooledDataSource comboPool= new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura?useTimeZone=true&serverTimeZome=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("jorge");
		comboPool.setMaxPoolSize(10);
		
		this.dataSou = comboPool;		
	}
	public Connection conectarBase(){
		try {
			return this.dataSou.getConnection();
		} catch (SQLException e) {
			System.out.println("Hubo un error");
			throw new RuntimeException(e);
		}
	}

}
