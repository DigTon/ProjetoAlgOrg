public class InsertionSort extends AlgoritmoDeOrdenacao {
    public InsertionSort() {
        super("Insertion Sort");
    }

    @Override
    public void ordenar(int[] vetor) {
        int tamanho = vetor.length;
        for (int i = 1; i < tamanho; ++i) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        }
    }
}