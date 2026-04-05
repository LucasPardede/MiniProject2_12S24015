package solution;

import java.time.LocalDate;

public class Task {
    private String mataKuliah;
    private String judulTugas;
    private LocalDate deadline;

    public Task(String mataKuliah, String judulTugas, LocalDate deadline) {
        this.mataKuliah = mataKuliah;
        this.judulTugas = judulTugas;
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return mataKuliah + " | " + judulTugas + " | Deadline: " + deadline;
    }
}