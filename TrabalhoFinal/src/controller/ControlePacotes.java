package controller;

import java.util.ArrayList;

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
	 * @param Destino the destino
	 * @param Hotel   the hotel
	 * @param Estadia the estadia
	 * @param Preco   the preco
	 * @return true, if successful
	 */
	public static boolean SalvaPacote(String Destino, String Hotel, String Estadia, String Preco) {
		Pacotes P = new Pacotes(Destino, Hotel, Estadia, Preco);
		System.out.println("ControlePacotes.SalvaPacote():\n" + P + "\n");
		return P.Persistir();
	}

	/**
	 * Gets the pacotes.
	 *
	 * @return the pacotes
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getPacotes() {
		@SuppressWarnings("unchecked")
		ArrayList<String[]> ListaPacote = new ArrayList();
		ArrayList<Pacotes> A = Pacotes.getPacotes();
		if (A != null) {
			for (int i = 0; i < A.size(); i++) {
				String a[] = new String[4];
				a[0] = A.get(i).getDestino();
				a[1] = A.get(i).getHotel();
				a[2] = A.get(i).getEstadia();
				a[3] = A.get(i).getPreco();
				ListaPacote.add(a);
			}
		}
		//System.out.println("Metodo ControlePacotes.getPacotes():\n"+ListaPacote+"\n");
		return ListaPacote;
	}
}
