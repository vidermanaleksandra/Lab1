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

1) Инициализация списка дел

Создаем пустой список задач с возможностью задать пользовательское имя.

Создаём объект класса TodoList:

Без параметров → используем имя по умолчанию: "Мой список дел".

С параметром name → имя устанавливается как заданное.

Внутри объекта:

Инициализируется пустой список tasks типа ArrayList<Task>.

Создаётся внутренний класс Task, содержащий:

name — название дела (строка),

completed — флаг завершённости (false по умолчанию).

2) Добавление нового дела (addTask)

Добавляем дело, если оно ещё не существует.

Получаем название дела taskName.

Проверяем все существующие дела:

Если найдено дело с таким же названием → выводим сообщение об ошибке и завершаем.

Если дело новое:

Создаем объект new Task(taskName).

Добавляем его в tasks.

Выводим подтверждение.

3) Вывод всех дел (printAllTasks)

Показываем весь список с индексацией буквами (a, b, c, …) и статусами.

Выводим заголовок (имя списка).

Если список пуст → сообщаем об этом.

Иначе:

Начинаем с буквы 'a'.

Для каждого дела:

Если completed == true → статус "x", иначе " ".

Выводим: (буква) [статус] "название".

4) Вывод только невыполненных дел (printPendingTasks)

Показываем только незавершённые дела.

Выводим заголовок "Невыполненные дела:".

Проходим по всем делам, считая буквы.

Выводим только те, где completed == false.

Если таких нет → сообщаем.

5) Вывод только выполненных дел (printCompletedTasks)

Показываем только завершённые дела.

Аналогично printPendingTasks, но фильтр: completed == true.

6) Переключение статуса дела

а) По номеру (toggleTaskByNumber):

Проверяем, что номер number в диапазоне [1, размер списка].

Если нет → ошибка.

Иначе:

Берем дело по индексу number - 1.

Меняем completed.

Выводим сообщение: "Дело ... выполнено." или "снято с выполнения.".

б) По названию (toggleTaskByName):

Проходим по всем делам.

Находим первое с совпадающим названием.

Переключаем статус и выводим сообщение.

Если не найдено → сообщаем об ошибке.

7) Получение номера по названию (getTaskNumberByName)

Узнаем позицию дела по его названию

Проходим по списку.

При совпадении названия → возвращаем индекс + 1.

Если не найдено → возвращаем -1.

8) Удаление дела

Есть два способа:

а) По номеру (removeTaskByNumber):

Проверяем корректность номера.

Удаляем из списка по индексу number - 1.

Выводим сообщение с названием удалённого дела.

б) По названию (removeTaskByName):

Находим дело с совпадающим названием.

Удаляем первое найденное.

Выводим сообщение.

Если не найдено → сообщаем об ошибке.

9) Статистика

Методы:

getTotalTasks() → общее количество дел.

getCompletedCount() → количество с completed == true.

getPendingCount() → разница между общим и выполненным.

getCompletionPercentage() → процент выполнения (0.0–100.0).

printStatistics():

Выводит:

Всего дел

Выполнено

Не выполнено

Процент (с 1 знаком после запятой)

10) Консольный интерфейс (main)

Обеспечиваем интерактивное взаимодействие.

Создаем TodoList с именем "Дела на неделю".

Запускаем бесконечный цикл:

Выводим доступные команды.

Прочитываем строку от пользователя.

Обрабатываем команду:

Команды:

add <текст> - добавить дело

list - вывести все дела

pending - только невыполненные

done - только выполненные

toggle <номер или название> - переключить статус

remove <номер или название> - удалить дело

stats - показать статистику

exit - завершить программу

11) Завершение программы

При вводе exit:

Выходим из цикла.

Закрытие Scanner.

Вывод "До свидания!".

### 3. Программа

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    private static class Task {
        String name;
        boolean completed;

        Task(String name) {
            this.name = name;
            this.completed = false;
        }
    }

    private List<Task> tasks = new ArrayList<>();
    private String name = "Мой список дел";

    // Конструкторы
    public TodoList() {}

    public TodoList(String name) {
        this.name = name;
    }

    // Добавление нового дела (проверка на дубликат)
    public void addTask(String taskName) {
        for (Task t : tasks) {
            if (t.name.equals(taskName)) {
                System.out.println("Дело \"" + taskName + "\" уже существует.");
                return;
            }
        }
        tasks.add(new Task(taskName));
        System.out.println("Дело \"" + taskName + "\" добавлено.");
    }

    // Вывод всего списка
    public void printAllTasks() {
        System.out.println(name + ":");
        if (tasks.isEmpty()) {
            System.out.println("  Список пуст.");
            return;
        }
        char letter = 'a';
        for (Task t : tasks) {
            String status;
            if (t.completed) {
                status = "x";
            } else {
                status = " ";
            }
            System.out.println("  (" + letter + ") [" + status + "] \"" + t.name + "\"");
            letter++;
        }
    }

    // Вывод только невыполненных дел
    public void printPendingTasks() {
        System.out.println("Невыполненные дела:");
        boolean found = false;
        char letter = 'a';
        for (Task t : tasks) {
            if (!t.completed) {
                System.out.println("  (" + letter + ") [ ] \"" + t.name + "\"");
                found = true;
            }
            letter++;
        }
        if (!found) {
            System.out.println("  Нет невыполненных дел.");
        }
    }

    // Вывод только выполненных дел
    public void printCompletedTasks() {
        System.out.println("Выполненные дела:");
        boolean found = false;
        char letter = 'a';
        for (Task t : tasks) {
            if (t.completed) {
                System.out.println("  (" + letter + ") [x] \"" + t.name + "\"");
                found = true;
            }
            letter++;
        }
        if (!found) {
            System.out.println("  Нет выполненных дел.");
        }
    }

    // Изменение статуса по номеру
    public void toggleTaskByNumber(int number) {
        if (number < 1 || number > tasks.size()) {
            System.out.println("Неверный номер: " + number);
            return;
        }
        Task t = tasks.get(number - 1);
        t.completed = !t.completed;
        String status;
        if (t.completed) {
            status = "выполнено";
        } else {
            status = "снято с выполнения";
        }
        System.out.println("Дело \"" + t.name + "\" " + status + ".");
    }

    // Изменение статуса по названию
    public void toggleTaskByName(String taskName) {
        for (Task t : tasks) {
            if (t.name.equals(taskName)) {
                t.completed = !t.completed;
                String status;
                if (t.completed) {
                    status = "выполнено";
                } else {
                    status = "снято с выполнения";
                }
                System.out.println("Дело \"" + t.name + "\" " + status + ".");
                return;
            }
        }
        System.out.println("Дело \"" + taskName + "\" не найдено.");
    }

    // Получение номера по названию
    public int getTaskNumberByName(String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).name.equals(taskName)) {
                return i + 1;
            }
        }
        return -1;
    }

    // Удаление по номеру
    public void removeTaskByNumber(int number) {
        if (number < 1 || number > tasks.size()) {
            System.out.println("Неверный номер: " + number);
            return;
        }
        String name = tasks.get(number - 1).name;
        tasks.remove(number - 1);
        System.out.println("Дело \"" + name + "\" удалено.");
    }

    // Удаление по названию
    public void removeTaskByName(String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).name.equals(taskName)) {
                tasks.remove(i);
                System.out.println("Дело \"" + taskName + "\" удалено.");
                return;
            }
        }
        System.out.println("Дело \"" + taskName + "\" не найдено.");
    }

    // Получение количества дел
    public int getTotalTasks() {
        return tasks.size();
    }

    public int getCompletedCount() {
        int count = 0;
        for (Task t : tasks) {
            if (t.completed) count++;
        }
        return count;
    }

    public int getPendingCount() {
        return getTotalTasks() - getCompletedCount();
    }

    // Процент выполнения
    public double getCompletionPercentage() {
        if (getTotalTasks() == 0) return 0.0;
        return (double) getCompletedCount() / getTotalTasks() * 100;
    }

    // Вывод статистики
    public void printStatistics() {
        int total = getTotalTasks();
        int done = getCompletedCount();
        int pending = getPendingCount();
        double percent = getCompletionPercentage();

        System.out.println("Статистика:");
        System.out.println("  Всего дел: " + total);
        System.out.println("  Выполнено: " + done);
        System.out.println("  Не выполнено: " + pending);
        System.out.printf("  Процент выполнения: %.1f%%\n", percent);
    }

    // Простой пример использования через консоль (опционально)
    public static void main(String[] args) {
        TodoList list = new TodoList("Дела на неделю");
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nКоманды: add, list, pending, done, toggle, remove, stats, exit");
            System.out.print("Введите команду: ");
            command = scanner.nextLine().trim();

            if (command.equals("exit")) {
                break;
            } else if (command.equals("list")) {
                list.printAllTasks();
            } else if (command.equals("pending")) {
                list.printPendingTasks();
            } else if (command.equals("done")) {
                list.printCompletedTasks();
            } else if (command.startsWith("add ")) {
                String task = command.substring(4).trim();
                if (!task.isEmpty()) list.addTask(task);
            } else if (command.startsWith("toggle ")) {
                String arg = command.substring(7).trim();
                try {
                    int num = Integer.parseInt(arg);
                    list.toggleTaskByNumber(num);
                } catch (NumberFormatException e) {
                    list.toggleTaskByName(arg);
                }
            } else if (command.startsWith("remove ")) {
                String arg = command.substring(7).trim();
                try {
                    int num = Integer.parseInt(arg);
                    list.removeTaskByNumber(num);
                } catch (NumberFormatException e) {
                    list.removeTaskByName(arg);
                }
            } else if (command.equals("stats")) {
                list.printStatistics();
            } else {
                System.out.println("Неизвестная команда.");
            }
        }
        scanner.close();
        System.out.println("До свидания!");
    }
}

```

