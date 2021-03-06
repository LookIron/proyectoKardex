package kardex.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kardex.logic.LogicKardex;

@SuppressWarnings("serial")
public class VistaPP extends JFrame implements ActionListener {

	private PanelKardexPP panelKardexPP;

	private FrameObtenerDatosPP ventanaAgregarPP;

	private LogicKardex mundo;

	private PanelOpcionesAgregarPP panelBotonesPP;

	private String tipo;

	private int numCompra = 1;

	private int numVenta = 1;
	
	private double valorTotal = 1;

	public VistaPP() {
		panelKardexPP = new PanelKardexPP(this);
		ventanaAgregarPP = new FrameObtenerDatosPP(this);
		mundo = new LogicKardex(0, 0, 0);
		tipo = "";
		panelBotonesPP = new PanelOpcionesAgregarPP(this);
		setLayout(new BorderLayout());
		add(panelBotonesPP, BorderLayout.SOUTH);
		add(panelKardexPP, BorderLayout.CENTER);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String comando = e.getActionCommand();
			if (comando.equals("A")) {
				if (tipo.equals("I")) {
					if (Double.parseDouble(ventanaAgregarPP.darUnidades()) <= 0
							|| Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()) <= 0
							|| Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()) <= 0) {
						throw new Exception("Se�or Stark... no me quiero ir....");
					}
					mundo.setSaldoUnidades(Double.parseDouble(ventanaAgregarPP.darUnidades()));
					mundo.setSaldoValorUnidad(Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()));
					mundo.setSaldoValorTotal(Double.parseDouble(ventanaAgregarPP.darTotal()));
					
					panelKardexPP.addInformacion(ventanaAgregarPP.darUnidades(), ventanaAgregarPP.darPrecioUnidad(),
							ventanaAgregarPP.darTotal(), 0, "I", "", "", "");
					this.setVisible(true);
					ventanaAgregarPP.setVisible(false);
					ventanaAgregarPP.limpiar();
					panelBotonesPP.quitarOpor();
					
				} else if (tipo.equals("V")) {
					if (Double.parseDouble(ventanaAgregarPP.darUnidades()) <= 0
							|| Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()) <= 0
							|| Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()) <= 0) {
						throw new Exception("Se�or Stark... no me quiero ir....");
					}
					try {
						double unidades = Double.parseDouble(ventanaAgregarPP.darUnidades());
						double valorUnidades = Double.parseDouble(ventanaAgregarPP.darPrecioUnidad());
						double valorTotal = Double.parseDouble(ventanaAgregarPP.darTotal());
						if (unidades > mundo.getSaldoUnidades()) {
							throw new Exception();
						}

						mundo.registrarVenta(unidades, valorUnidades, valorTotal);
						panelKardexPP.addInformacion(ventanaAgregarPP.darUnidades(), ventanaAgregarPP.darPrecioUnidad(),
								ventanaAgregarPP.darTotal(), numVenta, "V", mundo.getSaldoUnidades() + "",
								mundo.getSaldoValorUnidad() + "", mundo.getSaldoValorTotal() + "");

						numVenta++;
						this.setVisible(true);
						ventanaAgregarPP.setVisible(false);
						ventanaAgregarPP.limpiar();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(this,
								"Error esta intentando vender mas unidades de las que posee", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (tipo.equals("C")) {
					if (Double.parseDouble(ventanaAgregarPP.darUnidades()) <= 0
							|| Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()) <= 0
							|| Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()) <= 0) {
						throw new Exception("Se�or Stark... no me quiero ir....");
					}
					double unidades = Double.parseDouble(ventanaAgregarPP.darUnidades());
					double valorUnidades = Double.parseDouble(ventanaAgregarPP.darPrecioUnidad());
					double valorTotal = Double.parseDouble(ventanaAgregarPP.darTotal());
					mundo.registrarCompra(unidades, valorUnidades, valorTotal);
					DecimalFormat df1 = new DecimalFormat("#.00");
					panelKardexPP.addInformacion(ventanaAgregarPP.darUnidades(), ventanaAgregarPP.darPrecioUnidad(),
							ventanaAgregarPP.darTotal(), numCompra, "C", mundo.getSaldoUnidades() + "",
							df1.format(mundo.getSaldoValorUnidad()), df1.format(mundo.getSaldoValorTotal()));

					numCompra++;
					this.setVisible(true);
					ventanaAgregarPP.setVisible(false);
					ventanaAgregarPP.limpiar();
				}
			} else if (comando.equals("C")) {
				this.setVisible(true);
				ventanaAgregarPP.setVisible(false);
				ventanaAgregarPP.limpiar();
			} else if (comando.equals("In")) {
				this.setVisible(false);
				tipo = "I";
				ventanaAgregarPP.setVisible(true);
			} else if (comando.equals("VEN")) {
				this.setVisible(false);
				tipo = "V";
				ventanaAgregarPP.setVisible(true);
			} else if (comando.equals("COM")) {
				this.setVisible(false);
				tipo = "C";
				ventanaAgregarPP.setVisible(true);
			} else if (comando.equals("Vol")) {
				this.setVisible(false);
				KardexView prin = new KardexView();
				prin.setVisible(true);
			}

		} catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(this, "Error solo se aceptan valores numericos");
		}

		catch (Exception eerr) {
			if (eerr.getMessage().equals("Se�or Stark... no me quiero ir....")) {
				JOptionPane.showMessageDialog(ventanaAgregarPP, "No se permite ingresar valores negativos");
			}
		}
	}
}
