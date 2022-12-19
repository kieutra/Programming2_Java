import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

//Thi Thanh Tra KIEU - 261066512

public class Assignment2{
	static int cheese =10;
	static ArrayList<String>trappedMouse;
	static CopyOnWriteArrayList<String>mouseNames;
	static int sumCheeseLost;
	static synchronized void addCheese(int x) {
		cheese+=x;
	}
	static synchronized void removeCheese(int x) {
		cheese -=x;
	}
	static synchronized void addTrappedMouse(String s) {
		trappedMouse.add(s);
	}
	static synchronized void removeTrappedMouse(int index) {
		trappedMouse.remove(index);
	}
	
	public static void main(String[] args) {
		
		int mouses =5;
		int traps=3;
		Random r = new Random();
		
		System.out.println("[Status] Cheese left: "+cheese);
		System.out.println();
		
		trappedMouse = new ArrayList<>();
		
		mouseNames = new CopyOnWriteArrayList<>();
		for (int i = 0; i < mouses; i++) {
			mouseNames.add("mouse-" + (i + 1));
		}
		
		//Machine adds 10gr cheese into container every 2s
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(!Thread.interrupted()) {
					try {
						Thread.sleep(2000);						
							addCheese(10);
							System.out.println("[Action] Machine adds 10 grams of cheese");
							System.out.println("[Status] Cheese left: "+cheese);
							System.out.println();						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
			
		});
		t1.start();
		
		//Owner removes mouses from traps every 5s
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					try {
							Thread.sleep(5000);
							System.out.println("=====================================");
							while (trappedMouse.size() != 0) {
								for (int i = 0; i < trappedMouse.size(); i++) {
									System.out.println("[Action] Store owner removes " + trappedMouse.get(i));

									removeTrappedMouse(i);
								}
							}

							System.out.println("=====================================");
							if (mouseNames.size()==0) {
								t1.stop();
								System.out.println("Total cheese lost = " + sumCheeseLost);
								return;						
							}
						}

					 catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		t2.start();
		
		//Mouses are trapped or eat cheese every 1s
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {

					while (mouseNames.size() > 0) {
						try {
							Thread.sleep(1000);
							int random, mouseNumber;
							String previousMouseName = "";
							
							for (int i = 0; i < mouseNames.size(); i++) {
								 random = r.nextInt(2);
								 mouseNumber = r.nextInt(mouseNames.size());
								 
								
//								50% that a mouse gets caught by trap
								if (random == 1) {
									if (trappedMouse.size() < traps) {
										addTrappedMouse(mouseNames.get(mouseNumber));

										System.out.println(
												"[Action] " + mouseNames.get(mouseNumber) + " get caught by trap");
										System.out.println();

										mouseNames.remove(mouseNumber);
									}

								} else {
									
									if(!previousMouseName.equals(mouseNames.get(mouseNumber))) {
										int eatenCheese = 0;
										if (cheese == 0) {
											System.out.println(
													"[Action] " + mouseNames.get(mouseNumber) + " is waiting for cheese");
											System.out.println();
											break;
										}
										
										else if (cheese == 2)
											eatenCheese = r.nextInt(2)+1;
										else if (cheese == 1)
											eatenCheese = 1;
										else if (cheese >= 3)
											eatenCheese = r.nextInt(3)+1;

										System.out.println("[Action] " + mouseNames.get(mouseNumber) + " ate " + eatenCheese
												+ " grams of cheese");
										

										//calculate cheese left after being eaten by mouses
										removeCheese(eatenCheese);

										System.out.println("[Status] cheese left: " + cheese);
										System.out.println();

										

										previousMouseName = mouseNames.get(mouseNumber);
										
										sumCheeseLost += eatenCheese;
									}									
								}								
							}

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		t3.start();
	}
}
