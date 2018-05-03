package kardex.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelBanner extends JPanel{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * imagen del banner
	 */
	private JLabel imagen;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * constructor del panel de imagen
	 */

	public PanelBanner() {
		setLayout(new GridLayout(1, 1));
		setBackground(Color.WHITE);
		ImageIcon icono = new ImageIcon("data/automatica.jpg");

		imagen = new JLabel("");
		imagen.setIcon(icono);
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.setVerticalAlignment(SwingConstants.CENTER);
		add(imagen);
	}

}
