package view;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControleAtracoes;
import controller.TMAtracoes;

/**
 * The Class JanelaAtracoes.
 * 
 * @author Kesley Nascimento
 * @since 18.11.23.2059
 * @version 18.12.03.1624
 */
public class JanelaAtracoes extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3L;

	/** The pane atracoes. */
	private JPanel pane_atracoes;

	/** The tbl atracoes. */
	private JTable tbl_atracoes;

	/** The Modelo. */
	private TMAtracoes Modelo;

	/** The btn adicionar. */
	private JButton btn_adicionar;

	/** The btn excluir. */
	private JButton btn_excluir;

	/** The lbl destino. */
	private JLabel lbl_destino;

	/**
	 * Instantiates a new janela atracoes.
	 */
	public JanelaAtracoes() {
		setResizable(false);
		initComponents();
	}

	/**
	 * Instantiates a new janela atracoes.
	 *
	 * @param destino the destino
	 */
	public JanelaAtracoes(String destino) {
		ControleAtracoes.setLOCAL(destino);
		initComponents();
		LoadTable();
		lbl_destino.setText(destino);
	}

	/**
	 * Load table.
	 */
	private void LoadTable() {
		Modelo = new TMAtracoes(ControleAtracoes.getDados());
		tbl_atracoes.setModel(Modelo);
	}

	/**
	 * Inits the components.
	 */
	public void initComponents() {
		setType(Type.UTILITY);
		setTitle("SAV - Atrações locais");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 315, 315);
		pane_atracoes = new JPanel();
		pane_atracoes.setBackground(SystemColor.control);
		pane_atracoes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane_atracoes);

		lbl_destino = new JLabel("Destino selecionado");
		lbl_destino.setOpaque(true);
		lbl_destino.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_destino.setLabelFor(pane_atracoes);
		lbl_destino.setBorder(new MatteBorder(0, 0, 2, 0, new Color(128, 128, 128)));
		lbl_destino.setBackground(SystemColor.text);
		lbl_destino.setForeground(SystemColor.textHighlight);
		lbl_destino.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JScrollPane scrollpane_atracoes = new JScrollPane();
		scrollpane_atracoes.setBorder(null);

		btn_adicionar = new JButton("Adicionar");
		btn_adicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog(null, "Nova atração", "SAV - Adicionar", DISPOSE_ON_CLOSE);
				if (!result.isEmpty() && result.length() > 0)
					ControleAtracoes.SalvaObjeto(result);
				LoadTable();
			}
		});

		btn_excluir = new JButton("Excluir");
		btn_excluir.setEnabled(false);
		btn_excluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = tbl_atracoes.getSelectedRow();
				if (id >= 0 && id < Modelo.getRowCount())
					ControleAtracoes.ExcluirObjeto(id);
				LoadTable();
				btn_excluir.setEnabled(false);
			}
		});
		GroupLayout gl_pane_atracoes = new GroupLayout(pane_atracoes);
		gl_pane_atracoes.setHorizontalGroup(gl_pane_atracoes.createParallelGroup(Alignment.LEADING)
				.addComponent(lbl_destino, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
				.addGroup(gl_pane_atracoes.createSequentialGroup().addContainerGap()
						.addComponent(btn_adicionar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
						.addComponent(btn_excluir, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_pane_atracoes.createSequentialGroup().addContainerGap()
						.addComponent(scrollpane_atracoes, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addContainerGap()));
		gl_pane_atracoes.setVerticalGroup(gl_pane_atracoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pane_atracoes.createSequentialGroup()
						.addComponent(lbl_destino, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(11).addComponent(scrollpane_atracoes, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pane_atracoes.createParallelGroup(Alignment.BASELINE).addComponent(btn_adicionar)
								.addComponent(btn_excluir))));

		tbl_atracoes = new JTable();
		tbl_atracoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_excluir.setEnabled(true);
			}
		});
		tbl_atracoes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tbl_atracoes.setShowGrid(false);
		tbl_atracoes.setRowHeight(24);
		tbl_atracoes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbl_atracoes.setFillsViewportHeight(true);
		tbl_atracoes.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "Atrações locais" }));
		tbl_atracoes.getColumnModel().getColumn(0).setPreferredWidth(269);
		scrollpane_atracoes.setViewportView(tbl_atracoes);
		pane_atracoes.setLayout(gl_pane_atracoes);
		setLocationRelativeTo(null);
	}
}
