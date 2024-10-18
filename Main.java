import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static ArrayList<Expense> expenses = new ArrayList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nExpense Track Module:");
            System.out.println("1. Add Expense");
            System.out.println("2. View all Expense");
            System.out.println("3. Filter Expense by Category");
            System.out.println("4. Display Monthly summary");
            System.out.println("5. Exit");
            System.out.println("Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewAllExpenses();
                    break;
                case 3:
                    filterExpensesByCategory(scanner);
                    break;
                case 4:
                    displayMonthlySummary();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invlaid Choice. Please Try Again");
            }
        }
    }

    private static void displayMonthlySummary() {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getLocalDate().getMonth() == LocalDate.now().getMonth()) {
                total += expense.getAmount();
            }
        }
        System.out.println("Total Expenses for this month : " + total);
    }

    private static void filterExpensesByCategory(Scanner scanner) {
        System.out.println("Enter Category to filter: ");
        String category = scanner.nextLine();
        boolean isFound = false;
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                System.out.println(expense);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No Expenses found for this Category");
        }
    }

    private static void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No Expenses Recorded");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.println("Enter Amount : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter category(Eg : Food, Rent, Travel)");
        String category = scanner.nextLine();
        scanner.nextLine();

        LocalDate currenDate = LocalDate.now();
        Expense expense = new Expense(amount, category, currenDate);
        expenses.add(expense);
        System.out.println("Expense added successfully");
    }
}
