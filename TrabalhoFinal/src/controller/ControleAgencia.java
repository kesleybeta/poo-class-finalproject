package controller;

import java.util.ArrayList;

import model.Agencias;
import model.Pacotes;

/**
 * The Class ControlePacotes.
 *
 * @author Kesley Nascimento
 */
public class ControleAgencia {

	/**
	 * Salva pacote.
	 *
	 * @param Destino the destino
	 * @param Hotel   the hotel
	 * @param Estadia the estadia
	 * @param Preco   the preco
	 * @return true, if successful
	 */
	public static boolean SalvaObjeto(String nome, String site, String bair, String cida, String uf,
			ArrayList<Pacotes> listaP) {
		Agencias P = new Agencias(nome, site, bair, cida, uf, listaP);
		// System.out.println("ControlePacotes.SalvaPacote():\n" + P);
		return P.Persistir();
	}

	/**
	 * Gets the pacotes.
	 *
	 * @return the pacotes
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getAgencias() {
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
				// must be String a[5] = A.get(i).getListaPacotes();
				Lista.add(a);
			}
		}
		System.out.println("Lista.size(): " + Lista.size());
		return Lista;
	}
}
