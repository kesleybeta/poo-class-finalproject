package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControleAgencia;
import controller.ControlePacotes;
import model.TMAgencias;

public class JanelaAgencias extends JFrame {

	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Kesley Nascimento
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel_agencias;
	private TMAgencias Modelo;

	/** Declaração das variaveis das caixas de texto. */
	private JTextField txt_nome;
	private JTextField txt_site;
	private JTextField txt_bairro;
	private JTextField txt_cidade;
	private JTextField txt_uf;

	/** Declaração das variaveis dos botões. */
	private JButton btn_editar;
	private JButton btn_novo;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JButton btn_pctDisponivel;

	/** The tbl agencias. */
	private JTable tbl_agencias;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	/*
	 * public static void main(String[] args) { try {
	 * UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
	 * ); } catch (Throwable e) { e.printStackTrace(); } EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { JanelaAgencias frame = new
	 * JanelaAgencias(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public JanelaAgencias() {
		initComponents();
		ButtonState(false, true, false, false, false);
		LoadTable();
	}

	/**
	 * Inits the components.
	 */
	public void initComponents() {
		setResizable(false);
		panel_agencias = new JPanel();
		setTitle("SAV - Inicio");
		setBounds(100, 100, 520, 390);
		panel_agencias.setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel_agencias);

		JLabel lblSA = new JLabel("Sistema de Agências de Viagens");
		lblSA.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		lblSA.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSA.setForeground(Color.BLACK);
		lblSA.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JScrollPane scroll_agencias = new JScrollPane();
		scroll_agencias.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(160, 160, 160)));

		JPanel panel_info = new JPanel();
		panel_info.setBorder(new LineBorder(SystemColor.controlShadow));

		txt_nome = new JTextField();
		txt_nome.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_nome.setEditable(false);
		txt_nome.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(227, 227, 227)));
		txt_nome.setColumns(10);

		JLabel lblInformacoes = new JLabel("Informa\u00E7\u00F5es");
		lblInformacoes.setForeground(Color.DARK_GRAY);
		lblInformacoes.setFont(new Font("Dialog", Font.PLAIN, 14));

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);

		JLabel lblNome = new JLabel("Agencia:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_site = new JTextField();
		txt_site.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_site.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));
		txt_site.setEditable(false);
		txt_site.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_bairro = new JTextField();
		txt_bairro.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_bairro.setEditable(false);
		txt_bairro.setColumns(10);
		txt_bairro.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_cidade = new JTextField();
		txt_cidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_cidade.setEditable(false);
		txt_cidade.setColumns(10);
		txt_cidade.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));

		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_uf = new JTextField();
		txt_uf.setHorizontalAlignment(SwingConstants.CENTER);
		txt_uf.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_uf.setEditable(false);
		txt_uf.setColumns(10);
		txt_uf.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));

		btn_salvar = new JButton("Salvar");
		btn_salvar.addActionListener(new ActionListener() { // Action do botao Salvar
			public void actionPerformed(ActionEvent e) {
				try {
					if (ControleAgencia.SalvaObjeto(txt_nome.getText(), txt_site.getText(), txt_bairro.getText(),
							txt_cidade.getText(), txt_uf.getText())) {
						EditableTextFields(false);
						ButtonState(false, true, false, false, false);
						ClearTextFields();
						LoadTable();
						tbl_agencias.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Nova agência cadastrada");
					} else
						JOptionPane.showMessageDialog(null, "Erro ao salvar");
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, nfe);
				} catch (HeadlessException he) {
					JOptionPane.showMessageDialog(null, he);
				}
			}
		});
		btn_salvar.setAlignmentX(Component.CENTER_ALIGNMENT);

		btn_pctDisponivel = new JButton("Pacotes disponíveis");
		btn_pctDisponivel.addActionListener(new ActionListener() {
			// Action do Botao Abrir Pacotes
			// Abre a janela contendo os Pacotes Disponiveis relacionado a Agencia
			// escolhida.

			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable t) {
					t.printStackTrace();
				}
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							int index = tbl_agencias.getSelectedRow();
							// ControlePacotes.setIndex(index);
							ButtonState(false, true, false, false, false);
							JanelaPacotes framepct = new JanelaPacotes(txt_nome.getText(), index);
							framepct.setVisible(true);
							tbl_agencias.clearSelection();
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		JLabel lblcamposObrigatrios = new JLabel("Todos campos são obrigatórios");
		lblcamposObrigatrios.setVisible(false);
		lblcamposObrigatrios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblcamposObrigatrios.setForeground(new Color(139, 0, 0));
		lblcamposObrigatrios.setHorizontalAlignment(SwingConstants.RIGHT);

		btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbl_agencias.getSelectionModel().clearSelection();
				EditableTextFields(true);
				ButtonState(false, false, true, true, false);
				ClearTextFields();

			}
		});

		btn_editar = new JButton("Editar");
		btn_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbl_agencias.getSelectionModel().clearSelection();
				EditableTextFields(true);
				ButtonState(false, false, true, true, false);
			}
		});

		JLabel lblEscolhaUmaAgncia = new JLabel("Escolha uma agência...");
		lblEscolhaUmaAgncia.setAlignmentY(Component.TOP_ALIGNMENT);
		lblEscolhaUmaAgncia.setForeground(SystemColor.textInactiveText);
		lblEscolhaUmaAgncia.setFont(new Font("Tahoma", Font.ITALIC, 11));
		GroupLayout gl_panel_agencias = new GroupLayout(panel_agencias);
		gl_panel_agencias.setHorizontalGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_agencias.createSequentialGroup().addGroup(gl_panel_agencias
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_agencias.createSequentialGroup().addGap(10).addGroup(gl_panel_agencias
								.createParallelGroup(Alignment.TRAILING).addComponent(lblcamposObrigatrios)
								.addGroup(gl_panel_agencias.createSequentialGroup().addGroup(gl_panel_agencias
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_agencias.createSequentialGroup().addGap(2).addComponent(
												lblEscolhaUmaAgncia, GroupLayout.PREFERRED_SIZE, 160,
												GroupLayout.PREFERRED_SIZE))
										.addComponent(scroll_agencias, GroupLayout.PREFERRED_SIZE, 162,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_agencias.createSequentialGroup()
												.addComponent(btn_editar, GroupLayout.PREFERRED_SIZE, 77,
														GroupLayout.PREFERRED_SIZE)
												.addGap(8).addComponent(btn_novo, GroupLayout.PREFERRED_SIZE, 77,
														GroupLayout.PREFERRED_SIZE)))
										.addGap(10)
										.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
												.addComponent(btn_pctDisponivel, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
												.addComponent(panel_info, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_agencias.createSequentialGroup().addContainerGap().addComponent(lblSA,
								GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel_agencias.setVerticalGroup(gl_panel_agencias.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_agencias.createSequentialGroup()
						.addComponent(lblSA, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_agencias
								.createSequentialGroup().addComponent(lblEscolhaUmaAgncia).addGap(4)
								.addComponent(
										scroll_agencias, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
										.addComponent(btn_novo).addComponent(btn_editar)))
								.addComponent(panel_info, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblcamposObrigatrios)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btn_pctDisponivel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(5)));

		tbl_agencias = new JTable();
		tbl_agencias.setGridColor(SystemColor.control);
		tbl_agencias.setBorder(new MatteBorder(1, 2, 1, 1, (Color) SystemColor.controlHighlight));
		tbl_agencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ButtonState(true, true, false, false, true);
				int index = tbl_agencias.getSelectedRow();

				if (index >= 0 && index < Modelo.getRowCount()) {
					String temp[] = Modelo.getRegistro(index);
					txt_nome.setText(temp[0]);
					txt_site.setText(temp[1]);
					txt_bairro.setText(temp[2]);
					txt_cidade.setText(temp[3]);
					txt_uf.setText(temp[4]);
				}
			}
		});
		tbl_agencias.setRowHeight(24);
		tbl_agencias.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbl_agencias.setFillsViewportHeight(true);
		tbl_agencias.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "Agências" }) {

			private static final long serialVersionUID = -3591241270780965102L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbl_agencias.getColumnModel().getColumn(0).setPreferredWidth(154);
		scroll_agencias.setViewportView(tbl_agencias);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonState(false, true, false, false, false);
				ClearTextFields();
				EditableTextFields(false);
			}
		});
		btn_cancelar.setAlignmentX(0.5f);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setForeground(Color.DARK_GRAY);
		lblEndereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		GroupLayout gl_panel_info = new GroupLayout(panel_info);
		gl_panel_info.setHorizontalGroup(gl_panel_info.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_info
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_info.createSequentialGroup().addGap(1).addComponent(lblInformacoes))
						.addGroup(gl_panel_info.createSequentialGroup().addGap(8)
								.addGroup(gl_panel_info.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_info.createSequentialGroup()
												.addComponent(txt_cidade, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(lblUf).addGap(18).addComponent(txt_uf,
														GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
										.addComponent(txt_bairro, 205, 205, 205)))
						.addGroup(gl_panel_info.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_info.createSequentialGroup().addGap(1)
										.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(txt_nome))
								.addGroup(Alignment.LEADING,
										gl_panel_info.createSequentialGroup()
												.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(txt_site, 205, 205, 205)))
						.addGroup(gl_panel_info.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_info.createSequentialGroup().addComponent(btn_salvar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btn_cancelar))
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEndereco))
				.addContainerGap(915, Short.MAX_VALUE)));
		gl_panel_info.setVerticalGroup(gl_panel_info.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_info
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING).addComponent(lblInformacoes)
						.addGroup(gl_panel_info.createSequentialGroup().addGap(17).addComponent(separator,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_nome, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_site, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblEndereco).addGap(1)
				.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_bairro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_cidade, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(txt_uf, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE).addComponent(lblUf))
				.addGap(40).addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE).addComponent(btn_cancelar)
						.addComponent(btn_salvar))
				.addContainerGap()));
		panel_info.setLayout(gl_panel_info);
		panel_agencias.setLayout(gl_panel_agencias);
		setLocationRelativeTo(null);
	}

	/**
	 * Clear text fields.
	 */
	private void ClearTextFields() {
		txt_nome.setText(null);
		txt_site.setText(null);
		txt_bairro.setText(null);
		txt_cidade.setText(null);
		txt_uf.setText(null);
	}

	/**
	 * Load table.
	 */
	private void LoadTable() {
		Modelo = new TMAgencias(ControleAgencia.getAgencias());
		tbl_agencias.setModel(Modelo);
	}

	/**
	 * Editable text fields.
	 *
	 * @param state the state
	 */
	private void EditableTextFields(boolean state) {
		txt_nome.setEditable(state);
		txt_site.setEditable(state);
		txt_bairro.setEditable(state);
		txt_cidade.setEditable(state);
		txt_uf.setEditable(state);
	}

	/**
	 * Button state.
	 *
	 * @param e the e
	 * @param n the n
	 * @param s the s
	 * @param c the c
	 * @param p the p
	 */
	private void ButtonState(boolean e, boolean n, boolean s, boolean c, boolean p) {
		btn_editar.setEnabled(e);
		btn_novo.setEnabled(n);
		btn_salvar.setEnabled(s);
		btn_cancelar.setEnabled(c);
		btn_pctDisponivel.setEnabled(p);
	}
}
