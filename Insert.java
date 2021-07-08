import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Insert extends JFrame implements ActionListener 
{
    private  JLabel insertHeading,nameL,usnL,semL,branchL,cgpaL,nobL;
    private  JTextField nameT,usnT,semT,branchT,cgpaT,nobT;
    private  JButton insert,back;

    Container con=null;
    String name="", usn1="", sem="", branch="", cgpa="", nob="";

    Insert()
    {
        super("Insert Record");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.LIGHT_GRAY);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        insertHeading = new JLabel("INSERT DETAILS");
        insertHeading.setBounds(550, 2, 400,150);

        con.add(insertHeading);

        Font font = new Font("Verdana", Font.BOLD, 16);
        insertHeading.setFont(font);
        insertHeading.setForeground(Color.BLACK);

        nameL=new JLabel("Enter Name:");
        nameL.setBounds(350,100,150,40);
        nameL.setFont(font);
        nameL.setForeground(Color.BLACK);
        nameT=new JTextField(200);
		nameT.setBounds(725,100,250,50);
        nameT.setFont(font);
        nameT.setForeground(Color.BLACK);

        usnL=new JLabel("Enter USN:");
		usnL.setBounds(350,175,150,40);
        usnL.setFont(font);
        usnL.setForeground(Color.BLACK);
		usnT=new JTextField(200);
		usnT.setBounds(725,175,250,50);
        usnT.setFont(font);
        usnT.setForeground(Color.BLACK);
        
        semL=new JLabel("Enter Semester:");
		semL.setBounds(350,250,150,40);
        semL.setFont(font);
        semL.setForeground(Color.BLACK);
		semT=new JTextField(200);
		semT.setBounds(725,250,250,50);
        semT.setFont(font);
        semT.setForeground(Color.BLACK);

        branchL=new JLabel("Enter Branch:");
		branchL.setBounds(350,325,150,40);
        branchL.setFont(font);
        branchL.setForeground(Color.BLACK);
		branchT=new JTextField(200);
		branchT.setBounds(725,325,250,50);
        branchT.setFont(font);
        branchT.setForeground(Color.BLACK);

        cgpaL=new JLabel("Enter CGPA:");
		cgpaL.setBounds(350,400,150,40);
        cgpaL.setFont(font);
        cgpaL.setForeground(Color.BLACK);
		cgpaT=new JTextField(200);
		cgpaT.setBounds(725,400,250,50);
        cgpaT.setFont(font);
        cgpaT.setForeground(Color.BLACK);

        nobL=new JLabel("Enter Number of backlogs:");
		nobL.setBounds(350,475,300,40);
        nobL.setFont(font);
        nobL.setForeground(Color.BLACK);
		nobT=new JTextField(200);
		nobT.setBounds(725,475,250,50);
        nobT.setFont(font);
        nobT.setForeground(Color.BLACK);

        insert=new JButton("Insert");
		insert.setBounds(400,600,150,40);
		insert.addActionListener(this);
        insert.setFont(font);
        insert.setForeground(Color.BLACK);
        insert.setBackground(Color.LIGHT_GRAY);

		back = new JButton("Go Back");
		back.setBounds(600,600,150,40);
		back.addActionListener(this);
        back.setFont(font);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.LIGHT_GRAY);

        con.add(nameL);
		con.add(nameT);
        con.add(usnL);
		con.add(usnT);
		con.add(semL);
		con.add(semT);
		con.add(branchL);
		con.add(branchT);
        con.add(cgpaL);
		con.add(cgpaT);
        con.add(nobL);
		con.add(nobT);
		con.add(insert);
		con.add(back);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==insert)
        {
			try
			{
				String p = "999" + "|" + "999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" ;
				File data = new File("student.txt");
				File data1 = new File("journal.txt");
				if(data.createNewFile() && data1.createNewFile())   
				{
					//File data = new File("student.txt");
					Boolean createNewFile = data.createNewFile();
					Boolean createNewFile1 = data1.createNewFile();
					System.out.println("student "+createNewFile);
					System.out.println("journal "+createNewFile1);
					BufferedWriter pw = new BufferedWriter(new FileWriter(data));
					BufferedWriter pw1 = new BufferedWriter(new FileWriter(data1));
					pw.write(p);
					pw.write("\n");
					pw.close();
					pw1.write(p);
					pw1.write("\n");
					pw1.close();
				}

				String name = nameT.getText();
           		String usn1 = usnT.getText();
           		String sem = semT.getText();
           		String branch = branchT.getText();
           		String cgpa = cgpaT.getText();
           		String nob = nobT.getText();
				System.out.println(name + usn1 + sem +branch + cgpa + nob);

                int check=0,usn2=0,usn3=0;
				String usn="",r,sort,sort1="";
		       // System.out.println("Enter the usn");
		        //String usn1 = scan.next();
		        File file = new File("student.txt");
		     	BufferedReader br=new BufferedReader(new FileReader(file));
			    while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split("\\|");
		        	usn=result[1];
		        	if(usn.equals(usn1))
		        	{	check=1;
		        		showMessageDialog(null, "A record already exists with usn: "+result[1]);
						break;
		        	}
		        }
		        br.close();
		        //if record already exists
		        if(check==1)
		        {
					System.out.println("count=1");
		        	//System.out.println("Enter Name, Semester, Branch, CGPA and Number of Backlogs");
		        	//name = scan.next(); 
		        	//sem = scan.next(); 
		        	//branch = scan.next(); 
		        	//cgpa = scan.next();
		        	//nob = scan.next();
		        	String b = usn1 + "|" + sem + "|"  + cgpa + "|" + nob + "|";
		        	int len = b.length();
		        	String s1 = "-";
		        	if(len<50)
		        	{
		        		for(int i=len;i<=50;i++)
		        		b = b.concat(s1);
		        	}
		        	//modify(name,usn1,sem,branch,cgpa,nob);
					File file1 = new File ("journal.txt");
		        	BufferedReader br1 = new BufferedReader(new FileReader(file1));
		        	usn3=Integer.parseInt(usn1);
					System.out.println("usn3 " + usn3);
		        	//sorting before insertion
					File temp = new File("temp.txt");
					Boolean createNewFile1 = temp.createNewFile();
					BufferedWriter pw1 = new BufferedWriter(new FileWriter(temp));
					System.out.println("count1 " + b);
		        	String result[]={};
					String sem1,cgpa1,nob1;
		        	// sort="";
		        	while((sort = br1.readLine()) != null)
		        	{
						System.out.println("while");
		        		result = sort.split("\\|");
		        		usn2=Integer.parseInt(result[0]);
		        		sem1 = result[1];   
		        		cgpa1=result[2];
		        		nob1=result[3];
		        		sort1 = usn2 + "|" + sem1 + "|" + cgpa1 + "|" + nob1 + "|";
						System.out.println(sort1);
						System.out.println(usn3 + " " + usn2);
		        		if(usn3<usn2)
		        		{
		        			pw1.write(b);
							pw1.write("\n");
		        			break;                                            
		        		}
		        		else if(usn3 == usn2)        
		        		{
		        			pw1.write(sort1); 
							pw1.write("\n");
		        			pw1.write(b); 
							pw1.write("\n");
		        			break;
		        		}
		        		pw1.write(sort1); 
						pw1.write("\n");
		        	}    
		        	if(sort!=null )
		        	{
		        		if(result[0].equals("999"))
		        		{
		        			pw1.write(sort1);
							pw1.write("\n");
		        		}
		        		else
		        		{
		        			if(usn3>usn2)
		        			{
		        				pw1.write(b);
								pw1.write("\n");
		        				pw1.write(p);  
								pw1.write("\n");   
		        			}
		        			else if (usn3 == usn2)
		        			{
								System.out.println("while usn3 == usn2" + name + " " + usn1 + " " + sem + " " + branch + " " + cgpa + " " + nob);
		        				while(!(result[1].equals("999")))
		        				{
		        					sort = br1.readLine();
		        					result = sort.split("\\|");
		        					usn2=Integer.parseInt(result[0]);
		        					sem1 = result[1];
		        					cgpa1=result[2];
		        					nob1=result[3];
		        					sort1 = usn2 + "|" + sem1 + "|" + cgpa1 + "|" + nob1 + "|";
									System.out.println("inside while usn3 == usn2" + name + " " + usn2 + " " + sem1 + " " + branch + " " + cgpa1 + " " + nob1);
		        					pw1.write(sort1);
									pw1.write("\n");
		        				}
								System.out.println("after while usn3 == usn2" + name + " " + usn1 + " " + sem + " " + branch + " " + cgpa + " " + nob);
		        			}
		        			else
		        			{
		        				while(!result[1].equals("999"))
		        				{
		        					pw1.write(sort1);
									pw1.write("\n");
		        					sort = br1.readLine();
		        					result = sort.split("\\|");
		        					usn2=Integer.parseInt(result[0]);
		        					sem1 = result[1];
		        					cgpa1=result[2];
		        					nob1=result[3];
		        					sort1 = usn2 + "|" + sem1 + "|" + cgpa1 + "|" + nob1 + "|";
		        				}
		        			}
							System.out.println("after after while usn3 == usn2" + name + " " + usn1 + " " + sem + " " + branch + " " + cgpa + " " + nob);
		        			pw1.write(p);
							pw1.write("\n");
		        		}
		        	}
					showMessageDialog(null, "Record Updated!");
		        	pw1.flush();   
		        	pw1.close();
		        	br1.close();
		        	file1.delete();
		        	temp.renameTo(file1);
					System.out.println("before modify" + name + " " + usn1 + " " + sem + " " + branch + " " + cgpa + " " + nob);
					modify(name,usn1,sem,branch,cgpa,nob);
		        }
		        //if record does not exist
		        if(check == 0)
		        {
		        	File file1 = new File("student.txt");
		        	BufferedReader br1 = new BufferedReader(new FileReader(file1));
					System.out.println("check=0");
		        	//System.out.println("Welcome new user! Enter the following details");
		        	//System.out.println("Enter Name, USN, Semester, Branch, CGPA, Number of backlogs");
		        	//name = scan.next();
		        	//usn = scan.next();
		        	//sem = scan.next(); 
		        	//branch = scan.next();
		        	//cgpa = scan.next();
		        	//nob = scan.next();

		        	String b = name + "|" + usn1 + "|" + sem + "|" + branch + "|" + cgpa + "|" + nob + "|";
					System.out.println(b);
		        	int len = b.length();
		        	String s1 = "-";
		        	if(len<50)
		        	{
		        		for(int j=len;j<=50;j++)
		        		b = b.concat(s1);
		        	}
		        	usn3=Integer.parseInt(usn1);

		        	//sorting before insertion
					File temp = new File("temp.txt");
					Boolean createNewFile = temp.createNewFile();
					BufferedWriter pw1 = new BufferedWriter(new FileWriter(temp));
		        	String result[]={};
					System.out.println("count" + createNewFile);
		        	while((sort = br1.readLine()) != null)
		        	{
		        		result = sort.split("\\|");
		        		usn2=Integer.parseInt(result[1]);
						System.out.println(usn3 + " " +usn2);
		        		if(usn3<usn2)
		        		{
		        			pw1.write(b);
							pw1.write("\n");
		        			break;
		        		}
		        		pw1.write(sort); 
						pw1.write("\n");
		        	}    

		        	if(sort!=null )
		        	{
		        		if(result[1].equals("999"))
		        		{
		        			pw1.write(sort);
							pw1.write("\n");
		        		}
		        		else
		        		{ 
		        			while(!result[1].equals("999"))
		        			{
		        				pw1.write(sort);
								pw1.write("\n");
		        				sort = br1.readLine();
		        				result = sort.split("\\|");
		        			}
		        			pw1.write(p);
							pw1.write("\n");
		        		}
		        	}
					showMessageDialog(null, "Record Added!");
		        	pw1.flush();   
		        	pw1.close();
		        	br1.close();

		        	file1.delete();
		        	temp.renameTo(file1);
                }

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


    public void modify(String name0, String usn0,String sem0,String branch0, String cgpa0,String nob0) throws FileNotFoundException,IOException,NullPointerException
	{	
		String usn="",r;

		System.out.println("outside if" + name0 + " " + usn0 + " " + sem0 + " " + branch0 + " " + cgpa0 + " " + nob0);

		File file = new File("student.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		File temp = new File("temp.txt");
		Boolean createNewFile = temp.createNewFile();
		BufferedWriter pw = new BufferedWriter(new FileWriter(temp));

		while((r= br.readLine()) !=null)
		{	
			String[] result = r.split("\\|");
			usn=result[1];

			if(usn.equals(usn0))
			{
				String b = name0+"|"+usn0+"|"+sem0+"|"+branch0+"|"+cgpa0+"|"+nob0+"|";

				System.out.println("if" + name0 + " " + usn0 + " " + sem0 + " " + branch0 + " " + cgpa0 + " " + nob0);


				int len = b.length();

				String s1 = "-";
				if(len<50)
				{
					for(int i=len;i<=50;i++)
						b = b.concat(s1);
				}
				pw.write(b);
				pw.write("\n");
			}
			else
			{
				pw.write(r);
				pw.write("\n");
			}
		}
		pw.flush();
		pw.close();
		br.close();	

		file.delete();
		temp.renameTo(file);
	}



    public static void main(String args[])
    {
        Insert in = new Insert();
        in.setSize(1035,740);
        in.setVisible(true);
    }   
}   


