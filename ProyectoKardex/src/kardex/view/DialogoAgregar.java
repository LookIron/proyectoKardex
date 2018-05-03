package kardex.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class DialogoAgregar extends JDialog{
	
	private PanelAgregar agregar; 
	private VentanaConta principal;
	//TODO HACER CONEXION CON MUNDO
	public DialogoAgregar(VentanaConta p) {
		principal = p;
		setTitle("Agregar");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(HIDE_ON_CLOSE);		
		setLocationRelativeTo(null);		
		agregar = new PanelAgregar(this);
		add(agregar,BorderLayout.CENTER);
		pack();		
	}
	
	public void agregar(String nombre, String tipo, String subValor,double valor){
		principal.agregar(nombre,tipo,subValor,valor);
	}

}
