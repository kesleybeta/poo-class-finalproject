package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControleAtracoes;
import controller.TMAtracoes;

public class JanelaAtracoes extends JFrame {

	private static final long serialVersionUID = 3L;
	private JPanel pane_atracoes;
	private JTable tbl_atracoes;
	private TMAtracoes Modelo;
	private JButton btn_adicionar;

	private JLabel lbl_destino;

	public JanelaAtracoes() {
		setResizable(false);
		initComponents();
	}

	public JanelaAtracoes(String destino) {
		ControleAtracoes.setLOCAL(destino);
		initComponents();
		LoadTable();
		lbl_destino.setText(destino);
	}

	private void LoadTable() {
		Modelo = new TMAtracoes(ControleAtracoes.getAtracoes());
		tbl_atracoes.setModel(Modelo);
	}

	public void initComponents() {
		setType(Type.UTILITY);
		setTitle("SAV - Atrações locais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 315, 315);
		pane_atracoes = new JPanel();
		pane_atracoes.setBackground(SystemColor.control);
		pane_atracoes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane_atracoes);

		lbl_destino = new JLabel("Destino selecionado");
		lbl_destino.setOpaque(true);
		lbl_destino.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_destino.setLabelFor(pane_atracoes);
		lbl_destino.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
		lbl_destino.setBackground(SystemColor.text);
		lbl_destino.setForeground(SystemColor.textHighlight);
		lbl_destino.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JScrollPane scrollpane_atracoes = new JScrollPane();
		scrollpane_atracoes.setBorder(null);

		btn_adicionar = new JButton("Adicionar");
		btn_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GroupLayout gl_pane_atracoes = new GroupLayout(pane_atracoes);
		gl_pane_atracoes.setHorizontalGroup(
			gl_pane_atracoes.createParallelGroup(Alignment.LEADING)
				.addComponent(lbl_destino, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
				.addGroup(gl_pane_atracoes.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_adicionar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(207, Short.MAX_VALUE))
				.addGroup(gl_pane_atracoes.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollpane_atracoes, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pane_atracoes.setVerticalGroup(
			gl_pane_atracoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pane_atracoes.createSequentialGroup()
					.addComponent(lbl_destino, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollpane_atracoes, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_adicionar))
		);

		tbl_atracoes = new JTable();
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
