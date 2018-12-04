package controller;

import java.util.ArrayList;

import model.Pacotes;

/**
 * The Class ControlePacotes.
 *
 * @author Kesley Nascimento
 * @version 18.12.03.1624
 */
public class ControlePacotes {

	/** The index. */
	private static int INDEX;

	/**
	 * Sets the index.
	 *
	 * @param iNDEX the new index
	 */
	public static void setINDEX(int iNDEX) {
		INDEX = iNDEX;
	}

	/**
	 * Salva objeto.
	 *
	 * @param Pais    the pais
	 * @param Destino the destino
	 * @param Hotel   the hotel
	 * @param Estadia the estadia
	 * @param Preco   the preco
	 * @return true, if successful
	 */
	public static boolean SalvaObjeto(String Pais, String Destino, String Hotel, String Estadia, String Preco) {
		Pacotes DadosdaJanela = new Pacotes(Pais, Destino, Hotel, Estadia, Preco, null);
		return DadosdaJanela.Persistir(INDEX);
	}

	/**
	 * Salva objeto.
	 *
	 * @param Pais    the pais
	 * @param Destino the destino
	 * @param Hotel   the hotel
	 * @param Estadia the estadia
	 * @param Preco   the preco
	 * @param indexP  the index P
	 * @return true, if successful
	 */
	public static boolean SalvaObjeto(String Pais, String Destino, String Hotel, String Estadia, String Preco,
			int indexP) {
		Pacotes DadosdaJanela = new Pacotes(Pais, Destino, Hotel, Estadia, Preco, null);
		return DadosdaJanela.Editar(INDEX, indexP);
	}

	/**
	 * Excluir objeto.
	 *
	 * @param index the index
	 */
	public static void ExcluirObjeto(int index) {
		Pacotes.Excluir(INDEX, index);
	}

	/**
	 * Gets the dados.
	 *
	 * @return the dados
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getDados() {
		@SuppressWarnings("unchecked")
		ArrayList<String[]> Lista = new ArrayList();
		ArrayList<Pacotes> A = Pacotes.getPacotes(INDEX);
		if (A != null) {
			for (int i = 0; i < A.size(); i++) {
				String a[] = new String[5];
				a[0] = A.get(i).getPais();
				a[1] = A.get(i).getDestino();
				a[2] = A.get(i).getHotel();
				a[3] = A.get(i).getEstadia();
				a[4] = A.get(i).getPreco();
				Lista.add(a);
			}
			System.out.println();
		}
		return Lista;
	}
}
