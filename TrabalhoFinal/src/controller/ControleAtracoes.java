package controller;

import java.util.ArrayList;

import model.Atracoes;

/**
 * The Class ControleAtracoes.
 *
 * @author Kesley Nascimento
 */
public class ControleAtracoes {
	private static String LOCAL;

	public static boolean SalvaObjeto(String atracao) {
		Atracoes DadosdaJanela = new Atracoes(atracao);
		// System.out.println("ControleAtracoes.SalvaAtracao():\n" + P);
		return DadosdaJanela.Persistir();
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getAtracoes() {
		@SuppressWarnings("unchecked")
		ArrayList<String[]> Lista = new ArrayList();

		ArrayList<Atracoes> A = Atracoes.getAtracoes(LOCAL);
		if (A != null) {
			for (int i = 0; i < A.size(); i++) {
				String a[] = new String[1];
				a[0] = A.get(i).getNome();
				Lista.add(a);
			}
		}
		// System.out.println("Metodo ControleAtracoes.getAtracoes():\n"+ListaAtracao);
		return Lista;
	}

	public static void setLOCAL(String l) {
		LOCAL = l;
	}
}
