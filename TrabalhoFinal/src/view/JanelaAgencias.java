package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class JanelaAgencias extends JFrame {

	/**
	 * @author Kesley Nascimento
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_agencias;
	private JTextField txt_nome;
	private JTextField txt_site;
	private JTextField txt_bairro;
	private JTextField txt_cidade;
	private JTextField txt_estado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAgencias frame = new JanelaAgencias();
					frame.setVisible(true);
				} catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaAgencias() {
		setResizable(false);		
		panel_agencias = new JPanel();
		setTitle("SAV - Inicio");
		setBounds(100, 100, 535, 390);
		panel_agencias.setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel_agencias);
		
		JLabel lblSA = new JLabel("Sistema de Agências de Viagens");
		lblSA.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		lblSA.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSA.setForeground(Color.BLACK);
		lblSA.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JSeparator separator01 = new JSeparator();
		separator01.setForeground(Color.GRAY);
		
		JScrollPane scroll_agencias = new JScrollPane();
		
		JList<String> list = new JList<String>();
		list.setBorder(new MatteBorder(0, 2, 0, 0, (Color) SystemColor.controlShadow));
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setToolTipText("Clique para exibir as informa\u00E7\u00F5es");
		list.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7959693127743602063L;
			String[] values = new String[] {"Flytour Viagens"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		scroll_agencias.setViewportView(list);
		
		JPanel panel_info = new JPanel();
		panel_info.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		txt_nome = new JTextField();
		txt_nome.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_nome.setEditable(false);
		txt_nome.setBorder(null);
		txt_nome.setText("Flytour Viagens");
		txt_nome.setColumns(10);
		
		JLabel lblInformacoes = new JLabel("Informa\u00E7\u00F5es");
		lblInformacoes.setForeground(Color.DARK_GRAY);
		lblInformacoes.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		
		JLabel lblNome = new JLabel("Agencia:");
		
		JLabel lblWebsite = new JLabel("Website:");
		
		txt_site = new JTextField();
		txt_site.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_site.setBorder(null);
		txt_site.setEditable(false);
		txt_site.setText("www.flytour.com.br");
		txt_site.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setForeground(Color.DARK_GRAY);
		lblEndereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		txt_bairro = new JTextField();
		txt_bairro.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_bairro.setText("Alphaville");
		txt_bairro.setEditable(false);
		txt_bairro.setColumns(10);
		txt_bairro.setBorder(null);
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		txt_cidade = new JTextField();
		txt_cidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_cidade.setText("Santo Andre");
		txt_cidade.setEditable(false);
		txt_cidade.setColumns(10);
		txt_cidade.setBorder(null);
		
		JLabel lblEstado = new JLabel("Estado:");
		
		txt_estado = new JTextField();
		txt_estado.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_estado.setText("SP");
		txt_estado.setEditable(false);
		txt_estado.setColumns(10);
		txt_estado.setBorder(null);
		
// Action do botao SALVAR-------------------------------------------------------------------------------------------------------------
		JButton btn_salvar = new JButton("");
		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditableTextFields(false);
				btn_salvar.setEnabled(false);
			}
		});
		btn_salvar.setEnabled(false);
		btn_salvar.setContentAreaFilled(false);
		btn_salvar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_salvar.setBorder(null);
		btn_salvar.setIcon(new ImageIcon(JanelaAgencias.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));

// Botao para abrir a janela contendo os Pacotes Disponiveis relacionado a Agencia escolhida-------------------------------------------------------------------------------------------------------------
		JButton btn_pctDisponivel = new JButton("Pacotes disponíveis");
		btn_pctDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPacotes.main(null);
			}
		});
		
		JLabel lblcamposObrigatrios = new JLabel("Todos campos são obrigatórios");
		lblcamposObrigatrios.setVisible(false);
		lblcamposObrigatrios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblcamposObrigatrios.setForeground(new Color(139, 0, 0));
		lblcamposObrigatrios.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditableTextFields(true);
				ClearTextFields();
				btn_salvar.setEnabled(true);
			}
		});
		
		JButton btn_editar = new JButton("Editar");
		btn_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditableTextFields(true);		
				btn_salvar.setEnabled(true);
			}
		});
		
		JLabel lblEscolhaUmaAgncia = new JLabel("Escolha uma agência...");
		lblEscolhaUmaAgncia.setAlignmentY(Component.TOP_ALIGNMENT);
		lblEscolhaUmaAgncia.setForeground(SystemColor.textInactiveText);
		lblEscolhaUmaAgncia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		GroupLayout gl_panel_agencias = new GroupLayout(panel_agencias);
		gl_panel_agencias.setHorizontalGroup(
			gl_panel_agencias.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_agencias.createSequentialGroup()
					.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_agencias.createSequentialGroup()
							.addGap(12)
							.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_agencias.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_agencias.createSequentialGroup()
									.addGap(2)
									.addComponent(lblEscolhaUmaAgncia, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addComponent(scroll_agencias, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_agencias.createSequentialGroup()
									.addComponent(btn_editar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(btn_novo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addComponent(panel_info, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_agencias.createSequentialGroup()
							.addGap(377)
							.addComponent(lblcamposObrigatrios))
						.addGroup(gl_panel_agencias.createSequentialGroup()
							.addGap(369)
							.addComponent(btn_pctDisponivel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_agencias.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSA, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_agencias.setVerticalGroup(
			gl_panel_agencias.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_agencias.createSequentialGroup()
					.addComponent(lblSA, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(separator01, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_agencias.createSequentialGroup()
							.addComponent(lblEscolhaUmaAgncia)
							.addGap(4)
							.addComponent(scroll_agencias, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_novo)
								.addComponent(btn_editar)))
						.addComponent(panel_info, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addComponent(lblcamposObrigatrios)
					.addGap(3)
					.addComponent(btn_pctDisponivel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		GroupLayout gl_panel_info = new GroupLayout(panel_info);
		gl_panel_info.setHorizontalGroup(
			gl_panel_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_info.createSequentialGroup()
					.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_info.createSequentialGroup()
									.addGap(1)
									.addComponent(lblInformacoes))
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_nome, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(69)
							.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_site, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEndereco)
								.addGroup(gl_panel_info.createSequentialGroup()
									.addGap(1)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(81)
							.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_bairro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(77)
							.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_cidade, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(77)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_estado, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(9)
							.addComponent(btn_salvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		gl_panel_info.setVerticalGroup(
			gl_panel_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_info.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInformacoes)
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(17)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_nome, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txt_site, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEndereco)
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(18)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txt_bairro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(8)
					.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txt_cidade, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(6)
					.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txt_estado, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(6)
					.addComponent(btn_salvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		panel_info.setLayout(gl_panel_info);
		panel_agencias.setLayout(gl_panel_agencias);
		setLocationRelativeTo(null);
	}

	private void ClearTextFields() {
		txt_nome.setText(null);
		txt_site.setText(null);
		txt_bairro.setText(null);
		txt_cidade.setText(null);
		txt_estado.setText(null);
		
	}
	private void EditableTextFields(boolean state) {
		txt_nome.setEditable(state);
		txt_site.setEditable(state);
		txt_bairro.setEditable(state);
		txt_cidade.setEditable(state);
		txt_estado.setEditable(state);
		
		txt_nome.setBorder(new LineBorder(Color.GRAY));
		txt_site.setBorder(new LineBorder(Color.GRAY));
		txt_bairro.setBorder(new LineBorder(Color.GRAY));
		txt_cidade.setBorder(new LineBorder(Color.GRAY));
		txt_estado.setBorder(new LineBorder(Color.GRAY));
		
	}
}
