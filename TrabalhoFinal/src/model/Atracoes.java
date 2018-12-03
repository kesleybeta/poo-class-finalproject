package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

public class Atracoes {
	private static final String baseatr = "thirdbase";
	private String nome;

	public Atracoes(String nome) {
		this.setNome(nome);
	}

	public Atracoes(JSONObject json) {
		this.nome = json.getString("nome");
	}

	public Atracoes() {
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
		return json;
	}

	public static void Excluir(String local, int index) {
		System.out.print("|SecondBase| ");
		String strArquivoAtracao = Arquivo.Read(baseatr);
		JSONArray arrAtracao = new JSONArray(strArquivoAtracao);
		for (int j = 0; j < arrAtracao.length(); j++) {
			System.out.println(" 0 " + arrAtracao.getJSONObject(j).toString(1));
			if (arrAtracao.getJSONObject(j).has(local)) {
				arrAtracao.getJSONObject(j).getJSONArray(local).remove(index);
			}
		}
		Arquivo.Write(baseatr, arrAtracao.toString());
	}

	public boolean Persistir(String local) {
		JSONObject json = this.toJson();
		System.out.print("|ThirdBase| ");
		String base = Arquivo.Read(baseatr);
		
		JSONArray jarrAtr = new JSONArray();
		if (!base.isEmpty() && base.length() > 1) // Se a base não estiver vazia
			jarrAtr = new JSONArray(base);
		
		int count = 0;
		for (int j = 0; j < jarrAtr.length(); j++) {
			if (jarrAtr.getJSONObject(j).has(local)) {
				jarrAtr.getJSONObject(j).getJSONArray(local).put(json);
				count++;
			}
		}
		if (count == 0) {
			JSONArray jason = new JSONArray();
			jason.put(json);
			JSONObject jobje = new JSONObject();
			jobje.put(local, jason);
			jarrAtr.put(jobje);
		}
		Arquivo.Write(baseatr, jarrAtr.toString());
		return true;
	}

	public static ArrayList<Atracoes> getAtracoes(String local) {
		ArrayList<Atracoes> ListaRetornar = new ArrayList<>();
		System.out.print("|ThirdBase| ");
		String base = Arquivo.Read(baseatr);
		if (base.isEmpty() || base.length() < 5)
			return null;

		JSONArray jarrAtr = new JSONArray(base);
		JSONArray jobjAtr = null;
		for (int j = 0; j < jarrAtr.length(); j++) {
			if (jarrAtr.getJSONObject(j).has(local)) {
				jobjAtr = jarrAtr.getJSONObject(j).getJSONArray(local);
				System.out.println(local + " " + jarrAtr.getJSONObject(j).getJSONArray(local).toString(1));
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
