import java.io.*;
import java.util.*;

public class LeitorDeArquivo {
    public static int[] lerArquivo(String nomeArquivo) {
        try {
            List<Integer> numeros = new ArrayList<>();
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                numeros.add(Integer.parseInt(linha.trim()));
            }
            leitor.close();

            return numeros.stream().mapToInt(Integer::intValue).toArray();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + nomeArquivo);
            return null;
        }
    }
}