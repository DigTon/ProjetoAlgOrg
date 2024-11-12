public class BubbleSort extends AlgoritmoDeOrdenacao {
    public BubbleSort() {
        super("Bubble Sort");
    }

    @Override
    public void ordenar(int[] vetor) {
        int tamanho = vetor.length;
        for (int i = 0; i < tamanho-1; i++) {
            for (int j = 0; j < tamanho-i-1; j++) {
                if (vetor[j] > vetor[j+1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;
                }
            }
        }
    }
}