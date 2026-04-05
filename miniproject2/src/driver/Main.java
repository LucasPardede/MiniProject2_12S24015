package driver;

import java.util.Scanner;
import java.time.LocalDate;
import solution.Task;
import solution.TaskManager;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        int pilihan;

        do {
            System.out.println("=== STUDY TASK MANAGER ===");
            System.out.println("1. Tambah Banyak Tugas (Format: mk;judul;deadline)");
            System.out.println("2. Tandai Selesai (Hapus)");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.println("\nMasukkan tugas (ketik 'done' untuk selesai):");

                    while (true) {
                        System.out.print(">> ");
                        String baris = input.nextLine();

                        if (baris.equalsIgnoreCase("done")) {
                            break;
                        }

                        try {
                            String[] data = baris.split(";");

                            String mk = data[0];
                            String judul = data[1];
                            LocalDate deadline = LocalDate.parse(data[2]);

                            Task task = new Task(mk, judul, deadline);
                            manager.tambahTugas(task);

                        } catch (Exception e) {
                            System.out.println("Format salah! Gunakan: mk;judul;yyyy-mm-dd");
                        }
                    }

                    System.out.println("\nSemua tugas berhasil ditambahkan!");
                    manager.tampilkanTugas();
                    break;

                case 2:
                    manager.tampilkanTugas();

                    if (manager.getJumlahTugas() > 0) {
                        System.out.print("Pilih nomor tugas yang selesai: ");
                        int nomor = Integer.parseInt(input.nextLine());
                        manager.hapusTugas(nomor - 1);
                    }
                    break;

                case 3:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!\n");
            }

        } while (pilihan != 3);

        input.close();
    }
}