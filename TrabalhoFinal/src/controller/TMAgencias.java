package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * The Class TMAgencias.
 *
 * @author Kesley Nascimento
 * @version 18.12.01.1600
 */
public class TMAgencias extends AbstractTableModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7959961973467887108L;

	/** The linhas. */
	private List<String[]> linhas = null;

	/** The colunas. */
	private String[] colunas = new String[] { "Agências" };

	/**
	 * Instantiates a new Table Model Agencias vazia.
	 */
	public TMAgencias() {
		linhas = new ArrayList<String[]>();
	}

	/**
	 * Instantiates a new Table Model Agencias.
	 *
	 * @param lista the lista
	 */
	public TMAgencias(List<String[]> lista) {
		linhas = new ArrayList<String[]>(lista);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return linhas.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String t[] = linhas.get(rowIndex);

		// Preenche a tabela.
		switch (columnIndex) {
		case 0:
			return t[0];
		default:
			throw new IndexOutOfBoundsException("ColumnIndex out of bounds");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int,
	 * int)
	 */
	@Override
	// modifica na linha e coluna especificada
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String t[] = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

		switch (columnIndex) { // Seta o valor do campo respectivo
		case 0:
			t[0] = aValue.toString();
			break;
		default:
			// Isto não deveria acontecer...
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	/**
	 * Sets the value at.
	 *
	 * @param aValue   the a value
	 * @param rowIndex the row index
	 */
	// modifica na linha especificada
	public void setValueAt(String aValue[], int rowIndex) {
		String t[] = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

		t[0] = aValue[0];

		fireTableCellUpdated(rowIndex, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * Gets the registro.
	 *
	 * @param indiceLinha the indice linha
	 * @return the registro
	 */
	public String[] getRegistro(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	/**
	 * Adds the pacote.
	 *
	 * @param a the a
	 */
	public void addRegistro(String a[]) {
		// Adiciona o registro.
		linhas.add(a);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	/**
	 * Remove a linha especificada.
	 *
	 * @param indiceLinha the indice linha
	 */
	public void remove(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	/**
	 * Adiciona uma lista ao final dos registros.
	 *
	 * @param a the a
	 */
	public void addLista(List<String[]> a) {
		// Pega o tamanho antigo da tabela.
		int tamanhoAntigo = getRowCount();
		// Adiciona os registros.
		linhas.addAll(a);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	/**
	 * Remove todos os registros. Metodo Limpar.
	 */
	public void limpar() {
		linhas.clear();
		fireTableDataChanged();
	}

	/**
	 * Verifica se este table model esta vazio.
	 *
	 * @return true, if is empty
	 */

	public boolean isEmpty() {
		return linhas.isEmpty();
	}
}
