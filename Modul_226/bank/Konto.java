/**
 * 
 */
package bank;

/**
 * @author Jannik Elia Hug
 *
 */
public class Konto {
	
	private double saldo;
	private double zinssatz;
	private double zins;
	private Kunde inhaber;
	
	
	public Konto(double zinssatz, Kunde inhaber) {
		this.zinssatz=zinssatz;
		this.inhaber = inhaber;
	}
	
	public void einzahlen(double betrag) {
		saldo+=betrag;
	}
	
	public void zinsberechnung(int laufzeit) {
		if (saldo>=500000) {			
			zins=saldo*laufzeit*0/365;			
		} else if (saldo>=50000) {		
			zins=saldo*laufzeit*(zinssatz/2)/365;				
		} else {			
			zins=saldo*laufzeit*zinssatz/365;
		}
		saldo+=zins;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getZinssatz() {
		return zinssatz;
	}

	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}

	public double getZins() {
		return zins;
	}

	public void setZins(double zins) {
		this.zins = zins;
	}

	public Kunde getInhaber() {
		return inhaber;
	}

	public void setInhaber(Kunde inhaber) {
		this.inhaber = inhaber;
	}
	
	
	
	
}
