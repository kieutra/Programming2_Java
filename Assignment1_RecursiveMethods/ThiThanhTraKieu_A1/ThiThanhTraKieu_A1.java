import java.util.ArrayList;

// Thi Thanh Tra KIEU - 261066512

public class A1 {

	public static void main(String[] args) {


		System.out.println(crazySeries(5));
		System.out.println(crazySeries(9));

		
		System.out.println(benNumber(2,5));
		System.out.println(benNumber(3,8));
		System.out.println(benNumber(1,1));
		
	

	}


	//Q1
	public static ArrayList<Integer>crazy1(ArrayList<Integer>myarr, int delta, int start) {

		if(start <0) delta = -delta;
		myarr.add(start);
		start = start+delta;
		if(start != myarr.get(0))
			return crazy1(myarr, delta, start);
		else 
		{
			myarr.add(start);
			return myarr;
		}
		
		
	}
	
	public static ArrayList<Integer>crazySeries(int start){
		int delta = -3;
		ArrayList<Integer>myarr = new ArrayList<>();
		if(start <0) return null;
		else {
			crazy1(myarr, delta, start);
			return myarr;
		}
		
	}	
	
	
	
	//Q2
	public static int benNumber(int m, int n) {
		int answer = 0;
		ArrayList<Integer>myarr = new ArrayList<>();
		answer = sum(myarr, m, n);
		return answer;

	}
	public static int sum(ArrayList<Integer>myarr, int m, int n) {

		int sum = m;
			
		myarr.add(sum);
		int count = myarr.size();
		
		if(count ==n) {
			if(n%2==0) sum *= 2;
			else sum += 1;
		}
	
		if(count%2==1 && count<n) {
			sum +=1;
			return sum+sum(myarr,sum, n);
		}
	
		
		if(count%2==0 && count<n) {
			sum *=2;
			return sum+sum(myarr,sum, n);
		}
					
		return sum;
		
	}

}