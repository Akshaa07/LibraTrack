
package project1;



import java.awt.Image;
import java.sql.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class commonfunction
{
       
    
    public static void setLabelImage(JLabel lbl,String path)
    {
       
        BufferedImage img;
        try
        {
           img=ImageIO.read(new File(path));
           
           
           Image dimg=img.getScaledInstance(lbl.getWidth(),lbl.getHeight(),Image.SCALE_SMOOTH);
           ImageIcon imageicon =new ImageIcon(dimg);
           lbl.setIcon(imageicon);
        }
        catch(Exception e)
        {
            System.out.println("Caught"+e);
        }
    }
    public static Connection getconnection()
    {
        try
        {
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","sa123");
           return con;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}
