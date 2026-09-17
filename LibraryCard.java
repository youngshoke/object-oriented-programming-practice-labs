```java
/**
 * Практическое задание 1. Разработка базового класса и инкапсуляция
 * Вариант 11: LibraryCard (Библиотечный абонемент)
 *
 * Учёт количества взятых книг с ограничением на максимальное число
 * одновременно выданных книг (не более 5).
 */

public class LibraryCard {

    // Приватные поля класса
    private String cardNumber;
    private String ownerName;
    private int booksCount;

    // Максимальное количество книг, которое можно взять
    private static final int MAX_BOOKS = 5;

    // Конструктор
    public LibraryCard(String cardNumber, String ownerName) {
        this.cardNumber = cardNumber;
        this.ownerName = ownerName;
        this.booksCount = 0;
    }

    // Геттер для количества книг
    public int getBooksCount() {
        return booksCount;
    }

    // Геттер для имени владельца
    public String getOwnerName() {
        return ownerName;
    }

    // Геттер для номера абонемента
    public String getCardNumber() {
        return cardNumber;
    }

    // Метод для выдачи книги
    public void borrowBook() {
        if (booksCount >= MAX_BOOKS) {
            System.out.println(
                "Не могу выдать книгу - лимит уже достигнут (" 
                + MAX_BOOKS + " шт.)"
            );
            return;
        }

        booksCount++;

        System.out.println(
            "Книга выдана. Сейчас на руках: " 
            + booksCount + " кн."
        );
    }

    // Метод для возврата книги
    public void returnBook() {
        if (booksCount <= 0) {
            System.out.println("Ошибка: нет книг для возврата");
            return;
        }

        booksCount--;

        System.out.println(
            "Книга возвращена. Сейчас на руках: " 
            + booksCount + " кн."
        );
    }

    // Проверка работы программы
    public static void main(String[] args) {

        // Настраиваем вывод в UTF-8 для русского текста
        System.setOut(
            new java.io.PrintStream(
                new java.io.BufferedOutputStream(System.out),
                true,
                java.nio.charset.StandardCharsets.UTF_8
            )
        );

        // Создаём библиотечный абонемент
        LibraryCard card = new LibraryCard(
            "LC-001",
            "Аманов Самат"
        );

        // Выводим информацию об абонементе
        System.out.println(
            "Абонемент: " 
            + card.getCardNumber() 
            + ", владелец: " 
            + card.getOwnerName()
        );

        // Берём 5 книг подряд
        for (int j = 1; j <= 5; j++) {
            card.borrowBook();
        }

        // Пытаемся взять шестую книгу
        // Должно появиться сообщение об ошибке
        card.borrowBook();

        // Возвращаем 2 книги
        card.returnBook();
        card.returnBook();

        // Выводим итоговое количество книг
        System.out.println(
            "Итоговое количество книг на руках: " 
            + card.getBooksCount()
        );
    }
}
```

После сохранения в PowerShell выполни:

```powershell
javac -encoding UTF-8 LibraryCard.java
```

потом:

```powershell
java LibraryCard
```

**Важно:** `java .\LibraryCard.java` сейчас не используй — запускай именно `java LibraryCard`.
