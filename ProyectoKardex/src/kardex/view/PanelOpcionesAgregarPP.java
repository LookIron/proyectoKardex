package kardex.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpcionesAgregarPP extends JPanel {

	private JButton botonInicial;

	private JButton botonCompra;

	private JButton botonVenta;

	private VistaPP principal;
	
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

		setLayout(new GridLayout(1, 3));

		add(botonInicial);
		add(botonCompra);
		add(botonVenta);
	}
}
