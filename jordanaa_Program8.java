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



//the text file used for this program:

/*
100
Amazon 900 20000.00 purchasing@amazon.com 0.08
Nordstrom 210 50000.00 purchasing@nordstrom.com 0.07
Rutgers 010 32000.00 purchasing@rutgers.edu education
Alamo 520 23000.00 purchasing@alamo.com 0.05
Kean 001 158000.50 purchasing@kean.edu education
Allied 100 85300.00 purchasing@allied.com 0.06
JoesInc 950 999999.00 purchasing@joesinc.com 0.03
BostonU 697 340020.23 purchasing@tufts.edu education
TruckersInc 310 55000.00 purchasing@truckersinc.com 0.10
Clothiers 820 20044.00 purchasing@clothiers.com 0.05
RedCross 849 48900.20 purchasing@redcross.org non-profit
ChocolateRus 125 3000.50 purchasing@chocolate.com 0.1
CareBear 535 6000.00 purchasing@carebear.com 0.08
BalloonInc 331 5100.50 purchasing@balloon.com 0.06
TiresInc 345 25000.00 purchasing@tires.com 0.07
JeweleryInc 211 52000.00 purchasing@jewelery.com 0.08
Vassar 002 53000.00 purchasing@vassar.edu education
Hertz 521 22200.00 purchasing@hertz.com 0.07
JCU 009 135678.50 purchasing@jcu.edu education
Enterprise 120 75300.00 purchasing@enterprise.com 0.06
Avis 958 89999.00 purchasing@avis.com 0.03
Tufts 699 340020.23 purchasing@tufts.edu education
Truckers2Corp 910 55000.00 purchasing@truckers2corp.com 0.10
LandsEnd 825 20054.00 purchasing@landsend.com 0.04
TheFutureProject 853 48920.20 purchasing@tfp.org other
Bromilows 225 3300.50 purchasing@bromilows.com 0.5
Thrifty 539 6600.00 purchasing@thrify.com 0.07
FlowersRus 339 59300.50 purchasing@flowers.com 0.08
Prudential 660 28900.00 purchasing@prudential.com 0.07
MassMutual 567 5890.00 purchasing@massmutual.com 0.08
Montclair 111 39800.00 purchasing@montclair.edu education
SaveTheChildren 578 28760.00 purchasing@savechildren.com non-profit
NJDOE 154 158000.50 purchasing@njdoe.gov other
ShopRite 333 82100.00 purchasing@shoprite.com 0.07
Turtles 943 88888.00 purchasing@turtles.com 0.08
Brandeis 901 340020.23 purchasing@brandeis.edu education
TruckersRus 610 54000.00 purchasing@truckersrus.com 0.08
Clothier&Son 821 20044.00 purchasing@clothiersson.com 0.05
MLH 823 900.20 purchasing@mlh.org other
Calandras 725 43000.50 purchasing@calandra.com 0.7
PinkElephant 536 600.00 purchasing@pinkelephant.com 0.05
Essie 338 5000.50 purchasing@essie.com 0.07
Uber 348 1500.00 purchasing@uber.com 0.05
NYDOE 157 12000.50 purchasing@nydoe.gov other
Zales 213 54300.00 purchasing@zales.com 0.07
Columbia 322 54500.00 purchasing@columbia.edu education
CheapCars 555 23210.00 purchasing@cheapcars.com 0.09
NJIT 099 13978.50 purchasing@NJIT.edu education
DAV 358 4860.20 purchasing@dav.org non-profit
LLBean 852 2234.00 purchasing@llbean.com 0.03
ArthritisREU 238 4890.20 purchasing@arthritisreu.org other
Etsy 902 20400.00 purchasing@etsy.com 0.03
BedBath 212 55000.00 purchasing@Bedbath.com 0.05
UPenn 011 350000.00 purchasing@upenn.edu education
EnginesRus 522 23500.00 purchasing@enginesrus.com 0.06
SetonHall 008 158090.50 purchasing@setonhall.edu education
TiresToGo 108 8300.00 purchasing@tirestogo.com 0.06
BillShop 956 9999.00 purchasing@billshop.com 0.08
NorthEastern 798 40020.23 purchasing@northeastern.edu education
Chocolatiers 318 59000.00 purchasing@chocolatiers.com 0.03
DunkinDonuts 819 2044.00 purchasing@dunkingdonuts.com 0.06
DiabetesOrg 850 4900.20 purchasing@diabetes.org non-profit
Beans 126 1000.50 purchasing@beans.com 0.03
BabyGap 538 6100.00 purchasing@babygap.com 0.07
PartyStore 334 500.50 purchasing@partystore.com 0.03
Threads 349 29000.00 purchasing@threads.com 0.05
ColorsInc 218 2000.00 purchasing@colorsinc.com 0.06
CountyCollege1 12 5000.00 purchasing@cc1.edu education
BusinessRUs 531 1200.00 purchasing@businessrus.com 0.08
CountyCollege2 109 1678.50 purchasing@cc2.edu education
Business2 128 5300.00 purchasing@business2.com 0.02
Oleander 959 2999.00 purchasing@oleander.com 0.04
Harvard 698 34020.23 purchasing@harvard.edu education
TaxisInc 914 5000.00 purchasing@taxisinc.com 0.09
Jjill 829 2054.00 purchasing@jjill.com 0.05
CSTA 859 4820.20 purchasing@csta.org other
Godiva 229 3100.50 purchasing@godiva.com 0.06
DryCleaners 540 6800.00 purchasing@drycleaners.com 0.05
Macys 332 58200.50 purchasing@macys.com 0.07
CADOE 669 2900.00 purchasing@cadoe.gov.com other
Prudential 561 58290.00 purchasing@prudential.com 0.07
Linden 112 3800.00 purchasing@linden.gov other
FoodPantry 579 25760.00 purchasing@foodpantry.org non-profit
WADOE 159 18000.50 purchasing@wadoe.gov other
StopandShop 377 8100.00 purchasing@stopandshop.com 0.06
WholeFoods 953 8888.00 purchasing@wholefoods.com 0.06
FIT 907 30020.23 purchasing@fit.edu education
CarRental1 690 5400.00 purchasing@carrental1.com 0.04
Office1 851 2044.00 purchasing@office1.com 0.05
CodeHS 822 1000.20 purchasing@codehs.org other
Bakery1 727 4000.50 purchasing@bakery1.com 0.07
BabyToys 539 6000.00 purchasing@babytoys.com 0.04
Google 003 500.50 purchasing@google.com 0.01
NYYankees 019 15500.00 purchasing@nyyankees.com 0.07
Census 155 102000.50 purchasing@census.gov other
Fridays 110 5300.00 purchasing@fridays.com 0.06
CUNY 328 5500.00 purchasing@cuny.edu education
CheapFood 551 2210.00 purchasing@cheapfood.com 0.04
LegoInc 018 1978.50 purchasing@lego.com 0.02
DAV2 359 4860.20 purchasing@dav2.org non-profit
*/











