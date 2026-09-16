/**
 * Практическое задание 1. Разработка базового класса и инкапсуляция
 * Вариант 11: LibraryCard (Библиотечный абонемент)
 *
 * Учёт количества взятых книг с ограничением на максимальное число
 * одновременно выданных книг (не более 5).
 */
public class LibraryCard {

    // Шаг 1. Приватные поля класса
    private String cardNumber;
    private String ownerName;
    private int booksCount;

    // Максимально допустимое количество книг на руках
    private static final int MAX_BOOKS = 5;

    // Шаг 2. Конструктор
    public LibraryCard(String cardNumber, String ownerName) {
        this.cardNumber = cardNumber;
        this.ownerName = ownerName;
        this.booksCount = 0; // по умолчанию книг на руках нет
    }

    // Шаг 3. Методы (инкапсуляция)

    // Геттер — доступ только на чтение
    public int getBooksCount() {
        return booksCount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Взять книгу — увеличивает счётчик книг на 1.
     * Валидация: нельзя превышать MAX_BOOKS одновременно выданных книг.
     */
    public void borrowBook() {
        if (booksCount >= MAX_BOOKS) {
            System.out.println("Не могу выдать книгу - лимит уже достигнут (" + MAX_BOOKS + " шт.)");
            return;
        }
        booksCount++;
        System.out.println("Книга выдана. Сейчас на руках: " + booksCount + " кн.");
    }

    /**
     * Вернуть книгу — уменьшает счётчик книг на 1.
     * Валидация: нельзя вернуть книгу, если на руках их нет.
     */
    public void returnBook() {
        if (booksCount <= 0) {
            System.out.println("Ошибка: нет книг для возврата");
            return;
        }
        booksCount--;
        System.out.println("Книга возвращена. Сейчас на руках: " + booksCount + " кн.");
    }

    // Шаг 4. Проверка работы
    public static void main(String[] args) {
        LibraryCard card = new LibraryCard("LC-001", "Аманов Самат");

        System.out.println("Абонемент: " + card.getCardNumber() + ", владелец: " + card.getOwnerName());

        // берем 5 книг подряд, все должны пройти без ошибок
        for (int j = 1; j <= 5; j++) {
            card.borrowBook();
        }

        // а вот тут уже перебор - лимит сработает
        card.borrowBook();

        // сдаем 2 книги обратно
        card.returnBook();
        card.returnBook();

        // ну и смотрим что в итоге осталось на руках
        System.out.println("Итоговое количество книг на руках: " + card.getBooksCount());
    }
}
