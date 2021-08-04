import java.util.Scanner;

public class Cinema { // Покупка билетов в кинотеатре.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int y = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int x = scanner.nextInt();
        String[][] arr = new String[y][x];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "S"; } }
        System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit\n");
        int n;
        n = scanner.nextInt();
        do {
            switch (n) {
                case 1:
                    showTS(arr, x);
                    System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit\n");
                    n = scanner.nextInt();
                    break;
                case 2:
                    bueAT(y, x, arr);
                    System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit\n");
                    n = scanner.nextInt();
                    break;
                case 3:
                    stat(y, x, arr);
                    System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit\n");
                    n = scanner.nextInt();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong input!");
                    System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit\n");
                    n = scanner.nextInt();
            }
        } while (n != 0);
    }
    public static void showTS(String[][] arr, int x) { // КАРТА ЗАЛА
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int count = 1; count <= x; count++) {
            System.out.print(count + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void bueAT(int y, int x, String[][] arr) {  // КУПИТЬ БИЛЕТ
        Scanner scanner = new Scanner(System.in);
        int co = 0;
        int r;
        int m;
        int dol = 0;
        do {
            System.out.println("Enter a row number:");
            r = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            m = scanner.nextInt();
            if (y * x <= 60) dol = 10;
            else if (y * x > 60)
                if (r <= y / 2) dol = 10;
                else dol = 8;
            if (r - 1 >= y || m - 1 >= x) {
                System.out.println("Wrong input!");
            } else if (arr[r - 1][m - 1] == "B") {
                System.out.println("That ticket has already been purchased!");
            } else {
                arr[r - 1][m - 1] = "B";
                System.out.println("Ticket price: $" + dol);
                co = 1;
            }
        } while (co == 0);
    }
    public static void stat(int y, int x, String[][] arr) { //СТАТИСТИКА
        int tt = 0;
        int summ = 0;
        for (int i = 0; i <  arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == "B" && y * x <= 60) {
                    tt++;
                    summ += 10;
                } else if (arr[i][j] == "B" && y * x > 60) {
                    tt++;
                    if (i < y / 2) {
                        summ += 10;
                    } else if (i >= y /2) {
                        summ += 8;
                    }
                }
            }
        }
        System.out.println("Number of purchased tickets: " + tt);
        double p = 100 / ((double)y * (double) x) * tt;
        System.out.printf("Percentage: %.2f%%\n", p);
        System.out.println("Current income: $" + summ);
        if (y * x <= 60) {
            System.out.println("Total income: $" + y * x * 10);
        } else { System.out.println("Total income: $" + ((y / 2 * x * 10) + ((y - y / 2) * x * 8 ))); }
    }
}