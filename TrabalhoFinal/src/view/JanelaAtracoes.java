package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaAtracoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private JPanel atr_pane_atracoes;

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
					JanelaAtracoes frame = new JanelaAtracoes();
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
	public JanelaAtracoes() {
		setType(Type.UTILITY);
		setTitle("SAV - Atra\u00E7\u00F5es locais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 315, 295);
		atr_pane_atracoes = new JPanel();
		atr_pane_atracoes.setBackground(SystemColor.control);
		atr_pane_atracoes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(atr_pane_atracoes);
		
		JLabel atr_lbl_cidade = new JLabel("Cidade selecionada");
		atr_lbl_cidade.setOpaque(true);
		atr_lbl_cidade.setHorizontalAlignment(SwingConstants.CENTER);
		atr_lbl_cidade.setLabelFor(atr_pane_atracoes);
		atr_lbl_cidade.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
		atr_lbl_cidade.setBackground(SystemColor.text);
		atr_lbl_cidade.setForeground(SystemColor.textHighlight);
		atr_lbl_cidade.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JScrollPane atr_scroll_atracoes = new JScrollPane();
		atr_scroll_atracoes.setBorder(null);
		
		JList<String> atr_list_atracoes = new JList<String>();
		atr_scroll_atracoes.setViewportView(atr_list_atracoes);
		atr_list_atracoes.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.controlShadow));
		atr_list_atracoes.setBackground(SystemColor.control);
		atr_list_atracoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		atr_list_atracoes.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1902349894032498245L;
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton atr_btn_voltar = new JButton("Voltar");
		atr_btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton atr_btn_add = new JButton("Adicionar");
		GroupLayout gl_atr_pane_atracoes = new GroupLayout(atr_pane_atracoes);
		gl_atr_pane_atracoes.setHorizontalGroup(
			gl_atr_pane_atracoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_atr_pane_atracoes.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_atr_pane_atracoes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_atr_pane_atracoes.createSequentialGroup()
							.addComponent(atr_btn_add, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
							.addComponent(atr_btn_voltar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_atr_pane_atracoes.createSequentialGroup()
							.addComponent(atr_scroll_atracoes, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
							.addContainerGap())))
				.addComponent(atr_lbl_cidade, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
		);
		gl_atr_pane_atracoes.setVerticalGroup(
			gl_atr_pane_atracoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_atr_pane_atracoes.createSequentialGroup()
					.addComponent(atr_lbl_cidade, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(atr_scroll_atracoes, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_atr_pane_atracoes.createParallelGroup(Alignment.BASELINE)
						.addComponent(atr_btn_add)
						.addComponent(atr_btn_voltar)))
		);
		atr_pane_atracoes.setLayout(gl_atr_pane_atracoes);
		setLocationRelativeTo(null);
		
	}
}
