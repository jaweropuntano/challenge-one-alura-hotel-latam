package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Huespedes;
import modelo.Reserva;

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
	
	public List<Huespedes> mostrar(){
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, "
					+ "telefono, id_reserva FROM huespedes";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.execute();
				transformarResultado(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException("error en HuespedDao" + e.getMessage(),e);
		}		
	}
	
	public List<Huespedes> buscarId(String id){
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, "
					+ "telefono, id_reserva FROM huespedes WHERE id=?";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.setString(1, id);
				pstm.execute();
				transformarResultado(huespedes, pstm);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException("error en HuespedDao" + e.getMessage(),e);
		}		
	}
	
	public void ActualizarH(String nombre, String apellido, Date fechaNacimienhto, String nacionalidad,
			String telefono, Integer idReserva, Integer id) {
		try(PreparedStatement stm= con.prepareStatement(""
				+"UPDATE huespedes SET nombre=?, apellido=?, fecha_nacimiento=?, nacionalidad=?, "
				+"telefono=?, id_reserva=? WHERE id=?")){
			stm.setString(1, nombre);
			stm.setString(2, apellido);
			stm.setObject(3, fechaNacimienhto);
			stm.setString(4, nacionalidad);
			stm.setString(5, telefono);
			stm.setInt(6, idReserva);
			stm.setInt(7, id);
			stm.execute();
		}catch(SQLException e){
			throw new RuntimeException(e);			
		}		
	}
	
	public void Eliminar(Integer id) {
		try(PreparedStatement stm = con.prepareStatement("DELETE FROM huespedes WHERE id=?")){
			stm.setInt(1, id);
			stm.execute();			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	private void transformarResultado(List<Huespedes> huespedes, PreparedStatement pstm) throws SQLException{
		try(ResultSet rst = pstm.executeQuery()){
			while(rst.next()) {
				int id = rst.getInt("id");
				String nombre = rst.getString("nombre");
				String apellido = rst.getString("apellido");
				LocalDate fechaNacimiento = rst.getDate("fecha_nacimiento").toLocalDate().plusDays(1);
				String nacionalidad = rst.getString("nacionalidad");
				String telefono = rst.getString("telefono");
				int idReserva = rst.getInt("id_reserva");
				
				Huespedes huesped = new Huespedes(id, nombre, apellido, fechaNacimiento,nacionalidad,telefono,idReserva);
				huespedes.add(huesped);

			}
		}
	}
	
}
