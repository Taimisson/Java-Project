// Taimisson
// Classe que representa um Jogador
public class Jogador{
    private String nome;
    private int pontos;
    private Dado dadoBranco;
    private Dado dadoVermelho;
    
    // Método construtor do jogador
    public Jogador(String nome){
        this.nome = nome;
        this.pontos = 0; 
        this.dadoBranco = new Dado("Branco");
        this.dadoVermelho = new Dado("Vermelho");
    }

    // Métodos Setter e Getter
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPontos(int pontos){
        this.pontos = pontos;
    }
    public void setDadoBranco(Dado dadoBranco){
        this.dadoBranco = dadoBranco;
    }
    public void setDadoVermelho(Dado dadoVermelho){
        this.dadoVermelho = dadoVermelho;
    }
    public String getNome(){
        return nome;
    }
    public int getPontos(){
        return pontos;
    }
    public Dado getDadoBranco(){
        return dadoBranco;
    }
    public Dado getDadoVermelho(){
        return dadoVermelho;
    }

    // Método para jogar o dado branco e adicionar a pontuação
    public int jogarDadoBranco(){
        int resultado = dadoBranco.jogarDado();
        pontos += resultado;
        return resultado;
    }

    // Método para jogar o dado vermelho. Se o resultado for 6, a pontuação é dobrada.
    public int jogarDadoVermelho() {
        int resultado = dadoVermelho.jogarDado();
        pontos += resultado == 6 ? resultado * 2 : resultado;
        return resultado;
    }

    // Método para zerar a pontuação do jogador
    public void zerarPontuacao(){
        this.pontos = 0;
    }
}