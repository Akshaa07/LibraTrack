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
public class manageStudents extends javax.swing.JFrame {

    /**
     * Creates new form manageStudents
     */
    String name,year,course;
    int student_id;
    DefaultTableModel model;
    public manageStudents() {
        initComponents();
        tblstudentdetails();
        commonfunction.setLabelImage(lblclose, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\close.png");
        commonfunction.setLabelImage(lblreturn, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\back.png");
        commonfunction.setLabelImage(lblbookid, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\read.png");
        commonfunction.setLabelImage(lblbookname, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\graduating-student.png");
        commonfunction.setLabelImage(lblauthor, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\calendar.png");
        commonfunction.setLabelImage(lblquantitity, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\social.png");
        commonfunction.setLabelImage(lblmng, "C:\\Users\\akanksha\\Documents\\NetBeansProjects\\project1\\src\\project1\\images\\student.png");
    }
    public void tblstudentdetails()
    {
        
       try
        {
            Connection con =commonfunction.getconnection();
            String query="select * from managestudents";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                String StudentId=rs.getString("student_id");
                String Name=rs.getString("name");
                String year=rs.getString("year");
                String course=rs.getString("course");
                
               Object[] obj ={StudentId,Name,year,course};
               model=(DefaultTableModel)tblstudentsdetails.getModel();
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
            String query="insert into managestudents(student_id,name,year,course) values(?,?,?,?)";
            student_id=Integer.parseInt(txtstudentid.getText());
            name=txtstudentname.getText();
            year=cmbyear.getSelectedItem().toString();
            course=cmbCourse.getSelectedItem().toString();
            
            PreparedStatement pst= con.prepareStatement(query);
            pst.setInt(1, student_id);
            pst.setString(2, name);
            pst.setString(3,year);
            pst.setString(4, course);
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
        
        DefaultTableModel model = (DefaultTableModel)tblstudentsdetails.getModel();
        model.setRowCount(0);
    }
    public boolean update()
    {
        boolean updated=false;   
            student_id=Integer.parseInt(txtstudentid.getText());
            name=txtstudentname.getText();
            year=cmbyear.getSelectedItem().toString();
            course=cmbCourse.getSelectedItem().toString();
        try
        {
            Connection con=commonfunction.getconnection();
           
            String query="update managestudents set name=?,year=?,course=? where student_id=? ";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, year);
            pst.setString(3, course);
            pst.setInt(4, student_id);
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
        
        student_id=Integer.parseInt(txtstudentid.getText());
       
        try
        {
            Connection con=commonfunction.getconnection();
            String query="delete from managestudents where student_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, student_id);
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
        txtstudentid = new javax.swing.JTextField();
        txtstudentname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cmbyear = new javax.swing.JComboBox<>();
        cmbCourse = new javax.swing.JComboBox<>();
        lblreturn = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstudentsdetails = new rojeru_san.complementos.RSTableMetro();
        lblclose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblmng = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setText("Enter Student'Id:-");

        txtstudentid.setBackground(new java.awt.Color(153, 153, 255));
        txtstudentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));

        txtstudentname.setBackground(new java.awt.Color(153, 153, 255));
        txtstudentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 255)));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("course:-");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("Name:-");

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setText("year:-");

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cmbyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Year", "Second Year", "Third Year", "Final Year" }));

        cmbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Science", "Information Technology", "Electronics and Telecommunication", "Artifical Intelligence and Data Science", "Computer and Electronics" }));

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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbyear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstudentid)
                            .addComponent(txtstudentname)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(txtstudentid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbookid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtstudentname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbookname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cmbyear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblquantitity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cmbCourse)))
                .addGap(18, 18, 18)
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

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        tblstudentsdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "year", "Course"
            }
        ));
        tblstudentsdetails.setColorBackgoundHead(new java.awt.Color(0, 0, 255));
        tblstudentsdetails.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        tblstudentsdetails.setColorBordeHead(new java.awt.Color(255, 0, 51));
        tblstudentsdetails.setColorFilasBackgound1(new java.awt.Color(255, 204, 204));
        tblstudentsdetails.setColorFilasBackgound2(new java.awt.Color(255, 153, 153));
        tblstudentsdetails.setColorFilasForeground1(new java.awt.Color(0, 0, 255));
        tblstudentsdetails.setColorFilasForeground2(new java.awt.Color(0, 0, 255));
        tblstudentsdetails.setColorSelBackgound(new java.awt.Color(255, 102, 102));
        tblstudentsdetails.setColorSelForeground(new java.awt.Color(255, 204, 204));
        tblstudentsdetails.setFuenteFilas(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        tblstudentsdetails.setFuenteFilasSelect(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        tblstudentsdetails.setFuenteHead(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        tblstudentsdetails.setGridColor(new java.awt.Color(255, 204, 204));
        tblstudentsdetails.setRowHeight(30);
        tblstudentsdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblstudentsdetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblstudentsdetails);

        lblclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcloseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MANAGE STUDENTS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblclose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblmng, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lblclose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
           tblstudentdetails();
           txtstudentid.setText("");
            txtstudentname.setText("");
       
       }
       else
       {
           JOptionPane.showMessageDialog(this, "Failed to Update data!!");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblreturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblreturnMouseClicked
        main.main(null);
        this.dispose();
    }//GEN-LAST:event_lblreturnMouseClicked

    private void lblcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcloseMouseClicked
       this.dispose();
    }//GEN-LAST:event_lblcloseMouseClicked

    private void tblstudentsdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblstudentsdetailsMouseClicked
       int Rowno=tblstudentsdetails.getSelectedRow();
        TableModel model=tblstudentsdetails.getModel();
        
        txtstudentid.setText(model.getValueAt(Rowno, 0).toString());
        txtstudentname.setText(model.getValueAt(Rowno, 1).toString());
        cmbyear.setSelectedItem(model.getValueAt(Rowno, 2).toString());
        cmbCourse.setSelectedItem(model.getValueAt(Rowno, 3).toString());
       // cmbcourse.getSelectedItem(model.getValueAt(Rowno, 3).toString());
    }//GEN-LAST:event_tblstudentsdetailsMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(add()==true)
        {
            JOptionPane.showMessageDialog(this, "Student Information added !");
            clear();
            tblstudentdetails();
            txtstudentid.setText("");
            txtstudentname.setText("");
            

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Student Cannot be added");

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(deleteData()==true)
        {
           JOptionPane.showMessageDialog(this, "Data Deleted Sucessfully", "", JOptionPane.INFORMATION_MESSAGE);
           clear();
           tblstudentdetails();
            txtstudentid.setText("");
            txtstudentname.setText("");
           
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
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCourse;
    private javax.swing.JComboBox<String> cmbyear;
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
    private rojeru_san.complementos.RSTableMetro tblstudentsdetails;
    private javax.swing.JTextField txtstudentid;
    private javax.swing.JTextField txtstudentname;
    // End of variables declaration//GEN-END:variables
}
