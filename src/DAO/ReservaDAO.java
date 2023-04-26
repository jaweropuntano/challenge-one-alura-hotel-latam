package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import modelo.Reserva;

public class ReservaDAO {
	private Connection con;

	public ReservaDAO() {
	}

	public ReservaDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public void guardar(Reserva reserva) {
		try {
			String sql = "INSERT INTO reservas(fecha_entrada, fecha_salida, valor, forma_de_pago)"
					+  "VALUES(?,?,?,?)";
			try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setObject(1, reserva.getDataE());
				pstm.setObject(2, reserva.getDataS());
				pstm.setString(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPago());
				pstm.executeUpdate();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Error de ejecucion: " + e.getMessage(),e);
		}
	}
	public List<Reserva> mostrar(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.execute();
				transformarResultado(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException();
		}		
	}
	
/////////////////////////////// BUSCAR UNA RESERVA
	public List<Reserva> buscarId(String id){
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_de_pago FROM reservas WHERE id= ?";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.setString(1, id);
				pstm.execute();
				transformarResultado(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException();
		}		
	}
	public void Actualizar(LocalDate dataE,LocalDate dataS,String valor,String formaPago, Integer id) {
		try (PreparedStatement stm = con.prepareStatement("UPDATE reservas SET fecha_entrada=?, "
				+ "fecha_salida=?, valor=?, forma_de_pago=? WHERE id=?")){
			stm.setObject(1, java.sql.Date.valueOf(dataE));
			stm.setObject(2, java.sql.Date.valueOf(dataS));
			stm.setString(3, valor);
			stm.setString(4, formaPago);
			stm.setInt(5,id);
			stm.execute();
		}catch(SQLException e) {
			throw new RuntimeException("error en ReservaDao" + e.getMessage(),e);
		}		
	}
	
	public void Eliminar(Integer id) {
		try {
			Statement state = con.createStatement();
			state.execute("SET FOREIGN_KEY_CHECKS=0");				
			PreparedStatement stm = con.prepareStatement("DELETE FROM reservas WHERE id =?");
			stm.setInt(1, id);
			stm.execute();
			state.execute("SET FOREIGN_KEY_CHECKS=1");
		}catch(SQLException e){
			throw new RuntimeException("error en ReservaDao" + e.getMessage(),e);
		}
}
	
	private void transformarResultado(List<Reserva> reservas, PreparedStatement pstm) throws SQLException{
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				int id = rst.getInt("id");
				LocalDate fechaE = rst.getDate("fecha_entrada").toLocalDate().plusDays(1);
				LocalDate fechaS = rst.getDate("fecha_salida").toLocalDate().plusDays(1);
				String valor = rst.getString("valor");
				String formaPago = rst.getString("forma_de_pago");
				
				Reserva producto = new Reserva(id, fechaE, fechaS, valor, formaPago);
				reservas.add(producto);
			}
		}
	}




}
