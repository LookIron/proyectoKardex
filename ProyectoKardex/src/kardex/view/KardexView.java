package kardex.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import kardex.logic.ILogicKardex;

public class KardexView {

	private ILogicKardex logicKardex;

@SuppressWarnings("serial")
public class Principal extends JFrame implements ActionListener{
	
	private PanelKardex panelKardex;
	
	private VentanaAgregar ventanaAgregar;
	
	private PanelOpcionesAgregar panelBotones;
	
	private String tipo;
	
	public Principal() {
		panelKardex = new PanelKardex(this);
		ventanaAgregar = new VentanaAgregar(this);
		tipo = "";
		panelBotones = new PanelOpcionesAgregar(this);
		setLayout(new BorderLayout());
		add(panelBotones, BorderLayout.SOUTH);
		add(panelKardex, BorderLayout.CENTER);
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("A")) {
			if(tipo.equals("I")) {
				panelKardex.addInventarioInicial(ventanaAgregar.darUnidades(), ventanaAgregar.darPrecioUnidad(), ventanaAgregar.darTotal());
				this.setVisible(true);
				ventanaAgregar.setVisible(false);
			}else if(tipo.equals("V")) {
				
			}else if(tipo.equals("C")) {
				
			}
		}else if(comando.equals("C")) {
			this.setVisible(true);
			ventanaAgregar.setVisible(false);
			ventanaAgregar.limpiar();
		}else if(comando.equals("In")) {
			this.setVisible(false);
			tipo = "I";
			ventanaAgregar.setVisible(true);
		}else if(comando.equals("VEN")) {
			this.setVisible(false);
			tipo = "V";
			ventanaAgregar.setVisible(true);
		}else if(comando.equals("COM")) {
			this.setVisible(false);
			tipo = "C";
			ventanaAgregar.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.setVisible(true);
	}
}

@SuppressWarnings("serial")
class PanelBotones extends JPanel{
	
	private JButton botonAgregar;
	
	private JButton botonCancelar;

	private Principal principal;
	
	public PanelBotones(Principal p) {
		principal = p;
		botonAgregar =  new JButton("Aceptar");
		botonAgregar.addActionListener(principal);
		botonAgregar.setActionCommand("A");
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(principal);
		botonCancelar.setActionCommand("C");
		setLayout(new GridLayout(1,2));
		add(botonAgregar);
		add(botonCancelar);
	}	
}

@SuppressWarnings("serial")
class VentanaAgregar extends JFrame{
	private JLabel [] etiquetas;
	
	private JTextField[] cajasTexto;
	
	@SuppressWarnings("unused")
	private Principal principal;
	
	private PanelBotones panelBotones;
	
	public VentanaAgregar(Principal p) {
		principal = p;
		etiquetas = new JLabel[3];
		cajasTexto = new JTextField[3];
		panelBotones = new PanelBotones(p);
		setLayout(new BorderLayout());
		JPanel panelIngreso = crearPanel();
		this.add(panelBotones, BorderLayout.SOUTH);
		this.add(panelIngreso, BorderLayout.CENTER);
		pack();
	}

	public void limpiar() {
		cajasTexto [0].setText("");
		cajasTexto [1].setText("");
		cajasTexto [2].setText("");
		validate();
		repaint();
	}
	
	public String darTotal() {
		return cajasTexto[2].getText();
	}

	public String darPrecioUnidad() {
		return cajasTexto[1].getText();
	}

	public String darUnidades() {
		return cajasTexto[0].getText();
	}

	private JPanel crearPanel() {
		JPanel temp = new JPanel((new GridLayout(2,3)));
		etiquetas [0] = new JLabel("Cantidad");
		etiquetas [1] = new JLabel("precioXunidad");
		etiquetas [2] = new JLabel("precio total");
		cajasTexto [0] = new JTextField("");
		cajasTexto [1] = new JTextField("");
		cajasTexto [2] = new JTextField("");
		
		for (int i = 0; i < cajasTexto.length; i++) {
			etiquetas[i].setHorizontalAlignment(SwingConstants.CENTER);
			temp.add(etiquetas[i]);
		}
		
		for (int i = 0; i < cajasTexto.length; i++) {
			temp.add(cajasTexto[i]);
		}
		return temp;
	}
	
	
}

@SuppressWarnings("serial")
class PanelKardex extends JPanel{
	 private JLabel[][] matriz;
	 
	 private int fila;
	
	 private Principal principal;
	 
	 public PanelKardex(Principal p) {
		 llenarInicial();
		 fila = 2;
		 principal = p;
	 }



	private void llenarInicial() {
		matriz = new JLabel[20][10];
		setLayout(new GridLayout(20, 10));
		boolean primera = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = new JLabel("  ");
				if(!primera) {
					matriz[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
			}
			primera = false;
		}
		matriz[1][0].setText("Descripcion");
		matriz[1][0].setHorizontalAlignment(SwingConstants.CENTER);
		matriz[0][2].setText("Compras");
		matriz[0][2].setHorizontalAlignment(SwingConstants.CENTER);
		matriz[0][5].setText("Ventas");
		matriz[0][5].setHorizontalAlignment(SwingConstants.CENTER);
		matriz[0][8].setText("Saldo");
		matriz[0][8].setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 1; i < matriz[0].length; i+=3) {
			matriz[1][i].setText("und");
		}
		for (int i = 2; i < matriz[0].length; i+=3) {
			matriz[1][i].setText("$/und");
		}
		for (int i = 3; i < matriz[0].length; i+=3) {
			matriz[1][i].setText("$Total");
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				add(matriz[i][j]);
			}
		}
	}
	
	public void addInventarioInicial(String unidades, String costoUnidad, String costoTotal) {
		int filaActu = 0;
		if(fila==2) {
			try {
				Integer.parseInt(unidades);
				Double.parseDouble(costoUnidad);
				Double.parseDouble(costoTotal);
				matriz[fila][7].setText(unidades);
				matriz[fila][8].setText(costoUnidad);	
				matriz[fila][9].setText(costoTotal);
				matriz[fila][0].setText("I.Inicial");
				matriz[4][0].setText("compra # 1");
				fila++;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(principal, "información erronea!", "advertencia", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			try {
				if(matriz[fila-1][0].getText().equals("  ")||matriz[fila-1][0].getText().equals("I.Inicial")) {
					boolean esta = false;
					for (int i = fila-1; i >0 && !esta ; i--) {
						if(matriz[i][8].getText().equals(costoUnidad)) {
							esta = true;
							filaActu = i;
						}
					}
					if(esta) {
						int unidadesActu =Integer.parseInt(matriz[filaActu][7].getText());
						matriz[filaActu][7].setText((unidadesActu+Integer.parseInt(unidades))+"");
						int costoTotalAct = Integer.parseInt(matriz[filaActu][7].getText())*Integer.parseInt(matriz[filaActu][8].getText());
						matriz[filaActu][9].setText(costoTotalAct+"");
					}else {
						matriz[fila][7].setText(unidades);
						matriz[fila][8].setText(costoUnidad);	
						matriz[fila][9].setText(costoTotal);
						fila++;
					}
				}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(principal, "información erronea!", "advertencia", JOptionPane.ERROR_MESSAGE);
			}
		}
		validate();
		repaint();
	}
}

@SuppressWarnings("serial")
class PanelOpcionesAgregar extends JPanel{
	private JButton botonInicial;
	
	private JButton botonCompra;
	
	private JButton botonVenta;
	
	private Principal principal;
	
	public PanelOpcionesAgregar(Principal p) {
		
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


}
