// Aaron Jordan
import java.io.File;
import java.io.IOException;
import java.util.*;

public class jordanaa_Program8 {
	public static void main(String[] args)throws IOException{
		File prg8 = new File("program8.txt");
		Scanner reader = new Scanner(prg8);
		String cName = "";
		int cID = 0;
		double bill = 0.0;
		String email = "";
		double nExempt = 0.0;
		String tExempt = "";
		int x = 0;
		int j = 1;

		while(reader.hasNextInt()) {
			x = reader.nextInt();}
		Customers c1 [] = new Customers [x];
		for (int i = 0; i < x; i++) {
			cName = reader.next();
			cID = reader.nextInt();
			bill = reader.nextDouble();
			email = reader.next();	
			if (reader.hasNextDouble()) {
				nExempt = reader.nextDouble();
				c1 [i] = new Customers(cName, cID, bill, email, nExempt);			
			}
			else if (reader.hasNext()) {
				tExempt = reader.next();
				c1 [i] = new Customers(cName, cID, bill, email, tExempt);		
			}	
		}	
		reader.close();
		Arrays.sort(c1);
		for (int i = 0; i < x ; i++) {

			if (i % 45 == 0) {
				System.out.println("\n");
				printHeader(j);
				j++;
			}

			System.out.println(c1[i]);
		}	

	}
	public static void printHeader(int j) {

		System.out.printf("%84s %32s ", "Office Supplies Inc Customer Report" , "Page: " + j + " \n");
		System.out.printf("%87s",  "=================================== \n\n\n");
		System.out.printf("%-20s %5s %27s %30s %16s %13s","Customer Name" ,"ID",  "Email Address", "Balance" ,"Tax Type" , "Tax Amount" + "\n");
		System.out.printf("%-20s %5s %27s %30s %16s %14s","=============" ,"==",  "=============", "=======" ,"========" ,  "========== " + "\n");
		System.out.println();
	}
}



class Customers implements Comparable<Customers> {
	private String cName;
	private int cID;
	private double bill;
	private String email;
	private double nExempt;
	private String tExempt;

	public Customers() {
		cName = "";
		cID = 0;
		bill = 0.0;
		email = "";
		nExempt = 0.0;
		tExempt = "";
	}

	public Customers (String name, int cID, double bill, String email, double nExempt) {
		this.cName = name;
		this.cID = cID;
		this.bill = bill;
		this.email = email;
		this.nExempt = nExempt;
	}
	public Customers (String name, int cID, double bill, String email, String tExempt) {
		this.cName = name;
		this.cID = cID;
		this.bill = bill;
		this.email = email;
		this.tExempt = tExempt;
	}

	public String getCName () {
		return cName;
	}
	public String getEmail () {
		return email;
	}
	public String getTExempt () {
		return tExempt;
	}
	public int getCID() {
		return cID;
	}
	public double getBill() {
		return bill;
	}
	public double getnExempt() {
		return nExempt;
	}
	public void setCName (String cName) {
		this.cName = cName;
	}
	public void setEmail (String email) {
		this.email = email;
	}
	public void setTExempt (String tExempt) {
		this.tExempt = tExempt;
	}
	public void setCID (int cID) {
		this.cID = cID;
	}
	public void setnExempt (double nExempt) {
		this.nExempt = nExempt;
	}


	@Override
	public int compareTo(Customers it) {
		if (this.getCID()== it.getCID()) {
			return 0;
		}
		else if (this.getCID() < it.getCID()) {
			return -1;
		}
		else 
			return 1;
	}
	@Override
	public String toString() {
		String temp = "";
		if (nExempt != 0.0) {
			temp = String.format("%-20s %5d\t\t %-30s %,13.2f  %15s %12.2f", cName, cID,  email, bill,  "tax liable", (nExempt * bill) );
		}
		else {
			temp = String.format("%-20s %5d\t\t %-30s %,13.2f  %15s ", cName, cID,  email, bill, tExempt  );
		}
		return temp;
	}
}















