/**
 * 
 */
package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Jannik Elia Hug
 *
 */
public class TestKonto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Konto erstellen");

			System.out.println("Vorame: ");
			String vorname = reader.readLine();

			System.out.println("Name: ");
			String name = reader.readLine();

			System.out.println("Kontonummer: ");
			long kontonummer = 0;
			boolean korrekteEingabe = false;
			do {
				String kontonummer_string = reader.readLine();
				Scanner scanner = new Scanner(kontonummer_string);

				if (scanner.hasNextLong()) {
					korrekteEingabe = true;
					kontonummer = Long.parseLong(kontonummer_string);
				} else {
					System.out.println("Eingabe nicht korrekt, erneut Versuchen: ");
				}
			} while (!korrekteEingabe);

			System.out.println("Kontolaufzeit in Tagen: ");
			int laufzeit;
			String laufzeit_string = reader.readLine();
			laufzeit = Integer.parseInt(laufzeit_string);
			
			System.out.println("Geben sie einen Zinssatz für das Konto ein: ");
			double zinssatz;
			String zinssatz_string = reader.readLine();
			zinssatz = Double.parseDouble(zinssatz_string);
			
			Kunde kunde = new Kunde(vorname, name, kontonummer);
			Konto konto = new Konto(zinssatz, kunde);
			
			boolean exit = false;
			do {
				
				System.out.println("Hier können Sie Geld einzahlen: ");
				double geld;
				String geld_string = reader.readLine();
				geld = Double.parseDouble(geld_string);

				konto.einzahlen(geld);
				System.out.println("\nOhne Zins======================================================");
				System.out.println(formatOutput(konto));

				konto.zinsberechnung(laufzeit);
				System.out.println("Mit Zins=======================================================");
				System.out.println(formatOutput(konto));
				
				String verlassen;
				boolean ja_odern_nein = false;
				do {
					System.out.println("Möchten Sie noch mehr Geld einzahlen? [Ja / Nein]");
					verlassen = reader.readLine().toUpperCase();
					
					if (verlassen.equals("JA") || verlassen.equals("NEIN")) {
						ja_odern_nein = true;
					} else {
						System.out.println("\nFalsche Eingabe.");
					}
				} while (!ja_odern_nein);
				
				if (verlassen.equals("NEIN")) {
					exit = true;
				}
				
			} while (!exit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String formatOutput(Konto konto) {
		Kunde inhaber = konto.getInhaber();
		String format;

		format = "Inhaber: " + inhaber.getVorname() + " " + inhaber.getName();
		format += "\nKundennummer: " + inhaber.getKundennummer();
		format += "\nSaldo: " + konto.getSaldo();
		format += "\n===============================================================\n";

		return format;

	}

}
