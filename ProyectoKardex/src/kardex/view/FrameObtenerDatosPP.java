package kardex.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameObtenerDatosPP extends JFrame {

	private JLabel[] etiquetas;

	private JTextField[] cajasTexto;

	//@SuppressWarnings("unused")
	private VistaPP principal;

	private PanelBotonesPP panelBotones;
	
	//private String total;
	
	public FrameObtenerDatosPP(VistaPP p) {
		
		principal = p;
		etiquetas = new JLabel[2];
		cajasTexto = new JTextField[2];
		panelBotones = new PanelBotonesPP(p);
		setLayout(new BorderLayout());
		JPanel panelIngreso = crearPanel();
		this.add(panelBotones, BorderLayout.SOUTH);
		this.add(panelIngreso, BorderLayout.CENTER);
		pack();
		
	}
	
	public void limpiar() {
		cajasTexto[0].setText("");
		cajasTexto[1].setText("");
		validate();
		repaint();
	}
	
	public String darPrecioUnidad() {
		return cajasTexto[1].getText();
	}

	public String darUnidades() {
		return cajasTexto[0].getText();
	}
	
	public String darTotal(){
		
		int unidades = Integer.parseInt(darUnidades());
		int precioUnidad = Integer.parseInt(darPrecioUnidad());
		
		return unidades*precioUnidad + "";
	}
	
	private JPanel crearPanel() {
		JPanel temp = new JPanel((new GridLayout(2, 2)));
		etiquetas[0] = new JLabel("Cantidad");
		etiquetas[1] = new JLabel("precioXunidad");
		cajasTexto[0] = new JTextField("");
		cajasTexto[1] = new JTextField("");

		for (int i = 0; i < etiquetas.length; i++) {
			etiquetas[i].setHorizontalAlignment(SwingConstants.CENTER);
			temp.add(etiquetas[i]);
		}

		for (int i = 0; i < cajasTexto.length; i++) {
			temp.add(cajasTexto[i]);
		}
		return temp;
	}
	
}
