import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.*;
import java.io.*;

public class Home extends JFrame implements ActionListener
{
	JLabel welcome, heading;
    private  JButton insert, delete, display, search, ledger, eligible;


	Home()
	{
		super("CampusIn:Placement Management System");
		Container con = getContentPane();
		con.setLayout(null);
		Color  lightBlue = new Color(164, 206, 209);
        con.setBackground(lightBlue);
		con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

		heading = new JLabel("CAMPUSIN");
        heading.setBounds(550,30, 400,150);
		con.add(heading);

		Font fonth = new Font("Verdana", Font.BOLD, 24);
        heading.setFont(fonth);
        heading.setForeground(Color.BLACK);

		welcome = new JLabel("SELECT OPTION");
		welcome.setBounds(550,100, 400,150);
		con.add(welcome);

		Font fontw = new Font("Verdana", Font.BOLD, 16);
        welcome.setFont(fontw);
        welcome.setForeground(Color.BLACK);

		Color blue = new Color(42, 135, 141);
		insert = new JButton("Insert Details");
		insert.addActionListener(this);
		insert.setBounds(200,275,175, 50);
		Font font1 = new Font("Verdana", Font.BOLD, 16);
        insert.setFont(font1);
        insert.setForeground(Color.WHITE);
        insert.setBackground(blue);

		delete = new JButton("Delete Record");
		delete.addActionListener(this);
		delete.setBounds(500,275, 175, 50);
		Font font2 = new Font("Verdana", Font.BOLD, 16);
        delete.setFont(font2);
        delete.setForeground(Color.WHITE);
        delete.setBackground(blue);

		display = new JButton("Display Record");
		display.addActionListener(this);
		display.setBounds(830,275, 175, 50);
		Font font3 = new Font("Verdana", Font.BOLD, 16);
        display.setFont(font3);
        display.setForeground(Color.WHITE);
        display.setBackground(blue);

		search = new JButton("Search Record");
		search.addActionListener(this);
		search.setBounds(200,475, 175, 50);
		Font font4 = new Font("Verdana", Font.BOLD, 16);
        search.setFont(font4);
        search.setForeground(Color.WHITE);
        search.setBackground(blue);

		ledger = new JButton("View changes");
		ledger.addActionListener(this);
		ledger.setBounds(500,475, 175, 50);
		Font font5 = new Font("Verdana", Font.BOLD, 16);
        ledger.setFont(font5);
        ledger.setForeground(Color.WHITE);
        ledger.setBackground(blue);

		eligible = new JButton("Placement Eligibility");
		eligible.addActionListener(this);
		eligible.setBounds(800,475, 250, 50);
		Font font6 = new Font("Verdana", Font.BOLD, 16);
        eligible.setFont(font6);
        eligible.setForeground(Color.WHITE);
       	eligible.setBackground(blue);

		con.add(insert);
		con.add(delete);
		con.add(display);
		con.add(search);
		con.add(ledger);
		con.add(eligible);
	}

	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource()==insert)
		{
			this.dispose();
			Insert in=new Insert();
			in.setSize(2300,790);
			in.setVisible(true);
		}

		if(ae.getSource()==delete)
		{
			this.dispose();
			Delete del=new Delete();
			del.setSize(2300,790);
			del.setVisible(true);
		}

		if(ae.getSource()==display)
		{
			this.dispose();
			Display dis=new Display();
			dis.setSize(2300,790);
			dis.setVisible(true);
		}

		if(ae.getSource()==search)
		{
			this.dispose();
			Search ser=new Search();
			ser.setSize(2300,790);
			ser.setVisible(true);
		}

		if(ae.getSource()==ledger)
		{
			this.dispose();
			Ledger led=new Ledger();
			led.setSize(2300,790);
			led.setVisible(true);
		}

		if(ae.getSource()==eligible)
		{
			this.dispose();
			Eligible eli=new Eligible();
			eli.setSize(2300,790);
			eli.setVisible(true);
		}

	}

	public static void main(String args[])
	{
        Home h=new Home();
		h.setSize(2300,790);
		h.setVisible(true);
	}
}