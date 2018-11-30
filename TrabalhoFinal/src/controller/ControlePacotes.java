package controller;

import java.util.ArrayList;

import model.Pacotes;

/**
 * The Class ControlePacotes.
 *
 * @author Kesley Nascimento
 */
public class ControlePacotes {
	private static int index;

	public static boolean SalvaObjeto(String Destino, String Hotel, String Estadia, String Preco) {
		Pacotes P = new Pacotes(Destino, Hotel, Estadia, Preco, null);
		// System.out.println("ControlePacotes.SalvaPacote():\n" + P);
		return P.Persistir();
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getPacotes() {
		@SuppressWarnings("unchecked")
		ArrayList<String[]> Lista = new ArrayList();
		ArrayList<Pacotes> A = Pacotes.getPacotes(index);
		if (A != null) {
			for (int i = 0; i < A.size(); i++) {
				String a[] = new String[4];
				a[0] = A.get(i).getDestino();
				a[1] = A.get(i).getHotel();
				a[2] = A.get(i).getEstadia();
				a[3] = A.get(i).getPreco();
				Lista.add(a);
			}
		}
		// System.out.println("Metodo ControlePacotes.getPacotes():\n"+ListaPacote);
		return Lista;
	}

	public static void setIndex(int i) {
		index = i;
	}
}
