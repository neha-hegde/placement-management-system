import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Eligible extends JFrame implements ActionListener
{
    
    private JLabel eligibleheading;
    private JTextArea output;
    private JButton display,back;
    
    Container con=null;

    Eligible()
    {
        super("Placement Eligibility");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.LIGHT_GRAY);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Verdana", Font.BOLD, 16);

        eligibleheading=new JLabel("PLACEMENT ELIGIBILITY");
        eligibleheading.setBounds(200, 2, 700,150);
        eligibleheading.setFont(font);
        eligibleheading.setForeground(Color.BLACK);

        output=new JTextArea();
        output.setBounds(200, 150, 900,400);
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

        con.add(eligibleheading);
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
                //platinum
		        //cgpa >=8.0 && nob=0
		        //gold
		        //cgpa >=7.0 && nob=0
		        //silver
		        //cgpa >=6.0
                System.out.println("hi");
		        String name, cgpa1, nob1, r,b;
		        double cgpa, nob;
		        
                System.out.println("hi1");
                File temp = new File("temp.txt");
				Boolean createNewFile1 = temp.createNewFile();
                //BufferedWriter pw = new BufferedWriter(new FileWriter(temp));

                BufferedReader br = new BufferedReader(new FileReader("student.txt"));
                System.out.println("before while");
		        while((r = br.readLine()) != null )
		        {
                    BufferedWriter pw = new BufferedWriter(new FileWriter(temp));
                    System.out.println("inside while");
		        	String[] result = r.split("\\|"); 
		        	name=result[0];
		        	cgpa1=result[4];
		        	nob1=result[5];
		        	cgpa = Double.parseDouble(cgpa1);
		        	nob = Double.parseDouble(nob1);
		        	if(cgpa!=999)
		        	{
		        		if(cgpa >= 8.0 && nob == 0)
		        	    {
                            System.out.println(cgpa);
                            b = name + " : " + "Platinum , Gold, Silver";
                            pw.write(b);
                            pw.write("\n");
		        	    }
		        	    else if(cgpa >= 7.0 && nob == 0)
		        	    {
		        	    	b = name + " : " + "Gold, Silver";
                            pw.write(b);
                            pw.write("\n");
		        	    }
		        	    else if(cgpa >= 6.0)
		        	    {
		        	    	b = name + " : " + "Silver";
                            pw.write(b);
                            pw.write("\n");
		        	    }
		        	    else
		        	    {
		        	    	b = name + " : " + "Not Eligible";
                            pw.write(b);
                            pw.write("\n");
		        	    }
		        	}	
                    System.out.println("outside while");
                    br.close();
                    pw.close();
                    System.out.println("after close");
                    File file = new File("temp.txt");
                    BufferedReader br1 = new BufferedReader(new FileReader(file));
                    System.out.println("before display");
                    output.read(br1,null);
                    System.out.println("after display");
                    br1.close(); 
                    output.requestFocus();
                    //file.delete();  
                    System.out.println("end");
                }
            }
            catch(Exception e)
            {
                //e.printStackTrace();
                System.out.println("error is" +e);
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
        Eligible eli=new Eligible();
		eli.setSize(1035,790);
		eli.setVisible(true);
    }   

}