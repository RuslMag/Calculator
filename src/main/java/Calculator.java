import java.util.Scanner;

public class Calculator extends RomanToNumber {

    Scanner scanner = new Scanner(System.in);
    Decoration decoration = new Decoration();

    int num1, num2;
    boolean flag = false, flag2 = false;

    String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

    public void system() {
        try {
            decoration.head();

            String[] blocks = scanner.nextLine().split(" ");
            char operation = blocks[1].charAt(0);

            for (String s : roman) {
                if (s.equals(blocks[0])) {
                    flag = true;
                    break;
                }
            }
            for (String s : roman) {
                if (s.equals(blocks[2])) {
                    flag2 = true;
                    break;
                }
            }

            if (flag && flag2) {
                num1 = romanToDecimal(blocks[0]);
                num2 = romanToDecimal(blocks[2]);
                System.out.println("-------\n" + "Результат: "  + intToRoman(calculate(num1, num2, operation)) + ConsoleColors.RESET);
            } else {
                num1 = Integer.parseInt(blocks[0]);
                num2 = Integer.parseInt(blocks[2]);
                System.out.println("-------\n" + "Результат: " + calculate(num1, num2, operation) + ConsoleColors.RESET);
            }

            if ((num1 > 10 || num1 < 1) || (num2 > 10 || num2 < 1)) {
                throw new IllegalArgumentException();
            }

        } catch (RuntimeException e) {
            decoration.bootCamp();
            throw new IllegalArgumentException("Неверный формат данных");
        }

        decoration.bottom();
    }

    public int calculate(int number1, int number2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                decoration.bootCamp();
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
