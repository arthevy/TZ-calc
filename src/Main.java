import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sca = new Scanner(System.in);
        System.out.println(
                "\nТестовое задание - Калькулятор:\n" +
                        "1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку.\n" +
                        "2. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.\n" +
                        "3. Калькулятор принимает на вход числа от 1 до 10 включительно, не более.На выходе числа не ограничиваются по величине и могут быть любыми.\n" +
                        "4. Калькулятор умеет работать только с целыми числами. \n" +
                        "5. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу. \n" +
                        "6. При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.\n" +
                        "7. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.\n" +
                        "8. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.\n" +
                        "9. Результатом операции деления является целое число, остаток отбрасывается.\n" +
                        "10.1 Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.\n" +
                        "10.2 Результатом работы калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы, выбрасывается исключение.\n" +
                        "\n->> Введите данные (например 1+5, II-V, 1*X, 5/2):");
        String testcalc = sca.nextLine();
        testcalc = testcalc.replaceAll("\\s", "");
        String num1;
        String num2;
        String Arabian = ("12345678910");
        String Romanian = ("IIIVIIIX");
        if (testcalc.contains("-")) {
            String[] nums = testcalc.split("-");
            num1 = nums[0];
            num2 = nums[1];
        } else if (testcalc.contains("+")) {
            String[] nums = testcalc.split("[+]");
            num1 = nums[0];
            num2 = nums[1];
        } else if (testcalc.contains("*")) {
            String[] nums = testcalc.split("[*]");
            num1 = nums[0];
            num2 = nums[1];
        } else if (testcalc.contains("/")) {
            String[] nums = testcalc.split("[/]");
            num1 = nums[0];
            num2 = nums[1];
        } else {
            throw new Exception("т.к. строка не является математической операцией");
        }
        if (Arabian.contains(num1) && Arabian.contains(num2)) {
            Count.countarabian(num1, num2, testcalc);
        } else if (Romanian.contains(num1) && Romanian.contains(num2)) {
            Count.countroman(num1, num2, testcalc);
        } else if ((Arabian.contains(num1) && Romanian.contains(num2)) || (Romanian.contains(num1) && Arabian.contains(num2))) {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        } else {
            throw new Exception("Введено неверное значение");
        }

    }
}