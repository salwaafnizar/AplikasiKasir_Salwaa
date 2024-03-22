/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasikasir_ujikom;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.util.Date;

/**
 *
 * @author OWNER
 */
public class FormPenjualan extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst,pst2;
ResultSet rst;
int inputstok, inputstok2, inputharga, inputjumlah, kurangistok, tambahstok;
String harga, idproduk, idprodukpenjualan, iddetail, jam, tanggal, sub_total;
    /**
     * Creates new form FormPenjualan
     */
    public FormPenjualan() {
        initComponents();
        konek = Koneksi.koneksiDB();
        tampilwaktu();
        detail();
        autonumber();
        penjumlahan();
        

        //updateTabelBarang();
    }

     public void mulai(){
        txttanggal.setEnabled(false);
        txtwaktu.setEnabled(false);
        txtIdPenjualan.setEnabled(false);
        txttotal.setEnabled(false);
        txtkembalian.setEnabled(false);
    }
   
     public void tampilwaktu(){
         Thread clock =new Thread(){
             public void run(){
                 for(;;){
                     Calendar cal = Calendar.getInstance();
                     SimpleDateFormat jam = new SimpleDateFormat("hh:mm:ss");
                     SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
                     txtwaktu.setText(jam.format(cal.getTime()));
                     txttanggal.setText(tgl.format(cal.getTime()));
                 }
             }
             };
         clock.start();
     }
     
        private void simpan(){
               String tgl=txttanggal.getText();
               String jam=txtwaktu.getText();
             try {
                   String sql="insert into penjualan (PenjualanID,DetailID,TanggalPenjualan,JamPenjualan,TotalHarga) value (?,?,?,?,?)";
                   pst=konek.prepareStatement(sql);
                   pst.setString(1, txtIdPenjualan.getText());
                   pst.setString(2, iddetail);
                   pst.setString(3, tgl);
                   pst.setString(4, jam);
                   pst.setString(5, txttotal.getText());
                   pst.execute();
                   JOptionPane.showMessageDialog(null, "Data Tersimpan");
               } catch (Exception e){
                   JOptionPane.showMessageDialog(null, e);
                   }
           }

           private void total(){
           int total, bayar, kembali;
               total= Integer.parseInt(txtbayar.getText());
               bayar= Integer.parseInt(txttotal.getText());
               kembali=total-bayar;
               String ssub=String.valueOf(kembali);
               txtkembalian.setText(ssub);
           }

           public void clsr(){
           txtjumlah.setText("");
           //jdis.setText("");
           }

           public void cari(){
           try {
               String sql="select * from produk where ProdukID LIKE '%"+txtidproduk.getText()+"%'";
               pst=konek.prepareStatement(sql);
               rst=pst.executeQuery();
               tblproduk.setModel(DbUtils.resultSetToTableModel(rst));
              } catch (Exception e){ JOptionPane.showMessageDialog(null, e);} 
           }

           public void kurangi_stok(){
           int qty;
           qty=Integer.parseInt(txtjumlah.getText());
           kurangistok=inputstok-qty;
           }

           private void subtotal(){
           int jumlah, sub;
                jumlah= Integer.parseInt(txtjumlah.getText());
                sub=(jumlah*inputharga);
                sub_total=String.valueOf(sub);     
           }

           public void tambah_stok(){
           tambahstok=inputjumlah+inputstok2;
               try {
               String update="update produk set Stok='"+tambahstok+"' where ProdukID='"+idproduk+"'";
               pst2=konek.prepareStatement(update);
               pst2.execute();
               }catch (Exception e){
                   JOptionPane.showMessageDialog(null, e);}
           }

           public void ambil_stock(){
           try {
           String sql="select * from produk where ProdukID='"+idproduk+"'";
           pst=konek.prepareStatement(sql);
           rst=pst.executeQuery();
           if (rst.next()) {    
           String stok=rst.getString(("Stok"));
           inputstok2= Integer.parseInt(stok);
           }
           }catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);}
           }

           public void penjumlahan(){
               int totalBiaya = 0;
               int subtotal;
               DefaultTableModel dataModel = (DefaultTableModel) tblpenjualan.getModel();
               int jumlah = tblpenjualan.getRowCount();
               for (int i=0; i<jumlah; i++){
               subtotal = Integer.parseInt(dataModel.getValueAt(i, 4).toString());
               totalBiaya += subtotal;
               }
               txttotal.setText(String.valueOf(totalBiaya));
           }

           public void autonumber(){
           try{
               String sql = "SELECT MAX(RIGHT(PenjualanID,3)) AS NO FROM penjualan";
               pst=konek.prepareStatement(sql);
               rst=pst.executeQuery();
               while (rst.next()) {
                       if (rst.first() == false) {
                           txtIdPenjualan.setText("IDP001");
                       } else {
                           rst.last();
                           int auto_id = rst.getInt(1) + 1;
                           String no = String.valueOf(auto_id);
                           int NomorJual = no.length();
                           for (int j = 0; j < 3 - NomorJual; j++) {
                               no = "0" + no;
                           }
                           txtIdPenjualan.setText("IDP" + no);
                       }
                   }
               rst.close();
               }catch (Exception e){
                   JOptionPane.showMessageDialog(null, e);}
           }

           public void detail(){
           try {
               String Kode_detail=txtIdPenjualan.getText();
               String KD="D"+Kode_detail;
               String sql="select * from detailpenjualan where DetailID='"+KD+"'";
               pst=konek.prepareStatement(sql);
               rst=pst.executeQuery();
               tblpenjualan.setModel(DbUtils.resultSetToTableModel(rst));
              } catch (Exception e){ 
                  JOptionPane.showMessageDialog(null, e);} 
           }

           public void tampilJam(){
           Thread clock=new Thread(){
               public void run(){
                   for(;;){
                       Calendar cal=Calendar.getInstance();
                       SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
                       SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
                       txtwaktu.setText(format.format(cal.getTime()));
                        txttanggal.setText(format2.format(cal.getTime()));

                   try { sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                   }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidproduk = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblproduk = new javax.swing.JTable();
        txtjumlah = new javax.swing.JTextField();
        txtIdPenjualan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpenjualan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtkembalian = new javax.swing.JTextField();
        btnbayar = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        txtwaktu = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-sale-70.png"))); // NOI18N
        jLabel1.setText("INPUT PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setText("Masukan id produk");

        tblproduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Produk", "Nama Produk", "Harga", "Stok"
            }
        ));
        tblproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblprodukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblproduk);

        txtjumlah.setText("Jumlah");
        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });

        jLabel3.setText("Id Penjualan");

        jLabel4.setText("Data Produk");

        tblpenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DetailID", "ProdukID", "Harga", "JumlahProduk", "Subtotal"
            }
        ));
        tblpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpenjualanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblpenjualan);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Bayar");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Kembalian");

        btnbayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-transaction-20.png"))); // NOI18N
        btnbayar.setText("BAYAR");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });

        btnkeluar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-move-out-20.png"))); // NOI18N
        btnkeluar.setText("KELUAR");

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        btntambah.setText("Tambah");
        btntambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntambahMouseClicked(evt);
            }
        });
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnhapus.setIcon(new javax.swing.ImageIcon("C:\\New Folder (4)\\AplikasiKasir_Ujikom\\src\\image\\icons8-delete-20.png")); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapusMouseClicked(evt);
            }
        });
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(52, 52, 52))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(47, 47, 47)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtbayar)
                                .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addComponent(btnbayar)
                                    .addGap(53, 53, 53)
                                    .addComponent(btnkeluar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel7)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtidproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btncari))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtidproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btntambah))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnhapus)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbayar)
                            .addComponent(btnkeluar))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
cari();
// TODO add your handling code here:
    }//GEN-LAST:event_btncariActionPerformed

    private void tblprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblprodukMouseClicked
        try {
            int row=tblproduk.getSelectedRow();
            String tabel_klik=(tblproduk.getModel().getValueAt(row, 0).toString());
            String sql="select * from produk where ProdukID='"+tabel_klik+"'";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            if (rst.next()) {
            idproduk=rst.getString(("ProdukID"));    
            String stok=rst.getString(("Stok"));
            inputstok= Integer.parseInt(stok);
            harga=rst.getString(("Harga"));
            inputharga= Integer.parseInt(harga);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblprodukMouseClicked

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        total();
                simpan();
                autonumber();
                detail();
                txttotal.setText("");
                txtbayar.setText("");
                txtkembalian.setText("");
                txtidproduk.setText("");
                cari();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbayarActionPerformed

    private void tblpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpenjualanMouseClicked
                try {
            int row=tblpenjualan.getSelectedRow();
            idprodukpenjualan=(tblpenjualan.getModel().getValueAt(row, 1).toString());
            String sql="select * from detailpenjualan where ProdukID='"+idprodukpenjualan+"'";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            if (rst.next()) {   
            String jumlah=rst.getString(("JumlahProduk"));
            inputjumlah= Integer.parseInt(jumlah);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ambil_stock();
    
        // TODO add your handling code here:
    }//GEN-LAST:event_tblpenjualanMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseClicked
    subtotal();
            kurangi_stok();
            try {
                String Kode_detail=txtIdPenjualan.getText();
                iddetail="D"+Kode_detail;
                String sql="insert into detailpenjualan (DetailID,ProdukID,Harga,JumlahProduk,Subtotal) value (?,?,?,?,?)";
                String update="update produk set Stok='"+kurangistok+"' where ProdukID='"+idproduk+"'";
                pst=konek.prepareStatement(sql);
                pst2=konek.prepareStatement(update);
                pst.setString(1, iddetail);
                pst.setString(2, idproduk);
                pst.setString(3, harga);
                pst.setString(4, txtjumlah.getText());
                pst.setString(5, sub_total);
                pst.execute();
                pst2.execute();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
                }
            detail();
            penjumlahan();
            cari();
            clsr();
        // TODO add your handling code here:
    }//GEN-LAST:event_btntambahMouseClicked

    private void btnhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusMouseClicked
        try {
                    String sql="delete from detailpenjualan where ProdukID=?";
                    pst=konek.prepareStatement(sql);
                    pst.setString(1, idprodukpenjualan);
                    pst.execute();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                detail();
                penjumlahan();
                tambah_stok();
                cari();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusMouseClicked

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahActionPerformed

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
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblpenjualan;
    private javax.swing.JTable tblproduk;
    private javax.swing.JTextField txtIdPenjualan;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtidproduk;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtwaktu;
    // End of variables declaration//GEN-END:variables
}
