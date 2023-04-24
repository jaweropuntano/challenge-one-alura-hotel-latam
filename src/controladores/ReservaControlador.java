package controladores;

import DAO.ReservaDAO;
import modelo.Reserva;

public class ReservaControlador {
	
	private ReservaDAO reservaD;

	public ReservaControlador() {
		super();
		this.reservaD = reservaD;
	}
	
	public void guardar(Reserva reserva) {
		this.reservaD.guardar(reserva);
	}
	
	

}
