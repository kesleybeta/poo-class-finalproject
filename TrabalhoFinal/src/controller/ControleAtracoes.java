package controller;

import java.util.ArrayList;

import model.Atracoes;

/**
 * The Class ControleAtracoes.
 *
 * @author Kesley Nascimento
 * @version 18.12.03.1728
 */
public class ControleAtracoes {

	/** The local. */
	private static String LOCAL;

	/**
	 * Salva objeto.
	 *
	 * @param atracao the atracao
	 * @return true, if successful
	 */
	public static boolean SalvaObjeto(String atracao) {
		Atracoes DadosdaJanela = new Atracoes();
		if (!atracao.isEmpty()) {
			DadosdaJanela = new Atracoes(atracao);
		}
		return DadosdaJanela.Persistir(LOCAL);
	}

	/**
	 * Excluir objeto.
	 *
	 * @param index the index
	 */
	public static void ExcluirObjeto(int index) {
		Atracoes.Excluir(LOCAL, index);
	}

	/**
	 * Gets the dados.
	 *
	 * @return the dados
	 */
	public static ArrayList<String[]> getDados() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList<String[]> Lista = new ArrayList();
		ArrayList<Atracoes> A = Atracoes.getAtracoes(LOCAL);
		if (A != null) {
			for (int i = 0; i < A.size(); i++) {
				String a[] = new String[1];
				a[0] = A.get(i).getNome();
				Lista.add(a);
			}
		}
		return Lista;
	}

	/**
	 * Sets the local.
	 *
	 * @param l the new local
	 */
	public static void setLOCAL(String l) {
		LOCAL = l;
	}
}
