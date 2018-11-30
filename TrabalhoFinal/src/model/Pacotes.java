package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

public class Pacotes {

	private static final String basepct = "db/teste101.txt";

	private String destino, hotel;
	private String estadia;
	private String preco;
	private ArrayList<Atracoes> listaAtracoes;

	public Pacotes() {

	}

	public Pacotes(String destino, String hotel, String estadia, String preco) {
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
	}

	public Pacotes(JSONObject json) {
		System.out.println("Construtor Pacotes() >>> " + json);
		this.destino = json.getString("destino");
		this.hotel = json.getString("hotel");
		this.estadia = json.getString("estadia");
		this.preco = json.getString("preco");
	}

	public Pacotes(String destino, String hotel, String estadia, String preco, ArrayList<Atracoes> listaAtracoes) {
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
		this.setListaAtracoes(listaAtracoes);
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getEstadia() {
		return estadia;
	}

	public void setEstadia(String estadia) {
		this.estadia = estadia;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public ArrayList<Atracoes> getListaAtracoes() {
		return listaAtracoes;
	}

	public void setListaAtracoes(ArrayList<Atracoes> listaAtracoes) {
		this.listaAtracoes = listaAtracoes;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("preco", this.preco);
		json.put("estadia", this.estadia);
		json.put("hotel", this.hotel);
		json.put("destino", this.destino);
		System.out.println("Converter Objeto toJson:\n" + json + "\n");
		return json;
	}

	public boolean Persistir() {
		JSONObject json = this.toJson();
		String base = Arquivo.Read(basepct);
		JSONArray jA = new JSONArray();

		if (!base.isEmpty() && base.length() > 5)
			jA = new JSONArray(base);

		jA.put(json);
		System.out.println("Persisitr PACOTE >> " + jA.toString());
		Arquivo.Write(basepct, jA.toString());

		return true;
	}

	public static ArrayList<Pacotes> getPacotes(int index) {

		String baseage = Arquivo.Read(Agencias.getBasefile());
		JSONArray jpac = new JSONArray(baseage);
		//System.out.println("JSONArray(" + index + ") " + jpac.getJSONObject(index));
		JSONArray lPct = jpac.getJSONObject(index).getJSONArray("pacote");
		Arquivo.Write("db/teste101.txt", lPct.toString());

		ArrayList<Pacotes> pcts = new ArrayList<Pacotes>();
		String base = Arquivo.Read(basepct);
		System.out.print("getPacotes() >>> " + base);
		if (base.isEmpty() || base.length() < 5)
			return null;

		JSONArray jArr = new JSONArray(base);
		for (int i = 0; i < jArr.length(); i++) {
			Pacotes P = new Pacotes(jArr.getJSONObject(i));
			pcts.add(P);
		}
		// System.out.println("Pacotes.getPacotes(after):\t"+pcts);
		return pcts;
	}

	@Override
	public String toString() {
		return "{" + destino + "; " + hotel + "; " + estadia + "; " + preco + "; " + listaAtracoes + "}";
	}
}
