import exercises.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер case: ");
        int ex = scan.nextInt();
        switch (ex) {
            case 1: // Реализовать алгоритм сортировки слиянием
                Ex1.RunSort(30);
                break;
            case 2: // Пусть дан произвольный список целых чисел, удалить из него чётные числа
                Ex2.RemoveEvenNumbers(30);
                break;
            case 3: // Задан целочисленный список ArrayList. 
                    // Найти минимальное, максимальное и среднее из этого списка.
                Ex3.GetListStat(30);
                break;
            case 4: // Реализовать разность массивов и симметрическую разность
                Ex4.Run();
                break;
        }
    }
}