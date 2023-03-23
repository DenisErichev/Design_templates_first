//Генератор данных выполняется в цикле и с
//        задержкой в интервале времени [3,10] сек создает список из N элементов либо
//        целого, либо строкового типа. Тип генератора настраивается в конструкторе.
//        Подсистема обработки данных содержит
//        ******обработчики списков целых чисел:
//        - первый обработчик возвращает их сумму, среднее значение, минимальный и
//        максимальный элемент,
//        - второй обработчик — удаляет из списка четные или нечетные элементы, в
//        зависимости от настройки.
//        ******обработчики списков строк:
//        - первый обработчик — возвращает «склеенную» строку
//        - второй обработчик подсчитывает количество слов в каждой строке, общее
//        количество слов и символов по всем строкам списка.
//        Результаты обработки передаются в общий логгер, который выводит данные в
//        консоль.
import CheckMethods.CheckMethods;
import GenerateData.Data.GenerationData;

import java.util.Scanner;

import static CheckMethods.CheckMethods.checkInputCommand;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String type = "";
    static int counterElements = 0;
    public static void main(String[] args) {
        System.out.print("Введите тип с которым хотите работать: целое или строковое: ");
        type = checkInputCommand(type,sc);
        System.out.print("Введите колличество элементов: ");
        counterElements = CheckMethods.checkInputNum();
        GenerationData data = new GenerationData(counterElements,type);
        data.generateCurrData();
        data.answer();
    }

}

