package controller;

import java.util.ArrayList;

import model.Atracoes;

/**
 * The Class ControleAtracoes.
 *
 * @author Kesley Nascimento
 */
public class ControleAtracoes{
	private static String LOCAL;
	
	public static boolean SalvaObjeto(String atracao) {
		Atracoes DadosdaJanela = new Atracoes();
		if (!atracao.isEmpty()) {
			DadosdaJanela = new Atracoes(atracao);
		}
		return DadosdaJanela.Persistir(LOCAL);
	}
	
	public static void ExcluirObjeto(int index) {
		Atracoes.Excluir(LOCAL, index);
	}
	
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

	public static void setLOCAL(String l) {
		LOCAL = l;
	}
}
