package controller;

import java.util.ArrayList;

import model.Pacotes;

/**
 * The Class ControlePacotes.
 *
 * @author Kesley Nascimento
 */
public class ControlePacotes {
	private static int INDEX;

	public static boolean SalvaObjeto(String Destino, String Hotel, String Estadia, String Preco) {
		Pacotes DadosdaJanela = new Pacotes(Destino, Hotel, Estadia, Preco, null);
		// System.out.println("ControlePacotes.SalvaPacote():\n" + P);
		return DadosdaJanela.Persistir(INDEX);
	}
	public static boolean SalvaObjeto(String Destino, String Hotel, String Estadia, String Preco, int indexP) {
		Pacotes DadosdaJanela = new Pacotes(Destino, Hotel, Estadia, Preco, null);
		// System.out.println("ControlePacotes.SalvaPacote():\n" + P);
		return DadosdaJanela.Editar(INDEX, indexP);
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<String[]> getPacotes() {
		@SuppressWarnings("unchecked")
		ArrayList<String[]> Lista = new ArrayList();
		
		ArrayList<Pacotes> A = Pacotes.getPacotes(INDEX);
		if (A != null) {
			for (int i = 0; i < A.size(); i++) {
				String a[] = new String[4];
				a[0] = A.get(i).getDestino();
				a[1] = A.get(i).getHotel();
				a[2] = A.get(i).getEstadia();
				a[3] = A.get(i).getPreco();
				System.out.print("\n\tControlePacotes:");
				for (int j = 0; j < a.length; j++) {
					System.out.print(" > " + a[j]);
				}
				Lista.add(a);
			}
			System.out.println();
		}
		// System.out.println("Metodo ControlePacotes.getPacotes():\n"+ListaPacote);
		return Lista;
	}

	public static void setIndex(int i) {
		INDEX = i;
	}
}
