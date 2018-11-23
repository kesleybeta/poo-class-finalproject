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
	
	/** The estado. */
	private String bairro, cidade, estado;
	
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
	 * @param estado the estado
	 * @param listaPacotes the lista pacotes
	 */
	public Agencias(String nome, String website, String bairro, String cidade, String estado,
			ArrayList<Pacotes> listaPacotes) {
		super();
		this.setNome(nome);
		this.setWebsite(website);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);
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
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
