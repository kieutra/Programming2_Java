//Thi Thanh Tra Kieu #261066512
interface Computer{
	String getDescription();
	double getPrice();
	String getOrderID();	
}

//Default Computer
class DefaultComputer implements Computer{
	private int id=0;
	private static int count = 0;
	private static int arr[];
	public DefaultComputer(){		
		arr = new int[100];
		for(int i = 0; i<100; i++) {
			arr[i] = i+1;
		}
		for(int i = 0; i<100; i++) {
			int j = (int) Math.floor(Math.random()*(i+1));
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		id=arr[count++];
	}
	@Override
	public String getDescription() {
		return "Default Computer";
	}

	@Override
	public double getPrice() {
		return 700.0;
	}

	@Override
	public String getOrderID() {
		return "OrderID@" + id;
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

// ComputerDecorator
class ComputerDecorator implements Computer {
	Computer currentCompt;
	
	public ComputerDecorator(Computer c){
		currentCompt = c;
	}
	@Override
	public String getDescription() {
		return currentCompt.getDescription();
	}

	@Override
	public double getPrice() {
		return currentCompt.getPrice();
	}

	@Override
	public String getOrderID() {
		return currentCompt.getOrderID();
	}
}

// Ben's Picture
class BenPicture extends ComputerDecorator{

	public BenPicture(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " + Ben's Picture";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 4000.0;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

//GPU 3080 Ti
class GPU extends ComputerDecorator{

	public GPU(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " + GPU 3080 Ti";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 1949.86;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

//Keyboard
class Keyboard extends ComputerDecorator{

	public Keyboard(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " + Keyboard";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 89.99;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

//Microphone
class Microphone extends ComputerDecorator{

	public Microphone(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " + Microphone";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 231.18;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

//Monitor
class Monitor extends ComputerDecorator{

	public Monitor(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " + Monitor";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 325.2;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

//Mouse
class Mouse extends ComputerDecorator{

	public Mouse(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription()+ " + Mouse";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 38.99;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

//Speaker
class Speaker extends ComputerDecorator{

	public Speaker(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " + Speaker";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 109.31;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}

//USB
class USB extends ComputerDecorator{

	public USB(Computer c) {
		super(c);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + " + USB HD camera";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 205.49;
	}

	@Override
	public String getOrderID() {
		return super.getOrderID();
	}	
	@Override
	public String toString() {
		return getOrderID()+": "+getDescription()+ " "+String.format("%.2f", getPrice());
	}
}