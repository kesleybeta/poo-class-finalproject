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

/**
 * @author Kesley Nascimento
 */

public class JanelaPacotes extends JFrame {
	private static final long serialVersionUID = 2L;
	private JPanel pct_panel_pacotes;
	private JTable pct_table_pacotes;
	private JTextField pc_txt_pais;
	private JTextField pc_txt_hotel;
	private JTextField pc_txt_estadia;
	private JTextField pc_txt_preco;

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
					JanelaPacotes frame = new JanelaPacotes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPacotes() {
		JButton btnSalvar = new JButton("Salvar");
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("SAV - Pacotes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 495);
		pct_panel_pacotes = new JPanel();
		pct_panel_pacotes.setEnabled(false);
		setContentPane(pct_panel_pacotes);

		JButton pct_btn_novo = new JButton("Novo");
		pct_btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar.setEnabled(true);
			}
		});

		JScrollPane pct_scrollPane = new JScrollPane();

		pct_table_pacotes = new JTable();
		pct_table_pacotes.setGridColor(new Color(192, 192, 192));
		pct_table_pacotes.setRowHeight(24);
		pct_table_pacotes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pct_table_pacotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pct_table_pacotes.setFillsViewportHeight(true);
		pct_table_pacotes.setModel(new DefaultTableModel(
				new Object[][] { { "Abu Dhabi", "Sheraton Abu Dhabi Hotel & Resort", "6 (noites)", "R$ 6.250,00" }, },
				new String[] { "Destino", "Hospedagem", "Estadia", "Pre\u00E7o" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -118299489381514661L;
			@SuppressWarnings({ "rawtypes" })
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
		pct_table_pacotes.getColumnModel().getColumn(0).setPreferredWidth(100);
		pct_table_pacotes.getColumnModel().getColumn(1).setPreferredWidth(185);
		pct_table_pacotes.getColumnModel().getColumn(2).setPreferredWidth(56);
		pct_table_pacotes.getColumnModel().getColumn(3).setPreferredWidth(80);
		pct_scrollPane.setViewportView(pct_table_pacotes);

		JButton pct_btn_guia = new JButton("Guia de Atra\u00E7\u00F5es");
		pct_btn_guia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaAtracoes.main(null);
			}
		});

		JLabel pct_label_selAgencia = new JLabel("Ag\u00EAncia selecionada");
		pct_label_selAgencia.setAlignmentY(Component.TOP_ALIGNMENT);
		pct_label_selAgencia.setOpaque(true);
		pct_label_selAgencia.setHorizontalAlignment(SwingConstants.LEFT);
		pct_label_selAgencia.setForeground(SystemColor.textHighlight);
		pct_label_selAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		pct_label_selAgencia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
		pct_label_selAgencia.setBackground(Color.WHITE);

		JPanel pct_panel_detalhes = new JPanel();
		pct_panel_detalhes
		.setBorder(new TitledBorder(null, "Detalhes", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton pct_btn_editar = new JButton("Editar");

		JButton pct_btn_excluir = new JButton("Excluir");
		GroupLayout gl_pct_panel_pacotes = new GroupLayout(pct_panel_pacotes);
		gl_pct_panel_pacotes.setHorizontalGroup(gl_pct_panel_pacotes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pct_panel_pacotes.createSequentialGroup().addContainerGap().addGroup(gl_pct_panel_pacotes
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pct_panel_pacotes.createSequentialGroup().addGroup(gl_pct_panel_pacotes
								.createParallelGroup(Alignment.LEADING)
								.addComponent(pct_panel_detalhes, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_pct_panel_pacotes.createSequentialGroup()
										.addComponent(pct_btn_novo, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
										.addComponent(pct_btn_excluir, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(pct_btn_editar, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(pct_label_selAgencia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454,
										Short.MAX_VALUE)
								.addComponent(pct_scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454,
										Short.MAX_VALUE))
								.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pct_panel_pacotes.createSequentialGroup()
								.addComponent(pct_btn_guia, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addGap(167)))));
		gl_pct_panel_pacotes.setVerticalGroup(gl_pct_panel_pacotes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pct_panel_pacotes.createSequentialGroup().addGap(6)
						.addComponent(pct_label_selAgencia, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(pct_scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGap(7)
						.addGroup(gl_pct_panel_pacotes.createParallelGroup(Alignment.BASELINE)
								.addComponent(pct_btn_editar, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(pct_btn_excluir, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(pct_btn_novo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pct_panel_detalhes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(pct_btn_guia, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(29)));

		JLabel lblDestino = new JLabel("Pa\u00EDs destino:");

		JLabel lblHospedagemInclusa = new JLabel("Hospedagem inclusa:");

		pc_txt_pais = new JTextField();
		pc_txt_pais.setText("Pais");
		pc_txt_pais.setColumns(10);

		pc_txt_hotel = new JTextField();
		pc_txt_hotel.setText("Hotel");
		pc_txt_hotel.setColumns(10);

		JLabel lblEstadia = new JLabel("Estadia:");

		pc_txt_estadia = new JTextField();
		pc_txt_estadia.setText("6");
		pc_txt_estadia.setColumns(10);

		JLabel lblPreco = new JLabel("Preco:");

		pc_txt_preco = new JTextField();
		pc_txt_preco.setText("6250");
		pc_txt_preco.setColumns(10);

		JSeparator separator = new JSeparator();

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (ControlePacotes.SalvaPacote(pc_txt_pais.getText(), pc_txt_hotel.getText(),
							Integer.parseInt(pc_txt_estadia.getText()), Double.parseDouble(pc_txt_preco.getText()))) {
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
		btnSalvar.setEnabled(false);
		btnSalvar.setMaximumSize(new Dimension(75, 23));
		btnSalvar.setPreferredSize(new Dimension(75, 23));

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		GroupLayout gl_pct_panel_detalhes = new GroupLayout(pct_panel_detalhes);
		gl_pct_panel_detalhes.setHorizontalGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pct_panel_detalhes.createSequentialGroup().addContainerGap().addGroup(gl_pct_panel_detalhes
						.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
						.addGroup(gl_pct_panel_detalhes.createSequentialGroup()
								.addGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEstadia).addComponent(lblHospedagemInclusa)
										.addComponent(lblDestino))
								.addGap(18)
								.addGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.LEADING, false)
										.addComponent(pc_txt_pais, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_pct_panel_detalhes.createSequentialGroup()
												.addComponent(pc_txt_estadia, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(lblPreco).addGap(18).addComponent(pc_txt_preco,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(pc_txt_hotel)))
						.addGroup(Alignment.TRAILING,
								gl_pct_panel_detalhes.createSequentialGroup()
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnCancelar)))
						.addContainerGap()));
		gl_pct_panel_detalhes
		.setVerticalGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pct_panel_detalhes.createSequentialGroup().addContainerGap()
						.addGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDestino).addComponent(pc_txt_pais, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHospedagemInclusa)
								.addComponent(pc_txt_hotel, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstadia)
								.addComponent(pc_txt_estadia, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPreco).addComponent(pc_txt_preco, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pct_panel_detalhes.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar).addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		pct_panel_detalhes.setLayout(gl_pct_panel_detalhes);
		pct_panel_pacotes.setLayout(gl_pct_panel_pacotes);
		setLocationRelativeTo(null);

	}
}
