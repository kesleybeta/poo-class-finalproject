package controller;

import java.util.ArrayList;

import model.Agencias;

public class ControleAgencia {

	public static boolean SalvaObjeto(Agencias DadosdaJanela) {
		return DadosdaJanela.Persistir();
	}

	public static boolean SalvaObjeto(String nome, String site, String bair, String cida, String uf) {
		Agencias DadosdaJanela = new Agencias(nome, site, bair, cida, uf, null);
		return DadosdaJanela.Persistir();
	}

	public static boolean EditarObjeto(String nome, String site, String bair, String cida, String uf, int index) {
		Agencias DadosdaJanela = new Agencias(nome, site, bair, cida, uf);
		return DadosdaJanela.Editar(index);
	}

	public static void ExcluirObjeto(int index) {
		Agencias.Excluir(index);
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getDados() { // getAgencias retorna uma LISTA de agencias;
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
				// a[5] = A.get(i).getListaPacotes().toString();
				Lista.add(a);
			}
			System.out.println();
		}
		return Lista;
	}
}
