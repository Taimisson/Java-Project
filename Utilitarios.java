
// Taimisson
public class Utilitarios {

    // Método para imprimir uma linha em branco
    public static void linhaEmBranco() {
        System.out.println();
    }

    // Método para fazer uma pausa na execução em milissegundos.
    public static void pausa(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch(Exception e){}
    }

    // Método para imprimir um texto entre os caracteres " = "
    public static void centralizarTextoLinha(String texto) {
        if (texto.isEmpty()) System.out.println("==================================================");
        else System.out.println("=================" + texto + "=================");
    }


    // Método para imprimir um texto centralizado
    public static void centralizarTextoBranco(String texto) {
        if (texto.length() > 50)
            System.out.println(texto);
        else
            System.out.printf("%50s%n", String.format("%-" + ((50 + texto.length()) / 2) + "s", texto));
    }

    // Método para exibir as regras do jogo.
    public static void regrasJogo(Jogador jogador1, Jogador jogador2) {
        Utilitarios.centralizarTextoLinha("");
        Utilitarios.centralizarTextoBranco("");
        Utilitarios.centralizarTextoBranco("[BEM-VINDOS]");
        Utilitarios.centralizarTextoBranco(jogador1.getNome() + " e " + jogador2.getNome());
        System.out.println();
        Utilitarios.centralizarTextoBranco("      JOGO DO 21       ");
        System.out.println();
        Utilitarios.centralizarTextoBranco(" _______    _______ ");
        Utilitarios.centralizarTextoBranco("|       |  |  o o  |");
        Utilitarios.centralizarTextoBranco("|   o   |  |  o o  |");
        Utilitarios.centralizarTextoBranco("|       |  |  o o  |");
        Utilitarios.centralizarTextoBranco("|_______|  |_______|");
        Utilitarios.centralizarTextoBranco("");
        System.out.println();
        Utilitarios.centralizarTextoBranco("> REGRAS <");
        Utilitarios.centralizarTextoBranco("- Jogo com 2 Jogadores ");
        Utilitarios.centralizarTextoBranco("- O jogo possui 3 rodadas");
        Utilitarios.centralizarTextoBranco("- O jogador com a maior pontuação ganha ");
        Utilitarios.centralizarTextoBranco("- O jogador perde se ultrapassar 21 pontos ");
        Utilitarios.centralizarTextoBranco("- Cada jogador rola dois dados ou passa a vez ");
        Utilitarios.centralizarTextoBranco("- Pontos dos dados são somados em cada rodada ");
        Utilitarios.centralizarTextoBranco("- Rolar um 6 no dado vermelho, duplica o seu valor");
        Utilitarios.centralizarTextoBranco("");
        Utilitarios.centralizarTextoLinha("");

        pausa(1000);
    }

}