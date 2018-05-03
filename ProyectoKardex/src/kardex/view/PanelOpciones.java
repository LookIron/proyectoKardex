package kardex.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener {

	public final static String AGREGAR = "Agregar";
	public final static String BALANCE_GENERAL = "Balance General";
	public final static String ESTADO_DE_RESULTADOS = "Estado de Resultados";
	private static final String KARDEX = "Kardex";
	private JCheckBox balanceGeneral;
	private JCheckBox estadoDeResultados;
	private JButton agregar;
	private JButton kardex;
	private VentanaConta principal;

	public PanelOpciones(VentanaConta p) {
		principal = p;
		setLayout(new GridLayout(3, 1));
		balanceGeneral = new JCheckBox("Balance General");
		balanceGeneral.addActionListener(this);
		balanceGeneral.setActionCommand(BALANCE_GENERAL);
		add(balanceGeneral);
		estadoDeResultados = new JCheckBox("Estado de Resultados");
		estadoDeResultados.addActionListener(this);
		estadoDeResultados.setActionCommand(ESTADO_DE_RESULTADOS);
		add(estadoDeResultados);
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(0, 1));
		agregar = new JButton("AGREGAR");
		agregar.addActionListener(this);
		agregar.setActionCommand(AGREGAR);
		kardex = new JButton("KARDEX");
		kardex.addActionListener(this);
		kardex.setActionCommand(KARDEX);		
		aux.add(new JLabel());
		aux.add(new JLabel());
		aux.add(new JLabel());
		aux.add(agregar);
		aux.add(kardex);
		add(aux);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals(AGREGAR)) {
			principal.abrirDialogo();
		} else if (comando.equals(BALANCE_GENERAL)) {
			if (balanceGeneral.isSelected()) {
				principal.cambiarBalanceGeneral();
				estadoDeResultados.setEnabled(false);
			}else{
				principal.blanco();
				estadoDeResultados.setEnabled(true);
			}
		} else if (comando.equals(ESTADO_DE_RESULTADOS)) {
			if (estadoDeResultados.isSelected()) {
				principal.cambiarEstadoDeResultados(0);
				balanceGeneral.setEnabled(false);
			}else{
				principal.blanco();
				balanceGeneral.setEnabled(true);
			}
		} else if (comando.equals(KARDEX)){
			principal.setVisible(false);
			KardexView prin = new KardexView();
			prin.setVisible(true);
		}

	}

}
