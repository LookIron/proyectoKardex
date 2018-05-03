package kardex.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kardex.logic.ILogicKardex;
import kardex.logic.LogicKardex;

public class VistaPEPS extends JFrame implements ActionListener {

	private PanelKardex panelKardex;

	private FrameInfo ventanaAgregar;

	private LogicKardex mundo;

	private ILogicKardex temp;

	private PanelOpcionesAgregar panelBotones;

	private String tipo;

	public VistaPEPS() {
		panelKardex = new PanelKardex(this);
		ventanaAgregar = new FrameInfo(this);
		mundo = new LogicKardex(0, 0, 0);
		tipo = "";
		panelBotones = new PanelOpcionesAgregar(this);
		setLayout(new BorderLayout());
		add(panelBotones, BorderLayout.SOUTH);
		add(panelKardex, BorderLayout.CENTER);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String comando = e.getActionCommand();
			if (comando.equals("A")) {
				if (tipo.equals("I")) {
					if (Double.parseDouble(ventanaAgregar.darUnidades()) <= 0
							|| Double.parseDouble(ventanaAgregar.darPrecioUnidad()) <= 0
							|| Double.parseDouble(ventanaAgregar.darPrecioUnidad()) <= 0) {
						throw new Exception("Señor Stark... no me quiero ir....");
					}
					panelKardex.addInformacion(ventanaAgregar.darUnidades(), ventanaAgregar.darPrecioUnidad(),
							ventanaAgregar.darTotal(), 0, "", "", "", "");
					mundo.setSaldoUnidades(Double.parseDouble(ventanaAgregar.darUnidades()));
					mundo.setSaldoValorUnidad(Double.parseDouble(ventanaAgregar.darPrecioUnidad()));
					mundo.setSaldoValorTotal(Double.parseDouble(ventanaAgregar.darPrecioUnidad()));
					temp = new LogicKardex(Double.parseDouble(ventanaAgregar.darUnidades()),
							Double.parseDouble(ventanaAgregar.darPrecioUnidad()),
							Double.parseDouble(ventanaAgregar.darPrecioUnidad()));
					this.setVisible(true);
					ventanaAgregar.setVisible(false);
					ventanaAgregar.limpiar();
				} else if (tipo.equals("V")) {
					if (Double.parseDouble(ventanaAgregar.darUnidades()) <= 0
							|| Double.parseDouble(ventanaAgregar.darPrecioUnidad()) <= 0
							|| Double.parseDouble(ventanaAgregar.darPrecioUnidad()) <= 0) {
						throw new Exception("Señor Stark... no me quiero ir....");
					}
					try {
						int numero = 1;
						double unidades = Double.parseDouble(ventanaAgregar.darUnidades());
						double valorUnidades = Double.parseDouble(ventanaAgregar.darPrecioUnidad());
						double valorTotal = Double.parseDouble(ventanaAgregar.darTotal());
						mundo.registrarVenta(unidades, valorUnidades, valorTotal);
						if (unidades > mundo.getSaldoUnidades()) {
							throw new Exception();
						}

						panelKardex.addInformacion(ventanaAgregar.darUnidades(), ventanaAgregar.darPrecioUnidad(),
								ventanaAgregar.darTotal(), numero, "V", mundo.getSaldoUnidades() + "",
								mundo.getSaldoValorUnidad() + "", mundo.getSaldoValorTotal() + "");

						numero++;
						this.setVisible(true);
						ventanaAgregar.setVisible(false);
						ventanaAgregar.limpiar();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(this, "Error esta intentando vender mas unidades de las que posee",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (tipo.equals("C")) {
					if (Double.parseDouble(ventanaAgregar.darUnidades()) <= 0
							|| Double.parseDouble(ventanaAgregar.darPrecioUnidad()) <= 0
							|| Double.parseDouble(ventanaAgregar.darPrecioUnidad()) <= 0) {
						throw new Exception("Señor Stark... no me quiero ir....");
					}
					int numero = 1;
					double unidades = Double.parseDouble(ventanaAgregar.darUnidades());
					double valorUnidades = Double.parseDouble(ventanaAgregar.darPrecioUnidad());
					double valorTotal = Double.parseDouble(ventanaAgregar.darTotal());
					mundo.registrarCompra(unidades, valorUnidades, valorTotal);
					panelKardex.addInformacion(ventanaAgregar.darUnidades(), ventanaAgregar.darPrecioUnidad(),
							ventanaAgregar.darTotal(), numero, "C", mundo.getSaldoUnidades() + "",
							mundo.getSaldoValorUnidad() + "", mundo.getSaldoValorTotal() + "");

					numero++;
					this.setVisible(true);
					ventanaAgregar.setVisible(false);
					ventanaAgregar.limpiar();
				}
			} else if (comando.equals("C")) {
				this.setVisible(true);
				ventanaAgregar.setVisible(false);
				ventanaAgregar.limpiar();
			} else if (comando.equals("In")) {
				this.setVisible(false);
				tipo = "I";
				ventanaAgregar.setVisible(true);
			} else if (comando.equals("VEN")) {
				this.setVisible(false);
				tipo = "V";
				ventanaAgregar.setVisible(true);
			} else if (comando.equals("COM")) {
				this.setVisible(false);
				tipo = "C";
				ventanaAgregar.setVisible(true);
			} else if (comando.equals("Vol")) {
				this.setVisible(false);
				KardexView prin = new KardexView();
				prin.setVisible(true);
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "Error solo se aceptan valores numericos");
		} catch (Exception eerr) {
			if (eerr.getMessage().equals("Señor Stark... no me quiero ir....")) {
				JOptionPane.showMessageDialog(ventanaAgregar, "No se permite ingresar valores negativos");
			}
		}

	}
}
