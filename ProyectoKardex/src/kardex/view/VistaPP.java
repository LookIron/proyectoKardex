package kardex.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import kardex.logic.LogicKardex;

public class VistaPP extends JFrame implements ActionListener {

	private PanelKardexPP panelKardexPP;
	
	private FrameObtenerDatosPP ventanaAgregarPP;
	
	private LogicKardex mundo;
	
	private PanelOpcionesAgregarPP panelBotonesPP;
	
	private String tipo;

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
		
		String comando = e.getActionCommand();
		if (comando.equals("A")) {
			if (tipo.equals("I")) {
				panelKardexPP.addInformacion(ventanaAgregarPP.darUnidades(), ventanaAgregarPP.darPrecioUnidad(),
						ventanaAgregarPP.darTotal(), 0, "");
				mundo.setSaldoUnidades(Double.parseDouble(ventanaAgregarPP.darUnidades()));
				mundo.setSaldoValorUnidad(Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()));
				mundo.setSaldoValorTotal(Double.parseDouble(ventanaAgregarPP.darPrecioUnidad()));
				this.setVisible(true);
				ventanaAgregarPP.setVisible(false);
				ventanaAgregarPP.limpiar();
			} else if (tipo.equals("V")) {
				int numero = 1;
				panelKardexPP.addInformacion(ventanaAgregarPP.darUnidades(), ventanaAgregarPP.darPrecioUnidad(),
						ventanaAgregarPP.darTotal(), numero, "V"); //Dar total no es necesario
				double unidades = Double.parseDouble(ventanaAgregarPP.darUnidades());
				double valorUnidades = Double.parseDouble(ventanaAgregarPP.darPrecioUnidad());
				double valorTotal = Double.parseDouble(ventanaAgregarPP.darTotal());
				mundo.registrarVenta(unidades, valorUnidades, valorTotal);
				numero++;
				this.setVisible(true);
				ventanaAgregarPP.setVisible(false);
				ventanaAgregarPP.limpiar();
			} else if (tipo.equals("C")) {
				int numero = 1;
				panelKardexPP.addInformacion(ventanaAgregarPP.darUnidades(), ventanaAgregarPP.darPrecioUnidad(),
						ventanaAgregarPP.darTotal(), numero, "C");
				double unidades = Double.parseDouble(ventanaAgregarPP.darUnidades());
				double valorUnidades = Double.parseDouble(ventanaAgregarPP.darPrecioUnidad());
				double valorTotal = Double.parseDouble(ventanaAgregarPP.darTotal());
				// mundo.registrarCompra(unidades, valorUnidades, valorTotal);
				numero++;
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
		}
		
	}
}
