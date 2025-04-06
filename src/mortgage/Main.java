package mortgage;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main mortgage = new Main();
        Scanner scanner = new Scanner(System.in);
        double principal = 0;
        double Interest = 0;
        int year = 0;
        while (true) {
            System.out.print("Principal ($1K-$1M): ");
            principal = scanner.nextDouble();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("enter a number between 1000 and 1000000 ");
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            Interest = scanner.nextDouble();
            if (Interest > 0 && Interest <= 30)
                break;
            System.out.println("enter a number greater than 0 and less than and equal to 30");
        }
        while (true) {
            System.out.print("Period (Year): ");
            year = scanner.nextInt();
            if (year >= 1 && year <= 30)
                break;
            System.out.println("enter a value between 1 and 30");
        }

        double Mortgage = mortgage.calculateMortgage(principal, Interest, year);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(Mortgage));

        scanner.close();

    }

    public double calculateMortgage(double p, double I, int Y) {
        final int monthsInYear = 12;
        final int percent = 100;
        double Interest = I / (percent * monthsInYear);
        int numberOfMonths = Y * monthsInYear;

        double Mortgages = p * Interest * (Math.pow((1 + Interest), numberOfMonths))
                / (Math.pow((1 + Interest), numberOfMonths) - 1);

        return Mortgages;
    }
}
