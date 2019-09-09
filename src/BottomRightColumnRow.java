/*
 * Name: Caleb Chou
 * ID: 53086
 * Period 3
 */
public class BottomRightColumnRow implements Cipher {
    private String[][] codeBox;
    private int square;
    public String encode(String original) {
    	double temp = (Math.sqrt(intToDouble(original.length())));
    	this.square = (original.length() % temp==0) ? (int) temp : (int) Math.sqrt(squarify(original.length()));
    	this.codeBox = new String[this.square][this.square];
    	int index = 0;
    	for(int r = 0; r < this.square; r++)
    		for(int c = 0; c < this.square; c++ /* The best programming language */ ) {
    			this.codeBox[r][c] = (index < original.length()) ? "" + original.charAt(index) : "*";
    			index++;
    		}
        return botRightColumnRow();
    }
    public String decode(String encoded) {
        return encode(encode(encode(encode(encode(encode(encode(encode(encode(encode(encode(encode(encode(encoded))))))))))))).replaceAll("[^a-zA-Z]", "");
    }
    private String botRightColumnRow() {
    	String result ="";
    	for(int c = this.square-1; c>=0; c-- )
    		for(int r = this.square-1; r>=0; r-- )
        		result+=this.codeBox[r][c];
        return result;
    }
    private double intToDouble(int thisint) {
    	return Double.parseDouble(Integer.toString(thisint));
    }
    private int squarify(int f) {
    	while(f % Math.sqrt(intToDouble(f))!=0)
    		f++;
    	return f;
    }
}
// Including the interface cipher here

interface Cipher {
    public String encode(String orginal);
    public String decode(String encoded);
}
// Sample Runner

class CipherRunner {

    public static void main(String args[]) {
        BottomRightColumnRow cs = new BottomRightColumnRow();
        System.out.println("chicken");
        System.out.println(cs.encode("chicken"));
        System.out.println(cs.decode(cs.encode("chicken")));
        
        System.out.println("\nabc");
        System.out.println(cs.encode("abc"));
        System.out.println(cs.decode(cs.encode("abc")));

        System.out.println("\ndnadoublehelix");
        System.out.println(cs.encode("dnadoublehelix"));
        System.out.println(cs.decode(cs.encode("dnadoublehelix")));

        System.out.println("\ncipherscodesandstrings");
        System.out.println(cs.encode("cipherscodesandstrings"));
        System.out.println(cs.decode(cs.encode("cipherscodesandstrings")));

        System.out.println("\nelvissoundgardenhinderseetherbeatles");
        System.out.println(cs.encode("elvissoundgardenhinderseetherbeatles"));
        System.out.println(cs.decode(cs.encode("elvissoundgardenhinderseetherbeatles")));
    }
}