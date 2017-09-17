import java.util.Scanner;

public class DayOfWeek {
	static String pvm;
	
	public static void main(String[] args) {
		
		Scanner year = new Scanner(System.in);
		Scanner month = new Scanner(System.in);
		Scanner day = new Scanner(System.in);
		

		System.out.print("Syötä vuosi: ");
		int v = year.nextInt();
		while (v < 1) {
			year.reset();
			System.out.print("Syötä vuosi: ");
			v = year.nextInt();
		}

		System.out.print("Syötä kuukausi: ");
		int k = month.nextInt();
		while (k < 1 || k > 12) {
			month.reset();
			System.out.print("Syötä kuukausi: ");
			k = month.nextInt();
		}

		System.out.print("Syötä päivämäärä: ");
		int p = day.nextInt();
		while (p < 1 || p > 31) {
			day.reset();
			System.out.print("Syötä päivämäärä: ");
			p = day.nextInt();
		}

		
		
		switch(dayofweek(v,k,p)) {
		case 1:
			pvm = "maanantai";
			break;
		case 2:
			pvm = "tiistai";
			break;
		case 3:
			pvm = "keskiviikko";
			break;
		case 4:
			pvm = "torstai";
			break;
		case 5:
			pvm = "perjantai";
			break;
		case 6:
			pvm = "lauantai";
			break;
		case 0:
			pvm = "sunnuntai";
			break;
		default: 
			System.out.println();
		}
		
		
		System.out.println("Päivämäärän " + p + "." + k + "." + v + " viikonpäivä oli " + pvm);
		year.close();
		month.close();
		day.close();
	}


	public static int dayofweek(int y, int m, int d) {
		int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
		if(m<3) {
			y=y-1;
		}
		return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
	}

}
