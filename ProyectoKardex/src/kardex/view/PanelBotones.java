package kardex.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotones extends JPanel {

	private JButton botonAgregar;

	private JButton botonCancelar;

	private VistaPEPS principal;

	public PanelBotones(VistaPEPS p) {
		principal = p;
		botonAgregar = new JButton("Aceptar");
		botonAgregar.addActionListener(principal);
		botonAgregar.setActionCommand("A");
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(principal);
		botonCancelar.setActionCommand("C");
		setLayout(new GridLayout(1, 2));
		add(botonAgregar);
		add(botonCancelar);
	}
}
