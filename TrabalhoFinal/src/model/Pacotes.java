package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

public class Pacotes {

	private static final String basepct = "db/secondbase.txt";

	private String pais, destino, hotel;
	private String estadia, preco;
	private ArrayList<Atracoes> listaAtracoes;

	public Pacotes() {

	}

	public Pacotes(String pais, String destino, String hotel, String estadia, String preco) {
		this.setPais(pais);
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
	}

	public Pacotes(JSONObject json) {
//		System.out.println("Construtor Pacotes() >>> " + json);
		this.pais = json.getString("pais");
		this.destino = json.getString("destino");
		this.hotel = json.getString("hotel");
		this.estadia = json.getString("estadia");
		this.preco = json.getString("preco");
	}

	public Pacotes(String pais, String destino, String hotel, String estadia, String preco, ArrayList<Atracoes> listaAtracoes) {
		this.setPais(pais);
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
		this.setListaAtracoes(listaAtracoes);
	}

	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
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
		json.put("pais", this.pais);
		json.put("preco", this.preco);
		json.put("estadia", this.estadia);
		json.put("hotel", this.hotel);
		json.put("destino", this.destino);
//		System.out.println("Converte Objeto toJson: " + json + "\n");
		return json;
	}

	public boolean Persistir() {
		JSONObject json = this.toJson();
		System.out.print("|SecondBase|");
		String base = Arquivo.Read(basepct);
		JSONArray jA = new JSONArray();
		if (!base.isEmpty() && base.length() > 5)
			jA = new JSONArray(base);
		jA.put(json);
//		System.out.println("Persisitr PACOTE >> " + jA.toString());
		Arquivo.Write(basepct, jA.toString());
		return true;
	}
	
	public static void Excluir(int indexA, int indexP) {
//		System.out.print("\nINDEX AGENCIA: "+indexA);
//		System.out.println("\tINDEX PACOTE: "+indexP);
		System.out.print("|SecondBase|");
		String baseAge = Arquivo.Read(Agencias.getBasefile());
		JSONArray jarrAge = new JSONArray(baseAge);
//		System.out.println("jarrAge(" + indexA + ") " + jarrAge.getJSONObject(indexA));
		JSONArray lPct = jarrAge.getJSONObject(indexA).getJSONArray("pacote");
		Arquivo.Write(basepct, lPct.toString());

		lPct.remove(indexP);
		
//		System.out.println("\nEdicaoDeObjetoPacote > "+ this);
		for (int i = 0; i < jarrAge.length(); i++) {
			System.out.println("i >>" + jarrAge.get(i));
		}
		
		Arquivo.Write(Agencias.getBasefile(), jarrAge.toString());
	}
	
	public boolean Editar(int indexA, int indexP) {

//		System.out.print("\nINDEX AGENCIA: "+indexA);
//		System.out.println("\tINDEX PACOTE: "+indexP);
		System.out.print("|SecondBase|");
		String baseAge = Arquivo.Read(Agencias.getBasefile());
		JSONArray jarrAge = new JSONArray(baseAge);
//		System.out.println("jarrAge(" + indexA + ") " + jarrAge.getJSONObject(indexA));
		JSONArray lPct = jarrAge.getJSONObject(indexA).getJSONArray("pacote");
		Arquivo.Write(basepct, lPct.toString());
		
		lPct.getJSONObject(indexP).put("pais", this.pais);
		lPct.getJSONObject(indexP).put("preco", this.preco);
		lPct.getJSONObject(indexP).put("estadia", this.estadia);
		lPct.getJSONObject(indexP).put("hotel", this.hotel);
		lPct.getJSONObject(indexP).put("destino", this.destino);
		
//		System.out.println("\nEdicaoDeObjetoPacote > "+ this);
		for (int i = 0; i < jarrAge.length(); i++) {
			System.out.println("i >>" + jarrAge.get(i));
		}
		
		Arquivo.Write(Agencias.getBasefile(), jarrAge.toString());
		return true;
	}

	public boolean Persistir(int index) {
		System.out.print("|SecondBase|");
		String baseAge = Arquivo.Read(Agencias.getBasefile());
		JSONArray jarrAge = new JSONArray(baseAge);
//		System.out.println("jarrAge(" + index + ") " + jarrAge.getJSONObject(index));
		JSONArray lPct = jarrAge.getJSONObject(index).getJSONArray("pacote");
		Arquivo.Write(basepct, lPct.toString());

//		System.out.println("\nNovoObjetoPacote > "+this);
		JSONObject NovoPacote = this.toJson();
		String basePac = Arquivo.Read(basepct);

		JSONArray jarrBasePac = new JSONArray();
		if (!basePac.isEmpty() && basePac.length() > 5)
			jarrBasePac = new JSONArray(basePac);

		jarrBasePac.put(NovoPacote);
//		System.out.println("Persistir PACOTE >> " + jarrBasePac.toString());
		Arquivo.Write(basepct, jarrBasePac.toString());

		JSONObject jo = jarrAge.getJSONObject(index);
		jo.put("pacote", jarrBasePac);
		
//		for (int i = 0; i < jarrAge.length(); i++) {
//			System.out.println("i >>" + jarrAge.get(i));
//		}
		
		Arquivo.Write(Agencias.getBasefile(), jarrAge.toString());
		return true;
	}

	public static ArrayList<Pacotes> getPacotes(int index) {
		System.out.print("|FirstBase|");
		String baseage = Arquivo.Read(Agencias.getBasefile());
		JSONArray jarrAge = new JSONArray(baseage);
		//System.out.println("jarrAge(" + index + ") " + jarrAge.getJSONObject(index));
		JSONArray lPct = jarrAge.getJSONObject(index).getJSONArray("pacote");
		Arquivo.Write(basepct, lPct.toString());

		ArrayList<Pacotes> pcts = new ArrayList<Pacotes>();
		System.out.print("|SecondBase|");
		String base = Arquivo.Read(basepct);
//		System.out.print("getPacotes() >>> " + base);
		if (base.isEmpty() || base.length() < 5)
			return null;

		JSONArray jarrPct = new JSONArray(base);
		for (int i = 0; i < jarrPct.length(); i++) {
			Pacotes P = new Pacotes(jarrPct.getJSONObject(i));
			pcts.add(P);
		}
//		System.out.println("Pacotes.getPacotes(after):\t"+pcts);

		return pcts;
	}

	@Override
	public String toString() {
		return "{" + pais + "; " + destino + "; " + hotel + "; " + estadia + "; " + preco + "}";
	}
}
