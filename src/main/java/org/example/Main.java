import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main { // O nome da classe é Main

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiConnector connector = new ApiConnector();

        // Loop principal do menu
        while (true) {
            System.out.println("**************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println(" ");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Sair");
            System.out.println(" ");
            System.out.print("Escolha uma opção válida: ");
            System.out.println("\n**************************************************");

            try {
                int choice = scanner.nextInt();

                if (choice == 7) {
                    System.out.println("Obrigado por usar o conversor. Encerrando...");
                    break; // Sai do loop while
                }

                if (choice < 1 || choice > 6) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue; // Volta ao início do loop
                }

                // Pede o valor a ser convertido
                System.out.print("Digite o valor que deseja converter: ");
                double amount = scanner.nextDouble();

                String baseCurrency = "";
                String targetCurrency = "";

                // Define as moedas com base na escolha
                switch (choice) {
                    case 1:
                        baseCurrency = "USD";
                        targetCurrency = "ARS";
                        break;
                    case 2:
                        baseCurrency = "ARS";
                        targetCurrency = "USD";
                        break;
                    case 3:
                        baseCurrency = "USD";
                        targetCurrency = "BRL";
                        break;
                    case 4:
                        baseCurrency = "BRL";
                        targetCurrency = "USD";
                        break;
                    case 5:
                        baseCurrency = "USD";
                        targetCurrency = "COP";
                        break;
                    case 6:
                        baseCurrency = "COP";
                        targetCurrency = "USD";
                        break;
                }

                // Chama a API e calcula a conversão
                double rate = connector.getConversionRate(baseCurrency, targetCurrency);
                double convertedAmount = amount * rate;

                // Exibe o resultado formatado
                System.out.printf("O valor de %.2f [%s] corresponde ao valor final de %.2f [%s]%n%n",
                        amount, baseCurrency, convertedAmount, targetCurrency);

            } catch (InputMismatchException e) {
                System.err.println("Erro: Por favor, digite um número válido.");
                scanner.next(); // Limpa o buffer do scanner
            } catch (IOException | InterruptedException e) {
                System.err.println("Erro ao consultar a API: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}