package controladores;

import java.sql.Connection;
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
}
