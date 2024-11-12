public class Resultados {
    private String nomeAlgoritmo;
    private String tipoDados;
    private int tamanhoDados;
    private long tempoExecucao;

    public Resultados(String nomeAlgoritmo, String tipoDados, int tamanhoDados, long tempoExecucao) {
        this.nomeAlgoritmo = nomeAlgoritmo;
        this.tipoDados = tipoDados;
        this.tamanhoDados = tamanhoDados;
        this.tempoExecucao = tempoExecucao;
    }

    public String getNomeAlgoritmo() { return nomeAlgoritmo; }
    public String getTipoDados() { return tipoDados; }
    public int getTamanhoDados() { return tamanhoDados; }
    public long getTempoExecucao() { return tempoExecucao; }
}