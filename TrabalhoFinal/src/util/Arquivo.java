package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * The Class Arquivo.
 *
 * @author Gilberto Toledo
 * @author Kesley Nascimento
 */
public class Arquivo {

	/**
	 * Read.
	 *
	 * @param caminho the caminho
	 * @return the string
	 */
	public static String Read(String caminho) {
		String conteudo = "";
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while (linha != null) {
					conteudo += linha + "\n";
					linha = lerArq.readLine();
				}
				arq.close();
				if (conteudo.length() > 0)
					System.out.println("Arquivo lido com sucesso");
				return conteudo;
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Erro: Não foi possível ler o arquivo!");
				return "";
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Erro: Arquivo não encontrado!");
			return "";
		}
	}

	/**
	 * Write.
	 *
	 * @param Texto the texto
	 * @return true, if successful
	 */
	public static boolean Write(String caminho, String Texto) {
		try {
			FileWriter arq = new FileWriter(caminho);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(Texto);
			gravarArq.close();
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
