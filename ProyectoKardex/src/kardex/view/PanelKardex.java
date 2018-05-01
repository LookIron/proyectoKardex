package kardex.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelKardex extends JPanel {
	private JLabel[][] matriz;

	private int fila;

	private VistaPEPS principal;

	public PanelKardex(VistaPEPS p) {
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
				if (!primera) {
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
		for (int i = 1; i < matriz[0].length; i += 3) {
			matriz[1][i].setText("und");
		}
		for (int i = 2; i < matriz[0].length; i += 3) {
			matriz[1][i].setText("$/und");
		}
		for (int i = 3; i < matriz[0].length; i += 3) {
			matriz[1][i].setText("$Total");
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				add(matriz[i][j]);
			}
		}
	}

	public void addInformacion(String unidades, String costoUnidad, String costoTotal, int numero, String tipo) {
		int filaActu = 0;
		if (fila == 2) {
			try {
				Integer.parseInt(unidades);
				Double.parseDouble(costoUnidad);
				Double.parseDouble(costoTotal);
				matriz[fila][7].setText(unidades);
				matriz[fila][8].setText(costoUnidad);
				matriz[fila][9].setText(costoTotal);
				matriz[fila][0].setText("I.Inicial");
				fila++;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(principal, "información erronea!", "advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			if (tipo.equals("V")) {
				Integer.parseInt(unidades);
				Double.parseDouble(costoUnidad);
				Double.parseDouble(costoTotal);
				matriz[fila][4].setText(unidades);
				matriz[fila][5].setText(costoUnidad);
				matriz[fila][6].setText(costoTotal);
				matriz[fila][0].setText("Venta # " + numero + "");
				fila++;

			} else {
				Integer.parseInt(unidades);
				Double.parseDouble(costoUnidad);
				Double.parseDouble(costoTotal);
				matriz[fila][1].setText(unidades);
				matriz[fila][2].setText(costoUnidad);
				matriz[fila][3].setText(costoTotal);
				matriz[fila][0].setText("Compra # " + numero + "");
				fila++;
			}

			try {
				if (matriz[fila - 1][0].getText().equals("  ") || matriz[fila - 1][0].getText().equals("I.Inicial")) {
					boolean esta = false;
					for (int i = fila - 1; i > 0 && !esta; i--) {
						if (matriz[i][8].getText().equals(costoUnidad)) {
							esta = true;
							filaActu = i;
						}
					}
					if (esta) {
						int unidadesActu = Integer.parseInt(matriz[filaActu][7].getText());
						matriz[filaActu][7].setText((unidadesActu + Integer.parseInt(unidades)) + "");
						int costoTotalAct = Integer.parseInt(matriz[filaActu][7].getText())
								* Integer.parseInt(matriz[filaActu][8].getText());
						matriz[filaActu][9].setText(costoTotalAct + "");
					} else {
						matriz[fila][7].setText(unidades);
						matriz[fila][8].setText(costoUnidad);
						matriz[fila][9].setText(costoTotal);
						fila++;
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(principal, "información erronea!", "advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		validate();
		repaint();
	}

	public void addCompra(String unidades, String costoUnidad, String costoTotal, int numero) {
		int filaActu = 0;
		if (fila == 2) {
			try {
				Integer.parseInt(unidades);
				Double.parseDouble(costoUnidad);
				Double.parseDouble(costoTotal);
				matriz[fila][1].setText(unidades);
				matriz[fila][2].setText(costoUnidad);
				matriz[fila][3].setText(costoTotal);
				matriz[fila][0].setText("Compra #" + numero + "");
				fila++;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(principal, "información erronea!", "advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			try {
				if (matriz[fila - 1][0].getText().equals("  ") || matriz[fila - 1][0].getText().equals("I.Inicial")) {
					boolean esta = false;
					for (int i = fila - 1; i > 0 && !esta; i--) {
						if (matriz[i][8].getText().equals(costoUnidad)) {
							esta = true;
							filaActu = i;
						}
					}
					if (esta) {
						int unidadesActu = Integer.parseInt(matriz[filaActu][7].getText());
						matriz[filaActu][7].setText((unidadesActu + Integer.parseInt(unidades)) + "");
						int costoTotalAct = Integer.parseInt(matriz[filaActu][7].getText())
								* Integer.parseInt(matriz[filaActu][8].getText());
						matriz[filaActu][9].setText(costoTotalAct + "");
					} else {
						matriz[fila][7].setText(unidades);
						matriz[fila][8].setText(costoUnidad);
						matriz[fila][9].setText(costoTotal);
						fila++;
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(principal, "información erronea!", "advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		validate();
		repaint();
	}

}
