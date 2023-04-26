package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import DAO.HuespedesDAO;
import factory.ConexionBase;
import modelo.Huespedes;

public class HuespedesControlador {
	private HuespedesDAO huespedesDao;
	public HuespedesControlador() {
		Connection con = new ConexionBase().conectarBase();
		this.huespedesDao = new HuespedesDAO(con);
		}
	public void guardar(Huespedes huespedes) {
		this.huespedesDao.guardar(huespedes);
	}
	public List<Huespedes> mostrarHuesped(){
		return this.huespedesDao.mostrar();
	}
	public List<Huespedes> buscarHuesped(String id){
		return this.huespedesDao.buscarId(id);
	}
	
	public void actualizarH(String nombre, String apellido, Date fechaNacimienhto, String nacionalidad,
			String telefono, Integer idReserva, Integer id) {
		this.huespedesDao.ActualizarH(nombre, apellido, fechaNacimienhto, nacionalidad, telefono, idReserva, id);
		
	}
	
	public void Eliminar(Integer idReserva) {
		this.huespedesDao.Eliminar(idReserva);
	}
}
