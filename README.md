      Генератор данных выполняется в цикле и с
        задержкой в интервале времени [3,10] сек создает список из N элементов либо
        целого, либо строкового типа. Тип генератора настраивается в конструкторе.
        Подсистема обработки данных содержит
        ******обработчики списков целых чисел:
        - первый обработчик возвращает их сумму, среднее значение, минимальный и
        максимальный элемент,
        - второй обработчик — удаляет из списка четные или нечетные элементы, в
        зависимости от настройки.
        ******обработчики списков строк:
        - первый обработчик — возвращает «склеенную» строку
        - второй обработчик подсчитывает количество слов в каждой строке, общее
          количество слов и символов по всем строкам списка.
Результаты обработки передаются в общий логгер, который выводит данные в
консоль.
