package model;

import java.util.ArrayList;

import controller.ControlePacotes;
import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

// TODO: Auto-generated Javadoc
/**
 * The Class Agencias.
 *
 * @author Kesley Nascimento
 */
public class Agencias {

	/** The Constant basepct. */
	private static final String basepct = "db/teste001.txt";

	/** The website. */
	private String nome, website;

	/** The uf. */
	private String bairro, cidade, uf;

	/** The lista pacotes. */
	private ArrayList<Pacotes> listaPacotes = null;

	/**
	 * Instantiates a new agencias.
	 */
	public Agencias() {
		listaPacotes = new ArrayList<>();

	}

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param json the json
	 */
	public Agencias(JSONObject json) {
		listaPacotes = new ArrayList<>();
		// System.out.println("Construtor json: " + json);
		this.nome = json.getString("nome");
		this.website = json.getString("site");
		this.bairro = json.getString("bairro");
		this.cidade = json.getString("cidade");
		this.uf = json.getString("uf");
		
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
	 * @param nome         the nome
	 * @param website      the website
	 * @param bairro       the bairro
	 * @param cidade       the cidade
	 * @param uf           the uf
	 * @param listaPacotes the lista pacotes
	 */
	public Agencias(String nome, String website, String bairro, String cidade, String uf, Pacotes pacote) {
		listaPacotes = new ArrayList<>();
		this.setNome(nome);
		this.setWebsite(website);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.addListaPacotes(pacote);
	}

	/**
	 * Adds the pacote.
	 *
	 * @param pct the pct
	 */
	public void addPacote(Pacotes pct) {
		listaPacotes.add(pct);
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
	 * @param nome the nome to set
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
	 * @param website the website to set
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
	 * @param bairro the bairro to set
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
	 * @param cidade the cidade to set
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
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * Gets the lista pacotes.
	 *
	 * @return the listaPacotes
	 */
	public ArrayList<Pacotes> getListaPacotes() {
		return listaPacotes;
	}

	/**
	 * Sets the lista pacotes.
	 *
	 * @param listaPacotes the listaPacotes to set
	 */
	public void setListaPacotes(ArrayList<Pacotes> listaPacotes) {
		this.listaPacotes = listaPacotes;
	}
	
	public void addListaPacotes(Pacotes Pacote) {
		listaPacotes.add(Pacote);
	}

	/**
	 * To json.
	 *
	 * @return the JSON object
	 */
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("nome", this.nome);
		json.put("site", this.website);
		json.put("bairro", this.bairro);
		json.put("cidade", this.cidade);
		json.put("uf", this.uf);
		json.put("pacote", ControlePacotes.getPacotes());
//Criar um objeto Pacotes aqui mesmo.

		
		System.out.println("toJson:\n" + json + "\n");
		return json;
	}

	/**
	 * Persistir.
	 *
	 * @return true, if successful
	 */
	public boolean Persistir() {
		JSONObject json = this.toJson();
		String base = Arquivo.Read(basepct);
		//System.out.println("Persistir.BASE "+base);
		JSONArray jA = new JSONArray();
		if (!base.isEmpty() && base.length() > 5)
			jA = new JSONArray(base);

		jA.put(json);
		Arquivo.Write(basepct, jA.toString());

		return true;
	}

	/**
	 * Gets the pacotes.
	 *
	 * @return the pacotes
	 */
	public static ArrayList<Agencias> getAgencias() {
		ArrayList<Agencias> agen = new ArrayList<Agencias>();
		String base = Arquivo.Read(basepct);
		if (base.isEmpty() || base.length() < 5)
			return null;

		JSONArray jArr = new JSONArray(base);

		for (int i = 0; i < jArr.length(); i++) {
			Agencias A = new Agencias(jArr.getJSONObject(i));
			System.out.println("object(" + i + "):\t" + A);
			agen.add(A);
			System.out.println("arraylist: " + agen);
		}
		return agen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{" + nome + ", " + website + ", " + bairro + ", " + cidade + ", " + uf + ", " + listaPacotes + "}";
	}
}
