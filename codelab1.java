import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class codelab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Anda : ");
        String nama = scanner.nextLine();

        System.out.print("Jenis Kelamin (J/B) : ");
        String jenisKelaminStr = scanner.nextLine();
        JenisKelamin jenisKelamin = JenisKelamin.valueOf(jenisKelaminStr.toUpperCase());

        System.out.print("Tanggal Lahir (yyyy-mm-dd) : ");
        String tanggalLahirStr = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);
        LocalDate today = LocalDate.now();
        Period age = Period.between(tanggalLahir, today);

        long totalHari = age.toTotalMonths() * 30 + age.getDays();

        System.out.println();
        System.out.println("Nama anda : " + nama);
        System.out.println("Jenis Kelamin : " + jenisKelamin.getNamaLengkap());
        System.out.println("Umur Anda : " + age.getYears() + " tahun " + age.getMonths() + " bulan " + age.getDays() + " hari");

        String[] hariIndonesia = {"Ahad", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu"};
        System.out.println("Sekarang Hari " + hariIndonesia[today.getDayOfWeek().getValue()] + ", tanggal " + today.getDayOfMonth() + " bulan " + today.getMonthValue() + " tahun " + today.getYear());
    }
    enum JenisKelamin {
        J("Jantan"),
        B("Betina");
        private final String namaLengkap;
        JenisKelamin(String namaLengkap) {
            this.namaLengkap = namaLengkap;
        }
        public String getNamaLengkap() {
            return namaLengkap;
        }
    }
}