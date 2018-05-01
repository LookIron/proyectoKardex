package kardex.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuInicio extends JFrame implements ActionListener {

	private JButton btnPEPS;
	private JButton btnPP;
	private JLabel lblMensaje;
	private JPanel auxiliar;
	private String tipo = "";
	
	public MenuInicio() {
		
		setLayout(new BorderLayout());
		
		auxiliar = new JPanel();
		auxiliar.setLayout(new FlowLayout());
		
		lblMensaje = new JLabel("Eliga el metodo para trabajar en el Kardex");
		
		btnPEPS = new JButton("PEPS");
		btnPEPS.addActionListener(this);
		btnPEPS.setActionCommand("PEPS");
		
		btnPEPS = new JButton("PP");
		btnPEPS.addActionListener(this);
		btnPEPS.setActionCommand("PP");
		
		auxiliar.add(btnPEPS);
		auxiliar.add(btnPP);
		
		add(lblMensaje, BorderLayout.NORTH);
		add(auxiliar,BorderLayout.SOUTH);
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("PEPS")) {
			tipo = "PEPS";
		}else if(comando.equals("PP")){
			tipo = "PP";
		}
		
	}
	
	public String obtenerOpcion(){
		return tipo;
	}
}
