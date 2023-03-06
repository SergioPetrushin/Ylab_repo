package Ylab;

import java.util.Random;
import java.util.Scanner;

public class YlabDZ1 {
    public static void main(String[] args) {
        System.out.println("Введите номер задачи 1, 2, 3 или 4");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 1) {
            System.out.println("Вы запустили задачу №1:Stars");
            Stars.startZD1();
        } else if (number == 2) {
            System.out.println("Вы запустили задачу №2:Числа Пелля");
            PellNumber.pell();
        } else if (number == 3) {
            System.out.println("Вы запустили задачу №3:MultTable");
            MultTable.printMultTable();
        } else if (number == 4) {
            System.out.println("Вы запустили задачу №4:Guess");
            Guess.guesser();
        } else {
            System.out.println("Введено не верное число, попробуйте снова");
        }
    }
}

class Stars {
    public static void startZD1() {
        System.out.println("Введите последовательно (через пробел): количество строк, количество столбцов, произвольный символ");
        System.out.println("Числа должны быть целые больше 0");
        try (Scanner scanner = new Scanner(System.in)) {
            String[] words = scanner.nextLine().split(" ");
            int stringsQuantity = Integer.parseInt(words[0]);
            int columnsQuantity = Integer.parseInt(words[1]);
            char randomChar = words[2].charAt(0);
            //System.out.println("Результат" + stringsQuantity + " " + columnsQuantity+ " " + randomChar);
            for (int i = 0; i < stringsQuantity; i++) {
                for (int j = 0; j < columnsQuantity; j++) {
                    System.out.print(randomChar + " ");
                }
                System.out.println();
            }
        }
    }
}

class PellNumber {
    public static void pell() {
        System.out.println("Введите любое целое число от 0 до 30");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int pell=1;

            if (n == 0) {
                pell = 0;
            } else if (n == 1) {
                pell = 1;
            } else if (n > 1 & n <= 30) {
                int p1 = 0;
                int p2 = 1;
                int pn = 0;
                for (int i = 2; i <= n; i++) {
                    pn = 2 * p2 + p1;
                    p1 = p2;
                    p2 = pn;
                    pell = pn;
                }
            } else {
                System.out.println("Введено число не входящее в пределы задачи!");
            }
            System.out.println("Число Пелля равно "+pell);
        }
    }
}

class MultTable{
    static void printMultTable(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println((i+1) + " х " + (j+1) + " = " + ((i+1)*(j+1)));
            }
        }
    }
}

class Guess{
    static void guesser(){
        int number = new Random().nextInt(100);
        int maxAttempts = 10;
        System.out.println("Я загадал число. У тебя " + maxAttempts + " попыток угадать.");
        System.out.println("Введи любое число от 0 до 100");

        for (int i = maxAttempts; i > 0; i--) {
            Scanner scanner = new Scanner(System.in);
            int personNumber = scanner.nextInt();
            if (personNumber > number) {
                System.out.print("Мое число меньше! ");
            } else if (personNumber < number) {
                System.out.print("Мое число больше! ");
            } else if (personNumber == number) {
                System.out.println("Ты угадал с " + (maxAttempts-i) + " попытки!");
                return;
            }

            System.out.println("Осталось " + (i - 1) + " попыток");
        }
        System.out.println("Ты не угадал");
    }
}
