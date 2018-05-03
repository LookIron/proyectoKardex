package kardex.view;

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpcionesAgregarPP extends JPanel {

	private JButton botonInicial;

	private JButton botonCompra;

	private JButton botonVenta;

	private VistaPP principal;

	private AbstractButton botonVolver;
	
	public PanelOpcionesAgregarPP(VistaPP p) {
		
		principal = p;
		
		botonInicial = new JButton("A. Inicial");
		botonInicial.addActionListener(principal);
		botonInicial.setActionCommand("In");

		botonVenta = new JButton("A. Venta");
		botonVenta.addActionListener(principal);
		botonVenta.setActionCommand("VEN");

		botonCompra = new JButton("A. Compra");
		botonCompra.setActionCommand("COM");
		botonCompra.addActionListener(principal);
		
		botonVolver = new JButton("Seleccion tipo");
		botonVolver.setActionCommand("Vol");
		botonVolver.addActionListener(principal);

		setLayout(new GridLayout(1, 4));

		add(botonInicial);
		add(botonCompra);
		add(botonVenta);
		add(botonVolver);
	}

	public void quitarOpor() {
		botonInicial.setEnabled(false);
	}
}
