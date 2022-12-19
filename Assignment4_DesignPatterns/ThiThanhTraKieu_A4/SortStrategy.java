import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Thi Thanh Tra Kieu #261066512

  interface SortStrategy {
	public void sort(List<Computer>cart);
  }

// sort cart in descending order by orderID
 class SortByOrderID implements SortStrategy{

	@Override
	public void sort(List<Computer> cart) {
		Collections.sort(cart, new Comparator<Computer>() {
			@Override
			public int compare(Computer o1, Computer o2) {
				int idO1 = Integer.parseInt(o1.getOrderID().split("@")[1]);
				int idO2 = Integer.parseInt(o2.getOrderID().split("@")[1]);
				return idO2 - idO1;
			}		
		});
	} 
 }
 
// sort cart in descending order by total price of order
 class SortByPrice implements SortStrategy{

	@Override
	public void sort(List<Computer> cart) {
		Collections.sort(cart, new Comparator<Computer>() {

			@Override
			public int compare(Computer o1, Computer o2) {
				double delta = o1.getPrice() - o2.getPrice();
				if (delta > 0) return -1;
				if (delta < 0) return 1;
				return 0;
			}		
		});
	}	 
 }
