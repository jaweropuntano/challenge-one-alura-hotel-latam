package controladores;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import DAO.ReservaDAO;
import factory.ConexionBase;
import modelo.Reserva;

public class ReservaControlador {
	
	private ReservaDAO reservaD;

	public ReservaControlador() {
		Connection con = new ConexionBase().conectarBase();
		this.reservaD = new ReservaDAO(con);
	}
	
	public void guardar(Reserva reserva) {
		this.reservaD.guardar(reserva);
	}
	public List<Reserva> mostrar(){
		return this.reservaD.mostrar();
	}
	
	public List<Reserva> buscar(String id){
		return this.reservaD.buscarId(id);
	}
	public void actualizarReserva(LocalDate dataE, LocalDate dataS, String valor, String formaPago, Integer id) {
		this.reservaD.Actualizar(dataE, dataS, valor, formaPago, id);
	}
	public void Eliminar(Integer id) {
		this.reservaD.Eliminar(id);
	}
	

}
