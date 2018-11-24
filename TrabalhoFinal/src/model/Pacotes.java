package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

// TODO: Auto-generated Javadoc
/**
 * The Class Pacotes.
 *
 * @author Kesley Nascimento
 */
public class Pacotes {

	/** The Constant basepct. */
	private static final String basepct = "db/teste2pct.txt";

	/** The hotel. */
	private String destino, hotel;

	/** The estadia. */
	private String estadia;

	/** The preco. */
	private String preco;

	/** The agencia. */
	private Agencias agencia;

	/** The lista atracoes. */
	private ArrayList<Atracoes> listaAtracoes;

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param destino the destino
	 * @param hotel   the hotel
	 * @param estadia the estadia
	 * @param preco   the preco
	 */
	public Pacotes(String destino, String hotel, String estadia, String preco) {
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
	}

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param destino the destino
	 * @param hotel   the hotel
	 * @param estadia the estadia
	 * @param preco   the preco
	 * @param agencia the agencia
	 */
	public Pacotes(String destino, String hotel, String estadia, String preco, Agencias agencia) {
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
		this.setAgencia(agencia);
	}

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param json the json
	 */
	public Pacotes(JSONObject json) {
		// System.out.println("Construtor Pacotes(args)\n"+json);
		this.destino = json.getString("destino");
		this.hotel = json.getString("hotel");
		this.estadia = json.getString("estadia");
		this.preco = json.getString("preco");
	}

	/**
	 * Instantiates a new pacotes.
	 *
	 * @param destino       the destino
	 * @param hotel         the hotel
	 * @param estadia       the estadia
	 * @param preco         the preco
	 * @param agencia       the agencia
	 * @param listaAtracoes the lista atracoes
	 */
	public Pacotes(String destino, String hotel, String estadia, String preco, Agencias agencia, ArrayList<Atracoes> listaAtracoes) {
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
		this.setAgencia(agencia);
		this.setListaAtracoes(listaAtracoes);
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
	 * @param destino the destino to set
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
	 * @param hotel the hotel to set
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
	 * @param estadia the estadia to set
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
	 * @param preco the preco to set
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}

	/**
	 * Gets the agencia.
	 *
	 * @return the agencia
	 */
	public Agencias getAgencia() {
		return agencia;
	}

	/**
	 * Sets the agencia.
	 *
	 * @param agencia the agencia to set
	 */
	public void setAgencia(Agencias agencia) {
		this.agencia = agencia;
	}

	/**
	 * Gets the lista atracoes.
	 *
	 * @return the listaAtracoes
	 */
	public ArrayList<Atracoes> getListaAtracoes() {
		return listaAtracoes;
	}

	/**
	 * Sets the lista atracoes.
	 *
	 * @param listaAtracoes the listaAtracoes to set
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
		JSONObject json = new JSONObject();
		json.put("preco", this.preco);
		json.put("estadia", this.estadia);
		json.put("hotel", this.hotel);
		json.put("destino", this.destino);
		//System.out.println("Metodo Pacotes.toJson:\n" + json + "\n");
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
		JSONArray jA = new JSONArray();
		if (!base.isEmpty() && base.length() > 5)	jA = new JSONArray(base);

		jA.put(json);
		Arquivo.Write(basepct, jA.toString());

		return true;
	}

	/**
	 * Gets the pacotes.
	 *
	 * @return the pacotes
	 */
	public static ArrayList<Pacotes> getPacotes() {
		ArrayList<Pacotes> pcts = new ArrayList<Pacotes>();
		String base = Arquivo.Read(basepct);
		//System.out.print("Pacotes.getPacotes(before):\t"+base);		
		if (base.isEmpty() || base.length() < 5)	return null;

		JSONArray jArr = new JSONArray(base);

		for (int i = 0; i < jArr.length(); i++) {
			Pacotes P = new Pacotes(jArr.getJSONObject(i));
			pcts.add(P);
		}
		//System.out.println("Pacotes.getPacotes(after):\t"+pcts);
		return pcts;
	}

}
