package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.Huespedes;

public class HuespedesDAO {
	private Connection con;

	public HuespedesDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public void guardar(Huespedes huespedes) {
		try {
			String sql = "INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad"
					+ ", telefono, id_reserva) VALUES(?,?,?,?,?,?)";
			try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, huespedes.getNombre());
				pstm.setString(2, huespedes.getApellido());
				pstm.setObject(3, huespedes.getFechaNacimienhto());
				pstm.setString(4, huespedes.getNacionalidad());
				pstm.setString(5, huespedes.getTelefono());
				pstm.setInt(6, huespedes.getIdReserva());
				pstm.execute();
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while (rst.next()) {
						huespedes.setId(rst.getInt(1));
					}
				}				
			}
		} catch (Exception e) {
			throw new RuntimeException("Error while saving guest information: " + e.getMessage());
		}
	}
	
}
