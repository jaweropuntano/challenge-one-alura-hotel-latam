package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Usuarios;
import views.Login;
import views.MenuUsuario;

public class usuariosControlador implements ActionListener {
	private Login vista;
	
	public usuariosControlador() {
	}

	public usuariosControlador(Login vista){
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = vista.getNombre();
		String contraseña = vista.getContraseña();
		
		if(Usuarios.validarUsuario(nombre,contraseña)) {
			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);
			vista.dispose();
		}else {
			JOptionPane.showMessageDialog(vista, "Usuario o Contraseña no validos");
		}
	}
	


}
