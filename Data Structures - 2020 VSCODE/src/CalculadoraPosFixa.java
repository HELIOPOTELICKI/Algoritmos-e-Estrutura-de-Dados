import java.util.Scanner;

public class CalculadoraPosFixa {
  public static String operadores = "+-/*";
  public static String tiposDePilha = "VL";

  public static void run() throws Exception {
    Scanner s = new Scanner(System.in);

    String entrada, tipoPilha;

    do {
      System.out.print("Escreva a expressão: ");
      entrada = s.nextLine();
    } while (entrada.isEmpty());

    do {
      System.out.print("Você quer a pilha em vetor ou lista? (V/L) ");
      tipoPilha = s.nextLine().toUpperCase();
    } while (tipoPilha.isEmpty() || !tiposDePilha.contains(tipoPilha));

    s.close();

    Boolean eLista = tipoPilha.charAt(0) == 'L';

    String[] tokens = entrada.split(" ");
    Pilha<Double> pilha = eLista ? new PilhaLista<>() : new PilhaVetor<>(tokens.length);

    for (String token : tokens) {
      try {
        double num = Double.parseDouble(token);
        pilha.push(num);
      } catch (NumberFormatException e) {
        if (!operadores.contains(token)) {
          throw new Exception("Expressão inválida");
        }

        double b, a;

        try {
          b = pilha.pop();
          a = pilha.pop();
        } catch (Exception error) {
          throw new Exception("Expressão inválida");
        }

        double resultado;

        switch (token) {
          case "+":
            resultado = a + b;
            break;
          case "-":
            resultado = a - b;
            break;
          case "*":
            resultado = a * b;
            break;
          case "/":
            resultado = a / b;
            break;
          default:
            throw new Exception("Expressão inválida");
        }

        pilha.push(resultado);
      }
    }

    double resultado = pilha.pop();

    if (!pilha.vazia()) {
      throw new Exception("Expressão inválida");
    }

    System.out.println("Resultado: " + resultado);
  }
}