package nonFactoryPattern;

public class EndUser {
    public static void main(String[] args) {

        // Sáng ngày 5/6
        // Tới hãng Honda để xem và đặt xe để lái thử
        // Đi đến địa chỉ Hãng: quận Tân Bình
        HondaHead hondaHead = new HondaHead();
        hondaHead.viewCar();
        hondaHead.bookCar();
        hondaHead.driveCar();

        // Chiều ngày 5/6
        // Tới hãng Ford để xem và đặt xe để lái thử
        // Đi đến địa chỉ Hãng: quận 3

        FordHead fordHead = new FordHead();
        fordHead.viewCar();
        fordHead.bookCar();
        fordHead.driveCar();

        // Sáng ngày 6/6
        // Tới Huyndai để xem và đặt xe để lái thử
        // Đi đến địa chỉ Hãng: quận 1
        HuyndaiHead huyndai = new HuyndaiHead();
        huyndai.viewCar();
        huyndai.bookCar();
        huyndai.driveCar();



    }
}
