import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static File[] files = File.listRoots(); // root массив папок
    public static int[] numbers = new int[files.length]; // индексы массивов папок

    public static List<File[]> list = new ArrayList<>();
    public static List<int[]> list2 = new ArrayList<>();

    public static int deepToRec = 1;

    public static void main(String[] args) {

        for (int i = 0; i < files.length; i++) { // копируем..
            numbers[i] = i;
        }
        for (int i = 0; i < files.length; i++) {        // выводим в консоль
            System.out.println(numbers[i] + " " + files[i]);
        }

        list.add(files);
        list2.add(numbers);
        loopFolderSearch();

    }

    public static void loopFolderSearch()  {
        System.out.println("Введите число или слово back для перехода назад");
        String count = scanner.nextLine();

        if (count.equals("back")) {
            File[] view = list.get(deepToRec - 1);
            int[] view2 = list2.get(deepToRec - 1);
            for (int i = 0; i < view.length; i++) {
                String a = "";
                String b = "";
                if (view[i].isDirectory()) {
                    a = "[Папка]";
                }
                if (view[i].isFile()) {
                    b = "[Файл] " + fileSize(view[i]) + " mb";
                }
                System.out.println(view2[i] + " " + a + b + " " + view[i]);
            }

            files = list.get(deepToRec - 1);
            numbers = list2.get(deepToRec - 1);
            deepToRec--;
            list.remove(list.get(list.size() - 1));
            list2.remove(list2.get(list2.size() - 1));
            loopFolderSearch();

        }
        else if(StringUtils.isNumeric(count)){

        }
        else {
            System.out.println("Вы ввели не число и не слово back!");
            loopFolderSearch();
        }
        int[] number1 = numbers;

        for (int i = 0; i < number1.length; i++) {
            if (count.equals(String.valueOf(number1[i]))) {
                File[] file = files[i].listFiles(); // массив подпапки
                int[] number = new int[0];

                if (file.length == 0) {
                    System.out.println("Эта папка пустая");


                }
                if (file != null) {
                    number = new int[file.length];
                }

                list.add(files);
                list2.add(numbers);

                files = file;
                numbers = number;

                for (int j = 0; j < file.length; j++) {
                    number[j] = j;
                }

                for (int j = 0; j < file.length; j++) {  // просмотр массива подпапок
                        String a = "";
                        String b = "";
                        if (file[j].isDirectory()) {
                            a = "[Папка]";
                        }
                        if (file[j].isFile()) {
                            b = "[Файл] " + fileSize(file[j]) + " mb";
                        }
                        System.out.println(number[j] + " " + a + b + " " + file[j]);

                }
                break;
            }
        }
        deepToRec++;
        loopFolderSearch();
    }
    public static double fileSize(File file) {
        // Получаем размер файла в байтах
        long fileSizeInBytes = file.length();

        // Переводим размер из байт в мегабайты

        return Math.round((double) fileSizeInBytes / (1024 * 1024));
    }
}
