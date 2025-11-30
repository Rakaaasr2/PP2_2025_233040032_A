package modul07.Latihan1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenNilaiSiswaApp extends JFrame {
    // Variabel Global (Komponen GUI)
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // Method untuk membuat desain Tab Input
    private JPanel createInputPanel() {
        // Menggunakan GridLayout dengan 4 baris dan 2 kolom
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Komponen Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama); // [cite: 63]

        // Komponen Mata Pelajaran
        panel.add(new JLabel("Mata Pelajaran:"));
        // Opsi Mata Kuliah [cite: 66, 67]
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia",
                "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul); // [cite: 68]

        // Komponen Nilai [cite: 69]
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tombol Simpan [cite: 73]
        JButton btnSimpan = new JButton("Simpan Data"); //
        panel.add(new JLabel(""));
        panel.add(btnSimpan);

        // Event Handling Tombol Simpan [cite: 76]
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        return panel; // [cite: 83]
    }

    // Method untuk membuat desain Tab Tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Setup Model Tabel (Kolom) [cite: 91]
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0); // Baris awal 0
        tableData = new JTable(tableModel);

        // Membungkus tabel dengan ScrollPane
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Logika Validasi dan Penyimpanan Data
    private void prosesSimpan() {
        // 1. Ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // 2. VALIDASI INPUT [cite: 108]

        // Validasi 1: Cek apakah nama kosong [cite: 109, 139, 140, 141]
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE); // [cite: 111, 112]
            return; // Hentikan proses [cite: 113]
        }

        // Validasi 2: Cek apakah nilai berupa angka dan dalam range valid [cite: 114]
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai); // [cite: 117, 143]

            // Validasi range 0-100 [cite: 118, 147]
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0-100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE); // [cite: 119, 120]
                return; // [cite: 122]
            }
        } catch (NumberFormatException e) { // Menangkap error jika bukan angka [cite: 123, 144, 145, 146]
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE); // [cite: 124, 125]
            return; // [cite: 126]
        }

        // 3. Logika Bisnis (Menentukan Grade) [cite: 128]
        String grade;
        if (nilai >= 80) { // [cite: 129]
            grade = "A";
        } else if (nilai >= 70) {
            grade = "AB"; // [cite: 129]
        } else if (nilai >= 60) {
            grade = "B"; // [cite: 129]
        } else if (nilai >= 50) {
            grade = "BC"; // [cite: 130]
        } else if (nilai >= 40) {
            grade = "C"; // [cite: 130]
        } else if (nilai >= 30) {
            grade = "D"; // [cite: 130]
        } else {
            grade = "E"; // [cite: 130]
        }

        // 4. Masukkan ke Tabel (Update Model) [cite: 131]
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // 5. Reset Form dan Pindah Tab [cite: 132]
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0); // [cite: 135]
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!"); // [cite: 136]
        tabbedPane.setSelectedIndex(1); // Otomatis pindah ke tab tabel [cite: 136]
    }

    // Konstruktor tanpa parameter [cite: 148, 150]
    public ManajemenNilaiSiswaApp() {
        // 1. Konfigurasi Frame Utama [cite: 152]
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 2. Inisialisasi Tabbed Pane
        tabbedPane = new JTabbedPane();

        // 3. Membuat Panel untuk Tab 1 (Form Input)
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        // 4. Membuat Panel untuk Tab 2 (Tabel Data) [cite: 159]
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        // Menambahkan TabbedPane ke Frame [cite: 160]
        add(tabbedPane);
    }

    // Method main untuk menjalankan kelas [cite: 161]
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // [cite: 162]
            new ManajemenNilaiSiswaApp().setVisible(true); // [cite: 164]
        });
    }
}