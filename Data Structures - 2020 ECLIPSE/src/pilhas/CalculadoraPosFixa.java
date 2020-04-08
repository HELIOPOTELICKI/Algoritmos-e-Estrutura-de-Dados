package pilhas

import java.util.Scanner;

public class CalculadoraPosFixa {
  public static String operandos = "+-/*";

  public static void run() throws Exception {

    Scanner s = new Scanner(System.in);
    System.out.print("Escreva a expressão: ");
    String entrada = s.nextLine();

    if (entrada.isEmpty()) {
      s.close();
      throw new Exception("Entrada vazia");
    }

    System.out.print("Você quer a pilha em vetor ou lista? (V/L) ");
    String linha = s.nextLine();

    while (linha.isEmpty()) {
      System.out.print("Você quer a pilha em vetor ou lista? (V/L) ");
      linha = s.nextLine();
    }

    Boolean eLista = linha.charAt(0) == 'L';

    String[] tokens = entrada.split(" ");
    Pilha<Double> pilha = eLista ? new PilhaLista<>() : new PilhaVetor<>(tokens.length);

    for (String token : tokens) {
      try {
        double num = Double.parseDouble(token);
        pilha.push(num);
      } catch (NumberFormatException e) {
        if (!operandos.contains(token)) {
          s.close();
          throw new Exception("Operando invalido");
        }

        double b = pilha.pop();
        double a = pilha.pop();

        double resultado = 0;

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
        }

        pilha.push(resultado);
      }
    }

    s.close();
    System.out.println("Resultado: " + pilha.pop());
  }
}