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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Semaphore;

import static CheckMethods.CheckMethods.checkInputCommand;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String type = "";
    static int counterElements = 0;
    public static void main(String[] args) throws InterruptedException {
        int noOfCustomers=2;
        int noOfWaitingChairs=1;
        Semaphore barberLock =  new Semaphore(0);
        Semaphore customerLock =  new Semaphore(0);

        GenerationData saloon1 = createDate(noOfWaitingChairs,barberLock,customerLock);
        GenerationData saloon2 = createDate(noOfWaitingChairs,barberLock,customerLock);
        Thread barberThread1 = new Thread(new Barber(barberLock,customerLock,saloon1));
        Thread barberThread2 = new Thread(new Barber(barberLock,customerLock,saloon2));
        List<Thread> lstBarber = new ArrayList<>();
        lstBarber.add(barberThread1);
        lstBarber.add(barberThread2);
        List<GenerationData> lst = new ArrayList<>();
        lst.add(saloon1);
        lst.add(saloon2);
        Thread[] threads = new Thread[noOfCustomers];
        //Create customers
        for (int i = 0; i < noOfCustomers; i++) {
            Thread thread = new Thread(new Customer(lst.get(i)));
            threads[i]=thread ;
        }

        //Barber
        for(Thread th: lstBarber) {
            th.start();
        }

        for (int i = 0; i <noOfCustomers; i++) {
            threads[i].start();
        }

        //Wait for all customers
        for (int i = 0; i <noOfCustomers; i++) {
            threads[i].join();
        }

        // Cancel Barber Thread
        for(Thread th: lstBarber) {
            th.interrupt();
        }

    }

    public static GenerationData createDate(int noOfWaitingChairs, Semaphore barberLock, Semaphore customerLock) {
        System.out.print("Введите тип с которым хотите работать: целое или строковое: ");
        String delete = "";
        String type1 ="";
        type1 = checkInputCommand(type1,sc);
        if(type1.equals("целое")) {
            System.out.println("Какие элементы удалить? (четные или нечетные)");
            delete = CheckMethods.checkInputParity(delete,sc);
        }
        System.out.print("Введите колличество элементов: ");
        counterElements = CheckMethods.checkInputNum();
        return new GenerationData(barberLock,customerLock,type1,counterElements,delete);
    }
}
