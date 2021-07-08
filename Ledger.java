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
    public BufferedReader stud;
    public BufferedReader jour; 
    public BufferedWriter pw;
    public File temp;
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
        output.setBounds(200, 150, 900,400);
        output.setFont(font);
        output.setForeground(Color.BLACK);
        output.setEditable(false);
        //JScrollPane scroll = new JScrollPane(output);
        //JScrollPane sampleScrollPane = new JScrollPane (output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

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
		//con.add(scroll);
        con.add(display);
        con.add(back);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==display)
        {
			try
            {
                String b;
                temp = new File("temp.txt");
                Boolean createNewFile1 = temp.createNewFile();
                pw = new BufferedWriter(new FileWriter(temp));
                b = "NAME\t|USN\t|SEM\t|BRANCH\t|CGPA\t|NUMBER OF BACKS";
                pw.write(b); 
                pw.write("\n");
                stud = new BufferedReader(new FileReader("student.txt"));
				jour = new BufferedReader(new FileReader("journal.txt"));
				ledger(stud.readLine(),jour.readLine());
                stud.close();
                jour.close();  
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
    public void ledger (String s1, String s2) throws FileNotFoundException, IOException
	{
		String name = "", usn = "", sem = "", branch = "", cgpa= "", nob="", r, s, b, j="",sss,jjj;

		//consequential matching and merging
		String[] ss = s1.split("\\|"); 
		String name_s=ss[0];
		String sem_s= ss[2];
		String branch_s=ss[3];
		String cgpa_s=ss[4];
		String nob_s=ss[5];
		String[] jj = s2.split("\\|"); 
		String sem_j= jj[1];
		String cgpa_j=jj[2];
		String nob_j=jj[3];
		String usn_s=ss[1];
		String usn_j=jj[0];
		int item1=0,item2=0;

		item1=Integer.parseInt(usn_s);
		item2=Integer.parseInt(usn_j);
		if(ss[0].equals("999") && jj[0].equals("999")) //ss=null && jj=null
		{
            File temp1= new File("temp.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(temp1));
            output.read(br1, null);
            br1.close();
            output.requestFocus();
            temp1.delete();  
            return;       
        }	
		else if(!ss[0].equals("999") && !jj[0].equals("999")) //ss!=null && jj!=null
		{
			if (item1 == item2)
			{
				//System.out.println(name_s + " " + usn_s + " " + sem_j + " " + branch_s + " " + cgpa_j + " " + nob_j);
				b=name_s + "\t" + usn_s + "\t" + sem_j + "\t" + branch_s + "\t" + cgpa_j + "\t" + nob_j;
                pw.write(b);
                pw.write("\n");
                ledger(s1,jour.readLine());
			}                                          
			else if(item1 < item2)
			{
				//System.out.println("Latest Entry:" + name_s + " " + usn_s + " " + sem_s + " " + branch_s + " " + cgpa_s + " " + nob_s);
				b=name_s + "\t" + usn_s + "\t" + sem_s + "\t" + branch_s + "\t" + cgpa_s + "\t" + nob_s+"\nEND OF RECORD\n";
                pw.write(b);
                pw.write("\n");
                ledger(stud.readLine(),s2);
			}
			else
			 {
				// System.out.println("Invalid Record Entry");
                pw.write("Invalid Record Entry\n");
                ledger(s1,jour.readLine());
			 }
		}
		else //ss==null || jj==null
		{
			 if(jj[0].equals("999"))      
			{ 
				s1=stud.readLine();
				ss = s1.split("\\|"); 
				name_s=ss[0];
                usn_s=ss[1];
				sem_s= ss[2];
				branch_s=ss[3];
				cgpa_s=ss[4];
				nob_s=ss[5];
                pw.write("END OF RECORD\n");
				while(!ss[0].equals("999"))
				{
					b=name_s + "\t" + usn_s + "\t" + sem_s + "\t" + branch_s + "\t" + cgpa_s + "\t" + nob_s;
                    pw.write(b);
                    pw.write("\n");
                    s1=stud.readLine();
					ss = s1.split("\\|"); 
					name_s=ss[0];
                    usn_s=ss[1];
					sem_s= ss[2];
					branch_s=ss[3];
					cgpa_s=ss[4];
					nob_s=ss[5];
					
				}
                pw.write("END OF RECORD\n");
                pw.close();
				ledger(s1,s2); 
			} 
            //ss is reaching 999
			// jj = s2.split("\\|"); 
            // usn_j=jj[0];
			// sem_j= jj[1];
			// cgpa_j=jj[2];
			// nob_j=jj[3];
			// while(!jj[0].equals("999"))
			// {
            //     jour.readLine();
				
			// }
            pw.close();
            ledger(s1,s2);
		}
	}	

    public static void main(String args[])
    {
        Ledger led=new Ledger();
		led.setSize(1035,790);
		led.setVisible(true);
    }   




    
}
