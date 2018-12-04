package controller;

import java.util.ArrayList;

import model.Agencias;

/**
 * The Class ControleAgencia.
 * 
 * @author Kesley Nascimento
 * @version 18.12.03.1728
 */
public class ControleAgencia {

	/**
	 * Salva objeto.
	 *
	 * @param DadosdaJanela the dadosda janela
	 * @return true, if successful
	 */
	public static boolean SalvaObjeto(Agencias DadosdaJanela) {
		return DadosdaJanela.Persistir();
	}

	/**
	 * Salva objeto.
	 *
	 * @param nome the nome
	 * @param site the site
	 * @param bair the bair
	 * @param cida the cida
	 * @param uf   the uf
	 * @return true, if successful
	 */
	public static boolean SalvaObjeto(String nome, String site, String bair, String cida, String uf) {
		Agencias DadosdaJanela = new Agencias(nome, site, bair, cida, uf, null);
		return DadosdaJanela.Persistir();
	}

	/**
	 * Editar objeto.
	 *
	 * @param nome  the nome
	 * @param site  the site
	 * @param bair  the bair
	 * @param cida  the cida
	 * @param uf    the uf
	 * @param index the index
	 * @return true, if successful
	 */
	public static boolean EditarObjeto(String nome, String site, String bair, String cida, String uf, int index) {
		Agencias DadosdaJanela = new Agencias(nome, site, bair, cida, uf);
		return DadosdaJanela.Editar(index);
	}

	/**
	 * Excluir objeto.
	 *
	 * @param index the index
	 */
	public static void ExcluirObjeto(int index) {
		Agencias.Excluir(index);
	}

	/**
	 * GetDados() retorna uma LISTA de agencias e seus dados
	 *
	 * @return the dados
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getDados() {
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
