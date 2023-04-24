package modelo;

import java.time.LocalDate;

public class Reserva {
	private Integer id;
	private LocalDate dataE;
	private LocalDate dataS;
	private String valor;
	private String formaPago;
	
	
	public Reserva() {
	}

	public Reserva(Integer id, LocalDate dataE, LocalDate dataS, String valor, String formaPago) {
		this.id = id;
		this.dataE = dataE;
		this.dataS = dataS;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataE() {
		return dataE;
	}

	public void setDateE(LocalDate dataE) {
		this.dataE = dataE;
	}

	public LocalDate getDataS() {
		return dataS;
	}

	public void setDataS(LocalDate dataS) {
		this.dataS = dataS;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
}
