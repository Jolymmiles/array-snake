import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputData = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputData[0]), M = Integer.parseInt(inputData[1]), digitInArray = 0;
        int[][] array = new int[N][M];

        //Заполнение массива
        for (int line = 0; line < N; line++) {
            for (int column = 0; column < M; column++) {
                array[line][column] = ++digitInArray;
            }
        }

        //Вывод массива змейкой
        for (int line = 0; line < N; line++) {
            for (int column = 0; column < M; column++) {
                if (line % 2 == 0) {
                    System.out.print(array[line][column] + "\t");
                } else {
                    System.out.print(array[line][M-1 - column] + "\t");
                }
            }
            System.out.println();
        }
    }

}
