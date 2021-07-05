//ADDITION

//insertion - writing into the file
import java.util.*;
import java.io.*;

class plm
{
	Scanner scan = new Scanner(System.in);
	public static BufferedReader stud;
	public static BufferedReader jour;
	
	public static void main(String args[]) throws IOException
	{
		 plm obj = new plm();
		 PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("student.txt"),true));
		 String p = "999" + "|" + "999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" ;
		 pw2.println(p);
		 pw2.close();
		 PrintWriter pw3 = new PrintWriter(new FileOutputStream(new File("journal.txt"),true));
		 pw3.println(p);
		 pw3.close();
		while(true)
		{
			System.out.println("**********************");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Display");
			System.out.println("4. Search");
			System.out.println("5. General Ledger");
			System.out.println("6. Eligibility");
			System.out.println("**********************");

			System.out.println("Please enter your choice:");
			int choice = obj.scan.nextInt();
			switch(choice)
			{
			case 1:
				obj.insert();
				break;
			case 2:
				obj.remove();
				break;
			case 3:
				obj.display();
				break;
			case 4:
				obj.search();
				break;
			case 5:
				stud = new BufferedReader(new FileReader("student.txt"));
				jour = new BufferedReader(new FileReader("journal.txt"));
				obj.ledger(stud.readLine(),jour.readLine());
				break;
			case 6:
				obj.eligible();
				break;
			default:
				System.out.println("Invalid Option");
			}
		}	
	}

	public void insert() throws IOException, FileNotFoundException
	{
		int check=0,usn2=0,usn3=0;
		String name, usn, sem, branch, cgpa, nob,r,sort,sort1="";
		String p = "999" + "|" + "999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" +"999" + "|" ;
		System.out.println("Enter the usn");
		String usn1 = scan.next();
		File file = new File("student.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((r= br.readLine()) !=null)
		{
			String[] result = r.split("\\|");
			usn=result[1];
			if(usn.equals(usn1))
			{	check=1;
				break;
			}
		}
		br.close();
			//if record already exists
			if(check==1)
			{
				System.out.println("Enter Name, Semester, Branch, CGPA and Number of Backlogs");
				name = scan.next(); 
				sem = scan.next(); 
				branch = scan.next(); 
				cgpa = scan.next();
				nob = scan.next();
				
				String b = usn1 + "|" + sem + "|"  + cgpa + "|" + nob + "|";
				int len = b.length();
				String s1 = "-";
				if(len<50)
				{
					for(int i=len;i<=50;i++)
					b = b.concat(s1);
				}
				modify(name,usn1,sem,branch,cgpa,nob);
				File file1 = new File("journal.txt");
				BufferedReader br1 = new BufferedReader(new FileReader(file1));
				usn3=Integer.parseInt(usn1);
				//sorting before insertion
				File temp = new File("temp.txt");
				PrintWriter pw1 = new PrintWriter(temp);
				String result[]={};
				// sort="";
				while((sort = br1.readLine()) != null)
				{
					System.out.println(sort);
					result = sort.split("\\|");
					usn2=Integer.parseInt(result[0]);
					sem = result[1];
					cgpa=result[2];
					nob=result[3];
					sort1 = usn2 + "|" + sem + "|" + cgpa + "|" + nob + "|";
					System.out.println(usn2);
					if(usn3<usn2)
					{
						System.out.println(usn3 + " if " + usn2 );
						pw1.println(b);
						//pw1.println(sort1);
						break;                                            
					}
					else if(usn3 == usn2)        
					{
						pw1.println(sort1); 
						pw1.println(b); 
						break;
					}
					System.out.println(usn3 + " outside " +usn2); 
					pw1.println(sort1); 
				}    

				if(sort!=null )
				{
					if(result[0].equals("999"))
					{
						System.out.println("first if" +result[0]);
						pw1.println(sort1);
					}
					else
					{
						if(usn3>usn2)
						{
							pw1.println(b);
							pw1.println(p);     
						}
						else if (usn3 == usn2)
						{
							while(!result[1].equals("999"))
							{
								System.out.println("while" + result[0]);
								sort = br1.readLine();
								result = sort.split("\\|");
								usn2=Integer.parseInt(result[0]);
								sem = result[1];
								cgpa=result[2];
								nob=result[3];
								sort1 = usn2 + "|" + sem + "|" + cgpa + "|" + nob + "|";
								pw1.println(sort1);
							}
						}
						else
						{
							while(!result[1].equals("999"))
							{
								pw1.println(sort1);
								sort = br1.readLine();
								result = sort.split("\\|");
								usn2=Integer.parseInt(result[0]);
								sem = result[1];
								cgpa=result[2];
								nob=result[3];
								sort1 = usn2 + "|" + sem + "|" + cgpa + "|" + nob + "|";
							}
						}
						
						pw1.println(p);
					}
				}
				pw1.flush();   
				pw1.close();
				br1.close();

				file1.delete();
				temp.renameTo(file1);
			}
		
		
		//if record does not exist
		if(check == 0)
		{
			File file1 = new File("student.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			System.out.println("Welcome new user! Enter the following details");
			System.out.println("Enter Name, USN, Semester, Branch, CGPA, Number of backlogs");
			name = scan.next();
			usn = scan.next();
			sem = scan.next(); 
			branch = scan.next();
			cgpa = scan.next();
			nob = scan.next();
			
			String b = name + "|" + usn + "|" + sem + "|" + branch + "|" + cgpa + "|" + nob + "|";
			int len = b.length();
			String s1 = "-";
			if(len<50)
			{
				for(int j=len;j<=50;j++)
				b = b.concat(s1);
			}
			usn3=Integer.parseInt(usn);
			//sorting before insertion
			File temp = new File("temp.txt");
			PrintWriter pw1 = new PrintWriter(temp);
			String result[]={};
			while((sort = br1.readLine()) != null)
			{
				result = sort.split("\\|");
				usn2=Integer.parseInt(result[1]);
				if(usn3<usn2)
				{
					pw1.println(b);
					break;
				}
				pw1.println(sort); 
			}    

			if(sort!=null )
			{
				if(result[1].equals("999"))
				{
					pw1.println(sort);
				}
				else
				{ 
					while(!result[1].equals("999"))
					{
						pw1.println(sort);
						sort = br1.readLine();
						result = sort.split("\\|");
					}
					pw1.println(p);
				}
			}
			pw1.flush();   
			pw1.close();
			br1.close();

			file1.delete();
			temp.renameTo(file1);
		}		
	}


	//UPDATING


	public void modify(String name1, String usn1,String sem1,String branch1, String cgpa1,String nob1) throws FileNotFoundException,IOException,NullPointerException
	{	String name = "", usn = "", sem ="", branch = "", cgpa= "", nob="", r;
		int check=0;
		File file = new File("student.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		File temp = new File("temp.txt");
		PrintWriter pw = new PrintWriter(temp);

		while((r= br.readLine()) !=null)
		{	
			String[] result = r.split("\\|");
			name=result[0];
			usn=result[1];
			sem= result[2];
			branch=result[3];
			cgpa=result[4];
			nob=result[5];

			if(usn.equals(usn1))
			{
				String b = name1+"|"+usn1+"|"+sem1+"|"+branch1+"|"+cgpa1+"|"+nob1+"|";
				int len = b.length();

				String s1 = "-";
				if(len<50)
				{
					for(int i=len;i<=50;i++)
						b = b.concat(s1);
					pw.println(b);
				}
			}
			else
			{
				pw.println(r);
			}
		}
		pw.flush();
		pw.close();
		br.close();	

		file.delete();
		temp.renameTo(file);
	}

	//DELETING

	public void remove()throws IOException
	{
		String usn="",r;
		File file = new File("student.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		File temp = new File("temp.txt");
		PrintWriter pw = new PrintWriter(temp);
		System.out.println("Enter the usn of the student record to be deleted");
		String usn1 = scan.next();

		while((r= br.readLine()) !=null)
		{	
			String[] result = r.split("\\|");
			usn=result[1];

			if(usn.equals(usn1))
				continue;
			else
				pw.println(r);
		}
		pw.flush();
		pw.close();
		br.close();	

		file.delete();
		temp.renameTo(file);
		System.out.println("Record Deleted");
	}

	//DISPLAY


	//retrieval - reading from file

	public void display()throws IOException
	{
		String name = "" ,usn = "" ,sem = "" ,branch = "", cgpa= "", nob="", s;
		String result[];
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		s = br.readLine();
		result = s.split("\\|");
		name = result[0];
		usn = result[1];
		sem = result[2];
		branch = result[3];
		cgpa=result[4];
		while(!name.equals("999"))
		{
			System.out.println("The details are: " + name + " " + usn + " " + sem + " " + branch + " " + cgpa + " " + nob);
			s = br.readLine();
			result = s.split("\\|");
			name = result[0];
			usn = result[1];
			sem = result[2];
			branch = result[3];
			cgpa=result[4];
			nob=result[5];
		}
		br.close();
	}

	//SEARCHING

	//Linear search

	public void search()throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		String name = "", usn ="", sem = "", branch = "", cgpa= "", nob="", r;
		System.out.println("Enter the usn");
		String usn1 = scan.next();
		while((r= br.readLine()) !=null)
		{
			String[] result = r.split("\\|");
			name=result[0];
			usn=result[1];
			sem= result[2];
			branch=result[3];
			cgpa=result[4];
			nob=result[5];
			if(usn.equals(usn1))
			{
				System.out.println("Match found. The details of the record are:");
				System.out.println(name + " " + usn + " " + sem + " " + branch + " " + cgpa + " " + nob);
				br.close();
				return ;
			}
		}
		System.out.println("Record not found");
		br.close();
	}

	 //GENERAL LEDGER
	public void ledger (String s1, String s2) throws FileNotFoundException, IOException
	{
		// BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		String name = "", usn = "", sem = "", branch = "", cgpa= "", nob="", r, s, j="",sss,jjj;

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
			return;
		else if(!ss[0].equals("999") && !jj[0].equals("999")) //ss!=null && jj!=null
		{
			if (item1 == item2)
			{
				System.out.println(name_s + " " + usn_s + " " + sem_j + " " + branch_s + " " + cgpa_j + " " + nob_j);
				ledger(s1,jour.readLine());
			}                                          
			else if(item1 < item2)
			{
				System.out.println("Latest Entry:" + name_s + " " + usn_s + " " + sem_s + " " + branch_s + " " + cgpa_s + " " + nob_s);
				ledger(stud.readLine(),s2);
			}
			else if(item1 > item2)
			 {
				 System.out.println("Invalid Record Entry");
				 ledger(s1,jour.readLine());
			 }
			 else
			 {

			 }
		}
		 else //ss==null || jj==null
		 {
			 if(jj[0].equals("999"))      
			{ 
				s1=stud.readLine();
				ss = s1.split("\\|"); 
				name_s=ss[0];
				sem_s= ss[2];
				branch_s=ss[3];
				cgpa_s=ss[4];
				nob_s=ss[5];
				while(!ss[0].equals("999"))
				//while(!(s1=stud.readLine()).equals("0"))
				{
					System.out.println(name_s + " " + usn_s + " " + sem_s + " " + branch_s + " " + cgpa_s + " " + nob_s);
					s1=stud.readLine();
					ss = s1.split("\\|"); 
					name_s=ss[0];
					sem_s= ss[2];
					branch_s=ss[3];
					cgpa_s=ss[4];
					nob_s=ss[5];
					
				}
				ledger(s1,s2); 
			}
		 }
	}	


	//ELIGIBILITY
	public void eligible() throws IOException
	{
		//platinum
		//cgpa >=8.0 && nob=0
		//gold
		//cgpa >=7.0 && nob=0
		//silver
		//cgpa >=6.0
		String name, sem, branch, cgpa1, nob1, r;
		double cgpa, nob;
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		while((r = br.readLine()) != null )
		{
			String[] result = r.split("\\|"); 
			name=result[0];
			sem= result[2];
			branch=result[3];
			cgpa1=result[4];
			nob1=result[5];
			cgpa = Double.parseDouble(cgpa1);
			nob = Double.parseDouble(nob1);
			if(cgpa!=999)
			{
				if(cgpa >= 8.0 && nob == 0)
			{
				System.out.println(name + " is eligible for the following packages:");
				System.out.println("Platinum");
				System.out.println("Gold");
				System.out.println("Silver");
			}
			else if(cgpa >= 7.0 && nob == 0)
			{
				System.out.println(name + " is eligible for the following packages:");
				System.out.println("Gold");
				System.out.println("Silver");
			}
			else if(cgpa >= 6.0)
			{
				System.out.println(name + " is eligible for the following packages:");
				System.out.println("Silver");
			}
			else
			{
				System.out.println(name + " is not eligible");
			}
			}	
		}

	}
}	







