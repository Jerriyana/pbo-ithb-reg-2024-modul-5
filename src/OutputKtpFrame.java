import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class OutputKtpFrame extends JFrame {
    public OutputKtpFrame(String nik, String nama, String tempatLahir, String tanggalLahir, String jenisKelamin,
                          String golDarah, String alamat, String rtRw, String kelDesa, String kecamatan,
                          String agama, String statusPerkawinan, String pekerjaan, String kewarganegaraan,
                          String berlakuHingga, String kotaPembuatan, String tanggalPembuatan,
                          ImageIcon foto, ImageIcon tandaTangan) {
        // Setting JFrame
        setTitle("E-KTP Output");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        // Panel kiri: Informasi teks KTP
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Label Header: Provinsi dan Kota
        JLabel provinsiLabel = new JLabel("PROVINSI REPUBLIK HARAPAN BANGSA");
        provinsiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel kotaLabel = new JLabel("KABUPATEN / KOTA " + kotaPembuatan.toUpperCase());
        kotaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        leftPanel.add(provinsiLabel);
        leftPanel.add(kotaLabel);
        leftPanel.add(Box.createVerticalStrut(10)); // Spacer

        // Informasi lainnya
        leftPanel.add(createRowLabel("NIK", nik));
        leftPanel.add(createRowLabel("Nama", nama));
        leftPanel.add(createRowLabel("Tempat/Tgl Lahir", tempatLahir + ", " + tanggalLahir));
        leftPanel.add(createRowLabel("Jenis Kelamin", jenisKelamin + "   Gol. Darah: " + golDarah));
        leftPanel.add(createRowLabel("Alamat", alamat));
        leftPanel.add(createRowLabel("RT/RW", rtRw));
        leftPanel.add(createRowLabel("Kel/Desa", kelDesa));
        leftPanel.add(createRowLabel("Kecamatan", kecamatan));
        leftPanel.add(createRowLabel("Agama", agama));
        leftPanel.add(createRowLabel("Status Perkawinan", statusPerkawinan));
        leftPanel.add(createRowLabel("Pekerjaan", pekerjaan));
        leftPanel.add(createRowLabel("Kewarganegaraan", kewarganegaraan));
        leftPanel.add(createRowLabel("Berlaku Hingga", berlakuHingga));

        // Panel kanan: Foto, Tanda Tangan, Kota dan Tanggal Pembuatan
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Foto Muka
        JLabel fotoLabel = new JLabel(foto);
        fotoLabel.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(fotoLabel);

        // Spacer
        rightPanel.add(Box.createVerticalStrut(20));

        // Tanda Tangan
        JLabel tandaTanganLabel = new JLabel(tandaTangan);
        tandaTanganLabel.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(tandaTanganLabel);

        // Spacer
        rightPanel.add(Box.createVerticalStrut(20));

        // Kota Pembuatan
        JLabel kotaPembuatanLabel = new JLabel("Kota: " + kotaPembuatan);
        kotaPembuatanLabel.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(kotaPembuatanLabel);

        // Tanggal Pembuatan
        JLabel tanggalPembuatanLabel = new JLabel("Tanggal: " + tanggalPembuatan);
        tanggalPembuatanLabel.setAlignmentX(CENTER_ALIGNMENT);
        rightPanel.add(tanggalPembuatanLabel);

        // Split pane untuk membagi panel kiri dan kanan
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(350); // Atur ukuran pembagi

        // Tambahkan split pane ke frame
        setContentPane(splitPane);
    }

    // Helper method untuk membuat baris label
    private JPanel createRowLabel(String label, String value) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel keyLabel = new JLabel(label + ": ");
        keyLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
        JLabel valueLabel = new JLabel(value);

        panel.add(keyLabel);
        panel.add(valueLabel);
        return panel;
    }
}
