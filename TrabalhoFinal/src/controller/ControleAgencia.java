package controller;

import java.util.ArrayList;

import model.Agencias;
import model.Pacotes;

public class ControleAgencia {

	public static boolean SalvaObjeto(Agencias AGC) {
		return AGC.Persistir();
	}
	
	public static boolean SalvaObjeto(String nome,String site, String bair, String cidad, String uf, Pacotes pct) {
		Agencias AGC = new Agencias(nome, site, bair, cidad, uf, pct);
		return AGC.Persistir();
	}

	public static boolean SalvaObjeto(String nome, String site, String bair, String cida, String uf) {
		Agencias AGC = new Agencias(nome, site, bair, cida, uf);
		return AGC.Persistir();
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getAgencias() { // getAgencias retorna uma LISTA de agencias;
		@SuppressWarnings("unchecked")
		ArrayList<String[]> Lista = new ArrayList();
		ArrayList<Agencias> A = Agencias.getAgencias();
		if (A != null) {
			for (int i = 0; i < A.size(); i++) {
				String a[] = new String[6];
				a[0] = A.get(i).getNome();
				a[1] = A.get(i).getWebsite();
				a[2] = A.get(i).getBairro();
				a[3] = A.get(i).getCidade();
				a[4] = A.get(i).getUf();
				//must be String a[5] = A.get(i).getListaPacotes();
				for (int j = 0; j < a.length; j++) {
					System.out.print(" > "+a[j]);
				}
				Lista.add(a);
			}
		}
		//System.out.println("ControleAgencia-Lista.size(): " + Lista.size());
		return Lista;
	}



	
}
