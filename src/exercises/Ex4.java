package exercises;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Реализовать разность массивов и симметрическую разность
public class Ex4 {
    public static void Run() {
        var rnd1 = Ex1.GeneraterandomList(20);
        System.out.println("List 1: " + rnd1);
        var rnd2 = Ex1.GeneraterandomList(20);
        System.out.println("List 2: " + rnd2);
        // Сортируем списки, чтобы можно было применить алгоритм бинарного поиска
        rnd1 = Ex1.MergeSort(rnd1);
        rnd2 = Ex1.MergeSort(rnd2);
        List<Integer> leftJoin = new ArrayList<Integer>();
        List<Integer> innerJoin = new ArrayList<Integer>();
        Iterator<Integer> listItr = rnd1.iterator();
        while (listItr.hasNext()) {
            int val = listItr.next();
            boolean isFound = IsExist(val, rnd2);
            // проверяем найден элемент или нет, а также избавляемся от дубликатов в результирующем списке:
            if (!isFound && (leftJoin.size() == 0 || leftJoin.get(leftJoin.size() - 1) != val))
                leftJoin.add(val);
            else if (isFound && (innerJoin.size() == 0 || innerJoin.get(innerJoin.size() - 1) != val))
                innerJoin.add(val);
        }
        System.out.println("Left Join: " + leftJoin);
        System.out.println("Inner Join: " + innerJoin);
    }

    private static boolean IsExist(int val, List<Integer> testList) { // Бинарный поиск элемента в массиве:
        int low = 0;
        int high = testList.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2; // Делим пополам сумму макс и мин
            int midVal = testList.get(mid); // Получаем значение данного элемента в списке
            if (midVal < val)  // Сравниваем с искомым
                low = mid + 1;
            else if (midVal > val)
                high = mid - 1;
            else
                return true; // Элемент найден
        }
        return false; // Элемент не найден
    }
}
