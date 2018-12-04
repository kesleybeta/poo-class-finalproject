package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

/**
 * The Class Atracoes.
 * 
 * @author Kesley Nascimento
 * @since 18.11.24.1656
 * @version 18.12.03.1624
 */
public class Atracoes {

	/** The Constant ThirdBase. */
	private static final String ThirdBase = "thirdbase";

	/** The nome. */
	private String nome;

	/**
	 * Instantiates a new atracoes.
	 *
	 * @param nome the nome
	 */
	public Atracoes(String nome) {
		this.setNome(nome);
	}

	/**
	 * Instantiates a new atracoes.
	 *
	 * @param json the json
	 */
	public Atracoes(JSONObject json) {
		this.nome = json.getString("nome");
	}

	/**
	 * Instantiates a new atracoes.
	 */
	public Atracoes() {
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the baseatr.
	 *
	 * @return the baseatr
	 */
	public static String getBaseatr() {
		return ThirdBase;
	}

	/**
	 * To json.
	 *
	 * @return the JSON object
	 */
	public JSONObject toJson() {
		JSONObject NovoJObject = new JSONObject();
		NovoJObject.put("nome", this.nome);
		return NovoJObject;
	}

	/**
	 * Excluir.
	 *
	 * @param CidadeDestino the cidade destino
	 * @param index         the index
	 */
	public static void Excluir(String CidadeDestino, int index) {
		System.out.print("(ThirdBase) "); // Log 
		String StringThirdBase = Arquivo.Read(ThirdBase);
		JSONArray JArrayStringThirdBase = new JSONArray(StringThirdBase);
		for (int j = 0; j < JArrayStringThirdBase.length(); j++) {
			if (JArrayStringThirdBase.getJSONObject(j).has(CidadeDestino)) {
				JArrayStringThirdBase.getJSONObject(j).getJSONArray(CidadeDestino).remove(index);
			}
		}
		Arquivo.Write(ThirdBase, JArrayStringThirdBase.toString());
	}

	/**
	 * Persistir.
	 *
	 * @param CidadeDestino the cidade destino
	 * @return true, if successful
	 */
	public boolean Persistir(String CidadeDestino) {
		JSONObject JObjectNovaAtracao = this.toJson();
		System.out.print("(ThirdBase) "); // Log 
		String StringThirdBase = Arquivo.Read(ThirdBase);

		JSONArray NovoJArrayBase = new JSONArray();
		if (!StringThirdBase.isEmpty() && StringThirdBase.length() > 1) // Se a base não estiver vazia
			NovoJArrayBase = new JSONArray(StringThirdBase);

		int count = 0;
		for (int j = 0; j < NovoJArrayBase.length(); j++) {
			if (NovoJArrayBase.getJSONObject(j).has(CidadeDestino)) {
				NovoJArrayBase.getJSONObject(j).getJSONArray(CidadeDestino).put(JObjectNovaAtracao);
				count++;
			}
		}
		if (count == 0) {
			JSONArray NovoJArray = new JSONArray();
			NovoJArray.put(JObjectNovaAtracao);
			JSONObject NovoJObject = new JSONObject();
			NovoJObject.put(CidadeDestino, NovoJArray);
			NovoJArrayBase.put(NovoJObject);
		}
		Arquivo.Write(ThirdBase, NovoJArrayBase.toString());
		return true;
	}

	/**
	 * Gets the atracoes.
	 *
	 * @param CidadeDestino the cidade destino
	 * @return the atracoes
	 */
	public static ArrayList<Atracoes> getAtracoes(String CidadeDestino) {
		ArrayList<Atracoes> ArrayListAtracoes = new ArrayList<>();
		System.out.print("(ThirdBase) "); // Log 
		String StringThirdBase = Arquivo.Read(ThirdBase);
		if (StringThirdBase.isEmpty() || StringThirdBase.length() < 5)
			return null;

		JSONArray JArrayStringThirdBase = new JSONArray(StringThirdBase);
		JSONArray NovoJArray = new JSONArray();
		for (int j = 0; j < JArrayStringThirdBase.length(); j++) {
			if (JArrayStringThirdBase.getJSONObject(j).has(CidadeDestino)) {
				NovoJArray = JArrayStringThirdBase.getJSONObject(j).getJSONArray(CidadeDestino);
				System.out.println(CidadeDestino + " "
						+ JArrayStringThirdBase.getJSONObject(j).getJSONArray(CidadeDestino).toString(1));
			}
		}
		if (NovoJArray != null) {
			for (int i = 0; i < NovoJArray.length(); i++) {
				Atracoes NovaAtracao = new Atracoes(NovoJArray.getJSONObject(i));
				ArrayListAtracoes.add(NovaAtracao);
			}
		}
		return ArrayListAtracoes;
	}
}
