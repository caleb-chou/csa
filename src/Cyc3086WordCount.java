//Name : Caleb Chou
//ID   : 53086
//Lab  : Word Count
import java.io.BufferedReader;
//import java.util.Arrays;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class Cyc3086WordCount {
	private String filepath;
	private BufferedReader s;
	Cyc3086WordCount(){
		
	}
	Cyc3086WordCount(String filepath) {
		this.filepath = filepath;
	}
	public int reader() {
		int count = 0;
		try {
			s = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF8"));
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		String temp;
		try {
			while((temp = s.readLine())!=null) {
				temp = clean(temp);
				if(temp.isEmpty())
					continue;
				count+=counter(temp);
				//System.out.println(temp);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return count;
	}
	public int counter(String s) {
		return s.split("\\s+").length;
	}
	public String clean(String s) {
		return s.replaceAll("[—-]"," ").replaceAll("//","").replaceAll("/", " ")
				.replaceAll("[^a-zA-Z\\s]", "").trim();
	}
	public static void main(String[]args) {
		
		Cyc3086WordCount w = new Cyc3086WordCount("warandpeace.txt");
		System.out.println("The book " + w.filepath + " contains " + w.reader() + " words.");
	}
}
