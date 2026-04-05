package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskManager {
    private ArrayList<Task> daftarTugas = new ArrayList<>();

    public void tambahTugas(Task task) {
        daftarTugas.add(task);
    }

    public void tampilkanTugas() {
        if (daftarTugas.isEmpty()) {
            System.out.println("Belum ada tugas.\n");
            return;
        }

        Collections.sort(daftarTugas, Comparator.comparing(Task::getDeadline));

        System.out.println("\n=== DAFTAR TUGAS ===");
        for (int i = 0; i < daftarTugas.size(); i++) {
            System.out.println((i + 1) + ". " + daftarTugas.get(i));
        }
        System.out.println();
    }

    public void hapusTugas(int index) {
    if (index >= 0 && index < daftarTugas.size()) {
        System.out.println("Tugas selesai: " + daftarTugas.get(index));
        daftarTugas.remove(index);
        System.out.println("Tugas berhasil dihapus!\n");

        // TAMPILKAN LIST TERBARU
        tampilkanTugas();

    } else {
        System.out.println("Nomor tidak valid!\n");
    }
}

    public int getJumlahTugas() {
        return daftarTugas.size();
    }
}