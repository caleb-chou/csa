// Name: Caleb Chou, ID: 53086, Lab: Class Labs
public class Cyc3086Card {
	private int face;
	private String suit;
	public Cyc3086Card(int face, String suit) {
		this.face = face;
		this.suit = suit;
	}
	public String getFace() {
		String f;
		switch(this.face) {
			default: f = ""; break;
			case 1: f = "A";break;
			case 11: f = "J";break;
			case 12: f = "Q";break;
			case 13: f = "K";break;
		}
		return (this.face<=10&&this.face>1) ? ""+this.face:f;
	}
	public String getSuit() {
		return this.suit;
	}
	public String toString() {
		return getFace() + this.suit;
	}
}
