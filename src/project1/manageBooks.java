/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project1;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author akanksha
 */
public class manageBooks extends javax.swing.JFrame {

    /**
     * Creates new form manageStudents
     */
    String book_name,author;
    int book_id,quantity;
    DefaultTableModel model;
    public manageBooks() {
        initComponents();
        tblbookdetails();
        commonfunction.setLabelImage(lblclose, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\close.png");
        commonfunction.setLabelImage(lblreturn, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\back.png");
        commonfunction.setLabelImage(lblbookid, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\book (2).png");
        commonfunction.setLabelImage(lblbookname, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\book (1).png");
        commonfunction.setLabelImage(lblauthor, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\writer.png");
        commonfunction.setLabelImage(lblquantitity, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\quantity.png");
        commonfunction.setLabelImage(lblmng, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\stack-of-books.png");
    }
    public void tblbookdetails()
    {
        
        try
        {
            Connection con =commonfunction.getconnection();
            String query="select * from managebooks";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                String book_id= rs.getString("book_id");
                String book_name=rs.getString("book_name");
                String book_author=rs.getString("author");
                int quantity=rs.getInt("quantity");
                
               Object[] obj ={book_id,book_name,book_author,quantity};
               model = (DefaultTableModel)tblbookdetails.getModel();
               model.addRow(obj);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
    }
        
        
    }
    
    public boolean add()
    {
        boolean added=false;
        
        try
        {
            Connection con=commonfunction.getconnection();
            String query="insert into managebooks(book_id,book_name,author,quantity) values(?,?,?,?)";
            book_id=Integer.parseInt(txtbookid.getText());
            book_name=txtbookname.getText();
            author=txtauthor.getText();
            quantity=Integer.parseInt(txtquantity.getText());
            
            PreparedStatement pst= con.prepareStatement(query);
            pst.setInt(1, book_id);
            pst.setString(2, book_name);
            pst.setString(3,author);
            pst.setInt(4, quantity);
            int rowcount=pst.executeUpdate();
            if(rowcount>0)
            {
                added=true;
                            }
            else
            {
                added=false;
                
            }
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return added;
}
    public void clear()
    {
        
        DefaultTableModel model = (DefaultTableModel)tblbookdetails.getModel();
        model.setRowCount(0);
    }
    public boolean update()
    {
        boolean updated=false;   
            book_id=Integer.parseInt(txtbookid.getText());
            book_name=txtbookname.getText();
            author=txtauthor.getText();
            quantity=Integer.parseInt(txtquantity.getText());
        try
        {
            Connection con=commonfunction.getconnection();
           
            String query="update managebooks set book_name=?,author=?,quantity=? where book_id=? ";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, book_name);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, book_id);
            int count=pst.executeUpdate();
            if(count>0)
            {
                updated=true;
            }
            else
            {
                updated=false;
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return updated;
    }
    public boolean deleteData()
    {
        boolean deleted=false;
        
        book_id=Integer.parseInt(txtbookid.getText());
       
        try
        {
            Connection con=commonfunction.getconnection();
            String query="delete from managebooks where book_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, book_id);
            int count=pst.executeUpdate();
            if(count>0)
            {
                deleted=true;
            }
            else
            {
                deleted=false;    
            }
            
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
        
        return deleted;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblbookname = new javax.swing.JLabel();
        lblbookid = new javax.swing.JLabel();
        lblquantitity = new javax.swing.JLabel();
        lblauthor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbookid = new javax.swing.JTextField();
        txtbookname = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        txtauthor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblreturn = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbookdetails = new rojeru_san.complementos.RSTableMetro();
        lblclose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblmng = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setText("Enter Book'Id:-");

        txtbookid.setBackground(new java.awt.Color(255, 153, 153));
        txtbookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));

        txtbookname.setBackground(new java.awt.Color(255, 153, 153));
        txtbookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));

        txtquantity.setBackground(new java.awt.Color(255, 153, 153));
        txtquantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));

        txtauthor.setBackground(new java.awt.Color(255, 153, 153));
        txtauthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("Quantity:-");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("Book Name:-");

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setText("Author:-");

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 255));
        jButton3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblauthor, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(lblbookname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblbookid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblquantitity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbookid, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbookname, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbookid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbookid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbookname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbookname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblquantitity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        lblreturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblreturnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        tblbookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author", "Quantity"
            }
        ));
        tblbookdetails.setColorBackgoundHead(new java.awt.Color(0, 0, 255));
        tblbookdetails.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        tblbookdetails.setColorBordeHead(new java.awt.Color(255, 0, 51));
        tblbookdetails.setColorFilasBackgound1(new java.awt.Color(255, 204, 204));
        tblbookdetails.setColorFilasBackgound2(new java.awt.Color(255, 153, 153));
        tblbookdetails.setColorFilasForeground1(new java.awt.Color(0, 0, 255));
        tblbookdetails.setColorFilasForeground2(new java.awt.Color(0, 0, 255));
        tblbookdetails.setColorSelForeground(new java.awt.Color(255, 204, 204));
        tblbookdetails.setFuenteFilas(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        tblbookdetails.setFuenteFilasSelect(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        tblbookdetails.setFuenteHead(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        tblbookdetails.setGridColor(new java.awt.Color(255, 204, 204));
        tblbookdetails.setRowHeight(25);
        tblbookdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbookdetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbookdetails);

        lblclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcloseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MANAGE BOOKS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblclose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(lblmng, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lblclose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(lblmng, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     if(update()==true)
       {
           JOptionPane.showMessageDialog(this, "Data Updated Sucessfully","" , JOptionPane.INFORMATION_MESSAGE);
           clear();
           tblbookdetails();
           
       
       }
       else
       {
           JOptionPane.showMessageDialog(this, "Failed to Update data!!");
       }
            txtbookid.setText("");
            txtbookname.setText("");
            txtauthor.setText("");
            txtquantity.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblreturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblreturnMouseClicked
        main.main(null);
        this.dispose();
    }//GEN-LAST:event_lblreturnMouseClicked

    private void lblcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcloseMouseClicked
       this.dispose();
    }//GEN-LAST:event_lblcloseMouseClicked

    private void tblbookdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbookdetailsMouseClicked
        int Rowno=tblbookdetails.getSelectedRow();
        TableModel model=tblbookdetails.getModel();
        
        txtbookid.setText(model.getValueAt(Rowno, 0).toString());
        txtbookname.setText(model.getValueAt(Rowno, 1).toString());
        txtauthor.setText(model.getValueAt(Rowno, 2).toString());
        txtquantity.setText(model.getValueAt(Rowno, 3).toString());
    }//GEN-LAST:event_tblbookdetailsMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(add()==true)
        {
            JOptionPane.showMessageDialog(this, "Book added !");
            clear();
            tblbookdetails();
            txtbookid.setText("");
            txtbookname.setText("");
            txtauthor.setText("");
            txtquantity.setText("");

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Book Cannot be added");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(deleteData()==true)
        {
           JOptionPane.showMessageDialog(this, "Data Deleted Sucessfully", "", JOptionPane.INFORMATION_MESSAGE);
           clear();
           tblbookdetails();
            txtbookid.setText("");
            txtbookname.setText("");
            txtauthor.setText("");
            txtquantity.setText(""); 
           
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Failed to Delete Data", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblauthor;
    private javax.swing.JLabel lblbookid;
    private javax.swing.JLabel lblbookname;
    private javax.swing.JLabel lblclose;
    private javax.swing.JLabel lblmng;
    private javax.swing.JLabel lblquantitity;
    private javax.swing.JLabel lblreturn;
    private rojeru_san.complementos.RSTableMetro tblbookdetails;
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtbookid;
    private javax.swing.JTextField txtbookname;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
