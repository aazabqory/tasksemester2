import java.util.Scanner;

public class codelab2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
        int jumlahMahasiswa = 0;

        while (true) {
            System.out.println("Menu myUMM:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan;

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan pilihan yang valid (angka 1-3).");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama Mahasiswa: ");
                    String nama = scanner.nextLine();

                    boolean validNim = false;
                    String nim;
                    do {
                        System.out.print("Masukkan NIM Mahasiswa (15 digit): ");
                        nim = scanner.nextLine();
                        if (nim.isEmpty()) {
                            System.out.println("NIM tidak boleh kosong!");
                            continue;
                        }
                        if (nim.length() != 15) {
                            System.out.println("NIM HARUS 15 DIGIT!");
                        } else {
                            validNim = true;
                        }
                    } while (!validNim);

                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    String jurusan = scanner.nextLine();

                    Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan);
                    daftarMahasiswa[jumlahMahasiswa++] = mhs;

                    System.out.println("Data Mahasiswa berhasil ditambahkan.");
                    break;
                case 2:
                    if (jumlahMahasiswa == 0) {
                        System.out.println("Data Mahasiswa masih kosong.");
                    } else {
                        System.out.println("Data Mahasiswa:");
                        System.out.println(Mahasiswa.tampilUniversitas());
                        for (int i = 0; i < jumlahMahasiswa; i++) {
                            System.out.println(daftarMahasiswa[i].tampilDataMahasiswa());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Have a Nice Day!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static class Mahasiswa {

        private String nama;
        private String nim;
        private String jurusan;

        public Mahasiswa(String nama, String nim, String jurusan) {
            this.nama = nama;
            this.nim = nim;
            this.jurusan = jurusan;
        }
        public String getNama() {
            return nama;
        }
        public void setNama(String nama) {
            this.nama = nama;
        }
        public String getNim() {
            return nim;
        }
        public void setNim(String nim) {
            this.nim = nim;
        }
        public String getJurusan() {
            return jurusan;
        }
        public void setJurusan(String jurusan) {
            this.jurusan = jurusan;
        }
        public static String tampilUniversitas() {
            return "Universitas Muhammadiyah Malang";
        }
        public String tampilDataMahasiswa() {
            return String.format("Nama: %s, NIM: %s, Jurusan: %s", nama, nim, jurusan);
        }
    }
}