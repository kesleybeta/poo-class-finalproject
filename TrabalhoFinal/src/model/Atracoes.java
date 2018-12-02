
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
	private static final String baseatr = "db/thirdbase.txt";

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
		json.put("nome", this.nome);
		// System.out.println("Converte Objeto toJson: " + json + "\n");
		return json;
	}

	public boolean Persistir(String local) {
		JSONObject json = this.toJson();
		System.out.print("|ThirdBase|");
		String base = Arquivo.Read(baseatr);
//		System.out.println("\nBASE length >> " + base.length());

		JSONArray jarrAtr = new JSONArray(base);

		int count = 0;
		for (int j = 0; j < jarrAtr.length(); j++) {
			if (jarrAtr.getJSONObject(j).has(local)) {
				jarrAtr.getJSONObject(j).getJSONArray(local).put(json);
				count++;
				// System.out.println("\tif>"+jarrAtr.getJSONObject(j).toString(1));
			}
		}
		if (count == 0) {
			JSONArray jason = new JSONArray();
			jason.put(json);
//			System.out.println(jason);
			JSONObject jobje = new JSONObject();
			jobje.put(local, jason);
//			System.out.println(jobje);

			jarrAtr.put(jobje);
		}

//		System.out.println(jarrAtr.toString(1));
		Arquivo.Write(baseatr, jarrAtr.toString());

		return true;
	}

	public static ArrayList<Atracoes> getAtracoes(String local) {
		ArrayList<Atracoes> ListaRetornar = new ArrayList<>();
		System.out.print("|ThirdBase|");
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
		return ListaRetornar;
	}
}
