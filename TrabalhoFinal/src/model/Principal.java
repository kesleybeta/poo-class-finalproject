package model;

import java.io.IOException;
import java.util.ArrayList;

import controller.ControleAgencia;

public class Principal {
 
    public static void main(String args[]) throws IOException {
    	Pacotes pct1 = new Pacotes("1", "1", "1", "1");
    	Pacotes pct2 = new Pacotes("2", "2", "2", "2");
    	Agencias agen = new Agencias("Decolar.com", "decolar.com","jardim","curitiba" ,"pr");
    	agen.addListaPacotes(pct1);
    	agen.addListaPacotes(pct2);
        pct1.setAgencia(agen.getNome());
        pct2.setAgencia(agen.getNome());
    	//System.out.println(agen);
    	//ControleAgencia.SalvaObjeto(agen);
    	
    	ArrayList<String[]> lista = ControleAgencia.getAgencias();
    	
    	System.out.println(lista);
    }
 
}