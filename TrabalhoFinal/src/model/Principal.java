package model;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.UIManager;

import view.JanelaAgencias;

/**
 * The Class Principal.
 *
 * @author Kesley Nascimento
 * @version 18.12.03.1444
 * @since 18.11.23.2059
 */
public class Principal {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String args[]) throws IOException {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JanelaAgencias frame = new JanelaAgencias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
