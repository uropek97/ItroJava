import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class lesson1 {
    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);

        System.out.println("Задание 1: ");
        System.out.println("Введите ваше имя: ");
        var name = iScanner.nextLine();
        System.out.println(task1(name));

        int[] arr = new int[] {0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println("Задание 2: ");
        System.out.println(task2(arr, 1));

        System.out.println("Задание 3: ");
        var newArr = task3(arr, 1);
        for (var item : newArr)
            System.out.printf("%s ", item);

        System.out.println();

        System.out.println("Задание 4: ");
        System.out.println("Введите номер треугольного числа: ");
        var nNumb = iScanner.nextInt();
        System.out.println(task4(nNumb));

        System.out.println("Задание 5: ");
        String streq = "2? + ?5 = 69";
        System.out.printf("Дано уравнение: %s\n", streq);

        System.out.println("Результат: ");
        var parts = streq.split(" ");
        System.out.println(task5(parts[0], parts[2], parts[4], '?'));
    }

    public static String task1(String name) {

        var currntdate = Calendar.getInstance();
        var hours = currntdate.get(Calendar.HOUR_OF_DAY);

        var timeStr = "";
        if (hours >= 5 && hours < 12)
            timeStr = "Доброе утро, ";
        else if (hours >= 12 && hours < 18)
            timeStr = "Добрый день, ";
        else if (hours >= 18 && hours < 23)
            timeStr = "Добрый вечер, ";
        else
            timeStr = "Доброй ночи, ";

        return timeStr + name + '!';
    }

    public static int task2(int[] arr, int value) {
        int current = 0;
        int max = 0;

        for (int item : arr) {
            if (item == value)
                current++;
            else {
                if (current > max)
                    max = current;
                current = 0;
            }
        }
        return max;

    }

    public static int[] task3(int[] arr, int value) {
        var newArr = new int[arr.length];
        int back = 1;
        int front = 0;

        for (int item : arr) {
            if (item == value) {
                newArr[newArr.length - back] = item;
                back++;
            } else
                arr[front] = item;
            front++;
        }
        return newArr;
    }

    public static int task4(int n) {
        if (n == 1)
            return 1;
        return (int) ((double) n / 2 * (n + 1));
    }


    //метод работает исключительно для примера, подобному в условии.
    //для того чтобы сделать его универсальным, и так же например для работы с -/* и / нужно доработать
    public  static  String task5(String str1, String str2, String strRes, char value){
        var q = getdigits(str1, value);
        var w = getdigits(str2, value);
        var e = getdigits(strRes, value);

        // q+w=e

        for (int i = 1; i <= e.length; i++){
            if(q[q.length-i] == -1)
                q[q.length-i] = foundDigit(q[q.length-i], w[w.length-i], e[e.length-i]);
            else if (w[w.length-i] == -1)
                w[w.length-i] = foundDigit(q[q.length-i], w[w.length-i], e[e.length-i]);
            else if (e[e.length-i] == -1)
                e[e.length-i] = foundDigit(q[q.length-i], w[w.length-i], e[e.length-i]);
        }

        var SB = new StringBuilder();

        for (var item : q)
            SB.append(item);
        SB.append(" + ");
        for (var item : w)
            SB.append(item);
        SB.append(" = ");
        for (var item : e)
            SB.append(item);

        return SB.toString();
    }

    public static int[] getdigits(String str, char value){
        int[] number = new int[str.length()];
        char[] c = str.toCharArray();


        // можно ли как-то map сделать глобальной переменной, чтобы не инициализировать каждый раз его?
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);

        for(int i = 0; i < c.length; i++){
            if(c[i] == value)
                number[i] = -1;
            else
                number[i] = map.get(c[i]);
        }
        return number;
    }

    public static int foundDigit(int x, int y, int z){
        Boolean notNumb1 = x == -1 && y == -1;
        Boolean notNumb2 = x == -1 && z == -1;
        Boolean notNumb3 = y == -1 && z == -1;

        if (notNumb1 || notNumb2 || notNumb3)
            return -1;

        if(x == -1){
            if(z < y)
                z += 10;
            x = z - y;
            return x;
        }
        else if(y == -1){
            if(z < x)
                z += 10;
            y = z - x;
            return y;
        }
        else if(z == -1){
            z = x + y;
            if(z >= 10)
                z -=10;
            return z;
        }

        return -1;
    }
}