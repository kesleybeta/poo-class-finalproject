package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControlePacotes;
import controller.TMPacotes;

/**
 * The Class JanelaPacotes.
 *
 * @author Kesley Nascimento
 */
public class JanelaPacotes extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	private static int INDEXA, INDEXP;

	private JPanel panel_pacotes;

	private JTable tbl_pacotes;
	private JTextField txt_pais;
	private JTextField txt_destino;
	private JTextField txt_hotel;
	private JTextField txt_estadia;
	private JTextField txt_preco;

	private TMPacotes Modelo;

	private JButton btn_novo;
	private JButton btn_editar;
	private JButton btn_excluir;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JButton btn_guia;

	private JLabel labelAgenciaSelecionada;

	private ActionListener actionNovo;
	private ActionListener actionEdita;
	private JLabel lblporPessoa;

	/**
	 * Metodo para popular a tabela.
	 */
	public void LoadTable() {
		try {
			Modelo = new TMPacotes(ControlePacotes.getDados());
			tbl_pacotes.setModel(Modelo);
			tbl_pacotes.getColumnModel().getColumn(0).setPreferredWidth(60);
			tbl_pacotes.getColumnModel().getColumn(1).setPreferredWidth(60);
			tbl_pacotes.getColumnModel().getColumn(2).setPreferredWidth(175);
		} catch (Exception e) {
			System.out.println("LoadTable(): " + e);
		}
	}

	/**
	 * Button state.
	 *
	 * @param n the n
	 * @param e the e
	 * @param x the x
	 * @param s the s
	 * @param c the c
	 * @param g the g
	 */
	public void ButtonState(boolean n, boolean e, boolean x, boolean s, boolean c, boolean g) {
		btn_novo.setEnabled(n);
		btn_editar.setEnabled(e);
		btn_excluir.setEnabled(x);
		btn_salvar.setEnabled(s);
		btn_cancelar.setEnabled(c);
		btn_guia.setEnabled(g);
	}

	/**
	 * Estado dos text fields.
	 *
	 * @param logico the logico
	 */
	public void EditableTextFields(boolean logico) {
		txt_pais.setEnabled(logico);
		txt_destino.setEnabled(logico);
		txt_hotel.setEnabled(logico);
		txt_estadia.setEnabled(logico);
		txt_preco.setEnabled(logico);
		lblporPessoa.setVisible(!logico);
	}

	/**
	 * Limpa txts.
	 */
	public void ClearTextFields() {
		txt_pais.setText(null);
		txt_destino.setText(null);
		txt_hotel.setText(null);
		txt_estadia.setText(null);
		txt_preco.setText(null);
		lblporPessoa.setVisible(false);
	}

	public JanelaPacotes() {
		setAlwaysOnTop(true);
		initComponents();
		setLocationRelativeTo(null);
		Modelo = new TMPacotes();
		ButtonState(true, false, false, false, false, false);
		ClearTextFields();
		EditableTextFields(false);
		labelAgenciaSelecionada.setText("Nenhuma agência selecionada");
	}

	public JanelaPacotes(String agencia, int index) {
		ControlePacotes.setINDEX(index);
		setINDEXA(index);
		initComponents();
		setLocationRelativeTo(null);
		LoadTable();
		ButtonState(true, false, false, false, false, false);
		ClearTextFields();
		EditableTextFields(false);
		lblporPessoa.setVisible(false);
		labelAgenciaSelecionada.setText(agencia);
	}

	/**
	 * Cria o frame.
	 */
	public void initComponents() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("SAV - Pacotes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 466);
		panel_pacotes = new JPanel();
		setContentPane(panel_pacotes);

		JScrollPane scroll_pacotes = new JScrollPane();

		tbl_pacotes = new JTable();
		tbl_pacotes.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tbl_pacotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_pacotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ButtonState(true, true, true, false, false, true);
				lblporPessoa.setVisible(true);
				int index = tbl_pacotes.getSelectedRow();
				if (index >= 0 && index < Modelo.getRowCount()) {
					String temp[] = Modelo.getRegistro(index);
					txt_pais.setText(temp[0]);
					txt_destino.setText(temp[1]);
					txt_hotel.setText(temp[2]);
					txt_estadia.setText(temp[3]+" noites");
					double preco = Double.parseDouble(temp[4].replace(",", "."));
					txt_preco.setText("R$ " + preco);
				}
			}
		});
		tbl_pacotes.setGridColor(new Color(192, 192, 192));
		tbl_pacotes.setRowHeight(24);
		tbl_pacotes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tbl_pacotes.setFillsViewportHeight(true);

		tbl_pacotes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Pa\u00EDs", "Destino", "Hospedagem"
			}
		));
		scroll_pacotes.setViewportView(tbl_pacotes);

		btn_guia = new JButton("ATRAÇÕES");
		btn_guia.setEnabled(false);
		btn_guia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable t) {
					t.printStackTrace();
				}
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ButtonState(false, false, false, false, false, false);
							JanelaAtracoes framepct = new JanelaAtracoes(txt_destino.getText());
							framepct.setVisible(true);
							tbl_pacotes.clearSelection();
							ClearTextFields();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		labelAgenciaSelecionada = new JLabel("Pacotes oferecidos pela agência");
		labelAgenciaSelecionada.setAlignmentY(Component.TOP_ALIGNMENT);
		labelAgenciaSelecionada.setOpaque(true);
		labelAgenciaSelecionada.setHorizontalAlignment(SwingConstants.CENTER);
		labelAgenciaSelecionada.setForeground(SystemColor.textHighlight);
		labelAgenciaSelecionada.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		labelAgenciaSelecionada.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
		labelAgenciaSelecionada.setBackground(Color.WHITE);

		JPanel panel_detalhes = new JPanel();
		panel_detalhes.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_detalhes
				.setBorder(new TitledBorder(null, "Detalhes", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btn_excluir = new JButton("Excluir");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = tbl_pacotes.getSelectedRow();
				if (id >= 0 && id < Modelo.getRowCount())
					ControlePacotes.ExcluirObjeto(id);
				ClearTextFields();
				LoadTable();
				ButtonState(true, false, false, false, false, false);
			}
		});
		btn_salvar = new JButton("Salvar");
		btn_salvar.setEnabled(false);

		actionEdita = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setINDEXP(tbl_pacotes.getSelectedRow());
					if (ControlePacotes.SalvaObjeto(txt_pais.getText(), txt_destino.getText(), txt_hotel.getText(),
							txt_estadia.getText(), txt_preco.getText(), INDEXP)) {
						LoadTable();
						tbl_pacotes.clearSelection();
						ButtonState(true, false, false, false, false, false);
						ClearTextFields();
						EditableTextFields(false);
						tbl_pacotes.setEnabled(true);
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
		actionNovo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (ControlePacotes.SalvaObjeto(txt_pais.getText(), txt_destino.getText(), txt_hotel.getText(),
							txt_estadia.getText(), txt_preco.getText())) {
						LoadTable();
						ButtonState(true, false, false, false, false, false);
						ClearTextFields();
						EditableTextFields(false);
						tbl_pacotes.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Novo Pacote cadastrado");
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

		btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbl_pacotes.getSelectionModel().clearSelection();
				tbl_pacotes.setEnabled(false);
				ClearTextFields();
				EditableTextFields(true);
				ButtonState(false, false, false, true, true, false);
				btn_salvar.addActionListener(actionNovo);
			}
		});

		btn_editar = new JButton("Editar");
		btn_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonState(false, false, false, true, true, false);
				ClearTextFields();
				EditableTextFields(true);
				btn_salvar.addActionListener(actionEdita);
			}
		});

		btn_salvar.setMaximumSize(new Dimension(75, 23));
		btn_salvar.setPreferredSize(new Dimension(75, 23));

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ButtonState(true, false, false, false, false, false);
				ClearTextFields();
				EditableTextFields(false);
				tbl_pacotes.setEnabled(true);
			}
		});
		btn_cancelar.setEnabled(false);

		JSeparator separator = new JSeparator();

		GroupLayout gl_panel_pacotes = new GroupLayout(panel_pacotes);
		gl_panel_pacotes.setHorizontalGroup(
			gl_panel_pacotes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_pacotes.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_pacotes.createParallelGroup(Alignment.LEADING)
						.addComponent(scroll_pacotes, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
						.addComponent(labelAgenciaSelecionada, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_pacotes.createSequentialGroup()
							.addComponent(btn_novo, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(134)
							.addComponent(btn_excluir, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_editar, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_pacotes.createSequentialGroup()
							.addComponent(panel_detalhes, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_pacotes.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn_salvar, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(btn_cancelar, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(btn_guia, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
						.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_pacotes.setVerticalGroup(
			gl_panel_pacotes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_pacotes.createSequentialGroup()
					.addGap(6)
					.addComponent(labelAgenciaSelecionada, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scroll_pacotes, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_panel_pacotes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_editar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_novo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_excluir, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_pacotes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_pacotes.createSequentialGroup()
							.addGap(18)
							.addComponent(btn_salvar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_cancelar)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addComponent(btn_guia, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(38))
						.addGroup(gl_panel_pacotes.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_detalhes, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);

		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setForeground(SystemColor.textInactiveText);
		lblDestino.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblDestino.setBounds(36, 45, 40, 14);

		JLabel lblHospedagemInclusa = new JLabel("Hospedagem:");
		lblHospedagemInclusa.setForeground(SystemColor.textInactiveText);
		lblHospedagemInclusa.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblHospedagemInclusa.setBounds(10, 70, 66, 14);

		txt_destino = new JTextField();
		txt_destino.setMargin(new Insets(4, 2, 4, 2));
		txt_destino.setBounds(86, 42, 195, 21);
		txt_destino.setDisabledTextColor(Color.BLACK);
		txt_destino.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));
		txt_destino.setFont(new Font("SansSerif", Font.ITALIC, 12));
		txt_destino.setEnabled(false);
		txt_destino.setColumns(10);

		txt_hotel = new JTextField();
		txt_hotel.setMargin(new Insets(4, 2, 4, 2));
		txt_hotel.setBounds(86, 67, 195, 21);
		txt_hotel.setDisabledTextColor(Color.BLACK);
		txt_hotel.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));
		txt_hotel.setFont(new Font("SansSerif", Font.ITALIC, 12));
		txt_hotel.setEnabled(false);
		txt_hotel.setColumns(10);

		JLabel lblEstadia = new JLabel("Estadia:");
		lblEstadia.setForeground(SystemColor.textInactiveText);
		lblEstadia.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblEstadia.setBounds(36, 95, 39, 14);

		txt_estadia = new JTextField();
		txt_estadia.setMargin(new Insets(4, 2, 4, 2));
		txt_estadia.setBounds(85, 92, 80, 21);
		txt_estadia.setDisabledTextColor(Color.BLACK);
		txt_estadia.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));
		txt_estadia.setFont(new Font("SansSerif", Font.ITALIC, 12));
		txt_estadia.setEnabled(false);
		txt_estadia.setColumns(10);

		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setForeground(SystemColor.textInactiveText);
		lblPreco.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblPreco.setBounds(45, 120, 31, 14);

		txt_preco = new JTextField();
		txt_preco.setMargin(new Insets(4, 2, 4, 2));
		txt_preco.setBounds(86, 117, 110, 21);
		txt_preco.setDisabledTextColor(Color.BLACK);
		txt_preco.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));
		txt_preco.setFont(new Font("SansSerif", Font.ITALIC, 12));
		txt_preco.setEnabled(false);
		txt_preco.setColumns(10);
		panel_detalhes.setLayout(null);
		panel_detalhes.add(lblDestino);
		panel_detalhes.add(lblHospedagemInclusa);
		panel_detalhes.add(lblPreco);
		panel_detalhes.add(lblEstadia);
		panel_detalhes.add(txt_destino);
		panel_detalhes.add(txt_preco);
		panel_detalhes.add(txt_estadia);
		panel_detalhes.add(txt_hotel);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setForeground(SystemColor.textInactiveText);
		lblPais.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblPais.setBounds(55, 21, 21, 13);
		panel_detalhes.add(lblPais);

		txt_pais = new JTextField();
		txt_pais.setText((String) null);
		txt_pais.setMargin(new Insets(4, 2, 4, 2));
		txt_pais.setFont(new Font("SansSerif", Font.ITALIC, 12));
		txt_pais.setEnabled(false);
		txt_pais.setDisabledTextColor(Color.BLACK);
		txt_pais.setColumns(10);
		txt_pais.setBorder(new MatteBorder(0, 0, 1, 1, (Color) SystemColor.controlHighlight));
		txt_pais.setBounds(86, 17, 195, 21);
		panel_detalhes.add(txt_pais);
		
		lblporPessoa = new JLabel("(por pessoa)");
		lblporPessoa.setVisible(false);
		lblporPessoa.setForeground(Color.GRAY);
		lblporPessoa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblporPessoa.setBounds(206, 120, 57, 13);
		panel_detalhes.add(lblporPessoa);
		panel_pacotes.setLayout(gl_panel_pacotes);
	}

	/**
	 * @return the iNDEX
	 */
	public static int getINDEXA() {
		return INDEXA;
	}

	/**
	 * @param iNDEX the iNDEX to set
	 */
	public static void setINDEXA(int I) {
		INDEXA = I;
	}

	/**
	 * @return the iNDEXP
	 */
	public static int getINDEXP() {
		return INDEXP;
	}

	/**
	 * @param iNDEXP the iNDEXP to set
	 */
	public static void setINDEXP(int I) {
		INDEXP = I;
	}
}
