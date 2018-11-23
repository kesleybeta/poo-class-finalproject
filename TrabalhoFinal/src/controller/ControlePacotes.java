package controller;

import model.Pacotes;

/**
 * The Class ControlePacotes.
 *
 * @author Kesley Nascimento
 */

public class ControlePacotes {
	
	/**
	 * Salva pacote.
	 *
	 * @param Cidade the cidade
	 * @param Hotel the hotel
	 * @param Estadia the estadia
	 * @param Preco the preco
	 * @return true, if successful
	 */
	public static boolean SalvaPacote(String Cidade, String Hotel, int Estadia, double Preco) {
		Pacotes p = new Pacotes(Cidade, Hotel, Estadia, Preco, null, null);
		return p.Persistir();
	}
	
}
