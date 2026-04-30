package phuongHoaXuan;

public class DinhBoLinh {
    // Có access modifier là Private thì chỉ được phe sử dụng trong Class chứa nó

    // private (chỉ cho phép trong class dùng, bên ngoài ko truy cập được)
    private String espresso;


    // Method/ Function
    private String getEspresso() {
        return espresso;
    }

    // Default (Chỉ cho phép các class trong cùng package truy cập được)
    String capuchino;

    String getCapuchino() {
        return capuchino;
    }

    // Protected (Chỉ cho phép kế thừa mới sử dụng được)
    protected String cherry;

    protected String getCherry() {
        return cherry;
    }

    public String catimor;

    public String getCatimor() {
        return catimor;
    }

    public static String monokai;

    public static String getMonokai() {
        return monokai;
    }

    public static void main(String[] args) {
        // Hàm là static ko thể gọi trực tiếp đến 1 biến/ hàm non-static khác được
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.espresso = "Espresso";
        System.out.println(dinhBoLinh.getEspresso());

        dinhBoLinh.capuchino = "Capuchino";
        System.out.println(dinhBoLinh.getCapuchino());

        dinhBoLinh.cherry = "Cherry";
        System.out.println(dinhBoLinh.getCherry());

        dinhBoLinh.catimor = "Catimor";
        System.out.println(dinhBoLinh.getCatimor());

        // catimor = "AZ Cafe";
        monokai = "";

        getMonokai();

    }

}
