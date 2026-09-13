import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean isFirstOperation = true;

        while(true){
            double firstOperand;

            if(isFirstOperation){

                System.out.print("Введите первое число: ");

                firstOperand = scanner.nextDouble();
            }else{
                firstOperand = result;
            }

            System.out.print("Введите операцию (+, -, *, /) или C (сброс), S (выход): ");
            char operation = scanner.next().charAt(0);
            char upperOperation = Character.toUpperCase(operation);

            if(upperOperation == 'S'){
                System.out.println("Завершение работы.");
                break;
            }

            if(upperOperation == 'C'){
                result = 0;
                isFirstOperation = true;
                System.out.println("Результат сброшен.");
                continue;
            }

            System.out.print("Введите второе число: ");
            double secondOperand = scanner.nextDouble();

            switch (operation) {
                case '+':
                    result = add(firstOperand, secondOperand);
                    break;
                case '-':
                    result = subtract(firstOperand, secondOperand);
                    break;
                case '*':
                    result = multiply(firstOperand, secondOperand);
                    break;
                case '/':
                    if (secondOperand == 0) {
                        System.out.println("Ошибка: деление на ноль!");
                        continue;
                    }
                    result = divide(firstOperand, secondOperand);
                    break;
                default:
                    System.out.println("Ошибка: неподдерживаемая операция.");
                    continue;
            }

            System.out.println("Результат: " + result);
            isFirstOperation = false;
        }


    }


    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        return a / b;
    }

}

