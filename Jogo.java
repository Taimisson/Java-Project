import jdk.jshell.execution.Util;
// Taimisson
// Classe que representa o Jogo do 21 com 2 jogadores
public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;

    // Construtor que inicializa os jogadores e o visualizador ASCII.
    public Jogo() {
        String nome1, nome2;
        // Nomes dos jogadores são lidos pelo teclado e garante que não fique em branco.
        do {
            nome1 = Teclado.leString("\t\t\t[BEM VINDO] \n> DIGITE O NOME DO PRIMEIRO JOGADOR").trim();
            if (nome1.isEmpty()){
                System.out.println("[ERRO] O NOME NÃO PODE FICAR EM BRANCO!\n");
                Utilitarios.pausa(1000);
            }
        } while (nome1.isEmpty());

        do {
            nome2 = Teclado.leString("> DIGITE O NOME DO SEGUNDO JOGADOR").trim();
            if (nome2.isEmpty()) {
                System.out.println("[ERRO] O NOME NÃO PODE FICAR EM BRANCO!\n");
                Utilitarios.pausa(1000);
            }
        } while (nome2.isEmpty());

        this.jogador1 = new Jogador(nome1);
        this.jogador2 = new Jogador(nome2);
    }


    // Métodos Setter e Getter
    public void setNomeJogador1(Jogador nomeJogador1) {
        this.jogador1 = nomeJogador1;
    }

    public void setNomeJogador2(Jogador nomeJogador2) {
        this.jogador2 = nomeJogador2;
    }

    public Jogador getNomeJogador1() {
        return jogador1;
    }

    public Jogador getNomeJogador2() {
        return jogador2;
    }

    // Método para zerar a pontuação no início da partida.
    public void inicioJogo() {
        jogador1.zerarPontuacao();
        jogador2.zerarPontuacao();
    }

    // Método para começar o jogo.
    public void comecaJogo() {
        boolean respostaJogar;

        // DO-WHILE principal da PARTIDA
        do {
            inicioJogo();
            Utilitarios.regrasJogo(jogador1, jogador2);
            Utilitarios.centralizarTextoLinha("[INICIANDO O JOGO]");
            int rodada = 1;
            do {
                Utilitarios.pausa(1000);

                Utilitarios.centralizarTextoBranco("");
                Utilitarios.centralizarTextoBranco(" RODADA " + rodada + " ");

                jogada(jogador1); // Escolha de Jogada do Jogador e Resultado da Rodada
                Utilitarios.centralizarTextoLinha("");
                Utilitarios.linhaEmBranco();
                jogada(jogador2); // Escolha de Jogada do Jogador e Resultado da Rodada

                Utilitarios.centralizarTextoLinha(" [FIM DA RODADA " + rodada + "] ");
                Utilitarios.pausa(1000);
                rodada++;


            } while (rodada <= 3);

            exibirResultadoFinal(); // Exibe o resultado final do Jogo

            Utilitarios.linhaEmBranco();
            respostaJogar = desejaJogarNovamente(); // Perguntar se querem jogar novamente e validar


            if (respostaJogar) {
                String nomeAtualizar1, nomeAtualizar2;

                do {
                    nomeAtualizar1 = Teclado.leString("> DIGITE O NOME DO PRIMEIRO JOGADOR").trim();
                    if (nomeAtualizar1.isEmpty()){
                        System.out.println("[ERRO] O NOME NÃO PODE FICAR EM BRANCO!\n");
                        Utilitarios.pausa(1000);
                    }
                } while (nomeAtualizar1.isEmpty());

                do {
                    nomeAtualizar2 = Teclado.leString("> DIGITE O NOME DO SEGUNDO JOGADOR").trim();
                    if (nomeAtualizar2.isEmpty()){
                        System.out.println("[ERRO] O NOME NÃO PODE FICAR EM BRANCO!\n");
                        Utilitarios.pausa(1000);
                    }
                } while (nomeAtualizar2.isEmpty());

                jogador1.setNome(nomeAtualizar1);
                jogador2.setNome(nomeAtualizar2);
            }

        } while (respostaJogar);
    }

    // Método da jogada de um jogador. Jogar ou passar os dados / Resultados exibidos e pontos calculados
    public void jogada(Jogador jogador) {
        System.out.println("VEZ DE " + jogador.getNome());
        Utilitarios.linhaEmBranco();

        int escolha;

        while (true) {
            System.out.println("1 - JOGAR \n2 - PASSAR A VEZ");
            escolha = Teclado.leInt("\nESCOLHA UMA OPÇÃO: ");

            if (escolha == 1 || escolha == 2)
                break;
            else
                System.out.println("[ERRO] Escolha inválida. Tente novamente!");
        }
        switch (escolha) {
            case 1:
                int resultado1 = jogador.jogarDadoBranco();
                int resultado2 = jogador.jogarDadoVermelho();

                ASCII.exibirCombinacaoDeDados(resultado1, resultado2);

                Utilitarios.pausa(1000);
                if (resultado2 == 6)
                    Utilitarios.centralizarTextoBranco(" [AVISO] RODOU 6 NO DADO VERMELHO E O VALOR SERÁ DUPLICADO!");
                int soma = resultado1 + (resultado2 == 6 ? resultado2 * 2 : resultado2);
                int pontosTotais = jogador.getPontos();
                Utilitarios.centralizarTextoBranco("PONTOS RODADA: " + soma + " | PONTOS PARTIDA: " + pontosTotais);
                Utilitarios.linhaEmBranco();
                break;
            case 2:
                Utilitarios.centralizarTextoBranco("> " + jogador.getNome() + " PASSOU A VEZ < \n");
                break;
        }
    }

    // Método para exibir o resultado final do jogador
    public void exibirResultadoFinal() {

        Utilitarios.centralizarTextoBranco("");
        Utilitarios.centralizarTextoLinha(" [FIM DO JOGO] ");
        Utilitarios.centralizarTextoBranco("");

        String nomeJogador1 = jogador1.getNome();
        String nomeJogador2 = jogador2.getNome();
        int ptJogador1 = jogador1.getPontos();
        int ptJogador2 = jogador2.getPontos();

        if (ptJogador1 > 21 && ptJogador2 > 21)
            Utilitarios.centralizarTextoBranco("OS JOGADORES EMPATARAM!");
        else if (ptJogador1 > 21)
            Utilitarios.centralizarTextoBranco("O JOGADOR " + nomeJogador2 + " VENCEU!");
        else if (ptJogador2 > 21)
            Utilitarios.centralizarTextoBranco("O JOGADOR " + nomeJogador1 + " VENCEU!");
        else if (ptJogador1 == ptJogador2)
            Utilitarios.centralizarTextoBranco("O JOGO TERMINOU EMPATADO!");
        else
            Utilitarios.centralizarTextoBranco(ptJogador1 > ptJogador2 ? nomeJogador1 + " VENCEU!" : nomeJogador2 + " VENCEU!");
        Utilitarios.pausa(1000);

        Utilitarios.centralizarTextoBranco("");
        Utilitarios.centralizarTextoBranco(nomeJogador1 + ": " + ptJogador1);
        Utilitarios.centralizarTextoBranco(nomeJogador2 + ": " + ptJogador2);
        Utilitarios.linhaEmBranco();

        Utilitarios.centralizarTextoLinha("");
    }


    // Método para perguntar se os jogadores querem jogar novamente
    // Valida a resposta recebida pelo Teclado
    private boolean desejaJogarNovamente() {
        while (true) {
            String resposta = Teclado.leString("DESEJAM JOGAR NOVAMENTE? [SIM/NÃO]").trim().toLowerCase();
            if (resposta.equals("sim") || resposta.equals("s"))
                return true;
            else if (resposta.equals("não") || resposta.equals("nao") || resposta.equals("n"))
                return false;
            else
                System.out.println("[ERRO] RESPOSTA INVÁLIDA. POR FAVOR, DIGITE 'SIM' OU 'NÃO'");
        }
    }

}

