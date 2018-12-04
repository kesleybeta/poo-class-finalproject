
package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

/**
 * The Class Agencias.
 *
 * @author Kesley Nascimento
 * @version 18.12.03.1624
 * @since 18.11.23.2059
 */
public class Agencias {

	/** The Constant FirstBase. */
	private static final String FirstBase = "firstbase";

	/** The website. */
	private String nome;
	
	/** The website. */
	private String website;

	/** The bairro. */
	private String bairro;
	
	/** The cidade. */
	private String cidade;
	
	/** The uf. */
	private String uf;

	/** The lista pacotes. */
	private ArrayList<Pacotes> listaPacotes = null;

	/**
	 * Instantiates a new agencias.
	 */
	public Agencias() {
	}

	/**
	 * Instantiates a new agencias.
	 *
	 * @param NovoJObject the novo Json object
	 */
	public Agencias(JSONObject NovoJObject) {
		listaPacotes = new ArrayList<>();
		this.nome = NovoJObject.getString("nome");
		this.website = NovoJObject.getString("site");
		this.bairro = NovoJObject.getString("bairro");
		this.cidade = NovoJObject.getString("cidade");
		this.uf = NovoJObject.getString("uf");
		JSONArray JArrayPacotes = NovoJObject.getJSONArray("pacote");
		JSONObject JObjectPacote;
		if (!JArrayPacotes.isNull(0)) {
			for (int i = 0; i < JArrayPacotes.length(); i++) {
				JObjectPacote = JArrayPacotes.getJSONObject(i);
				Pacotes pct = new Pacotes(JObjectPacote);
				addListaPacotes(pct);
			}
		}
	}

	/**
	 * Instantiates a new agencias.
	 *
	 * @param nome    the nome
	 * @param website the website
	 * @param bairro  the bairro
	 * @param cidade  the cidade
	 * @param uf      the uf
	 */
	public Agencias(String nome, String website, String bairro, String cidade, String uf) {
		listaPacotes = new ArrayList<>();
		this.nome = nome;
		this.website = website;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	/**
	 * Instantiates a new agencias.
	 *
	 * @param nome    the nome
	 * @param website the website
	 * @param bairro  the bairro
	 * @param cidade  the cidade
	 * @param uf      the uf
	 * @param pacote  the pacote
	 */
	public Agencias(String nome, String website, String bairro, String cidade, String uf, ArrayList<Pacotes> pacote) {
		listaPacotes = new ArrayList<>();
		this.setNome(nome);
		this.setWebsite(website);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setListaPacotes(listaPacotes);
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
	 * Gets the website.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 *
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Gets the cidade.
	 *
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Sets the cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Gets the uf.
	 *
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * Sets the uf.
	 *
	 * @param uf the new uf
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * Gets the lista pacotes.
	 *
	 * @return the lista pacotes
	 */
	public ArrayList<Pacotes> getListaPacotes() {
		return listaPacotes;
	}

	/**
	 * Sets the lista pacotes.
	 *
	 * @param listaPacotes the new lista pacotes
	 */
	public void setListaPacotes(ArrayList<Pacotes> listaPacotes) {
		this.listaPacotes = listaPacotes;
	}

	/**
	 * Adds the lista pacotes.
	 *
	 * @param Pacote the pacote
	 */
	public void addListaPacotes(Pacotes Pacote) {
		listaPacotes.add(Pacote);
	}

	/**
	 * To json.
	 *
	 * @return the JSON object
	 */
	public JSONObject toJson() {
		JSONObject JObject = new JSONObject();
		JObject.put("nome", this.nome);
		JObject.put("site", this.website);
		JObject.put("bairro", this.bairro);
		JObject.put("cidade", this.cidade);
		JObject.put("uf", this.uf);
		JObject.put("pacote", this.listaPacotes);
		return JObject;
	}

	/**
	 * Excluir.
	 *
	 * @param index the index
	 */
	public static void Excluir(int index) {
		System.out.print("(FirstBase) ");
		String StringFirstBase = Arquivo.Read(getFirstBase());
		JSONArray JArrFirstBase = new JSONArray(StringFirstBase);
		JArrFirstBase.remove(index);
		Arquivo.Write(getFirstBase(), JArrFirstBase.toString());
	}

	/**
	 * Editar.
	 *
	 * @param index the index
	 * @return true, if successful
	 */
	public boolean Editar(int index) {
		System.out.print("(FirstBase) ");
		String StringFirstBase = Arquivo.Read(getFirstBase());
		JSONArray JArrFirstBase = new JSONArray(StringFirstBase);
		JArrFirstBase.getJSONObject(index).put("nome", this.nome);
		JArrFirstBase.getJSONObject(index).put("site", this.website);
		JArrFirstBase.getJSONObject(index).put("bairro", this.bairro);
		JArrFirstBase.getJSONObject(index).put("cidade", this.cidade);
		JArrFirstBase.getJSONObject(index).put("uf", this.uf);
		Arquivo.Write(getFirstBase(), JArrFirstBase.toString());
		return true;
	}

	/**
	 * Persistir.
	 *
	 * @return true, if successful
	 */
	public boolean Persistir() {
		JSONObject JsonNovaAgencia = this.toJson();
		System.out.print("(FirstBase) ");
		String StringFirstBase = Arquivo.Read(getFirstBase());
		JSONArray NovoJArray = new JSONArray();
		if (!StringFirstBase.isEmpty() && StringFirstBase.length() > 1) // Se a base não estiver vazia
			NovoJArray = new JSONArray(StringFirstBase);
		NovoJArray.put(JsonNovaAgencia);
		Arquivo.Write(getFirstBase(), NovoJArray.toString());
		return true;
	}

	/**
	 * Gets the agencias.
	 *
	 * @return the agencias
	 */
	public static ArrayList<Agencias> getAgencias() {
		ArrayList<Agencias> ArrayListAgencias = new ArrayList<Agencias>();
		System.out.print("(FirstBase) ");
		String StringFirstBase = Arquivo.Read(getFirstBase());
		if (StringFirstBase.isEmpty() || StringFirstBase.length() < 1)
			return null;
		JSONArray JArrStringFirstBase = new JSONArray(StringFirstBase);
		for (int i = 0; i < JArrStringFirstBase.length(); i++) {
			Agencias NovaAgencia = new Agencias(JArrStringFirstBase.getJSONObject(i));
			ArrayListAgencias.add(NovaAgencia);
		}
		return ArrayListAgencias;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{" + nome + "; " + website + "; " + bairro + "; " + cidade + "; " + uf + "; " + listaPacotes + "}";
	}

	/**
	 * Gets the FirstBase.
	 *
	 * @return the FirstBase
	 */
	public static String getFirstBase() {
		return FirstBase;
	}
}
