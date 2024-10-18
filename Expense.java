import java.time.LocalDate;

public class Expense {
    private double amount;
    private String category;
    private LocalDate localDate;

    public Expense(double amount, String category, LocalDate localDate) {
        this.amount = amount;
        this.category = category;
        this.localDate = localDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "Amount: " + amount + ", Category: " + category + ", Date: " + localDate;
    }
}
