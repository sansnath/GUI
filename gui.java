package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class gui extends JFrame {
    private JPanel mainPanel;
    private JTextField namaField, tanggalLahirField, nomorRegistrasiField, nomorTeleponField, alamatField, emailField;
    private JButton submitButton;

    public gui() {
        setTitle("Registrasi Mahasiswa");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame();
    }

    private void frame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        namaField = new JTextField(20);
        tanggalLahirField = new JTextField(20);
        nomorRegistrasiField = new JTextField(20);
        nomorTeleponField = new JTextField(20);
        alamatField = new JTextField(20);
        emailField = new JTextField(20);

        mainPanel.add(createLabelFieldPanel("Nama Lengkap:", namaField));
        mainPanel.add(createLabelFieldPanel("Tanggal Lahir:", tanggalLahirField));
        mainPanel.add(createLabelFieldPanel("Nomor Pendaftaran:", nomorRegistrasiField));
        mainPanel.add(createLabelFieldPanel("Nomor Telepon:", nomorTeleponField));
        mainPanel.add(createLabelFieldPanel("Alamat:", alamatField));
        mainPanel.add(createLabelFieldPanel("E-mail:", emailField));

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        mainPanel.add(submitButton);
        add(mainPanel);
    }

    private JPanel createLabelFieldPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, 20));
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    private void submitForm() {
        if (namaField.getText().isEmpty() || tanggalLahirField.getText().isEmpty() ||
                nomorRegistrasiField.getText().isEmpty() || nomorTeleponField.getText().isEmpty() ||
                alamatField.getText().isEmpty() || emailField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Mohon semua data diisi.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int respon = JOptionPane.showConfirmDialog(this,
                    "Apakah data yang anda masukkan sudah benar?",
                    "Konfirmasi",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (respon == JOptionPane.OK_OPTION) {
                hasilData();
            }
        }
    }

    private void hasilData() {
        JFrame frameDetail = new JFrame("Data Mahasiswa");
        frameDetail.setSize(350, 250);
        frameDetail.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.cyan);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 500, 10));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        textLabel("Nama", namaField.getText(), detailsPanel, gbc, 0);
        textLabel("Tanggal Lahir", tanggalLahirField.getText(), detailsPanel, gbc, 1);
        textLabel("Nomor Registrasi", nomorRegistrasiField.getText(), detailsPanel, gbc, 2);
        textLabel("Nomor Telepon", nomorTeleponField.getText(), detailsPanel, gbc, 3);
        textLabel("Alamat", alamatField.getText(), detailsPanel, gbc, 4);
        textLabel("E-mail", emailField.getText(), detailsPanel, gbc, 5);

        frameDetail.add(topPanel, BorderLayout.NORTH);
        frameDetail.add(bottomPanel, BorderLayout.CENTER);

        topPanel.add(detailsPanel, BorderLayout.CENTER);

        JLabel judulLabel = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        judulLabel.setFont(new Font("Serif", Font.BOLD, 30));
        judulLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        topPanel.add(judulLabel, BorderLayout.NORTH);

        frameDetail.setVisible(true);
    }

    private void textLabel(String labelText, String text, JPanel panel, GridBagConstraints gbc, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 0, 5);

        JLabel label = new JLabel(labelText, SwingConstants.LEFT);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        panel.add(label, gbc);

        JLabel colonLabel = new JLabel(":", SwingConstants.LEFT);
        colonLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 5);
        panel.add(colonLabel, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        JLabel valueLabel = new JLabel(text);
        valueLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        panel.add(valueLabel, gbc);
    }
}