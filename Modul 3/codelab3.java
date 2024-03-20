import java.util.Scanner;

public abstract class codelab3 {
    private String name;

    public codelab3(String name) {
        this.name = name;
    }

    public abstract void inputNilai();

    public abstract double luasPermukaan();

    public abstract double volume();

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        codelab3[] bangunRuangs = {
                new Kubus("kubus"),
                new Tabung("tabung"),
                new Balok("balok")
        };

        for (codelab3 bangunRuang : bangunRuangs) {
            bangunRuang.inputNilai();
            System.out.println("Luas permukaan " + bangunRuang.getName() + ": " + bangunRuang.luasPermukaan());
            System.out.println("Volume " + bangunRuang.getName() + ": " + bangunRuang.volume());
            System.out.println();
        }
    }
}

class Kubus extends codelab3 {
    private double sisi;

    public Kubus(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input nilai untuk " + getName());
        System.out.print("Input sisi: ");
        sisi = scanner.nextDouble();
    }

    @Override
    public double luasPermukaan() {
        return 6 * Math.pow(sisi, 2);
    }

    @Override
    public double volume() {
        return Math.pow(sisi, 3);
    }
}

class Tabung extends codelab3 {
    private double tinggi;
    private double jariJari;

    public Tabung(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input nilai untuk " + getName());
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
        System.out.print("Input jari-jari: ");
        jariJari = scanner.nextDouble();
    }

    @Override
    public double luasPermukaan() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(jariJari, 2) * tinggi;
    }
}

class Balok extends codelab3 {
    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input nilai untuk " + getName());
        System.out.print("Input panjang: ");
        panjang = scanner.nextDouble();
        System.out.print("Input lebar: ");
        lebar = scanner.nextDouble();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
    }

    @Override
    public double luasPermukaan() {
        return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }

    @Override
    public double volume() {
        return panjang * lebar * tinggi;
    }
}