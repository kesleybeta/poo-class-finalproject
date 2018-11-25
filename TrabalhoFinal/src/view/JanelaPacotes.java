package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControlePacotes;
import model.TMPacotes;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

/**
 * The Class JanelaPacotes.
 *
 * @author Kesley Nascimento
 */
public class JanelaPacotes extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	/** The panel pacotes. */
	private JPanel panel_pacotes;

	/** The tbl pacotes. */
	private JTable tbl_pacotes;

	/** The txt destino. */
	private JTextField txt_destino;

	/** The txt hotel. */
	private JTextField txt_hotel;

	/** The txt estadia. */
	private JTextField txt_estadia;

	/** The txt preco. */
	private JTextField txt_preco;

	/** The Modelo. */
	private TMPacotes Modelo;

	/** The btn novo. */
	private JButton btn_novo;

	/** The btn editar. */
	private JButton btn_editar;

	/** The btn excluir. */
	private JButton btn_excluir;

	/** The btn salvar. */
	private JButton btn_salvar;

	/** The btn cancelar. */
	private JButton btn_cancelar;

	/** The btn guia. */
	private JButton btn_guia;

	/**
	 * Metodo para popular a tabela.
	 */
	public void LoadTable() {
		try {
			Modelo = new TMPacotes(ControlePacotes.getPacotes());
			tbl_pacotes.setModel(Modelo);
			tbl_pacotes.getColumnModel().getColumn(0).setPreferredWidth(70);
			tbl_pacotes.getColumnModel().getColumn(1).setPreferredWidth(185);
			tbl_pacotes.getColumnModel().getColumn(2).setPreferredWidth(59);
			tbl_pacotes.getColumnModel().getColumn(3).setPreferredWidth(57);
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
		txt_destino.setEnabled(logico);
		txt_hotel.setEnabled(logico);
		txt_estadia.setEnabled(logico);
		txt_preco.setEnabled(logico);

		if (!logico) {
			txt_destino.setBorder(null);
			txt_hotel.setBorder(null);
			txt_estadia.setBorder(null);
			txt_preco.setBorder(null);
		} else {
			txt_destino.setBorder(new LineBorder(Color.GRAY));
			txt_hotel.setBorder(new LineBorder(Color.GRAY));
			txt_estadia.setBorder(new LineBorder(Color.GRAY));
			txt_preco.setBorder(new LineBorder(Color.GRAY));
		}
	}

	/**
	 * Limpa txts.
	 */
	public void ClearTextFields() {
		txt_destino.setText(null);
		txt_hotel.setText(null);
		txt_estadia.setText(null);
		txt_preco.setText(null);
	}

	/**
	 * Abre o frame.
	 */
	public JanelaPacotes() {
		initComponents();
		setLocationRelativeTo(null);
		//LoadTable();
		Modelo = new TMPacotes();
		ButtonState(true, false, false, false, false, false);
		ClearTextFields();
		EditableTextFields(false);
	}

	/**
	 * Cria o frame.
	 */
	public void initComponents() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("SAV - Pacotes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 458);
		panel_pacotes = new JPanel();
		setContentPane(panel_pacotes);

		btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbl_pacotes.getSelectionModel().clearSelection();
				tbl_pacotes.setEnabled(false);
				ClearTextFields();
				EditableTextFields(true);
				ButtonState(false, false, false, true, true, false);
			}
		});

		JScrollPane scroll_pacotes = new JScrollPane();

		tbl_pacotes = new JTable();
		tbl_pacotes.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tbl_pacotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_pacotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ButtonState(true, true, true, false, false, true);
				int index = tbl_pacotes.getSelectedRow();
				if (index >= 0 && index < Modelo.getRowCount()) {
					String temp[] = Modelo.getRegistro(index);
					txt_destino.setText(temp[0]);
					txt_hotel.setText(temp[1]);
					txt_estadia.setText(temp[2]);
					txt_preco.setText(temp[3]);
				}
			}
		});
		tbl_pacotes.setGridColor(new Color(192, 192, 192));
		tbl_pacotes.setRowHeight(24);
		tbl_pacotes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tbl_pacotes.setFillsViewportHeight(true);

		tbl_pacotes.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Destino", "Hospedagem", "Estadia", "Preço" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -118299489381514661L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbl_pacotes.getColumnModel().getColumn(0).setPreferredWidth(70);
		tbl_pacotes.getColumnModel().getColumn(1).setPreferredWidth(185);
		tbl_pacotes.getColumnModel().getColumn(2).setPreferredWidth(59);
		tbl_pacotes.getColumnModel().getColumn(3).setPreferredWidth(57);
		scroll_pacotes.setViewportView(tbl_pacotes);

		btn_guia = new JButton("ATRAÇÕES");
		btn_guia.setEnabled(false);
		btn_guia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaAtracoes.main(null);
			}
		});

		JLabel labelAgenciaSelecionada = new JLabel("Pacotes oferecidos pela agência");
		labelAgenciaSelecionada.setAlignmentY(Component.TOP_ALIGNMENT);
		labelAgenciaSelecionada.setOpaque(true);
		labelAgenciaSelecionada.setHorizontalAlignment(SwingConstants.LEFT);
		labelAgenciaSelecionada.setForeground(SystemColor.textHighlight);
		labelAgenciaSelecionada.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		labelAgenciaSelecionada.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
		labelAgenciaSelecionada.setBackground(Color.WHITE);

		JPanel panel_detalhes = new JPanel();
		panel_detalhes
				.setBorder(new TitledBorder(null, "Detalhes", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btn_editar = new JButton("Editar");
		btn_excluir = new JButton("Excluir");
		btn_salvar = new JButton("Salvar");
		btn_salvar.setEnabled(false);

		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (ControlePacotes.SalvaObjeto(txt_destino.getText(), txt_hotel.getText(), txt_estadia.getText(),
							txt_preco.getText())) {
						LoadTable();
						ButtonState(true, false, false, false, false, false);
						ClearTextFields();
						EditableTextFields(false);
						tbl_pacotes.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Novo pacote cadastrado");
					} else
						JOptionPane.showMessageDialog(null, "Erro ao salvar");
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, nfe);
				} catch (HeadlessException he) {
					JOptionPane.showMessageDialog(null, he);
				}

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
		gl_panel_pacotes.setHorizontalGroup(gl_panel_pacotes.createParallelGroup(Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_panel_pacotes.createSequentialGroup().addContainerGap().addGroup(gl_panel_pacotes
						.createParallelGroup(Alignment.LEADING)
						.addComponent(labelAgenciaSelecionada, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 379,
								Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_pacotes.createSequentialGroup()
								.addComponent(btn_novo, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
								.addComponent(btn_excluir, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_editar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addComponent(scroll_pacotes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 379,
								Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_pacotes.createSequentialGroup()
								.addComponent(panel_detalhes, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_pacotes.createParallelGroup(Alignment.TRAILING)
										.addComponent(btn_salvar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89,
												Short.MAX_VALUE)
										.addComponent(btn_cancelar, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(btn_guia, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)).addContainerGap()));
		gl_panel_pacotes.setVerticalGroup(gl_panel_pacotes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_pacotes.createSequentialGroup().addGap(6)
						.addComponent(labelAgenciaSelecionada, GroupLayout.PREFERRED_SIZE, 45,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scroll_pacotes, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGap(7)
						.addGroup(gl_panel_pacotes.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_editar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_excluir, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_novo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_pacotes.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_pacotes.createSequentialGroup().addGap(18)
										.addComponent(btn_salvar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btn_cancelar)
										.addGap(52).addComponent(btn_guia, GroupLayout.PREFERRED_SIZE, 26,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_pacotes.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panel_detalhes,
												GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
						.addGap(88)));

		JLabel lblDestino = new JLabel("Destino:");

		JLabel lblHospedagemInclusa = new JLabel("Hospedagem:");

		txt_destino = new JTextField();
		txt_destino.setDisabledTextColor(Color.BLACK);
		txt_destino.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(227, 227, 227)));
		txt_destino.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_destino.setEnabled(false);
		txt_destino.setColumns(10);

		txt_hotel = new JTextField();
		txt_hotel.setDisabledTextColor(Color.BLACK);
		txt_hotel.setBorder(new EmptyBorder(0, 0, 1, 0));
		txt_hotel.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_hotel.setEnabled(false);
		txt_hotel.setColumns(10);

		JLabel lblEstadia = new JLabel("Estadia:");

		txt_estadia = new JTextField();
		txt_estadia.setDisabledTextColor(Color.BLACK);
		txt_estadia.setBorder(new LineBorder(SystemColor.control));
		txt_estadia.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_estadia.setEnabled(false);
		txt_estadia.setColumns(10);

		JLabel lblPreco = new JLabel("Preco:");

		txt_preco = new JTextField();
		txt_preco.setDisabledTextColor(Color.BLACK);
		txt_preco.setBorder(new LineBorder(SystemColor.control));
		txt_preco.setFont(new Font("SansSerif", Font.BOLD, 12));
		txt_preco.setEnabled(false);
		txt_preco.setColumns(10);
		GroupLayout gl_panel_detalhes = new GroupLayout(panel_detalhes);
		gl_panel_detalhes.setHorizontalGroup(gl_panel_detalhes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_detalhes.createSequentialGroup().addGroup(gl_panel_detalhes
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_detalhes.createSequentialGroup().addGap(10)
								.addGroup(gl_panel_detalhes.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDestino).addComponent(lblHospedagemInclusa))
								.addGap(18)
								.addGroup(gl_panel_detalhes
										.createParallelGroup(Alignment.LEADING, false).addComponent(txt_hotel)
										.addComponent(txt_destino, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
						.addGroup(gl_panel_detalhes.createSequentialGroup().addGap(37)
								.addGroup(gl_panel_detalhes.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPreco).addComponent(lblEstadia))
								.addGap(18)
								.addGroup(gl_panel_detalhes.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txt_preco, 0, 0, Short.MAX_VALUE)
										.addComponent(txt_estadia, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))))
						.addContainerGap()));
		gl_panel_detalhes.setVerticalGroup(gl_panel_detalhes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_detalhes.createSequentialGroup().addGap(11)
						.addGroup(gl_panel_detalhes.createParallelGroup(Alignment.BASELINE).addComponent(lblDestino)
								.addComponent(txt_destino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_panel_detalhes.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHospedagemInclusa).addComponent(txt_hotel, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(5)
						.addGroup(gl_panel_detalhes.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_estadia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstadia))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_detalhes.createParallelGroup(Alignment.BASELINE).addComponent(txt_preco,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPreco))
						.addGap(23)));
		panel_detalhes.setLayout(gl_panel_detalhes);
		panel_pacotes.setLayout(gl_panel_pacotes);
	}

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
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
					JanelaPacotes frame = new JanelaPacotes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
