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
	
	public static void setINDEX(int iNDEX) {
		INDEX = iNDEX;
	}
	
	public static boolean SalvaObjeto(String Pais, String Destino, String Hotel, String Estadia, String Preco) {
		Pacotes DadosdaJanela = new Pacotes(Pais, Destino, Hotel, Estadia, Preco, null);
		return DadosdaJanela.Persistir(INDEX);
	}
	public static boolean SalvaObjeto(String Pais, String Destino, String Hotel, String Estadia, String Preco, int indexP) {
		Pacotes DadosdaJanela = new Pacotes(Pais, Destino, Hotel, Estadia, Preco, null);
		return DadosdaJanela.Editar(INDEX, indexP);
	}

	public static void ExcluirObjeto(int index) {
		Pacotes.Excluir(INDEX, index);
	}

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
				System.out.print("\n\tControlePacotes:");
				for (int j = 0; j < a.length; j++) {
					System.out.print(" > " + a[j]);
				}
				Lista.add(a);
			}
			System.out.println();
		}
		return Lista;
	}
}
