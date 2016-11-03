package masterMind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * MasterMind Konsolen Anwendung.
 * @author vmadmin
 */
public class MasterMind {

  /**
   * Main Methode, hier wird die Applikation gestartet.
   * @param args Argumente
   */
  public static void main(final String[] args) {

    int anzahlVersuche = 10;
    final String[] loesungsMuster = new String[4];
    final String[] moeglicheFarben = new String[] { "R", "G", "B", "O", "T", "V", "M" };
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    if(args.length > 0) {
        if (args[0].equals("Multiplayer")) {
        	
            System.out.println(
                    "M�gliche Farben:\nR f�r Rot\nG f�r Gr�n\nB f�r Blau\nO f�r Orange\nT f�r T�rkis\nV f�r Violett\nM f�r Magenta\n");
        	try {
        		boolean korrekteEingabe = false;
        		
        		do {
        			
    	        	System.out.println("Ein L�sungsmuster eingeben [Muster: R,G,B,O]");
    	            final String le1 = reader.readLine();
    	
    	            final String le2 = le1.replaceAll("\\s+", "");
    	            final String loesung_input = le2.replaceAll(",", "").toUpperCase();
    	            
    	            if (loesung_input.length() == 4) {
    	
    	                final String farbe1 = loesung_input.substring(0, 1).toUpperCase();
    	                final String farbe2 = loesung_input.substring(1, 2).toUpperCase();
    	                final String farbe3 = loesung_input.substring(2, 3).toUpperCase();
    	                final String farbe4 = loesung_input.substring(3, 4).toUpperCase();
    	                
    	                final List<String> farbenListe = Arrays.asList(moeglicheFarben);
    	
    	                if (farbenListe.contains(farbe1) && farbenListe.contains(farbe2) && farbenListe.contains(farbe3)
    	                    && farbenListe.contains(farbe4)) {
    	                	
    	                  korrekteEingabe = true;
    	                  loesungsMuster[0] = farbe1;
    	                  loesungsMuster[1] = farbe2;
    	                  loesungsMuster[2] = farbe3;
    	                  loesungsMuster[3] = farbe4;
    	
    	                } else {
    		                korrekteEingabe = false;
    		                System.out.println("\nEingabe nicht korrekt! Eingabe muss diesem Muster entsprechen: R,G,B,O");
    		            }  
    	            } else {
    	                korrekteEingabe = false;
    	                System.out.println("\nEingabe nicht korrekt! Eingabe muss diesem Muster entsprechen: R,G,B,O");
    	            }
    	            
        		} while (!korrekteEingabe);
        		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        	} catch (final IOException e) {
                System.out.println(e);
            }
        }  	
    } else {
    	
        for (int i = 0; i < 4; i++) {
            final Random random = new Random();

            final int neueFarbe = random.nextInt(7) + 1;

            switch (neueFarbe) {
              case 1:
                loesungsMuster[i] = "R";
                break;
              case 2:
                loesungsMuster[i] = "G";
                break;
              case 3:
                loesungsMuster[i] = "B";
                break;
              case 4:
                loesungsMuster[i] = "O";
                break;
              case 5:
                loesungsMuster[i] = "T";
                break;
              case 6:
                loesungsMuster[i] = "V";
                break;
              case 7:
                loesungsMuster[i] = "M";
                break;
              default:
                break;
            }
        }
    }

    System.out.println(
        "M�gliche Farben:\nR f�r Rot\nG f�r Gr�n\nB f�r Blau\nO f�r Orange\nT f�r T�rkis\nV f�r Violett\nM f�r Magenta\n");
    boolean vorbei = false;
    do {
      try {
        boolean korrekteEingabe = false;
        System.out.println("Verbleibende Versuche: " + anzahlVersuche
            + "\nErrate das L�sungs Muster. Eingabe muss diesem Muster entsprechen: R,G,B,O");
        do {
          int richtigePosition = 0;
          int richtigeFarbe = 0;
          final String eingabe = reader.readLine();

          final String eingabe2 = eingabe.replaceAll("\\s+", "");
          final String eingabe3 = eingabe2.replaceAll(",", "");

          if (eingabe3.length() == 4) {

            final String farbe1 = eingabe3.substring(0, 1).toUpperCase();
            final String farbe2 = eingabe3.substring(1, 2).toUpperCase();
            final String farbe3 = eingabe3.substring(2, 3).toUpperCase();
            final String farbe4 = eingabe3.substring(3, 4).toUpperCase();

            final List<String> farbenListe = Arrays.asList(moeglicheFarben);

            if (farbenListe.contains(farbe1) && farbenListe.contains(farbe2) && farbenListe.contains(farbe3)
                && farbenListe.contains(farbe4)) {
              korrekteEingabe = true;

              final String[] gerateneFarben = new String[] { farbe1, farbe2, farbe3, farbe4 };

              if (Arrays.toString(loesungsMuster).equals(Arrays.toString(gerateneFarben))) {
                printLine();
                System.out.println("Gratulation! Du hast gewonnen! L�sung: " + Arrays.toString(loesungsMuster)
                    + " / Ben�tigte Versuche: " + (10 - anzahlVersuche));
                vorbei = true;
                break;
              }

              anzahlVersuche -= 1;
              if (anzahlVersuche == 0) {
                printLine();
                System.out.println("Schade! Du hast verloren! L�sung: " + Arrays.toString(loesungsMuster));
                vorbei = true;
                break;
              }

              for (int i = 0; i < 4; i++) {
                if (loesungsMuster[i].equals(gerateneFarben[i])) {
                  richtigePosition += 1;
                }
              }

              final ArrayList<Integer> schonGetestet = new ArrayList<>();
              for (final String color : loesungsMuster) {
                for (int i = 0; i < 4; i++) {
                  if (color.equals(gerateneFarben[i]) && !schonGetestet.contains(i)) {
                    schonGetestet.add(i);
                    richtigeFarbe += 1;
                    break;
                  }
                }
              }
              richtigeFarbe -= richtigePosition;

              System.out.println("\nDu hast " + richtigeFarbe + " richtige Farben und " + richtigePosition
                  + " richtige Farben an der richtigen Position.");
              printLine();

            } else {
              korrekteEingabe = false;
              System.out.println("\nEingabe nicht korrekt! Eingabe muss diesem Muster entsprechen: R,G,B,O");
            }

          } else {
            korrekteEingabe = false;
            System.out.println("\nEingabe nicht korrekt! Eingabe muss diesem Muster entsprechen: R,G,B,O");
          }

        } while (!korrekteEingabe);
      } catch (final IOException e) {
        System.out.println(e);
      }
    } while (!vorbei);
  }

  private static void printLine() {
    System.out.println("\n================================================================================\n");
  }

}
