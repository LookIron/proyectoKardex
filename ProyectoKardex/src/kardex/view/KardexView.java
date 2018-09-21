package kardex.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class KardexView extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JButton btnIniciarPeps;
	private JButton btnIniciar;
	private JPanel auxiliar;
	private String tipo = "";
	private JButton btnHomunculo;
	private static VentanaConta ventana;

	// Las dos vistas: PEPS PP
	private VistaPEPS peps;
	private VistaPP pp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KardexView frame = new KardexView();
					frame.setVisible(true);
					ventana = new VentanaConta();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KardexView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		auxiliar = new JPanel();
		auxiliar.setLayout(new FlowLayout());

		JPanel panelImg = new JPanel();
		panelImg.setBackground(Color.WHITE);
		contentPane.add(panelImg, BorderLayout.CENTER);
		panelImg.setLayout(null);

		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBounds(25, 52, 249, 90);
		panelSeleccion.setBackground(Color.WHITE);
		panelImg.add(panelSeleccion);

		JLabel lblKardexPorPp = new JLabel("Kardex por PP");
		lblKardexPorPp.setBounds(21, 32, 88, 17);
		lblKardexPorPp.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		panelSeleccion.setLayout(null);

		JLabel lblPEPS = new JLabel("Kardex por PEPS");
		lblPEPS.setBounds(21, 58, 120, 17);
		lblPEPS.setFont(new Font("Times New Roman", Font.ITALIC, 14));
//		panelSeleccion.add(lblPEPS);
		panelSeleccion.add(lblKardexPorPp);
		
		JLabel lblFina = new JLabel("Estados Fin.");
		lblFina.setBounds(21, 5, 120, 17);
		lblFina.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		panelSeleccion.add(lblFina);
		panelSeleccion.add(lblFina);

		btnIniciar = new JButton("Iniciar PP");
		btnIniciar.addActionListener(this);
		btnIniciar.setBounds(127, 27, 89, 23);
		btnIniciar.setActionCommand("Iniciar PP");
		panelSeleccion.add(btnIniciar);

//		btnIniciarPeps = new JButton("Iniciar PEPS");
//		btnIniciarPeps.addActionListener(this);
//		btnIniciarPeps.setBounds(127, 56, 89, 23);
//		btnIniciarPeps.setActionCommand("Iniciar PEPS");
		
		btnHomunculo = new JButton("Estados Financieros");
		btnHomunculo.setBounds(127, 0, 89, 23);
		btnHomunculo.addActionListener(this);
		btnHomunculo.setActionCommand("Estados Financieros");

//		panelSeleccion.add(btnIniciarPeps);
		
		panelSeleccion.add(btnHomunculo);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 294, 41);
		panelImg.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JLabel labelTitulo = new JLabel("Bienvenido al Gestor de Kardex ");
		labelTitulo.setBounds(24, 11, 253, 24);
		labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelTitulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel.add(labelTitulo);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(300, 0, 403, 348);
		panelImg.add(panel_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(KardexView.class.getResource("/resources/img-AerialCompany-hero.png")));
		panel_1.add(label);

		JLabel lblM = new JLabel("");
		lblM.setIcon(new ImageIcon(KardexView.class.getResource("/resources/gg.png")));
		lblM.setBounds(56, 153, 238, 174);
		panelImg.add(lblM);
		this.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Iniciar PEPS")) {
			tipo = "PEPS";
			setVisible(false);
			peps = new VistaPEPS();
			peps.setVisible(true);

		} else if (comando.equals("Iniciar PP")) {
			tipo = "PP";
			setVisible(false);
			pp = new VistaPP();
			pp.setVisible(true);
		}
		else if (comando.equals("Estados Financieros")) {
			this.setVisible(false);
			ventana.setVisible(true);

		}
	}
}
