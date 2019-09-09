import java.util.Scanner;
import java.io.File;
public class Cyc3086Expressions {
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("expression.txt"));
			String exp = s.nextLine().toLowerCase().replaceAll("\\s+", " ");
			while(s.hasNextLine()) {
				String temp = s.nextLine();
				if(!temp.contains("=")) continue;
				exp = exp.replace(temp.substring(0,temp.indexOf("=")-1).toLowerCase().replaceAll("\\s+",""),temp.substring(temp.indexOf("=")+1).replaceAll("\\s+",""));
			}
			s.close();
			System.out.print(exp + " = ");
			String[] expArr = exp.split(" ");
			try { 
				double result = Double.parseDouble(expArr[0]);
				for(int i = 2;i<expArr.length;i+=2) {
					switch(expArr[i-1]) {
						default: System.out.println("Invalid Operator.");break;
						case "*": result *=Double.parseDouble(expArr[i]);break;
						case "/": if(expArr[i].equals("0")) {
							System.out.println("Divide by Zero error.");
							return;
						} result /=Double.parseDouble(expArr[i]);break;
						case "+": result +=Double.parseDouble(expArr[i]);break;
						case "-": result -=Double.parseDouble(expArr[i]);break;
						case "%": result %=Double.parseDouble(expArr[i]);break;
					}
				}
				System.out.println(result);
			} catch(Exception e) {
				System.out.println("There was a problem with your equation.");
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
