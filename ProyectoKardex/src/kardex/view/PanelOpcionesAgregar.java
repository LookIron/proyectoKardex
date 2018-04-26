package kardex.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


class PanelOpcionesAgregar extends JPanel {
	private JButton botonInicial;

	private JButton botonCompra;

	private JButton botonVenta;

	private KardexView principal;

	public PanelOpcionesAgregar(KardexView p) {

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
