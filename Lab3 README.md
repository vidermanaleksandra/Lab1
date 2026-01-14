# ## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2501`

#### Выполнила: `Видерман Александра Сергеевна`

#### Вариант: `3`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Алгоритм](#2-алгоритм)
- [Программа](#3-программа)

### 1. Постановка задачи
Разработать функционал для управления списком дел с возможностью добавления, удаления и изменения статуса задач. Предусмотреть вывод полного списка, выполненных
или невыполненных задач, а также отображение статистики: общее количество дел, выполненные, невыполненные и процент выполнения. Реализовать операции для работы
с задачами по их названию или порядковому номеру.

Описание функционала
1. Создание пустого списка дел
Создание списка дел с возможным указанием его названия. Список по умолчанию
пустой.
2. Вывод списка дел
Вывод списка дел в формате:
(a) [ ] «НевыполненноеДело»
(b) [ x ] «ВыполненноеДело».
Нумерация дел делает список удобным для восприятия.
3. Вывод списка не сделанных дел
Формирует и выводит список только невыполненных задач.
4. Вывод списка выполненных дел
Формирует и выводит список только выполненных задач.
5. Добавление нового дела
Добавляет новое дело в список, проверяя, что оно еще не существует.
6. Изменение статуса дела по номеру
Устанавливает статус задачи как выполненной, используя её порядковый номер.
7. Изменение статуса дела по названию
Устанавливает статус задачи как выполненной, используя её название.
8. Получение номера дела по названию
Возвращает порядковый номер задачи в списке по её названию.
9. Удаление дела по номеру
Удаляет дело из списка, используя его порядковый номер.
10. Удаление дела по названию
Удаляет дело из списка, используя его название.
11. Получение общего количества дел
Возвращает общее количество задач в списке.
12. Получение количества выполненных дел
Возвращает количество задач со статусом “выполнено”.
13. Получение количества невыполненных дел
Возвращает количество задач со статусом “не выполнено”.
14. Вычисление процента выполненных дел
Рассчитывает процент выполненных задач от общего количества. Может быть
выведен в удобном формате.
15. Вывод статистики по делам
Отображает количество всех дел, выполненных и невыполненных задач, а также
процент выполнения.

### 2. Алгоритм

1. Добавление нового дела
   
   `ЕСЛИ список полон (count >= MAX_TASKS):
    Вывести "Список полон!"
ИНАЧЕ:
    Прочитать название дела
    Удалить пробелы в начале и конце (trim)
    ЕСЛИ название пустое:
        Вывести ошибку
    ИНАЧЕ ЕСЛИ дело уже существует:
        Вывести "Такое дело уже существует!"
    ИНАЧЕ:
        Добавить дело в массив tasks[count]
        Установить completed[count] = false
        Увеличить count на 1
        Вывести "Дело добавлено!"`

2. Вывод всех дел

   
   `ЕСЛИ список пуст (count == 0):
    Вывести "Список пуст."
ИНАЧЕ:
    Для i от 0 до count-1:
        Определить статус: 
            если completed[i] == true → "x"
            иначе → " "
        Вывести в формате: "(буква) [статус] «название»"
        (буквы: a, b, c, ...)`

 3. Вывод невыполненных дел

    `Установить флаг found = false
Для i от 0 до count-1:
    ЕСЛИ completed[i] == false:
        Вывести дело в формате: "(буква) [ ] «название»"
        Установить found = true
ЕСЛИ found == false:
    Вывести "Нет невыполненных дел."`

 4. Вывод выполненных дел

    `Аналогично пункту 3, но проверяем completed[i] == true
и выводим в формате: "(буква) [x] «название»"`
    
 5.  Отметка как выполненное (по номеру)

`ЕСЛИ список пуст:
    Вывести ошибку
 ИНАЧЕ:
    Прочитать номер
    ЕСЛИ номер < 1 ИЛИ номер > count:
        Вывести "Неверный номер!"
     ИНАЧЕ:
        Установить completed[номер - 1] = true
        Вывести подтверждение`
        
    
 6.  Отметка как выполненное (по названию)

`ЕСЛИ список пуст:
    Вывести ошибку
 ИНАЧЕ:
    Прочитать название
    Для i от 0 до count-1:
        ЕСЛИ tasks[i] равно названию:
            Установить completed[i] = true
            Вывести подтверждение
            Завершить поиск
    ЕСЛИ не найдено:
        Вывести "Дело не найдено!"`
    
 7–8. Удаление дела (по номеру / по названию)

 `Аналогично пункту 5/6, но после нахождения:
    Сдвинуть все элементы справа на одну позицию влево
    Уменьшить count на 1`
 
 9. Поиск номера по названию

     `Для i от 0 до count-1:
    ЕСЛИ tasks[i] равно названию:
        Вывести "Номер дела: i+1"
        Завершить поиск
ЕСЛИ не найдено:
    Вывести "Дело не найдено!"`
    
 10. Вывод статистики

  `  Вычислить:
    total = count
    completedCount = количество true в completed[]
    pendingCount = total - completedCount
    percentage = (completedCount * 100.0) / total (если total > 0)
     Вывести:
    "Всего дел: total"
    "Выполнено: completedCount"
    "Не выполнено: pendingCount"
    "Процент выполнения: percentage%"`
    
### 3. Программа

```java

import java.util.Scanner;

public class Main {
    static final int MAX_TASKS = 100;


    static String[] tasks = new String[MAX_TASKS];
    static boolean[] completed = new boolean[MAX_TASKS];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Список дел ===");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать все дела");
            System.out.println("3. Показать невыполненные");
            System.out.println("4. Показать выполненные");
            System.out.println("5. Отметить как выполненное (по номеру)");
            System.out.println("6. Отметить как выполненное (по названию)");
            System.out.println("7. Удалить дело (по номеру)");
            System.out.println("8. Удалить дело (по названию)");
            System.out.println("9. Найти номер по названию");
            System.out.println("10. Статистика");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    printAllTasks();
                    break;
                case 3:
                    printPendingTasks();
                    break;
                case 4:
                    printCompletedTasks();
                    break;
                case 5:
                    markCompletedByNumber(scanner);
                    break;
                case 6:
                    markCompletedByName(scanner);
                    break;
                case 7:
                    removeByNumber(scanner);
                    break;
                case 8:
                    removeByName(scanner);
                    break;
                case 9:
                    findNumberByName(scanner);
                    break;
                case 10:
                    printStatistics();
                    break;
                case 0:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    // Добавление нового дела
    static void addTask(Scanner scanner) {
        if (count >= MAX_TASKS) {
            System.out.println("Список полон! Нельзя добавить больше " + MAX_TASKS + " дел.");
            return;
        }

        System.out.print("Введите название дела: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Название не может быть пустым!");
            return;
        }

        // Проверка существования уже такое дела
        for (int i = 0; i < count; i++) {
            if (tasks[i].equals(name)) {
                System.out.println("Такое дело уже существует!");
                return;
            }
        }

        tasks[count] = name;
        completed[count] = false;
        count++;
        System.out.println("Дело добавлено!");
    }

    // Вывод всех дел
    static void printAllTasks() {
        if (count == 0) {
            System.out.println("Список пуст.");
            return;
        }

        System.out.println("Все дела:");
        char letter = 'a';
        for (int i = 0; i < count; i++) {
            String status = completed[i] ? "x" : " ";
            System.out.println("(" + letter + ") [" + status + "] «" + tasks[i] + "»");
            letter++;
        }
    }

    // Вывод невыполненных дел
    static void printPendingTasks() {
        boolean found = false;
        System.out.println("Невыполненные дела:");
        char letter = 'a';
        for (int i = 0; i < count; i++) {
            if (!completed[i]) {
                System.out.println("(" + letter + ") [ ] «" + tasks[i] + "»");
                letter++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет невыполненных дел.");
        }
    }

    // Вывод выполненных дел
    static void printCompletedTasks() {
        boolean found = false;
        System.out.println("Выполненные дела:");
        char letter = 'a';
        for (int i = 0; i < count; i++) {
            if (completed[i]) {
                System.out.println("(" + letter + ") [x] «" + tasks[i] + "»");
                letter++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет выполненных дел.");
        }
    }

    // Отметка как выполненное по номеру
    static void markCompletedByNumber(Scanner scanner) {
        if (count == 0) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.print("Введите номер дела (1-" + count + "): ");
        int number = scanner.nextInt();

        if (number < 1 || number > count) {
            System.out.println("Неверный номер!");
            return;
        }

        completed[number - 1] = true;
        System.out.println("Дело отмечено как выполненное!");
    }

    // Отметка как выполненное по названию
    static void markCompletedByName(Scanner scanner) {
        if (count == 0) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.print("Введите название дела: ");
        String name = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (tasks[i].equals(name)) {
                completed[i] = true;
                System.out.println("Дело отмечено как выполненное!");
                return;
            }
        }
        System.out.println("Дело не найдено!");
    }

    // Удаление дела по номеру
    static void removeByNumber(Scanner scanner) {
        if (count == 0) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.print("Введите номер дела (1-" + count + "): ");
        int number = scanner.nextInt();

        if (number < 1 || number > count) {
            System.out.println("Неверный номер!");
            return;
        }

        for (int i = number - 1; i < count - 1; i++) {
            tasks[i] = tasks[i + 1];
            completed[i] = completed[i + 1];
        }
        count--;
        System.out.println("Дело удалено!");
    }

    // Удаление дела по названию
    static void removeByName(Scanner scanner) {
        if (count == 0) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.print("Введите название дела: ");
        String name = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (tasks[i].equals(name)) {
                for (int j = i; j < count - 1; j++) {
                    tasks[j] = tasks[j + 1];
                    completed[j] = completed[j + 1];
                }
                count--;
                System.out.println("Дело удалено!");
                return;
            }
        }
        System.out.println("Дело не найдено!");
    }

    // Поиск номера по названию
    static void findNumberByName(Scanner scanner) {
        if (count == 0) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.print("Введите название дела: ");
        String name = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (tasks[i].equals(name)) {
                System.out.println("Номер дела: " + (i + 1));
                return;
            }
        }
        System.out.println("Дело не найдено!");
    }

    // Вывод статистики
    static void printStatistics() {
        int total = count;
        int completedCount = 0;

        for (int i = 0; i < count; i++) {
            if (completed[i]) {
                completedCount++;
            }
        }
        int pendingCount = total - completedCount;
        double percentage = (total == 0) ? 0.0 : (double) completedCount / total * 100;

        System.out.println("Статистика:");
        System.out.println("Всего дел: " + total);
        System.out.println("Выполнено: " + completedCount);
        System.out.println("Не выполнено: " + pendingCount);
        System.out.printf("Процент выполнения: %.1f%%\n", percentage);
    }
}

```

