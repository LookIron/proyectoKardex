package kardex.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.omg.CORBA.Principal;

import kardex.logic.nodo;
import kardex.logic.principal;

@SuppressWarnings("serial")
public class VentanaConta extends JFrame{
	
	private PanelOpciones opciones;
	private PanelVista vista;
	private PanelBanner banner;
	private principal mundo;
	public VentanaConta() {
		mundo = new principal();
		setTitle("Contabilidad");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		
		banner =  new PanelBanner();
		add(banner,BorderLayout.NORTH);
		opciones = new PanelOpciones(this);
		add(opciones,BorderLayout.WEST);
		vista = new PanelVista();
		add(vista,BorderLayout.CENTER);
	}
	
	
	public void abrirDialogo(){
		DialogoAgregar agregar =  new DialogoAgregar(this);
		agregar.setVisible(true);
	}
	
	public void blanco(){
		vista.blanco();
	}
	
	public void cambiarBalanceGeneral(){
		vista.iniciarBalanceGeneral();
		String pasivo 	= mundo.buscarPasivos();
		String activo = mundo.buscarActivos();
		String patrimonio 	= mundo.buscarPatrimonio();
		vista.cambiarBalanceGeneral(pasivo,activo,patrimonio,mundo.sumarActivos(),mundo.sumarPasivos());
	}
	
	public void cambiarEstadoDeResultados(int utilidad){
		vista.iniciarEstadoDeResultados();
		String costo	= mundo.buscarCostos();
		String ingreso	= mundo.buscaringreso();
		vista.cambiarEstadoDeResultados(costo,ingreso,utilidad);
	}	




	public void agregar(String nombre, String tipo, String subValor, double valor) {
		if (tipo.equals(nodo.COSTO) || tipo.equals(nodo.INGRESO)) {
			mundo.agregarAEstadoResultado(new nodo(nombre, tipo, subValor, valor));
			int utilid = mundo.calcularUtilidad();
			cambiarBalanceGeneral();
			cambiarEstadoDeResultados(utilid);
		}else{
			mundo.agregarABalanceGEneral(new nodo(nombre, tipo, subValor, valor));
			cambiarBalanceGeneral();
		}
		
	}

}
