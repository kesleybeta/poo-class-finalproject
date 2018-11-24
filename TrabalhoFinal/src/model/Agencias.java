package model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Agencias.
 *
 * @author Kesley Nascimento
 */
public class Agencias {

	/** The website. */
	private String nome, website;
	
	/** The uf. */
	private String bairro, cidade, uf;
	
	/** The lista pacotes. */
	private ArrayList<Pacotes> listaPacotes;
	
	/**
	 * Instantiates a new agencias.
	 */
	public Agencias() {
		
	}

	/**
	 * Instantiates a new agencias.
	 *
	 * @param nome the nome
	 * @param website the website
	 * @param bairro the bairro
	 * @param cidade the cidade
	 * @param uf the uf
	 * @param listaPacotes the lista pacotes
	 */
	public Agencias(String nome, String website, String bairro, String cidade, String uf,
			ArrayList<Pacotes> listaPacotes) {
		this.setNome(nome);
		this.setWebsite(website);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.listaPacotes = listaPacotes;
	}

	/**
	 * Adds the pacote.
	 *
	 * @param pct the pct
	 */
	public void addPacote(Pacotes pct) {
		pct.setAgencia(this);
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

}
