import java.util.Scanner;
//Thi Thanh Tra Kieu #261066512
public class Main {
	
	private static MarketSpace marketspace;
	private static Computer currentCompt;
	
	public static void main(String[] args) {
		
		marketspace = MarketSpace.getInstance();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi, what would you like to do?");
		System.out.println("1: Buy a computer");
		System.out.println("2: See my shopping cart");
		System.out.println("3: Sort by order ID (Descending order)");
		System.out.println("4: Sort by order price (Descending order)");
		System.out.println("5: Quit");
		
//		List of 5 choices to choose
		while(scanner.hasNextInt()) {
			
			int choice = scanner.nextInt();	
			if(choice==1) {
				Computer defaultCompt = new DefaultComputer();
				System.out.println();
				System.out.println("Current Build: "+  defaultCompt.getDescription() + ", and total price is "+ defaultCompt.getPrice());
				System.out.println("What component would you like to add?");
				for(int i = 1; i<=marketspace.getProducts().size(); i++) {
					System.out.println(marketspace.getProducts().get(i));
				}
				System.out.println("9: Done");
				currentCompt = defaultCompt; 
//				List of 8 products to choose
				while(scanner.hasNextInt() ) {
					int product = scanner.nextInt();
					
					if(product == 1) {
						currentCompt = new BenPicture(currentCompt);
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					} else if(product == 2) {
						currentCompt = new GPU(currentCompt);
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					}
					else if(product == 3) {
						currentCompt = new Keyboard(currentCompt);	
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					}
					else if(product == 4) {
						currentCompt = new Microphone(currentCompt);
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					}
					else if(product == 5) {
						currentCompt = new Monitor(currentCompt);
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					}
					else if(product == 6) {
						currentCompt = new Mouse(currentCompt);					
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					}
					else if(product == 7) {
						currentCompt = new Speaker(currentCompt);
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					}
					else if(product == 8) {
						currentCompt = new USB(currentCompt);
						System.out.println();
						System.out.println("Current Build: "+  currentCompt.getDescription() + ", and total price is "+ String.format("%.2f", currentCompt.getPrice()));
						System.out.println("What component would you like to add?");
						for(int i = 1; i<=marketspace.getProducts().size(); i++) {
							System.out.println(marketspace.getProducts().get(i));
						}
						System.out.println("9: Done");
					}
					else if(product == 9) {
						marketspace.addToCart(currentCompt);
						System.out.println();
						break;
					}
				}	
			}
			
//			Print the orders in the cart
			else if(choice ==2) {
				if(currentCompt ==null) {
					System.out.println();
					System.out.println("No items");
				}else {
					System.out.println();
					for(int i = 0; i<marketspace.getCartList().size(); i++) {
						System.out.println(marketspace.getCartList().get(i).toString());
					}
				}			
			}
			
//			Using SortByOrderID 
			else if (choice == 3) {
				if(currentCompt ==null) {
					System.out.println();
					System.out.println("No items");
				}else {
					marketspace.sort(choice);
					System.out.println();
				}				
			}
			
//			Using SortByPrice 
			else if (choice == 4) {
				if(currentCompt ==null) {
					System.out.println();
					System.out.println("No items");
				}else {
					marketspace.sort(choice);
					System.out.println();
				}			
			}
			
//			Exit
			else if(choice== 5) break;

			System.out.println("Hi, what would you like to do?");
			System.out.println("1: Buy a computer");
			System.out.println("2: See my shopping cart");
			System.out.println("3: Sort by order ID (Descending order)");
			System.out.println("4: Sort by order price (Descending order)");
			System.out.println("5: Quit");
		}
		scanner.close();
	}

}
