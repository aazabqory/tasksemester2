import java.util.Scanner;
public class tugas1 {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            displayMenu();
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    loginStudent(scanner);
                    break;
                case 2:
                    loginAdmin(scanner);
                    break;
                case 3:
                    System.out.println("See you soon");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (pilihan != 3);
        scanner.close();
    }
    private static void displayMenu() {
        System.out.println("Library System");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
    }
    private static void loginStudent(Scanner scanner) {
        System.out.print("Enter your NIM: ");
        String nim = scanner.next();
        if (isValidNim(nim)) {
            System.out.println("Successful Login as Student");
        } else {
            System.out.println("User Not Found!");
        }
    }
    private static void loginAdmin(Scanner scanner) {
        System.out.print("Enter your username (admin): ");
        String username = scanner.next();

        System.out.print("Enter your password (admin): ");
        String password = scanner.next();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Successful Login as Admin.");
        } else {
            System.out.println("Admin User Not Found!");
        }
    }
    private static boolean isValidNim(String nim) {
        return nim.length() == 15;
    }
}