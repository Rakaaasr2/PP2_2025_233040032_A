package modul03.Latihan1;

public class ProgramSiswa {

    public static void main(String[] args) {
        System.out.println("--- Data Siswa ---");

        Siswa siswa1 = new Siswa("Budi", "10A", 12345);
        Siswa siswa2 = new Siswa("Ani", "11B", 54321);

        siswa1.infoSiswa();
        siswa2.infoSiswa();
    }
}