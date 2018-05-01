package kardex.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameInfo extends JFrame {
	private JLabel[] etiquetas;

	private JTextField[] cajasTexto;

	@SuppressWarnings("unused")
	private VistaPEPS principal;

	private PanelBotones panelBotones;

	public FrameInfo(VistaPEPS p) {
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
		cajasTexto[0].setText("");
		cajasTexto[1].setText("");
		cajasTexto[2].setText("");
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
		JPanel temp = new JPanel((new GridLayout(2, 3)));
		etiquetas[0] = new JLabel("Cantidad");
		etiquetas[1] = new JLabel("precioXunidad");
		etiquetas[2] = new JLabel("precio total");
		cajasTexto[0] = new JTextField("");
		cajasTexto[1] = new JTextField("");
		cajasTexto[2] = new JTextField("");

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
