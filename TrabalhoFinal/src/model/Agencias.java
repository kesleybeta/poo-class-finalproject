package model;

import java.util.ArrayList;

import json.JSONArray;
import json.JSONObject;
import util.Arquivo;

public class Agencias {

	private static final String basefile = "db/teste006.txt";
	private String nome, website;
	private String bairro, cidade, uf;
	private ArrayList<Pacotes> listaPacotes;

	public Agencias() {
	}

	public static void CriaArquivoPacote(JSONObject jso) { // algo parecido com isso
		JSONArray lPct = jso.getJSONArray("pacote");
		Arquivo.Write("db/teste101.txt", lPct.toString());
	}

	public Agencias(JSONObject json) {
		System.out.println("ConstrutorAgencias >> " + json);
		listaPacotes = new ArrayList<>();
		this.nome = json.getString("nome");
		this.website = json.getString("site");
		this.bairro = json.getString("bairro");
		this.cidade = json.getString("cidade");
		this.uf = json.getString("uf");

		JSONArray lPct = json.getJSONArray("pacote");
		//		Arquivo.Write("db/teste101.txt", lPct.toString());

		for (int i = 0; i < lPct.length(); i++)
			System.out.println("\tPacote(" + i + ") " + lPct.get(i));
	}

	public Agencias(String nome, String website, String bairro, String cidade, String uf) {
		listaPacotes = new ArrayList<>();
		this.nome = nome;
		this.website = website;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Agencias(String nome, String website, String bairro, String cidade, String uf, Pacotes pacote) {
		listaPacotes = new ArrayList<>();
		this.setNome(nome);
		this.setWebsite(website);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.addListaPacotes(pacote);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public ArrayList<Pacotes> getListaPacotes() {
		return listaPacotes;
	}

	public String getStrignPacotes() {
		String pacotera = null;

		return pacotera;
	}

	public void setListaPacotes(ArrayList<Pacotes> listaPacotes) {
		this.listaPacotes = listaPacotes;
	}

	public void addListaPacotes(Pacotes Pacote) {
		listaPacotes.add(Pacote);
	}

	public JSONObject toJson() { // -------- Momento de criacao das labels
		JSONObject json = new JSONObject();
		json.put("nome", this.nome);
		json.put("site", this.website);
		json.put("bairro", this.bairro);
		json.put("cidade", this.cidade);
		json.put("uf", this.uf);
		// json.put("pacote", this.listaPacotes);

		System.out.println("toJson:\n\t" + json + "\n");

		return json;
	}

	public boolean Persistir() {
		JSONObject json = this.toJson();

		String base = Arquivo.Read(getBasefile());
		System.out.println("Persistir.BASE " + base.length());
		JSONArray jA = new JSONArray();
		if (!base.isEmpty() && base.length() > 5) // Se a base não estiver vazia
			jA = new JSONArray(base);

		jA.put(json);
		Arquivo.Write(getBasefile(), jA.toString());

		return true;
	}

	public static ArrayList<Agencias> getAgencias() {
		ArrayList<Agencias> agen = new ArrayList<Agencias>();

		String base = Arquivo.Read(getBasefile());
		if (base.isEmpty() || base.length() < 5)
			return null;

		JSONArray jArr = new JSONArray(base);
		for (int i = 0; i < jArr.length(); i++) {
			System.out.println("JSONArray(" + i + ") " + jArr.getJSONObject(i));
			Agencias A = new Agencias(jArr.getJSONObject(i));
			//			System.out.println("object(" + i + "):\t" + A);
			agen.add(A);
		}
		//		System.out.println("arraylist: " + agen);
		return agen;
	}

	@Override
	public String toString() {
		return "{" + nome + "; " + website + "; " + bairro + "; " + cidade + "; " + uf + "; " + listaPacotes + "}";
	}

	public static String getBasefile() {
		return basefile;
	}
}
