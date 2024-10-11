/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe_management_system;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;

/**
 *
 * @author DELL
 */
public class PlaceOrder extends javax.swing.JFrame
{
    public int billId=1;
    public int grandTotal=0;
    public int price=0;
    public int prototal=0;
    public String email_pattern="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobile_pattern="^[0-9, ]*$";
    public String email;
    public String name;
    public String mob_no;
    public PlaceOrder()
    {
        initComponents();
    }
     public PlaceOrder(String usremail,String n,String mob)
    {
        initComponents();
        txtproName.setEditable(false);
        
        txtprice.setEditable(false);
        txttotal.setEditable(false);
        btnadd.setEnabled(false);
        btngenerate.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor)counter.getEditor()).getTextField();

        tf.setEnabled(false);
        email=usremail;
        name=n;
        mob_no=mob;
        txtcustName.setText(name);
        txtmob_no.setText(mob_no);
        txtmail.setText(email);
        txtcustName.setEditable(false);
        txtmob_no.setEditable(false);
        txtmail.setEditable(false);
    }
     public void productNameByCategory(String category)
     {
        DefaultTableModel dtm = (DefaultTableModel) tab1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.getAllRecordsByCategory (category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()) {
        Product productObj = itr.next();
        dtm.addRow(new Object[]{productObj.getName()});
     }

     }
      public void FilterProductByName(String name,String category)
     {
         DefaultTableModel dtm = (DefaultTableModel) tab1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.FilterProductName(category, name);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()) 
        {
        Product productObj = itr.next();
        dtm.addRow(new Object[]{productObj.getName()});
        }
     }
      public void clearProductFields()
      {
          txtproName.setText("");
          txtprice.setText("");
          counter.setValue(1);
          txttotal.setText("");
          btnadd.setEnabled(false);
      }
      public void validateFields()
      {
          String cust_name=txtcustName.getText();
          String cust_mob=txtmob_no.getText();
          String cust_mail=txtmail.getText();
          if(!cust_name.equals("") && cust_mob.matches(mobile_pattern)&& cust_mail.matches(email_pattern) && cust_mob.length()==10 && grandTotal>0)
              
          {
              btngenerate.setEnabled(true);
          }
          else
          {
               btngenerate.setEnabled(false);
          }
            
      }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmob_no = new javax.swing.JTextField();
        txtcustName = new javax.swing.JTextField();
        txtmail = new javax.swing.JTextField();
        lblbill = new javax.swing.JLabel();
        cmbcat = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        counter = new javax.swing.JSpinner();
        txtproName = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        btnclear = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        billtab = new javax.swing.JTable();
        btngenerate = new javax.swing.JButton();
        lblgrand = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentShown(java.awt.event.ComponentEvent evt)
            {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Category");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Place Order");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Customer Details:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mobile Number");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email");

        txtmob_no.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtmob_no.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtmob_noKeyReleased(evt);
            }
        });

        txtcustName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtcustName.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtcustNameKeyReleased(evt);
            }
        });

        txtmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtmail.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtmailKeyReleased(evt);
            }
        });

        lblbill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblbill.setText("Bill ID : --");

        cmbcat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbcat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbcatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Search");

        txtsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtsearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtsearchKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        tab1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tab1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Name"
            }
        ));
        tab1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tab1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab1);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Name");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Quantity");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Price");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Total");

        counter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        counter.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                counterStateChanged(evt);
            }
        });

        txtproName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtproName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtproNameActionPerformed(evt);
            }
        });
        txtproName.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtproNameKeyTyped(evt);
            }
        });

        txtprice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtprice.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtpriceKeyTyped(evt);
            }
        });

        txttotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txttotal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txttotalActionPerformed(evt);
            }
        });
        txttotal.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txttotalKeyTyped(evt);
            }
        });

        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnclearActionPerformed(evt);
            }
        });

        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnadd.setText("Add to Cart");
        btnadd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnaddActionPerformed(evt);
            }
        });

        billtab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        billtab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        billtab.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                billtabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(billtab);

        btngenerate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btngenerate.setText("Generate bill and print");
        btngenerate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btngenerateActionPerformed(evt);
            }
        });

        lblgrand.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblgrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblgrand.setText("Grand Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblbill, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(391, 391, 391)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(343, 343, 343)
                        .addComponent(cmbcat, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcustName, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsearch)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmob_no, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(lblgrand, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btngenerate)
                        .addGap(211, 211, 211))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtproName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtprice)
                                            .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(btnclear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnadd))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(199, 199, 199))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1319, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblbill)
                                .addComponent(jLabel9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtproName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(8, 8, 8)
                                .addComponent(txtmob_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnadd)
                                    .addComponent(btnclear))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel11)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngenerate)
                    .addComponent(lblgrand, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel2)
                    .addContainerGap(559, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbcatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbcatActionPerformed
    {//GEN-HEADEREND:event_cmbcatActionPerformed
        // TODO add your handling code here:
        String category=(String)cmbcat.getSelectedItem();
        
        productNameByCategory(category);
    }//GEN-LAST:event_cmbcatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(email,name,mob_no).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtsearchActionPerformed
    {//GEN-HEADEREND:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentShown
    {//GEN-HEADEREND:event_formComponentShown
        // TODO add your handling code here:
        billId=Integer.parseInt(BillDao.getId());
        lblbill.setText(BillDao.getId());
        ArrayList<Category>list=CategoryDao.getAllRecords();
        Iterator<Category>itr=list.iterator();
        while(itr.hasNext())
        {
            Category Categoryobj=itr.next();
            cmbcat.addItem(Categoryobj.getName());
        }
        String category=(String)cmbcat.getSelectedItem();
        productNameByCategory(category);
        
    }//GEN-LAST:event_formComponentShown

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtsearchKeyReleased
    {//GEN-HEADEREND:event_txtsearchKeyReleased
        // TODO add your handling code here:
        String name=txtsearch.getText();
        String category=(String)cmbcat.getSelectedItem();
        this.FilterProductByName(name, category);
    }//GEN-LAST:event_txtsearchKeyReleased

    private void tab1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tab1MouseClicked
    {//GEN-HEADEREND:event_tab1MouseClicked
        // TODO add your handling code here:
        int index=tab1.getSelectedRow();
        TableModel tbl=tab1.getModel();
        String productName=tbl.getValueAt(index,0).toString();
        Product product=ProductDao.getProductByName(productName);
        txtproName.setText(product.getName());
        txtprice.setText(product.getPrice());
        counter.setValue(1);
        txttotal.setText(product.getPrice());
        price=Integer.parseInt(product.getPrice());
        prototal=Integer.parseInt(product.getPrice());
        btnadd.setEnabled(true);
    }//GEN-LAST:event_tab1MouseClicked

    private void counterStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_counterStateChanged
    {//GEN-HEADEREND:event_counterStateChanged
        // TODO add your handling code here:
        int quant=(Integer)counter.getValue();
        if(quant<=1)
        {
            counter.setValue(1);
            quant=1;
        }
        prototal=price*quant;
        txttotal.setText(String.valueOf(prototal));
        
    }//GEN-LAST:event_counterStateChanged

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnaddActionPerformed
    {//GEN-HEADEREND:event_btnaddActionPerformed
        // TODO add your handling code here:
        String name=txtproName.getText();
        String price=txtprice.getText();
        String quantity=String.valueOf(counter.getValue());
        DefaultTableModel dtm = (DefaultTableModel) billtab.getModel();
        dtm.addRow(new Object[]{name,price, quantity,prototal});
        grandTotal = grandTotal + prototal;
         lblgrand.setText(String.valueOf(grandTotal));
        clearProductFields(); 
        validateFields();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnclearActionPerformed
    {//GEN-HEADEREND:event_btnclearActionPerformed
        // TODO add your handling code here:
        this.clearProductFields();
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtcustNameKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtcustNameKeyReleased
    {//GEN-HEADEREND:event_txtcustNameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtcustNameKeyReleased

    private void txtmob_noKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtmob_noKeyReleased
    {//GEN-HEADEREND:event_txtmob_noKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtmob_noKeyReleased

    private void txtmailKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtmailKeyReleased
    {//GEN-HEADEREND:event_txtmailKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtmailKeyReleased

    private void btngenerateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btngenerateActionPerformed
    {//GEN-HEADEREND:event_btngenerateActionPerformed
        // TODO add your handling code here:
        String cust_name=txtcustName.getText();
        String cust_mob=txtmob_no.getText();
        String cust_mail=txtmail.getText();
        SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-YYYY");
        Date date=new Date();
        String todayDate=dFormat.format(date);
        String total=String.valueOf(grandTotal);
        String createBy=email;
        Bill bill=new Bill();
        bill.setId(billId);
        bill.setName(cust_name);
        bill.setMobile_no(cust_mob);
        bill.setEmail(cust_mail);
        bill.setDate(todayDate);
        bill.setTotal(total);
        bill.setCreateBy(createBy);
        BillDao.save(bill);
        //Creating Documnet
        String path="F:\\";
        com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
        try
        {
            PdfWriter.getInstance (doc, new FileOutputStream(path + "" + billId +".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                                                     Cafe Management System\n");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("******************************************************************************************");
            doc.add(starLine);
            Paragraph paragraph3= new Paragraph("\tBill ID: "+billId+"\nCustomer Name: "+cust_name+"    Total Paid : "+grandTotal);
            doc.add(paragraph3);
            doc.add(starLine);
            PdfPTable tbl= new PdfPTable(4);
            tbl.addCell("Name");
            tbl.addCell("Price");
            tbl.addCell("Quantity");
            tbl.addCell("Total");
            for(int i=0; i <billtab.getRowCount(); i++) 
            {
                String n = billtab.getValueAt(i, 0).toString();
                String d =billtab.getValueAt(i, 1).toString();
                String r=billtab.getValueAt(i,2).toString();
                String q=billtab.getValueAt(i, 3).toString();
                tbl.addCell(n);
                tbl.addCell(d);
                tbl.addCell(r);
                tbl.addCell(q);
                doc.add(tbl);
                doc.add(starLine);
                Paragraph thanksMsg = new Paragraph ("Thank you, Please visit Again!!!");
                doc.add(thanksMsg);
                OpenPdf.OpenById(String.valueOf(billId));
         
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(createBy,cust_name,cust_mob).setVisible(true);
    }//GEN-LAST:event_btngenerateActionPerformed

    private void billtabMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_billtabMouseClicked
    {//GEN-HEADEREND:event_billtabMouseClicked
        // TODO add your handling code here:
        int index=billtab.getSelectedRow();
        int a=JOptionPane.showConfirmDialog(null,"Do you want to remove this product?","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            TableModel model=billtab.getModel();
            String total=model.getValueAt(index,3).toString();
            grandTotal-=Integer.parseInt(total);
            lblgrand.setText(String.valueOf(grandTotal));
            ((DefaultTableModel)billtab.getModel()).removeRow(index);
            
        }
    }//GEN-LAST:event_billtabMouseClicked

    private void txtproNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtproNameActionPerformed
    {//GEN-HEADEREND:event_txtproNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproNameActionPerformed

    private void txtproNameKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtproNameKeyTyped
    {//GEN-HEADEREND:event_txtproNameKeyTyped
        // TODO add your handling code here:
        evt.consume();
       
    }//GEN-LAST:event_txtproNameKeyTyped

    private void txtpriceKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtpriceKeyTyped
    {//GEN-HEADEREND:event_txtpriceKeyTyped
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_txtpriceKeyTyped

    private void txttotalKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txttotalKeyTyped
    {//GEN-HEADEREND:event_txttotalKeyTyped
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_txttotalKeyTyped

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txttotalActionPerformed
    {//GEN-HEADEREND:event_txttotalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txttotalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable billtab;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btngenerate;
    private javax.swing.JComboBox<String> cmbcat;
    private javax.swing.JSpinner counter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblbill;
    private javax.swing.JLabel lblgrand;
    private javax.swing.JTable tab1;
    private javax.swing.JTextField txtcustName;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtmob_no;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproName;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
