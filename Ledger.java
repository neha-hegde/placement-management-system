import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Ledger extends JFrame implements ActionListener
{
    
    private JLabel ledgerheading;
    private JTextArea output;
    private JButton display,back;
    
    Container con=null;

    Ledger()
    {

        super("Ledger Record");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.LIGHT_GRAY);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);

        ledgerheading=new JLabel("The record history:");
        ledgerheading.setBounds(200, 2, 700,150);
        ledgerheading.setFont(font);
        ledgerheading.setForeground(Color.BLACK);

        output=new JTextArea();
        output.setBounds(200, 150, 700,400);
        output.setFont(font);
        output.setForeground(Color.BLACK);
        output.setEditable(false);

        display = new JButton("Display");
		display.setBounds(400,600,150,40);
		display.addActionListener(this);
        display.setFont(font);
        display.setForeground(Color.BLACK);
        display.setBackground(Color.LIGHT_GRAY);

        back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.LIGHT_GRAY);

        con.add(ledgerheading);
		con.add(output);
        con.add(display);
        con.add(back);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==display)
        {
			try
            {
                String name = "", usn ="", sem = "", branch = "", cgpa= "", nob="", r;

                File temp = new File("temp.txt");
				Boolean createNewFile1 = temp.createNewFile();
                BufferedReader br = new BufferedReader(new FileReader("journal.txt"));
                BufferedWriter pw = new BufferedWriter(new FileWriter("temp.txt"));
                String b = "USN\t|SEM\t|CGPA\t|NUMBER OF BACKS";
                pw.write(b); 
                pw.write("\n");
                while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split("\\|");
		        	usn=result[0];
		        	sem= result[1];
		        	cgpa=result[2];
		        	nob=result[3];
                    if(usn.equals("999"))
                        break;
                    String bb = usn + "\t|" + sem + "\t|" + cgpa + "\t|" + nob;
                    System.out.println(bb);
                    pw.write(bb);
                    pw.write("\n");
		        }
                br.close();
                pw.close();
                File file = new File("temp.txt");
                BufferedReader br1 = new BufferedReader(new FileReader(file));
                output.read(br1,null);
                br1.close(); 
                output.requestFocus();
                file.delete();  
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
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
        Ledger led=new Ledger();
		led.setSize(1035,790);
		led.setVisible(true);
    }   




    
}
