/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasikasir_ujikom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author OWNER
 */
public class MenuUtama extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst;
ResultSet rst;
    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        konek = Koneksi.koneksiDB();
        mulai();
        tampilWaktu();
        
    }
    public void mulai(){
        Register.setEnabled(false);
        Logout.setEnabled(false);
        Master.setEnabled(false);
        Transaksi.setEnabled(false);
        Laporan.setEnabled(false);
        txtJam.setEnabled(false);
        txtTanggal.setEnabled(false);
        btnRegister.setEnabled(false);
        btnProduk.setEnabled(false);
        btnPelanggan.setEnabled(false);
        btnPenjualan.setEnabled(false);
        FormLogin.setVisible(false);
    }
    public void tampilWaktu(){
        Thread clock = new Thread(){
            public void run(){
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat Jam = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat Tanggal = new SimpleDateFormat("yyyy-MM-dd");
                txtJam.setText(Jam.format(cal.getTime()));
                txtTanggal.setText(Tanggal.format(cal.getTime()));
                try { sleep(1000);
                } catch (InterruptedException ex) {
                Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null,ex);
             }
                 }
        
        };
        clock.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnPelanggan = new javax.swing.JButton();
        btnProduk = new javax.swing.JButton();
        btnPenjualan = new javax.swing.JButton();
        FormLogin = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        cmbHakAkses = new javax.swing.JComboBox<>();
        btnBatal = new javax.swing.JButton();
        btnMasuk = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtJam = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Beranda = new javax.swing.JMenu();
        Register = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        Login = new javax.swing.JMenuItem();
        Master = new javax.swing.JMenu();
        Produk = new javax.swing.JMenuItem();
        Pelanggan = new javax.swing.JMenuItem();
        Transaksi = new javax.swing.JMenu();
        Penjualan = new javax.swing.JMenuItem();
        Laporan = new javax.swing.JMenu();
        rekaplap = new javax.swing.JMenuItem();
        Tentang = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setToolTipText("Aplikasi Kasir Menu Utama");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUser.setText("Silakan Login Dulu..!!");

        btnRegister.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-add-32.png")); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblUser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnRegister)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegister)
                .addGap(30, 30, 30))
        );

        btnPelanggan.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-customer-20.png")); // NOI18N
        btnPelanggan.setText("Pelanggan");
        btnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelangganActionPerformed(evt);
            }
        });

        btnProduk.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-product-20.png")); // NOI18N
        btnProduk.setText("Produk");

        btnPenjualan.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-sale-15.png")); // NOI18N
        btnPenjualan.setText("Penjualan");

        FormLogin.setTitle("Form Login");
        FormLogin.setVisible(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-login-70.png"))); // NOI18N
        jLabel2.setText("LOGIN DISINI");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-username-20.png")); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-password-20.png")); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-access-rights-20.png")); // NOI18N
        jLabel5.setText("Hak Akses");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        cmbHakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Salah Satu-", "Admin", "Petugas", " " }));

        btnBatal.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-cancel-20.png")); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnMasuk.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-enter-32.png")); // NOI18N
        btnMasuk.setText("MASUK");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormLoginLayout = new javax.swing.GroupLayout(FormLogin.getContentPane());
        FormLogin.getContentPane().setLayout(FormLoginLayout);
        FormLoginLayout.setHorizontalGroup(
            FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLoginLayout.createSequentialGroup()
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FormLoginLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormLoginLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel4)))
                    .addGroup(FormLoginLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbHakAkses, 0, 179, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(FormLoginLayout.createSequentialGroup()
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormLoginLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnBatal)
                        .addGap(87, 87, 87)
                        .addComponent(btnMasuk))
                    .addGroup(FormLoginLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        FormLoginLayout.setVerticalGroup(
            FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLoginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMasuk))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnPelanggan)
                        .addGap(117, 117, 117)
                        .addComponent(btnProduk)
                        .addGap(109, 109, 109)
                        .addComponent(btnPenjualan)
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(FormLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtJam, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FormLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPelanggan)
                    .addComponent(btnProduk)
                    .addComponent(btnPenjualan))
                .addGap(39, 39, 39))
        );

        Beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-home-20.png"))); // NOI18N
        Beranda.setText("Beranda");

        Register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-report-20.png"))); // NOI18N
        Register.setText("Register");
        Beranda.add(Register);

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-logout-15.png"))); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Beranda.add(Logout);

        Login.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-login-20 (2).png")); // NOI18N
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        Beranda.add(Login);

        jMenuBar1.add(Beranda);

        Master.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-shop-20.png"))); // NOI18N
        Master.setText("Master");

        Produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-product-15.png"))); // NOI18N
        Produk.setText("Produk");
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        Master.add(Produk);

        Pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-customer-15.png"))); // NOI18N
        Pelanggan.setText("Pelanggan");
        Pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PelangganActionPerformed(evt);
            }
        });
        Master.add(Pelanggan);

        jMenuBar1.add(Master);

        Transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-transaction-20.png"))); // NOI18N
        Transaksi.setText("Transaksi");

        Penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-sale-15.png"))); // NOI18N
        Penjualan.setText("Penjualan");
        Penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PenjualanActionPerformed(evt);
            }
        });
        Transaksi.add(Penjualan);

        jMenuBar1.add(Transaksi);

        Laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-report-20.png"))); // NOI18N
        Laporan.setText("Laporan");
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });

        rekaplap.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-report-20 (1).png")); // NOI18N
        rekaplap.setText("Rekap Laporan");
        rekaplap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rekaplapMouseClicked(evt);
            }
        });
        Laporan.add(rekaplap);

        jMenuBar1.add(Laporan);

        Tentang.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-about-20 (1).png")); // NOI18N
        Tentang.setText("Help");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-about-20 (1).png")); // NOI18N
        jMenuItem1.setText("Tentang");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Tentang.add(jMenuItem1);

        jMenuBar1.add(Tentang);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PenjualanActionPerformed
Pnjualan: new FormPenjualan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_PenjualanActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
try {
    String sql = "select *from login where Username='"+txtUsername.getText()+"' and Password='"+txtPassword.getText()+"' and HakAkses='" +cmbHakAkses.getSelectedItem()+"'";
    pst = konek.prepareStatement(sql);
    rst = pst.executeQuery();
    if(rst.next()){
        if(txtUsername.getText().equals(rst.getString("Username"))&& txtPassword.getText().equals(rst.getString("Password"))&& cmbHakAkses.getSelectedItem().equals(rst.getString("HakAKses"))             );
        if(cmbHakAkses.getSelectedItem().equals("Admin")) {
        Register.setEnabled(true);
        Logout.setEnabled(true);
        Master.setEnabled(true);
        Transaksi.setEnabled(true);
        Laporan.setEnabled(true);
        btnRegister.setEnabled(true);
        btnProduk.setEnabled(true);
        btnPelanggan.setEnabled(true);
        btnPenjualan.setEnabled(true);
        txtJam.setEnabled(false);
        txtTanggal.setEnabled(false);
        FormLogin.setVisible(false);
    } else if (cmbHakAkses.getSelectedItem().equals("Petugas")) {
        Register.setEnabled(true);
        Logout.setEnabled(true);
        Master.setEnabled(true);
        Transaksi.setEnabled(true);
        Laporan.setEnabled(true);
        btnRegister.setEnabled(true);
        btnProduk.setEnabled(true);
        btnPelanggan.setEnabled(true);
        btnPenjualan.setEnabled(true);
        txtJam.setEnabled(false);
        txtTanggal.setEnabled(false);
        FormLogin.setVisible(false);
    }
    {
        JOptionPane.showMessageDialog(null, "Selamat Datang '"+txtUsername.getText()+"'");
        String text = txtUsername.getText();
        lblUser.setText("Selamat Datang, "+text);
    }  
    } else {
            JOptionPane.showMessageDialog(null,"Gagal Masuk. Periksa Kembali Username/Password/Hak Akses");
            txtUsername.setText("");
            txtPassword.setText("");
            cmbHakAkses.setSelectedItem("-Pilih Salah Satu-");
             }
    } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi");
            }
    }//GEN-LAST:event_btnMasukActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        btnBatal :new MenuUtama().setVisible(true);           // TODO add your handling code here:
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        Register: new FromRegister().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        Login: FormLogin.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Logout: new MenuUtama().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
        Produk: new FormProduk().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_ProdukActionPerformed

    private void PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PelangganActionPerformed
        pelanggan: new FormPelanggan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_PelangganActionPerformed

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
        btnPelanggan :new FormPelanggan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnPelangganActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LaporanActionPerformed

    private void rekaplapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rekaplapMouseClicked
new FormLaporanTransaksi().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_rekaplapMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
new FormAbout().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Beranda;
    private javax.swing.JInternalFrame FormLogin;
    private javax.swing.JMenu Laporan;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenu Master;
    private javax.swing.JMenuItem Pelanggan;
    private javax.swing.JMenuItem Penjualan;
    private javax.swing.JMenuItem Produk;
    private javax.swing.JMenuItem Register;
    private javax.swing.JMenu Tentang;
    private javax.swing.JMenu Transaksi;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnProduk;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbHakAkses;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenuItem rekaplap;
    private javax.swing.JTextField txtJam;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
