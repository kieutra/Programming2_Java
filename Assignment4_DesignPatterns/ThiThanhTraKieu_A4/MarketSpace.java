import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


//Thi Thanh Tra Kieu #261066512

public class MarketSpace {
	private List<Computer> cart;
	private Map<Integer, String> products;
	private static MarketSpace ms;	
	
//	initialize cart and products
	private MarketSpace() {
		cart = new CopyOnWriteArrayList<>();
		products = new ConcurrentHashMap<>();
	}
	
	public static synchronized MarketSpace getInstance() {
		if(ms == null)
			ms = new MarketSpace();
		return ms;	
	}
	
//	load Products from text file into Map
	public void loadProducts() {
		
		File file = new File("src/products.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[]strings;
		String product;
		int key = 1;
		try {
			while((product = br.readLine()) != null) {
				strings = product.split(",");
				product = key+ ": "+ strings[0]+" $" + strings[1];
				products.put(key, product);
				key++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
//	return products
	public Map<Integer, String> getProducts(){
		loadProducts();
		return products;
	}
	
//	return cart
	public List<Computer> getCartList(){
		return cart;
	}
	
//	add each order into cart
	public void addToCart(Computer c) {
		cart.add(c);
	}
	
//	sort the cart in descending order
	public void sort(int number) {
		if(number==3) {
			SortStrategy ss = new SortByOrderID();
			ss.sort(cart);		
		}else if(number==4) {
			SortStrategy ss = new SortByPrice();
			ss.sort(cart);
		}	
	}
}
