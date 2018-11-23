package model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Pacotes.
 *
 * @author Kesley Nascimento
 */
public class Pacotes {
	
	/** The hotel. */
	private String destino, hotel;
	
	/** The estadia. */
	private int estadia;
	
	/** The preco. */
	private double preco;
	
	/** The agencia. */
	private Agencias agencia;
	
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
	 * @param destino the destino
	 * @param hotel the hotel
	 * @param estadia the estadia
	 * @param preco the preco
	 * @param agencia the agencia
	 * @param listaAtracoes the lista atracoes
	 */
	public Pacotes(String destino, String hotel, int estadia, double preco, Agencias agencia,
			ArrayList<Atracoes> listaAtracoes) {
		this.setDestino(destino);
		this.setHotel(hotel);
		this.setEstadia(estadia);
		this.setPreco(preco);
		this.setAgencia(agencia);
		this.setListaAtracoes(listaAtracoes);
	}

	/**
	 * Persistir.
	 *
	 * @return true, if successful
	 */
	public boolean Persistir() {
		return true;
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
	public int getEstadia() {
		return estadia;
	}

	/**
	 * Sets the estadia.
	 *
	 * @param estadia the estadia to set
	 */
	public void setEstadia(int estadia) {
		this.estadia = estadia;
	}

	/**
	 * Gets the preco.
	 *
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Sets the preco.
	 *
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
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
	
	
}
