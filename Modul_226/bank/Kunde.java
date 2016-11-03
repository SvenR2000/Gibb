/**
 * 
 */
package bank;


/**
 * @author janni
 *
 */
public class Kunde {
	
	private String name;
	private String vorname;
	private long kundennummer;
	
	public Kunde(String name, String vorname, long kundennummer) {
		this.name = name;
		this.vorname = vorname;
		this.kundennummer = kundennummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public long getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(long kundennummer) {
		this.kundennummer = kundennummer;
	}
	
	
	
}
