import java.util.Scanner;

public class MediaNotas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita as 4 notas
        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();
        System.out.print("Digite a quarta nota: ");
        double nota4 = scanner.nextDouble();

        // Calcula a média
        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        // Exibe a média e valida a aprovação
        System.out.println("Média das notas: " + media);

        // Exemplo de regras de validação:
        if (media >= 7) {
            System.out.println("Aprovado!");
        } else if (media >= 5) {
            System.out.println("Recuperação!");
        } else {
            System.out.println("Reprovado!");
        }

        scanner.close();
    }
}
