// Taimisson
// Classe que representa a exibição dos dados em formato ASCII
public class ASCII {

    // Método para exibir a combinação de dois dados.
    public static void exibirCombinacaoDeDados(int dado1, int dado2) {
        Utilitarios.pausa(500);
        System.out.println("\nDADO BRANCO:");
        exibirDado(dado1);
        Utilitarios.pausa(500);
        System.out.println("DADO VERMELHO:");
        exibirDado(dado2);
    }

    // Método para exibir o desenho ASCII de um dado com base no lado.
    private static void exibirDado(int lado) {
        switch (lado) {
            case 1:
                System.out.println(" _______ \n" +
                                "|       |\n" +
                                "|   •   |\n" +
                                "|       |\n" +
                                "|_______|\n");
                break;
            case 2:
                System.out.println(" _______ \n" +
                                "| •     |\n" +
                                "|       |\n" +
                                "|     • |\n" +
                                "|_______|\n");
                break;
            case 3:
                System.out.println(" _______ \n" +
                                "| •     |\n" +
                                "|   •   |\n" +
                                "|     • |\n" +
                                "|_______|\n");
                break;
            case 4:
                System.out.println(" _______ \n" +
                                "| •   • |\n" +
                                "|       |\n" +
                                "| •   • |\n" +
                                "|_______|\n");
                break;
            case 5:
                System.out.println(" _______ \n" +
                                "| •   • |\n" +
                                "|   •   |\n" +
                                "| •   • |\n" +
                                "|_______|\n");
                break;
            case 6:
                System.out.println(" _______ \n" +
                                "| •   • |\n" +
                                "| •   • |\n" +
                                "| •   • |\n" +
                                "|_______|\n");
                break;
        }
    }
}
