package controller;

import java.util.ArrayList;

import model.Agencias;
import model.Pacotes;

public class ControleAgencia {

	public static boolean SalvaObjeto(Agencias AGC) {
		return AGC.Persistir();
	}

	public static boolean SalvaObjeto(String nome, String site, String bair, String cidad, String uf, ArrayList<Pacotes> pct) {
		Agencias AGC = new Agencias(nome, site, bair, cidad, uf, pct);
		return AGC.Persistir();
	}

	public static boolean SalvaObjeto(String nome, String site, String bair, String cida, String uf) {
		Agencias AGC = new Agencias(nome, site, bair, cida, uf, null);
		return AGC.Persistir();
	}
	public static boolean SalvaObjeto(String nome, String site, String bair, String cida, String uf, int index) {
		Agencias AGC = new Agencias(nome, site, bair, cida, uf);
		return AGC.Editar(index);
	}
//	public static boolean SalvaObjeto(String nome, String site, String bair, String cida, String uf, int index) {
//		Agencias AGC = new Agencias(nome, site, bair, cida, uf);
//		return AGC.Excluir(index);
//	}
	
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
				a[5] = A.get(i).getListaPacotes().toString();
				System.out.print("\n\tControleAgencia:");
				for (int j = 0; j < a.length; j++) {
					System.out.print(" > " + a[j]);
				}
				Lista.add(a);
			}
			System.out.println();
		}
		System.out.println("\t > ControleAgencia-Lista.size(): " + Lista.size());
		return Lista;
	}

}	
