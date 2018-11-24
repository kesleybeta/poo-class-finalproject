
package model;

/**
 * The Class Atracoes.
 *
 * @author Kesley Nascimento
 */
public class Atracoes {

	/** O nome da atração. */
	private String nome;

	/** O tipo da atração. Ex: Museu, Teatro, Praia, etc. */
	private String tipo;

	/** The pacote. */
	private Pacotes pacote;

	/**
	 * Instantiates a new atracoes.
	 *
	 * @param nome   the nome
	 * @param tipo   the tipo
	 * @param pacote the pacote
	 */
	public Atracoes(String nome, String tipo, Pacotes pacote) {
		this.setNome(nome);
		this.setTipo(tipo);
		this.setPacote(pacote);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the pacote
	 */
	public Pacotes getPacote() {
		return pacote;
	}

	/**
	 * @param pacote the pacote to set
	 */
	public void setPacote(Pacotes pacote) {
		this.pacote = pacote;
	}
}
