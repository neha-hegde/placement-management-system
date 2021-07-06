//ADDITION

//insertion - writing into the file
import java.util.*;
import java.io.*;

class plm
{
	Scanner scan = new Scanner(System.in);
	public static void main(String args[]) throws IOException
	{
		 plm obj = new plm();
		while(true)
		{
			System.out.println("**********************");
			System.out.println("1. Insert");
			System.out.println("2. Modify");
			System.out.println("3. Delete");
			System.out.println("4. Display");
			System.out.println("5. Search");
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
				obj.modify();
				break;
			case 3:
				obj.remove();
				break;
			case 4:
				obj.display();
				break;
			case 5:
				obj.search();
				break;
			case 6:
				public BufferedReader stud = new BufferedReader(new FileReader("student.txt"));
				public BufferedReader jour = new BufferedReader(new FileReader("journal.txt"));
				obj.ledger(stud.readLine(),jour.readLine());
				stud.close();
				jour.close();
				break;
			default:
				System.out.println("Invalid Option");
			}
		}	
	}

	public void insert() throws IOException, FileNotFoundException
	{
		String name, usn, sem, branch, cgpa, nob;
		System.out.println("Enter Name, USN, Semester, Branch, CGPA, Number of backlogs");
		name = scan.next();
		usn = scan.next();
		sem = scan.next(); 
		branch = scan.next();
		cgpa = scan.next();
		nob = scan.next();
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("student.txt"),true));
		String b = name + "|" + usn + "|" + sem + "|" + branch + "|" + cgpa + "|" + nob + "|";
		int len = b.length();
		String s1 = "-";
		if(len<50)
		{
			for(int j=len;j<=50;j++)
			b = b.concat(s1);
		}
		pw.println(b);
		pw.flush();
		pw.close();
	}


	//UPDATING


	public void modify() throws FileNotFoundException,IOException,NullPointerException
	{	String name = "", usn = "", sem ="", branch = "", cgpa= "", nob="", r;
		int check=0;
		File file = new File("student.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		File temp = new File("temp.txt");
		PrintWriter pw = new PrintWriter(temp);
		System.out.println("Enter usn");
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
				check=1;
				System.out.println("The details are: " + name + " " + usn + " " + sem + " " + branch+ " " + cgpa + " " + nob );
				System.out.println("Enter Name, USN, Sem, Branch, CGPA, Number of Backlogs");
				String name11 = scan.next();
				String usn11 = scan.next();
				String sem11 = scan.next();
				String branch11 = scan.next();
				String cgpa11 = scan.next();
				String nob11= scan.next();
				String b = name11+"|"+usn11+"|"+sem11+"|"+branch11+"|"+cgpa11+"|"+nob11+"|";
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
		if(check == 0)
			System.out.println("USN not present in the records");
		else
			System.out.println("File Modified");
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
			{
				continue;
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
		System.out.println("Record Deleted");
	}

	//DISPLAY


	//retrieval - reading from file

	public void display()throws IOException
	{
		String name = "" ,usn = "" ,sem = "" ,branch = "", cgpa= "", nob="", s;
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));
		while((s = br.readLine())!=null)
		{
			String[] result = s.split("\\|");
			name = result[0];
			usn = result[1];
			sem = result[2];
			branch = result[3];
			cgpa=result[4];
			nob=result[5];
			System.out.println("The details are: " + name + " " + usn + " " + sem + " " + branch + " " + cgpa + " " + nob);
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
		// int check=0;
		// System.out.println("Enter the usn");
		// String usn1 = scan.next();
		// while((r= br.readLine()) !=null)
		// {
		// 	String[] result = r.split("\\|");
		// 	usn=result[1];

		// 	//if record already exists
		// 	if(usn.equals(usn1))
		// 	{
		// 		check=1;
		// 		System.out.println("Enter Semester, CGPA and Number of Backlogs");
		// 		sem = scan.next(); 
		// 		cgpa = scan.next();
		// 		nob = scan.next();
		// 		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("journal.txt"),true));
		// 		String b = usn + "|" + sem + "|"  + cgpa + "|" + nob + "|";
		// 		int len = b.length();
		// 		String s1 = "-";
		// 		if(len<50)
		// 		{
		// 			for(int i=len;i<=50;i++)
		// 			b = b.concat(s1);
		// 		}
		// 		pw.println(b);
		// 		pw.flush();
		// 		pw.close();
		// 		break;
		// 	}
		// }

		// //if record does not exist
		// if(check == 0)
		// {
		// 	System.out.println("Welcome new user! Enter the following details");
		// 	insert();
		// }
		// br.close();

		//sorting student.txt
		
		//sorting journal.txt

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
		String item1=ss[1];
		String item2=jj[0];
		if(s1 == NULL && s2 == NULL)
			return;
		else if(s1 != NULL && s2 != NULL)
		{
			if (item1 == item2)
			{
				System.out.println(name_s + " " + usn_s + " " + sem_j + " " + branch_s + " " + cgpa_j + " " + nob_j);
				ledger(s1,jour.readLine());
			}
			else if(item1 < item2)
			{
				ledger(stud.readLine(),s2);
			}
			else //(item1 > item2)
			 {
				 ledger(s1,jour.readLine());
			 }
		}
		else
		{
			if(s1 != NULL)
			{
				while(s1 != NULL)
				{
					stud.readLine();
					System.out.println(name_s + " " + usn_s + " " + sem_s + " " + branch_s + " " + cgpa_s + " " + nob_s);
				}
			}
			if(s2 != NULL)
			{
				while(s2 != NULL)
				{
					stud.readLine();
					System.out.println(name_s + " " + usn_s + " " + sem_s + " " + branch_s + " " + cgpa_s + " " + nob_s);
				}
			}
		}
	}		

}
	

	//student
	// guru|49|6|ise|8.9|0|-------------------------------
	// rafaath|70|6|ise|7.8|0|----------------------------
	// neha|71|6|ise|8.8|0|-------------------------------
	// nibha|73|6|ise|9.2|0|------------------------------
	//nikesh|74|
	// //journal
	// 
	// 49|6|9.1|0|----------------------------------------
	// 49|6|8.0|0|---------------------------------------
	// 70|6|9.0|0|----------------------------------------
	// 72|6|8.85|0|---------------------------------------







	





// //open student file and sort

// akhil|17|6|ise|7.9|1|------------------------------
// guru|49|6|ise|8.7|0|-------------------------------
// neha|71|6|ise|8.5|0|-------------------------------


// //open journal file and sort

// 17|6|8.2|0
// 17|6|8.25|0
// 49|6|8.8|0


// //open student  //item1
// akhil|17|6|ise|7.9|1|------------------------------
// guru|49|6|ise|8.7|0|-------------------------------
// neha|71|6|ise|8.5|0|-------------------------------


// //open journal  //item 2
// 17|6|8.2|0
// 17|6|8.25|0
// 49|6|8.8|0
// 71
// temp
// 49|6|8.8|0

// while(student!=null || journal!=null)
// {
// 	if(item1 < item2)
// 	{
		
// 	}