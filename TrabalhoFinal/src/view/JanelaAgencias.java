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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jag_panel_agencias;
	private JTextField jagi_txtfield_nome;
	private JTextField jagi_txtfield_site;
	private JTextField jagi_txtfield_bairro;
	private JTextField jagi_txtfield_cidade;
	private JTextField jagi_txtfield_estado;
	
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
		jag_panel_agencias = new JPanel();
		setTitle("SAV - Inicio");
		setBounds(100, 100, 535, 390);
		jag_panel_agencias.setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(jag_panel_agencias);
		
		JLabel lblSistemaDeAgencias = new JLabel("Sistema de Agências de Viagens");
		lblSistemaDeAgencias.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		lblSistemaDeAgencias.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSistemaDeAgencias.setForeground(Color.BLACK);
		lblSistemaDeAgencias.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JSeparator separator01 = new JSeparator();
		separator01.setForeground(Color.GRAY);
		
		JScrollPane jag_scroll_agencias = new JScrollPane();
		
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
		jag_scroll_agencias.setViewportView(list);
		
		JPanel jag_panel_info = new JPanel();
		jag_panel_info.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		jagi_txtfield_nome = new JTextField();
		jagi_txtfield_nome.setFont(new Font("SansSerif", Font.BOLD, 12));
		jagi_txtfield_nome.setEditable(false);
		jagi_txtfield_nome.setBorder(null);
		jagi_txtfield_nome.setText("Flytour Viagens");
		jagi_txtfield_nome.setColumns(10);
		
		JLabel lblInformacoes = new JLabel("Informa\u00E7\u00F5es");
		lblInformacoes.setForeground(Color.DARK_GRAY);
		lblInformacoes.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		
		JLabel lblNome = new JLabel("Agencia:");
		
		JLabel lblWebsite = new JLabel("Website:");
		
		jagi_txtfield_site = new JTextField();
		jagi_txtfield_site.setFont(new Font("SansSerif", Font.BOLD, 12));
		jagi_txtfield_site.setBorder(null);
		jagi_txtfield_site.setEditable(false);
		jagi_txtfield_site.setText("www.flytour.com.br");
		jagi_txtfield_site.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setForeground(Color.DARK_GRAY);
		lblEndereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		jagi_txtfield_bairro = new JTextField();
		jagi_txtfield_bairro.setFont(new Font("SansSerif", Font.BOLD, 12));
		jagi_txtfield_bairro.setText("Alphaville");
		jagi_txtfield_bairro.setEditable(false);
		jagi_txtfield_bairro.setColumns(10);
		jagi_txtfield_bairro.setBorder(null);
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		jagi_txtfield_cidade = new JTextField();
		jagi_txtfield_cidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		jagi_txtfield_cidade.setText("Santo Andre");
		jagi_txtfield_cidade.setEditable(false);
		jagi_txtfield_cidade.setColumns(10);
		jagi_txtfield_cidade.setBorder(null);
		
		JLabel lblEstado = new JLabel("Estado:");
		
		jagi_txtfield_estado = new JTextField();
		jagi_txtfield_estado.setFont(new Font("SansSerif", Font.BOLD, 12));
		jagi_txtfield_estado.setText("SP");
		jagi_txtfield_estado.setEditable(false);
		jagi_txtfield_estado.setColumns(10);
		jagi_txtfield_estado.setBorder(null);
		
// Action do botao SALVAR-------------------------------------------------------------------------------------------------------------
		JButton jagi_btn_salvar = new JButton("");
		jagi_btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditableTextFields(false);
				jagi_btn_salvar.setEnabled(false);
			}
		});
		jagi_btn_salvar.setEnabled(false);
		jagi_btn_salvar.setContentAreaFilled(false);
		jagi_btn_salvar.setAlignmentX(Component.CENTER_ALIGNMENT);
		jagi_btn_salvar.setBorder(null);
		jagi_btn_salvar.setIcon(new ImageIcon(JanelaAgencias.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));

// Botao para abrir a janela contendo os Pacotes Disponiveis relacionado a Agencia escolhida-------------------------------------------------------------------------------------------------------------
		JButton jag_btnPacotesDisponiveis = new JButton("Pacotes disponiveis");
		jag_btnPacotesDisponiveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPacotes.main(null);
			}
		});
		
		JLabel lblcamposObrigatrios = new JLabel("Todos campos s\u00E3o obrigat\u00F3rios");
		lblcamposObrigatrios.setVisible(false);
		lblcamposObrigatrios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblcamposObrigatrios.setForeground(new Color(139, 0, 0));
		lblcamposObrigatrios.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton jag_button_novo = new JButton("Novo");
		jag_button_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditableTextFields(true);
				ClearTextFields();
				jagi_btn_salvar.setEnabled(true);
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditableTextFields(true);		
				jagi_btn_salvar.setEnabled(true);
			}
		});
		
		JLabel lblEscolhaUmaAgncia = new JLabel("Escolha uma ag\u00EAncia...");
		lblEscolhaUmaAgncia.setAlignmentY(Component.TOP_ALIGNMENT);
		lblEscolhaUmaAgncia.setForeground(SystemColor.textInactiveText);
		lblEscolhaUmaAgncia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		GroupLayout gl_jag_panel_agencias = new GroupLayout(jag_panel_agencias);
		gl_jag_panel_agencias.setHorizontalGroup(
			gl_jag_panel_agencias.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jag_panel_agencias.createSequentialGroup()
					.addGroup(gl_jag_panel_agencias.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jag_panel_agencias.createSequentialGroup()
							.addGap(12)
							.addComponent(separator01, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_agencias.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_jag_panel_agencias.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jag_panel_agencias.createSequentialGroup()
									.addGap(2)
									.addComponent(lblEscolhaUmaAgncia, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addComponent(jag_scroll_agencias, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_jag_panel_agencias.createSequentialGroup()
									.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(jag_button_novo)))
							.addGap(10)
							.addComponent(jag_panel_info, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_agencias.createSequentialGroup()
							.addGap(377)
							.addComponent(lblcamposObrigatrios))
						.addGroup(gl_jag_panel_agencias.createSequentialGroup()
							.addGap(369)
							.addComponent(jag_btnPacotesDisponiveis, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_agencias.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSistemaDeAgencias, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_jag_panel_agencias.setVerticalGroup(
			gl_jag_panel_agencias.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jag_panel_agencias.createSequentialGroup()
					.addComponent(lblSistemaDeAgencias, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(separator01, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_jag_panel_agencias.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jag_panel_agencias.createSequentialGroup()
							.addComponent(lblEscolhaUmaAgncia)
							.addGap(4)
							.addComponent(jag_scroll_agencias, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_jag_panel_agencias.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEditar)
								.addComponent(jag_button_novo)))
						.addComponent(jag_panel_info, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addComponent(lblcamposObrigatrios)
					.addGap(3)
					.addComponent(jag_btnPacotesDisponiveis, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		GroupLayout gl_jag_panel_info = new GroupLayout(jag_panel_info);
		gl_jag_panel_info.setHorizontalGroup(
			gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jag_panel_info.createSequentialGroup()
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jag_panel_info.createSequentialGroup()
									.addGap(1)
									.addComponent(lblInformacoes))
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jagi_txtfield_nome, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(69)
							.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jagi_txtfield_site, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEndereco)
								.addGroup(gl_jag_panel_info.createSequentialGroup()
									.addGap(1)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(81)
							.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jagi_txtfield_bairro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(77)
							.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jagi_txtfield_cidade, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(77)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jagi_txtfield_estado, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(9)
							.addComponent(jagi_btn_salvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		gl_jag_panel_info.setVerticalGroup(
			gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jag_panel_info.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInformacoes)
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(17)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(jagi_txtfield_nome, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(jagi_txtfield_site, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEndereco)
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(18)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(jagi_txtfield_bairro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(8)
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(jagi_txtfield_cidade, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(6)
					.addGroup(gl_jag_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jag_panel_info.createSequentialGroup()
							.addGap(2)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(jagi_txtfield_estado, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(6)
					.addComponent(jagi_btn_salvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		jag_panel_info.setLayout(gl_jag_panel_info);
		jag_panel_agencias.setLayout(gl_jag_panel_agencias);
		setLocationRelativeTo(null);
	}

	private void ClearTextFields() {
		jagi_txtfield_nome.setText(null);
		jagi_txtfield_site.setText(null);
		jagi_txtfield_bairro.setText(null);
		jagi_txtfield_cidade.setText(null);
		jagi_txtfield_estado.setText(null);
		
	}
	private void EditableTextFields(boolean state) {
		jagi_txtfield_nome.setEditable(state);
		jagi_txtfield_site.setEditable(state);
		jagi_txtfield_bairro.setEditable(state);
		jagi_txtfield_cidade.setEditable(state);
		jagi_txtfield_estado.setEditable(state);
		
		jagi_txtfield_nome.setBorder(new LineBorder(Color.GRAY));
		jagi_txtfield_site.setBorder(new LineBorder(Color.GRAY));
		jagi_txtfield_bairro.setBorder(new LineBorder(Color.GRAY));
		jagi_txtfield_cidade.setBorder(new LineBorder(Color.GRAY));
		jagi_txtfield_estado.setBorder(new LineBorder(Color.GRAY));
		
	}
}
