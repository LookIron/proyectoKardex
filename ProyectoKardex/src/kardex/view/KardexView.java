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

import kardex.logic.LogicKardex;

public class KardexView extends JFrame implements ActionListener {

	private JButton btnPEPS;
	private JButton btnPP;
	private JLabel lblMensaje;
	private JPanel auxiliar;
	private String tipo = "";
	
	//Las dos vistas: PEPS PP
	private VistaPEPS peps;
	private VistaPP pp;
	

	public KardexView() {
		
		setLayout(new BorderLayout());
		
		auxiliar = new JPanel();
		auxiliar.setLayout(new FlowLayout());
		
		lblMensaje = new JLabel("Eliga el metodo para trabajar en el Kardex");
		
		btnPEPS = new JButton("PEPS");
		btnPEPS.addActionListener(this);
		btnPEPS.setActionCommand("PEPS");
		
		btnPP = new JButton("PP");
		btnPP.addActionListener(this);
		btnPP.setActionCommand("PP");
		
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
			setVisible(false);
			peps = new VistaPEPS();
			peps.setVisible(true);
			
		}else if(comando.equals("PP")){
			tipo = "PP";
			setVisible(false);
			pp = new VistaPP();
			pp.setVisible(true);
		}
	}

	public static void main(String[] args) {
		KardexView prin = new KardexView();
		
		prin.setVisible(true);
		
	}
}
