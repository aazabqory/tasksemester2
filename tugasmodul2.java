import java.util.ArrayList;
import java.util.Scanner;

public class tugasmodul2 {
    static ArrayList<String> studentlist = new ArrayList<>();
    static ArrayList<String> bookList = new ArrayList<>();

    public static void main(String[] args) {
        bookList.add("1*title*author*Sejarah*3");
        bookList.add("2*title2*author2*Komedi*4");
        bookList.add("3*title3*author3*Komedi*2");
        menu();
    }

    static void menu() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Perpustakaan UMM =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
        pil = input.nextInt();

        switch (pil) {
            case 1:
                System.out.println("Student");
                inputNim();
                break;
            case 2:
                System.out.println("Admin");
                System.out.print("Enter Your Username (admin): ");
                String userAdmin = input.next();
                System.out.print("Enter Your NIM (admin): ");
                String passAdmin = input.next();
                if (userAdmin.equalsIgnoreCase("admin") && passAdmin.equalsIgnoreCase("admin")) {
                    System.out.println("Successful Login as Admin");
                    menuAdmin();
                } else {
                    System.out.println("Invalid c for admin");
                    menu();
                }
                break;
            case 3:
                System.out.println("Thankyou Exiting Program");
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
    }

    static void inputNim() {
        Scanner input = new Scanner(System.in);
        String nim;
        boolean continueInput = true;
        int i = 99;
        while (continueInput) {
            System.out.print("Enter your NIM (input " + i + " for back): ");
            nim = input.next();
            if (checkNim(nim) == 1) {
                System.out.println("benar");
                menuStudent();
                continueInput = false;
            } else if (i == 0) {
                System.out.println("Input NIM gagal");
                continueInput = false;
            } else {
                i--;
            }
        }
    }

    static int checkNim(String nim) {
        return nim.length() == 15 ? 1 : 0;
    }

    static void menuStudent() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Student Menu =====");
        System.out.println("1. Buku Terpinjam");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Keluar");
        System.out.print("Choose option (1-3): ");
        pil = input.nextInt();

        Mahasiswa menu = new Mahasiswa();

        switch (pil) {
            case 1:
                System.out.println("Buku Terpinjam");
                menu.displayBooks();
                break;
            case 2:
                System.out.println("Pinjam Buku");
                menu.borrowBook();
                break;
            case 3:
                System.out.println("Pinjam Buku atau Logout");
                menu.Logout();
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
    }

    static void menuAdmin() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Admin Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Student");
        System.out.println("3. Logout");
        System.out.print("Choose option (1-3): ");
        pil = input.nextInt();

        Admin settingan = new Admin();

        switch (pil) {
            case 1:
                settingan.addStudent();
                break;
            case 2:
                settingan.displayStudents();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
    }
}

class Admin {
    String adminUsername;
    String adminPassword;
    String[] studentList;

    void displayStudents() {
        for (String data : tugasmodul2.studentlist) {
            studentList = data.split("-");
            System.out.println("Nama: " + studentList[0] + "\nFakultas: " + studentList[1] + "\nNIM: " + studentList[2] + "\nProgram: " + studentList[3] + "\n");
        }
        tugasmodul2.menuAdmin();
    }

    void addStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama Mahasiswa : ");
        String nama = input.next();
        System.out.print("Masukkan nim Mahasiswa : ");
        String nim = input.next();
        while (nim.length() != 15) {
            System.out.println("NIM harus 15 Digit !!!");
            System.out.print("Masukkan nim Mahasiswa : ");
            nim = input.next();
        }
        System.out.print("Masukkan fakultas Mahasiswa : ");
        String fakultas = input.next();
        System.out.print("Masukkan jurusan Mahasiswa : ");
        String jurusan = input.next();

        tugasmodul2.studentlist.add(nama + "-" + fakultas + "-" + nim + "-" + jurusan);

        tugasmodul2.menuAdmin();
    }
}

class Mahasiswa {
    String name;
    String faculty;
    String programStudi;
    ArrayList<String[]> borrowedBooks = new ArrayList<>();

    void Logout() {
        Scanner input = new Scanner(System.in);
        int pil;
        System.out.println("Input Id Buku yang Ingin dipinjam (input 99 untuk back)");
        System.out.print("Input: ");
        pil = input.nextInt();
        if (pil == 99) {
            tugasmodul2.menu();
        }
    }

    void displayBooks() {
        System.out.println("===================================================================================");
        System.out.println("|| No. || Id buku \t ||Nama Buku\t|| Author\t|| Category\t|| Stock ||");
        System.out.println("===================================================================================");

        for (int i = 0; i < tugasmodul2.bookList.size(); i++) {
            String[] book = tugasmodul2.bookList.get(i).split("\\*");
            System.out.println("|| " + (i + 1) + " || " + book[0] + "\t ||" + book[1] + "\t || " + book[2] + "\t ||" + book[3] + "\t || " + book[4] + "   ||");
        }

        System.out.println("===================================================================================");

        tugasmodul2.menuStudent();
    }

    void borrowBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan ID Buku yang ingin dipinjam:");
        String bookId = input.next();

        boolean bookFound = false;
        for (String book : tugasmodul2.bookList) {
            String[] bookData = book.split("\\*");
            if (bookData[0].equals(bookId)) {
                bookFound = true;
                int stock = Integer.parseInt(bookData[4]);
                if (stock > 0) {
                    stock--;
                    bookData[4] = String.valueOf(stock);
                    book = String.join("*", bookData);
                    tugasmodul2.bookList.set(tugasmodul2.bookList.indexOf(book), book);

                    String[] borrowedBook = {bookId, bookData[1], bookData[2]};
                    this.borrowedBooks.add(borrowedBook);
                    System.out.println("Buku berhasil dipinjam.");
                } else {
                    System.out.println("Stok buku habis.");
                }
                break;
            }
        }
        if (!bookFound) {
            System.out.println("ID Buku tidak ditemukan.");
        }
        tugasmodul2.menuStudent();
    }
}