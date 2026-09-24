// Prakticheskoe zadanie 2. Nasledovanie i polimorfizm
// Variant 11: Finansovye vklady i bankovskie scheta

// Shag 1. Bazovyi abstraktnyi klass BankDeposit
abstract class BankDeposit {

    private String accountId;   // identifikator scheta
    private String ownerName;   // imya vladelca
    protected double balance;   // tekushchiy balans scheta

    public BankDeposit(String accountId, String ownerName, double balance) {
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Abstraktnyi metod - kazhdyi potomok realizuet raschet procentov po-svoemu
    public abstract double calculateInterest();

    // Obshchiy dlya vseh potomkov metod polucheniya informacii o schete
    public String getInfo() {
        return String.format(
                "ID: %s | Vladelec: %-18s | Balans: %10.2f | Nachislennye procenty: %8.2f",
                accountId, ownerName, balance, calculateInterest()
        );
    }

    public String getAccountId() {
        return accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
}

// Shag 2. Klass-potomok CheckingAccount (tekushchiy schet - bez procentov)
class CheckingAccount extends BankDeposit {

    public CheckingAccount(String accountId, String ownerName, double balance) {
        super(accountId, ownerName, balance);
    }

    @Override
    public double calculateInterest() {
        // Po usloviyu tekushchiy schet procentov ne nachislyaet
        return 0.0;
    }
}

// Shag 3. Klass-potomok SavingsAccount
// (sberegatelnyi schet - s kapitalizaciey procentov)
class SavingsAccount extends BankDeposit {

    private double interestRate; // godovaya procentnaya stavka, %

    public SavingsAccount(String accountId, String ownerName, double balance, double interestRate) {
        super(accountId, ownerName, balance);

        if (interestRate < 0) {
            throw new IllegalArgumentException(
                    "Procentnaya stavka ne mozhet byt otricatelnoy"
            );
        }

        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        // Kapitalizaciya procentov: procenty nachislyayutsya na tekushchiy balans
        return balance * interestRate / 100.0;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

// Shag 4. Demonstraciya polimorfizma
public class BankDeposit_Task11 {

    public static void main(String[] args) {

        // Massiv ssylok na bazovyi tip BankDeposit
        BankDeposit[] deposits = new BankDeposit[4];

        deposits[0] = new CheckingAccount("CH-001", "Ivanov Ivan", 50000);
        deposits[1] = new CheckingAccount("CH-002", "Petrov Petr", 120000);
        deposits[2] = new SavingsAccount("SV-001", "Sidorova Anna", 200000, 8.5);
        deposits[3] = new SavingsAccount("SV-002", "Kim Aliya", 350000, 10.0);

        System.out.println("=== Spisok bankovskih schetov ===");

        for (BankDeposit d : deposits) {

            // Vyzov getInfo() privodit k vyzovu calculateInterest()
            // togo klassa, obekt kotorogo realno hranitsya v massive
            // Eto demonstriruet polimorfizm

            System.out.println(d.getInfo());
        }
    }
}