// Taimisson
// Classe que representa um dado
public class Dado {
    private int dadoLados;
    private String cor;

    // Construtor da classe que inicializa o dado com uma cor e padrão de 6 lados.
    public Dado(String cor) {
        this.dadoLados = 6;
        this.cor = cor;
    }

    // Métodos Getter e Setter
    public void setDadoLados(int dadoLados) {
        this.dadoLados = dadoLados;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getDadoLados() {
        return dadoLados;
    }

    public String getCor() {
        return cor;
    }

    // Método que simula o ato de jogar o dado, retornando um número aleatório entre 1 e o número de lados do dado.
    public int jogarDado() {
        return (int) (Math.random() * 6) + 1;
    }

    // Método String do dado.
    public String toString() {
        return "Dado de 6 lados e cor: " + cor;
    }

}