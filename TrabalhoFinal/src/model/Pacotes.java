package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

/**
 * The Class Pacotes.
 * 
 * @author Kesley Nascimento
 * @since 18.11.23.2059
 * @version 18.12.03.1624
 */
public class Pacotes {

	/** The Constant SecondBase. */
	private static final String SecondBase = "secondbase";

	/** The pais. */
	private String pais;

	/** The destino. */
	private String destino;

	/** The hotel. */
	private String hotel;

	/** The estadia. */
	private String estadia;

	/** The preco. */
	private String preco;

	/** The lista atracoes. */
	private ArrayList<Atracoes> listaAtracoes;

	/**
	 * Instantiates a new pacotes.
	 */
	public Pacotes() {
	}

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param pais    the pais
	 * @param destino the destino
	 * @param hotel   the hotel
	 * @param estadia the estadia
	 * @param preco   the preco
	 */
	public Pacotes(String pais, String destino, String hotel, String estadia, String preco) {
		this.setPais(pais);
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
	}

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param NovoJObject the novo J object
	 */
	public Pacotes(JSONObject NovoJObject) {
		this.pais = NovoJObject.getString("pais");
		this.destino = NovoJObject.getString("destino");
		this.hotel = NovoJObject.getString("hotel");
		this.estadia = NovoJObject.getString("estadia");
		this.preco = NovoJObject.getString("preco");
	}

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param pais          the pais
	 * @param destino       the destino
	 * @param hotel         the hotel
	 * @param estadia       the estadia
	 * @param preco         the preco
	 * @param listaAtracoes the lista atracoes
	 */
	public Pacotes(String pais, String destino, String hotel, String estadia, String preco,
			ArrayList<Atracoes> listaAtracoes) {
		this.setPais(pais);
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
		this.setListaAtracoes(listaAtracoes);
	}

	/**
	 * Gets the pais.
	 *
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Sets the pais.
	 *
	 * @param pais the new pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Gets the destino.
	 *
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Sets the destino.
	 *
	 * @param destino the new destino
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * Gets the hotel.
	 *
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}

	/**
	 * Sets the hotel.
	 *
	 * @param hotel the new hotel
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	/**
	 * Gets the estadia.
	 *
	 * @return the estadia
	 */
	public String getEstadia() {
		return estadia;
	}

	/**
	 * Sets the estadia.
	 *
	 * @param estadia the new estadia
	 */
	public void setEstadia(String estadia) {
		this.estadia = estadia;
	}

	/**
	 * Gets the preco.
	 *
	 * @return the preco
	 */
	public String getPreco() {
		return preco;
	}

	/**
	 * Sets the preco.
	 *
	 * @param preco the new preco
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}

	/**
	 * Gets the lista atracoes.
	 *
	 * @return the lista atracoes
	 */
	public ArrayList<Atracoes> getListaAtracoes() {
		return listaAtracoes;
	}

	/**
	 * Sets the lista atracoes.
	 *
	 * @param listaAtracoes the new lista atracoes
	 */
	public void setListaAtracoes(ArrayList<Atracoes> listaAtracoes) {
		this.listaAtracoes = listaAtracoes;
	}

	/**
	 * To json.
	 *
	 * @return the JSON object
	 */
	public JSONObject toJson() {
		JSONObject NovoJObject = new JSONObject();
		NovoJObject.put("pais", this.pais);
		NovoJObject.put("preco", this.preco);
		NovoJObject.put("estadia", this.estadia);
		NovoJObject.put("hotel", this.hotel);
		NovoJObject.put("destino", this.destino);

		return NovoJObject;
	}

	/**
	 * Persistir.
	 *
	 * @return true, if successful
	 */
	public boolean Persistir() {
		JSONObject JObjectNovoPacote = this.toJson();
		System.out.print("(SecondBase) ");
		String StringSecondBase = Arquivo.Read(SecondBase);
		JSONArray jA = new JSONArray();
		if (!StringSecondBase.isEmpty() && StringSecondBase.length() > 5)
			jA = new JSONArray(StringSecondBase);
		jA.put(JObjectNovoPacote);

		Arquivo.Write(SecondBase, jA.toString());
		return true;
	}

	/**
	 * Excluir.
	 *
	 * @param indexAgencia the index agencia
	 * @param indexPacote  the index pacote
	 */
	public static void Excluir(int indexAgencia, int indexPacote) {
		System.out.print("(FirstBase) ");
		String StringFirstBase = Arquivo.Read(Agencias.getFirstBase());
		JSONArray JArrayStringFirstBase = new JSONArray(StringFirstBase);
		JSONArray getJArrayFirstBasePacote = JArrayStringFirstBase.getJSONObject(indexAgencia).getJSONArray("pacote");
		Arquivo.Write(SecondBase, getJArrayFirstBasePacote.toString());
		getJArrayFirstBasePacote.remove(indexPacote);
		for (int i = 0; i < JArrayStringFirstBase.length(); i++)
			System.out.println("i >>" + JArrayStringFirstBase.get(i));

		Arquivo.Write(Agencias.getFirstBase(), JArrayStringFirstBase.toString());
	}

	/**
	 * Editar.
	 *
	 * @param indexAgencia the index agencia
	 * @param indexPacote  the index pacote
	 * @return true, if successful
	 */
	public boolean Editar(int indexAgencia, int indexPacote) {
		System.out.print("(FirstBase) ");
		String StringFirstBase = Arquivo.Read(Agencias.getFirstBase());
		JSONArray JArrayStringFirstBase = new JSONArray(StringFirstBase);
		JSONArray getJArrayFirstBasePacote = JArrayStringFirstBase.getJSONObject(indexAgencia).getJSONArray("pacote");
		Arquivo.Write(SecondBase, getJArrayFirstBasePacote.toString());

		getJArrayFirstBasePacote.getJSONObject(indexPacote).put("pais", this.pais);
		getJArrayFirstBasePacote.getJSONObject(indexPacote).put("preco", this.preco);
		getJArrayFirstBasePacote.getJSONObject(indexPacote).put("estadia", this.estadia);
		getJArrayFirstBasePacote.getJSONObject(indexPacote).put("hotel", this.hotel);
		getJArrayFirstBasePacote.getJSONObject(indexPacote).put("destino", this.destino);

		Arquivo.Write(Agencias.getFirstBase(), JArrayStringFirstBase.toString());
		return true;
	}

	/**
	 * Persistir.
	 *
	 * @param index the index
	 * @return true, if successful
	 */
	public boolean Persistir(int index) {
		System.out.print("(FirstBase) "); // log to console
		String StringFirstBase = Arquivo.Read(Agencias.getFirstBase());
		JSONArray JArrayStringFirstBase = new JSONArray(StringFirstBase);

		JSONArray getJArrayFirstBasePacote = JArrayStringFirstBase.getJSONObject(index).getJSONArray("pacote");
		Arquivo.Write(SecondBase, getJArrayFirstBasePacote.toString());

		JSONObject JObjectNovoPacote = this.toJson();
		System.out.print("SecondBase) "); // log to console
		String StringSecondBase = Arquivo.Read(SecondBase);

		JSONArray JArrayStringSecondBase = new JSONArray();
		if (!StringSecondBase.isEmpty() && StringSecondBase.length() > 5)
			JArrayStringSecondBase = new JSONArray(StringSecondBase);

		JArrayStringSecondBase.put(JObjectNovoPacote);

		Arquivo.Write(SecondBase, JArrayStringSecondBase.toString());

		JSONObject JObjectJArrFirstBaseIndex = JArrayStringFirstBase.getJSONObject(index);
		JObjectJArrFirstBaseIndex.put("pacote", JArrayStringSecondBase);

		Arquivo.Write(Agencias.getFirstBase(), JArrayStringFirstBase.toString());
		return true;
	}

	/**
	 * Gets the pacotes.
	 *
	 * @param index the index
	 * @return the pacotes
	 */
	public static ArrayList<Pacotes> getPacotes(int index) {
		System.out.print("(FirstBase) "); // log to console
		String StringFirstBase = Arquivo.Read(Agencias.getFirstBase());
		JSONArray JArrayStringFirstBase = new JSONArray(StringFirstBase);

		JSONArray getJArrayFirstBasePacote = JArrayStringFirstBase.getJSONObject(index).getJSONArray("pacote");
		Arquivo.Write(SecondBase, getJArrayFirstBasePacote.toString());

		ArrayList<Pacotes> ArrayListPacotes = new ArrayList<Pacotes>();
		System.out.print("(SecondBase) "); // log to console
		String StringSecondBase = Arquivo.Read(SecondBase);

		if (StringSecondBase.isEmpty() || StringSecondBase.length() < 5)
			return null;

		JSONArray JArrayStringSecondBase = new JSONArray(StringSecondBase);
		for (int i = 0; i < JArrayStringSecondBase.length(); i++) {
			Pacotes P = new Pacotes(JArrayStringSecondBase.getJSONObject(i));
			ArrayListPacotes.add(P);
		}

		System.out.println(JArrayStringFirstBase.getJSONObject(index).getJSONArray("pacote").toString(1));
		return ArrayListPacotes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{" + pais + "; " + destino + "; " + hotel + "; " + estadia + "; " + preco + "}";
	}
}
