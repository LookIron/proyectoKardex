package kardex.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PanelVista extends JPanel {

	private JTextArea activos;
	private JTextArea pasivos;
	private JTextArea patrimonio;
	private JTextArea estadoDeResultados;
	private JLabel sumaActivos;
	private JLabel sumaPasivosPatrimonio;
	private JLabel utilidad;
	public PanelVista() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		activos = new JTextArea();
		activos.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		activos.setEditable(false);
		pasivos = new JTextArea();
		pasivos.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pasivos.setEditable(false);
		patrimonio = new JTextArea();
		patrimonio
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		patrimonio.setEditable(false);
		estadoDeResultados = new JTextArea();
		estadoDeResultados
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		estadoDeResultados.setEditable(false);
		blanco();
	}

	public void blanco() {
		removeAll();
		setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JTextArea nuevo = new JTextArea();
		nuevo.setEditable(false);
		nuevo.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		add(nuevo, BorderLayout.CENTER);
		repaint();
		validate();
	}

	public void iniciarBalanceGeneral() {
		removeAll();
		setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JTextArea balance = new JTextArea("                                                                                                                        Balance General\n                                                                                                                            Contabilidad\n                                                                                                                                  2017");
		balance.setEditable(false);
		balance.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(2, 1));
		JScrollPane panel1 = new JScrollPane(activos);
		panel1.setPreferredSize(new Dimension(400, 0));
		add(panel1,BorderLayout.WEST);
		JScrollPane panel2 = new JScrollPane(pasivos);
		aux.add(panel2);		
		JScrollPane panel3 = new JScrollPane(patrimonio);
		aux.add(panel3);
		add(balance,BorderLayout.NORTH);
		add(aux, BorderLayout.CENTER);
		JPanel aux2 = new JPanel();
		aux2.setBackground(Color.white);
		aux2.setLayout(new GridLayout(1, 4));
		aux2.add(new JLabel("Suma:"));
		sumaActivos = new JLabel();
		sumaActivos.setPreferredSize(new Dimension(0, 30));
		aux2.add(sumaActivos);
		sumaPasivosPatrimonio = new JLabel();
		aux2.add(new JLabel("Suma:"));
		aux2.add(sumaPasivosPatrimonio);
		add(aux2,BorderLayout.SOUTH);
		repaint();
		validate();
	}
	

	public void iniciarEstadoDeResultados() {
		removeAll();
		setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JTextArea estado = new JTextArea("                                                                                                                      Estado de Resultados\n                                                                                                                               Contabilidad\n                                                                                                                                     2017");
		estado.setEditable(false);
		estado.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		add(estado,BorderLayout.NORTH);
		JScrollPane panel = new JScrollPane(estadoDeResultados);
		add(panel, BorderLayout.CENTER);
		JPanel aux = new JPanel();
		aux.setBackground(Color.white);
		aux.setLayout(new GridLayout(1,2));
		aux.add(new JLabel("  Utilidad: "));
		utilidad = new JLabel();
		utilidad.setPreferredSize(new Dimension(0, 40));
		aux.add(utilidad);
		add(aux,BorderLayout.SOUTH);
		repaint();
		validate();
	}

	public void cambiarBalanceGeneral(String activos, String pasivos, String patrimonio,int act,int pas) {
		this.pasivos.setText(activos);
		this.activos.setText(pasivos);
		this.patrimonio.setText(patrimonio);
		sumaActivos.setText(act+"");
		sumaPasivosPatrimonio.setText(pas+"");
	}

	public void cambiarEstadoDeResultados(String costo, String ingreso, int utilidad2) {
		estadoDeResultados.setText(ingreso+"\n"+costo);
		utilidad.setText(utilidad2+"");
	}

}
