import java.util.Scanner;

public class tugas3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;
        User user = new User();

        while (isRunning) {
            System.out.println("==Perpustakaan Ajojing==");
            System.out.println("1. Login Mahasiswa");
            System.out.println("2. Login Admin");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.menuUser();
                    break;
                case 2:
                    user.menuAdmin();
                    break;
                case 3:
                    System.out.println("Have a Nice Dayy^-^");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}

class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int stock;
    private int duration;

    public Book(String bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void displayBooks() {
        System.out.println("Daftar Buku:");
        System.out.println("1. " + this.getTitle() + " by " + this.getAuthor());
    }
}

class HistoryBook extends Book {
    public HistoryBook(String bookId, String title, String author, String category) {
        super(bookId, title, author, category);
    }
}

class StoryBook extends Book {
    public StoryBook(String bookId, String title, String author, String category) {
        super(bookId, title, author, category);
    }
}

class TextBook extends Book {
    public TextBook(String bookId, String title, String author, String category) {
        super(bookId, title, author, category);
    }
}

class User {
    private String[][] bookList = {
            {"|| 1", "1", "Aaz Hirata", "Bagas Drible", "Action", "20"},
            {"|| 2", "2", "Tere Abqory", "Si Tokek", "Fantasy", "20"},
            {"|| 3", "3", "Aaz William", "Uni Bakwan", "Horror", "20"}
    };

    private String[][] borrowedBooks = new String[0][6];

    private String[][] userStudent = {};

    private final String admin_username = "admin";
    private final String admin_password = "admin";

    public void displayBooks() {
        System.out.println("========================================================================");
        System.out.println("|| No\tBook ID\tPenulis\t\t\tJudul\t\t\tKategori\tStock     ||");
        System.out.println("========================================================================");
        for (String[] book : bookList) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\t" + book[5]);
        }
        System.out.println("========================================================================");
    }

    public void addBook(String[] newBook) {
        bookList = append(bookList, newBook);
    }

    public void borrowBook(String bookId) {
        for (String[] book : bookList) {
            if (bookId.equals(book[1])) {
                if (Integer.parseInt(book[5]) > 0) {
                    String[] newBook = new String[6];
                    System.arraycopy(book, 0, newBook, 0, 6);
                    newBook[5] = String.valueOf(Integer.parseInt(newBook[5]) - 1);
                    String[] newBorrowedBook = new String[6];
                    System.arraycopy(book, 0, newBorrowedBook, 0, 6);
                    borrowedBooks = append(borrowedBooks, newBorrowedBook);
                    System.out.println("Buku berhasil dipinjam.\n");
                    return;
                } else {
                    System.out.println("Buku tidak tersedia.\n");
                    return;
                }
            }
        }
        System.out.println("Buku tidak ditemukan.\n");
    }

    public void displayBorrowedBooks() {
        System.out.println("No\tBook ID\tAuthor\t\t\t\tTitle\t\t\tCategory\tStatus");
        for (String[] book : borrowedBooks) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\tBorrowed");
        }
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        String username, password;

        System.out.print("Masukkan username (admin): ");
        username = scanner.nextLine();

        System.out.print("Masukkan password (admin): ");
        password = scanner.nextLine();

        if (!username.equals(admin_username) || !password.equals(admin_password)) {
            System.out.println("Username atau password salah.\n");
            return;
        }

        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Tambahkan Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String nim, nama, jurusan ;
                    System.out.print("Masukkan NIM Mahasiswa: \n");
                    nim = scanner.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    jurusan = scanner.nextLine();

                    String[] newStudent = {nim, nama, jurusan};
                    addStudent(newStudent);
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("Logout.\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }

    private void addStudent(String[] newStudent) {
        userStudent = append(userStudent, newStudent);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private void displayStudent() {
    }

    public void menuUser() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;
        String nim;
        System.out.print("Masukkan NIM: ");
        nim = scanner.nextLine();

        if (nim.length() != 15) {
            System.out.println("NIM tidak valid. Harus 15 digit cik!.\n");
            return;
        }

        while (isRunning) {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Pilihan Buku");
            System.out.println("2. Tampilkan Buku yang dipinjam");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    displayBorrowedBooks();
                    break;
                case 3:
                    System.out.print("Masukkan ID Buku : ");
                    scanner.nextLine();
                    borrowBook(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Keluar.\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi cik.\n");
            }
        }
    }

    private String[][] append(String[][] array, String[] toAppend) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAppend;
        return newArray;
    }
}