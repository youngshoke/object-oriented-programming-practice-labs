
public class LibraryCard {

    // Shag 1. Privatnye polya klassa
    private String cardNumber;
    private String ownerName;
    private int booksCount;

   
    private static final int MAX_BOOKS = 5;


    public LibraryCard(String cardNumber, String ownerName) {
        this.cardNumber = cardNumber;
        this.ownerName = ownerName;
        this.booksCount = 0;
    }

   //only read
    public int getBooksCount() {
        return booksCount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    
    public void borrowBook() {
        if (booksCount >= MAX_BOOKS) {
            System.out.println("Ne mogu vydat knigu - limit uzhe dostignut (" + MAX_BOOKS + " sht.)");
            return;
        }
        booksCount++;
        System.out.println("Kniga vydana. Seychas na rukakh: " + booksCount + " kn.");
    }

    
    public void returnBook() {
        if (booksCount <= 0) {
            System.out.println("Oshibka: net knig dlya vozvrata");
            return;
        }
        booksCount--;
        System.out.println("Kniga vozvrashchena. Seychas na rukakh: " + booksCount + " kn.");
    }


    public static void main(String[] args) {
        LibraryCard card = new LibraryCard("LC-001", "Amanov Samat");

        System.out.println("Abonement: " + card.getCardNumber() + ", vladelets: " + card.getOwnerName());

        // berem 5 
        for (int j = 1; j <= 5; j++) {
            card.borrowBook();
        }

        // limit
        card.borrowBook();

        // back 2 books
        card.returnBook();
        card.returnBook();

        // end
        System.out.println("Itogovoe kolichestvo knig na rukakh: " + card.getBooksCount());
    }
}