
package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

/**
 * The Class Atracoes.
 *
 * @author Kesley Nascimento
 */
public class Atracoes {
	private static final String baseatr = "db/atrc002.txt";

	private String nome;

	public Atracoes(String nome) {
		this.setNome(nome);
	}

	public Atracoes(JSONObject json) {
		this.nome = json.getString("nome");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static String getBaseatr() {
		return baseatr;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("preco", this.nome);
		//System.out.println("Converte Objeto toJson: " + json + "\n");
		return json;
	}

	public boolean Persistir() {
		JSONObject json = this.toJson();

		String base = Arquivo.Read(baseatr);
		System.out.println("BASE length >> " + base.length());
		JSONArray jA = new JSONArray();
		if (!base.isEmpty() && base.length() > 1) // Se a base não estiver vazia
			jA = new JSONArray(base);

		jA.put(json);
		Arquivo.Write(baseatr, jA.toString());

		return true;
	}

	public static ArrayList<Atracoes> getAtracoes(String local) {
		ArrayList<Atracoes> ListaRetornar = new ArrayList<>();
		String base = Arquivo.Read(baseatr);

		if (base.isEmpty() || base.length() < 5)
			return null;

		JSONArray jarrAtr = new JSONArray(base);

		JSONArray jobjAtr = null;
		for (int j = 0; j < jarrAtr.length(); j++) {
			if (jarrAtr.getJSONObject(j).has(local)) {
				jobjAtr = jarrAtr.getJSONObject(j).getJSONArray(local);
			}
		}
		if (jobjAtr != null) {
			for (int i = 0; i < jobjAtr.length(); i++) {
				Atracoes NovaAtracao = new Atracoes(jobjAtr.getJSONObject(i));
				ListaRetornar.add(NovaAtracao);
			}
		}
		System.out.println("Lista Retornada: " + ListaRetornar);

		return ListaRetornar;
	}
}
