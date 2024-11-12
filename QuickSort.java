public class QuickSort extends AlgoritmoDeOrdenacao {
    public QuickSort() {
        super("Quick Sort");
    }

    @Override
    public void ordenar(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private void quickSort(int[] vetor, int menor, int maior) {
        if (menor < maior) {
            int indicePivo = particao(vetor, menor, maior);
            quickSort(vetor, menor, indicePivo - 1);
            quickSort(vetor, indicePivo + 1, maior);
        }
    }

    private int particao(int[] vetor, int menor, int maior) {
        int pivo = vetor[maior];
        int i = (menor - 1);
        for (int j = menor; j < maior; j++) {
            if (vetor[j] < pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[maior];
        vetor[maior] = temp;
        return i + 1;
    }
}