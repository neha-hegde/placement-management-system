import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Delete extends JFrame implements ActionListener
{
    private JLabel usnL;
    private JTextField usnT;
    private JButton delete,back;
    
    Container con=null;
    String usn="";

    Delete()
    {
        super("Delete Record");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.LIGHT_GRAY);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);

        usnL=new JLabel("Enter usn of record to be delete");
        usnL.setBounds(400, 50, 700,150);
        usnL.setFont(font);
        usnL.setForeground(Color.BLACK);

        usnT=new JTextField(200);
		usnT.setBounds(725,100,250,50);
        usnT.setFont(font);
        usnT.setForeground(Color.BLACK);

        delete = new JButton("Delete");
		delete.setBounds(400,600,150,40);
		delete.addActionListener(this);
        delete.setFont(font);
        delete.setForeground(Color.BLACK);
        delete.setBackground(Color.LIGHT_GRAY);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.LIGHT_GRAY);


        con.add(usnL);
		con.add(usnT);
        con.add(delete);
        con.add(back);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==delete)
        {
			try{
                String usn = usnT.getText();
                String usn1="",r;
                int count=0;
                File file = new File("student.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                File temp = new File("temp.txt");
                Boolean createNewFile1 = temp.createNewFile();
                BufferedWriter pw = new BufferedWriter(new FileWriter(temp));
                System.out.println("usn=" + usn);
                while((r= br.readLine()) !=null)
                {	
                    System.out.println("while");
                    String[] result = r.split("\\|");
                    usn1=result[1];
                    System.out.println(usn1 + " " +usn);
                    if(usn1.equals(usn)) 
                    {
                        count=1;
                        continue;
                    }
                    else
                    {
                        pw.write(r);
                        pw.write("\n");
                    } 
                }
                if(count == 0)
                {
                    showMessageDialog(null, "Invalid USN");
                    // Delete del=new Delete();
		            // del.setSize(1035,790);
		            // del.setVisible(true);

                }
                else
                {
                    showMessageDialog(null, "Record Deleted!");
                }
                pw.flush();
                pw.close();
                br.close();	
        
                file.delete();
                temp.renameTo(file);
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            this.dispose();
            Home h=new Home();
            h.setSize(1035,790);
            h.setVisible(true);
        }

        if(ae.getSource()==back)
        {
            try
            {
                this.dispose();
                Home h=new Home();
                h.setSize(1035,790);
                h.setVisible(true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[])
    {
        Delete del=new Delete();
		del.setSize(1035,790);
		del.setVisible(true);
    }   
}
