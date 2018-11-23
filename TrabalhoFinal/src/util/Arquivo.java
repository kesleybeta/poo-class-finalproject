package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Arquivo.
 *
 * @author Gilberto Toledo
 * @author Kesley Nascimento
 */
public class Arquivo {
    
    /** The Constant Caminho. */
    private static final String Caminho = "../db/Pacote.txt";
    
    /**
     * Read.
     *
     * @return the string
     */
    public static String Read(){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);			// mudar para atributo
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: N�o foi poss�vel ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo n�o encontrado!");
            return "";
        }
    }
    
    /**
     * Write.
     *
     * @param Texto the texto
     * @return true, if successful
     */
    public static boolean Write(String Texto){
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
