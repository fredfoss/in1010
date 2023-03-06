abstract class Vehicle {
    public String brand;
    
    public Vehicle(String brand) {
    	this.brand = brand;
    }
	
    public String getBrand() {
        return brand;
     }
}


class Car extends Vehicle {
    public int price;

    public Car(String brand, int price) {
        super(brand);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}



class Test {
    public static void main(String[] args) {
    	Car myFastCar = new Car("Mustand", 100);
    	System.out.println(myFastCar.getBrand());
        System.out.println(myFastCar.getPrice());
    }
}

// Oooo en test
