import java.util.*;

class AnalisadorDeDesempenho {
    private List<AlgoritmoDeOrdenacao> algoritmos;
    private List<Resultados> resultados;
    private final String[] tamanhos = {"100", "1000", "10000"};
    private final String[] tipos = {"aleatorio", "crescente", "decrescente"};

    public AnalisadorDeDesempenho() {
        algoritmos = new ArrayList<>();
        algoritmos.add(new BubbleSort());
        algoritmos.add(new InsertionSort());
        algoritmos.add(new QuickSort());
        resultados = new ArrayList<>();
    }

    public void executarAnalise() {
        for (String tipo : tipos) {
            for (String tamanho : tamanhos) {
                String nomeArquivo = "src/" + tipo + "_" + tamanho + ".csv";
                int[] dados = LeitorDeArquivo.lerArquivo(nomeArquivo);

                if (dados != null) {
                    for (AlgoritmoDeOrdenacao algoritmo : algoritmos) {
                        long tempo = algoritmo.medirTempoDeOrdenacao(dados);
                        resultados.add(new Resultados(
                                algoritmo.getName(),
                                tipo,
                                Integer.parseInt(tamanho),
                                tempo
                        ));
                    }
                }
            }
        }
    }

    public void imprimirResultados() {
        System.out.println("Tempos de execução (nanosegundos):");
        System.out.println("================================");

        for (String tipo : tipos) {
            System.out.println("\nTipo: " + tipo.toUpperCase());
            System.out.println("Tamanho\tBubble\tInsertion\tQuick");

            for (String tamanho : tamanhos) {
                System.out.printf("%s\t", tamanho);
                int tamanhoInt = Integer.parseInt(tamanho);

                for (AlgoritmoDeOrdenacao algoritmo : algoritmos) {
                    long tempo = resultados.stream()
                            .filter(r -> r.getTipoDados().equals(tipo)
                                    && r.getTamanhoDados() == tamanhoInt
                                    && r.getNomeAlgoritmo().equals(algoritmo.getName()))
                            .findFirst()
                            .map(Resultados::getTempoExecucao)
                            .orElse(0L);

                    System.out.printf("%d\t", tempo);
                }
                System.out.println();
            }
        }
    }

    public List<Resultados> getResultados() {
        return resultados;
    }
}