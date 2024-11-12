public abstract class AlgoritmoDeOrdenacao {
    protected String name;

    public AlgoritmoDeOrdenacao(String name) {
        this.name = name;
    }

    public abstract void ordenar(int[] arr);

    public String getName() {
        return name;
    }

    public long medirTempoDeOrdenacao(int[] arr) {
        int[] copyArr = arr.clone();
        long startTime = System.nanoTime();
        ordenar(copyArr);
        return System.nanoTime() - startTime;
    }
}