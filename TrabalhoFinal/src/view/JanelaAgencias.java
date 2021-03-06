package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControleAgencia;
import controller.TMAgencias;

/**
 * The Class JanelaAgencias.
 *
 * @author Kesley Nascimento
 * @version 18.12.03.1728
 * @since 18.11.23.2059
 */
public class JanelaAgencias extends JFrame {
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The index. */
	private static int INDEX;
	
	/** The txt nome. */
	private JTextField txt_nome;

	/** The txt site. */
	private JTextField txt_site;

	/** The txt bairro. */
	private JTextField txt_bairro;

	/** The txt cidade. */
	private JTextField txt_cidade;

	/** The txt uf. */
	private JTextField txt_uf;

	/** The btn editar. */
	private JButton btn_editar;

	/** The btn excluir. */
	private JButton btn_excluir;

	/** The btn novo. */
	private JButton btn_novo;

	/** The btn salvar. */
	private JButton btn_salvar;

	/** The btn cancelar. */
	private JButton btn_cancelar;

	/** The btn pct disponivel. */
	private JButton btn_pctDisponivel;

	/** The tbl agencias. */
	private JTable tbl_agencias;

	/** The action novo. */
	private ActionListener actionNovo;

	/** The action edita. */
	private ActionListener actionEdita;

	/** The scroll agencias. */
	private JScrollPane scroll_agencias;

	/** The panel agencias. */
	private JPanel panel_agencias;

	/** The Modelo. */
	private TMAgencias Modelo;

	/**
	 * Create the frame.
	 */
	public JanelaAgencias() {
		initComponents();
		ButtonState(false, true, false, false, false, false);
		LoadTable();
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
		Modelo = new TMAgencias(ControleAgencia.getDados());
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
	 * @param x the x
	 */
	private void ButtonState(boolean e, boolean n, boolean s, boolean c, boolean p, boolean x) {
		btn_editar.setEnabled(e);
		btn_novo.setEnabled(n);
		btn_salvar.setEnabled(s);
		btn_cancelar.setEnabled(c);
		btn_pctDisponivel.setEnabled(p);
		btn_excluir.setEnabled(x);
	}

	/**
	 * Gets the index.
	 *
	 * @return the iNDEX
	 */
	public static int getINDEX() {
		return INDEX;
	}

	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public static void setINDEX(int index) {
		INDEX = index;
	}

	/**
	 * Inits the components.
	 */
	public void initComponents() {
		setResizable(false);
		panel_agencias = new JPanel();
		setTitle("SAV - Inicio");
		setBounds(100, 100, 545, 380);
		panel_agencias.setBackground(new Color(248, 248, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel_agencias);

		JLabel lblSA = new JLabel("Sistema de Agências de Viagens");
		lblSA.setBorder(new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
		lblSA.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSA.setForeground(Color.BLACK);
		lblSA.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		scroll_agencias = new JScrollPane();
		scroll_agencias.setBorder(new MatteBorder(0, 2, 0, 0, new Color(160, 160, 160)));

		JPanel panel_info = new JPanel();
		panel_info.setBackground(SystemColor.control);
		panel_info.setBorder(new LineBorder(SystemColor.controlShadow));

		txt_nome = new JTextField();
		txt_nome.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		txt_nome.setEditable(false);
		txt_nome.setBorder(new MatteBorder(0, 0, 1, 1, SystemColor.controlHighlight));
		txt_nome.setColumns(10);

		JLabel lblInformacoes = new JLabel("Informações");
		lblInformacoes.setBorder(new MatteBorder(0, 0, 2, 0, SystemColor.activeCaptionBorder));
		lblInformacoes.setForeground(Color.DARK_GRAY);
		lblInformacoes.setFont(new Font("Dialog", Font.PLAIN, 14));

		JLabel lblNome = new JLabel("Agencia:");
		lblNome.setForeground(SystemColor.textInactiveText);
		lblNome.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setForeground(SystemColor.textInactiveText);
		lblWebsite.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblWebsite.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_site = new JTextField();
		txt_site.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		txt_site.setBorder(new MatteBorder(0, 0, 1, 1, SystemColor.controlHighlight));
		txt_site.setEditable(false);
		txt_site.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(SystemColor.textInactiveText);
		lblBairro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_bairro = new JTextField();
		txt_bairro.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		txt_bairro.setEditable(false);
		txt_bairro.setColumns(10);
		txt_bairro.setBorder(new MatteBorder(0, 0, 1, 1, SystemColor.controlHighlight));

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(SystemColor.textInactiveText);
		lblCidade.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_cidade = new JTextField();
		txt_cidade.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		txt_cidade.setEditable(false);
		txt_cidade.setColumns(10);
		txt_cidade.setBorder(new MatteBorder(0, 0, 1, 1, SystemColor.controlHighlight));

		JLabel lblUf = new JLabel("UF:");
		lblUf.setForeground(SystemColor.textInactiveText);
		lblUf.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);

		txt_uf = new JTextField();
		txt_uf.setHorizontalAlignment(SwingConstants.CENTER);
		txt_uf.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		txt_uf.setEditable(false);
		txt_uf.setColumns(2);
		txt_uf.setBorder(new MatteBorder(0, 0, 1, 1, SystemColor.controlHighlight));

		btn_salvar = new JButton("Salvar");
		btn_salvar.setAlignmentX(Component.CENTER_ALIGNMENT);

		actionEdita = new ActionListener() { // Action do botao Salvar
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("index " + INDEX);

					if (ControleAgencia.EditarObjeto(txt_nome.getText(), txt_site.getText(), txt_bairro.getText(),
							txt_cidade.getText(), txt_uf.getText(), INDEX)) {
						EditableTextFields(false);
						ButtonState(false, true, false, false, false, false);
						ClearTextFields();
						LoadTable();
						tbl_agencias.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Edição completa!");
					} else
						JOptionPane.showMessageDialog(null, "Erro ao salvar");

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, nfe);
				} catch (HeadlessException he) {
					JOptionPane.showMessageDialog(null, he);
				}
				btn_salvar.removeActionListener(this);
			}
		};

		actionNovo = new ActionListener() { // Action do botao Salvar
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (ControleAgencia.SalvaObjeto(txt_nome.getText(), txt_site.getText(), txt_bairro.getText(),
							txt_cidade.getText(), txt_uf.getText())) {
						EditableTextFields(false);
						ButtonState(false, true, false, false, false, false);
						ClearTextFields();
						LoadTable();
						tbl_agencias.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Nova Agência cadastrada");
					} else
						JOptionPane.showMessageDialog(null, "Erro ao salvar");
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "NumberFormatException: " + nfe);
				} catch (HeadlessException he) {
					JOptionPane.showMessageDialog(null, he);
				}
				btn_salvar.removeActionListener(this);
			}
		};

		btn_pctDisponivel = new JButton("Pacotes disponíveis");
		btn_pctDisponivel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable t) {
					t.printStackTrace();
				}
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						try {
							setINDEX(tbl_agencias.getSelectedRow());
							ButtonState(false, true, false, false, false, false);
							JanelaPacotes framepct = new JanelaPacotes(txt_nome.getText(), INDEX);
							framepct.setVisible(true);
							tbl_agencias.clearSelection();
							ClearTextFields();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tbl_agencias.getSelectionModel().clearSelection();
				EditableTextFields(true);
				ButtonState(false, false, true, true, false, false);
				ClearTextFields();
				btn_salvar.addActionListener(actionNovo);
			}
		});

		btn_editar = new JButton("Editar");
		btn_editar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditableTextFields(true);
				ButtonState(false, false, true, true, false, false);
				setINDEX(tbl_agencias.getSelectedRow());
				scroll_agencias.setEnabled(false);
				btn_salvar.addActionListener(actionEdita);
				tbl_agencias.getSelectionModel().clearSelection();
			}
		});

		JLabel lblEscolhaUmaAgncia = new JLabel("Escolha uma agência...");
		lblEscolhaUmaAgncia.setAlignmentY(Component.TOP_ALIGNMENT);
		lblEscolhaUmaAgncia.setForeground(SystemColor.textInactiveText);
		lblEscolhaUmaAgncia.setFont(new Font("Tahoma", Font.ITALIC, 11));

		btn_excluir = new JButton("Excluir");
		btn_excluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = tbl_agencias.getSelectedRow();
				if (id >= 0 && id < Modelo.getRowCount())
					ControleAgencia.ExcluirObjeto(id);
				ClearTextFields();
				LoadTable();
				ButtonState(false, true, false, false, false, false);
			}
		});
		btn_excluir.setEnabled(false);
		GroupLayout gl_panel_agencias = new GroupLayout(panel_agencias);
		gl_panel_agencias.setHorizontalGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_agencias.createSequentialGroup().addContainerGap().addGroup(gl_panel_agencias
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSA, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
						.addGroup(gl_panel_agencias.createSequentialGroup()
								.addGroup(gl_panel_agencias.createParallelGroup(Alignment.LEADING)
										.addComponent(scroll_agencias, 0, 0, Short.MAX_VALUE)
										.addGroup(gl_panel_agencias.createSequentialGroup().addComponent(btn_novo)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btn_editar)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btn_excluir))
										.addComponent(lblEscolhaUmaAgncia, GroupLayout.PREFERRED_SIZE, 160,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_info, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
						.addComponent(btn_pctDisponivel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panel_agencias.setVerticalGroup(gl_panel_agencias.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_agencias.createSequentialGroup()
						.addComponent(lblSA, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_agencias.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_agencias
								.createSequentialGroup().addComponent(lblEscolhaUmaAgncia).addGap(4)
								.addComponent(scroll_agencias, GroupLayout.PREFERRED_SIZE, 194,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
								.addGroup(gl_panel_agencias.createParallelGroup(Alignment.BASELINE)
										.addComponent(btn_novo).addComponent(btn_editar).addComponent(btn_excluir)))
								.addComponent(panel_info, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btn_pctDisponivel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(25)));

		tbl_agencias = new JTable();
		tbl_agencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_agencias.setGridColor(SystemColor.control);
		tbl_agencias.setBorder(new MatteBorder(1, 1, 1, 2, new Color(227, 227, 227)));
		tbl_agencias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scroll_agencias.setEnabled(true);
				ButtonState(true, true, false, false, true, true);
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

			@Override
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbl_agencias.getColumnModel().getColumn(0).setPreferredWidth(154);
		scroll_agencias.setViewportView(tbl_agencias);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setMargin(new Insets(2, 10, 2, 10));
		btn_cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonState(false, true, false, false, false, false);
				ClearTextFields();
				EditableTextFields(false);
			}
		});
		btn_cancelar.setAlignmentX(0.5f);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBorder(new MatteBorder(0, 0, 2, 0, SystemColor.activeCaptionBorder));
		lblEndereco.setForeground(Color.DARK_GRAY);
		lblEndereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		GroupLayout gl_panel_info = new GroupLayout(panel_info);
		gl_panel_info.setHorizontalGroup(gl_panel_info.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_info
				.createSequentialGroup()
				.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_info.createSequentialGroup().addGap(11).addComponent(lblInformacoes,
								GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
						.addGroup(gl_panel_info.createSequentialGroup().addContainerGap().addGroup(gl_panel_info
								.createParallelGroup(Alignment.LEADING)
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
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblUf).addGap(18).addComponent(txt_uf,
																GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(txt_bairro, 205, 205, 205)))
								.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_info.createSequentialGroup().addGap(1)
												.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 49,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(txt_nome))
										.addGroup(gl_panel_info.createSequentialGroup()
												.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(txt_site, 205, 205, 205)))
								.addGroup(gl_panel_info.createSequentialGroup().addGap(156).addComponent(btn_salvar)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btn_cancelar,
												GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel_info.createSequentialGroup().addContainerGap()
						.addComponent(lblEndereco, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE).addGap(9)));
		gl_panel_info.setVerticalGroup(gl_panel_info.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_info
				.createSequentialGroup()
				.addGroup(gl_panel_info.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_info
						.createSequentialGroup().addGap(36)
						.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_nome, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWebsite, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_site))
						.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel_info.createSequentialGroup().addContainerGap().addComponent(lblInformacoes)
								.addGap(53)))
				.addGap(10).addComponent(lblEndereco).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_bairro, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_cidade, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(txt_uf, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE).addComponent(lblUf))
				.addGap(40).addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE).addComponent(btn_salvar)
						.addComponent(btn_cancelar))
				.addContainerGap()));
		panel_info.setLayout(gl_panel_info);
		panel_agencias.setLayout(gl_panel_agencias);
		setLocationRelativeTo(null);
	}
}
