package kardex.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kardex.logic.nodo;

@SuppressWarnings("serial")
public class PanelAgregar extends JPanel implements ActionListener{
	
	public final static String AGREGAR = "Agregar";
	
	private DialogoAgregar principal;
	
	private JLabel nombre;
	private JTextField nom;
	private JLabel valor;
	private JTextField val;
	private JLabel tipo;
	private JComboBox<String> combo;
	private JLabel subdivision;
	private JComboBox<String> plazo;	
	private JButton agregar;
	
	public PanelAgregar(DialogoAgregar p) {
		principal = p;
		setLayout(new GridLayout(5, 5));
		nombre = new JLabel("Nombre: ");
		add(nombre);
		nom = new JTextField();
		add(nom);	
		valor = new JLabel("Valor: ");
		add(valor);
		val = new JTextField();
		add(val);
		tipo = new JLabel("Tipo: ");
		add(tipo);
		String[]array = {nodo.ACTIVOS,nodo.PASIVOS,nodo.PATRIMONIO,nodo.INGRESO,nodo.COSTO};
		combo = new JComboBox<>();
		combo.setModel(new DefaultComboBoxModel<String>(array));
		add(combo);
		String[]array2 ={nodo.C_PLAZO,nodo.L_PLAZO,nodo.OPERATIVO,nodo.NOPERATIVO};
		subdivision =  new JLabel("Subdivicion: ");
		add(subdivision);
		plazo = new JComboBox<>();
		plazo.setModel(new DefaultComboBoxModel<String>(array2));
		add(plazo);		
		add(new JLabel());
		agregar = new JButton("Agregar");
		agregar.addActionListener(this);
		agregar.setActionCommand(AGREGAR);
		add(agregar);		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals(AGREGAR)) {
			String nombre = nom.getText();
			String tipo = combo.getItemAt(combo.getSelectedIndex());
			String subdivicion = plazo.getItemAt(plazo.getSelectedIndex());
			try {
			double valor = Double.parseDouble(val.getText());
			principal.agregar(nombre, tipo,subdivicion, valor);			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "El campo de texto valor solo admite caracteres numericos");
			}
		}
		
	}

}
