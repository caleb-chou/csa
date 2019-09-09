import java.util.Arrays;

public class Cyc3086ArrayLab2 {
	private int array[] = {2, 9, 4, 7, 6, 5, 8, 3, 10, 1};
	public void part1() {
		for(int i =0; i<array.length;i++) {
			if(i==array.length-1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + " - ");
			}
		}
		System.out.println();
	}
	public void part2() {
		int[] a = new int[array.length];
		for(int i=0;i<array.length;i++)
			a[i] = array[i];
		for(int i = 0;i<array.length;i++) {
			a[i] = (i==0) ? array[array.length-1]:array[i-1];
		}
		this.array = a;
		System.out.println(Arrays.toString(array));
	}
	public void part3(int shift) {
		int[] a = new int[array.length];
		int[] b = new int[array.length];
		for(int i=0;i<array.length;i++)
			a[i] = array[i];
		for(int j= 0;j<shift;j++) {
			for(int n=0;n<a.length;n++)
				b[n] = a[n];
			for(int i = 0;i<b.length;i++) {
				a[i] = (i==0) ? b[b.length-1]:b[i-1];
			}
		}
		this.array = a;
		System.out.println(Arrays.toString(array));
	}
	public void part4(int shift) {
		int[] a = new int[array.length];
		int[] b = new int[array.length];
		for(int i=0;i<array.length;i++)
			a[i] = array[i];
		if(shift>=0) {
			for(int j= 0;j<shift;j++) {
				for(int n=0;n<a.length;n++)
					b[n] = a[n];
				for(int i = 0;i<b.length;i++) {
					a[i] = (i==0) ? b[b.length-1]:b[i-1];
				}
			}
		} else {
			for(int j=shift;j<0;j++) {
				for(int n=0;n<a.length;n++)
					b[n] = a[n];
				for(int i = 0;i<b.length;i++) {
					a[i] = (i==b.length-1) ? b[0]:b[i+1];
				}
			}
		}
		this.array = a;
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		Cyc3086ArrayLab2 a = new Cyc3086ArrayLab2();
		a.part1();
		a.part2();
		a.part3(3);
		a.part4(-1);
	}
}