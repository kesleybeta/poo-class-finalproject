package model;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.UIManager;

import controller.ControleAgencia;
import json.JSONArray;
import json.JSONObject;
import view.JanelaAgencias;

public class Principal {
 
    public static void main(String args[]) throws IOException {
//    	Agencias agen = new Agencias("Decolar.com", "decolar.com", "jardim", "curitiba" ,"pr", null);
//    	//, new Pacotes("1", "1", "1", "1"));
//    	System.out.println("\tPrincipal >> "+ agen);
    	
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAgencias frame001 = new JanelaAgencias();
					frame001.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    	
    	
//		ControleAgencia.SalvaObjeto("Decolar.com", "decolar.com", "jardim", "curitiba" ,"pr", null); // Dados que veem da JANELA AGENCIAS
//    	
//    	
//    	
//    	ArrayList<String[]> lista = ControleAgencia.getAgencias();
//    	
//    	System.out.println("\tPrincipal: "+ lista);
    	 

    }
 
}
