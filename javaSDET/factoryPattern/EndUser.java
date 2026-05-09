package factoryPattern;

public class EndUser {
    public static CarFactory carFactory;
    public static void main(String[] args) {
        // End User muốn xem và lái xe honda
        carFactory = getCar("Honda");
        carFactory.viewCar();
        carFactory.bookCar();
        carFactory.driveCar();

    }

    public static CarFactory getCar(String carName) {
        CarFactory carFactory = null;
        System.out.println(carName.toUpperCase());
        CarList carList = CarList.valueOf(carName.toUpperCase());
        switch (carList) {
            case HONDA:
                carFactory = new HondaHead();
                break;
            case HUYNDAI:
                carFactory = new HuyndaiHead();
                break;
            case FORD:
                carFactory = new FordHead();
                break;
            default:
                new RuntimeException("Car name is not valid.");
        }
        System.out.println(carFactory.toString());
        return carFactory;

    }
}
