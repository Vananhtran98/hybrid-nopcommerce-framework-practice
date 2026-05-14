package dynamicLocator;

import java.io.File;

public class SystemInformation {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");

        String projectPath = System.getProperty("user.dir");

        String separator = System.getProperty("file.separator");
        System.out.println(separator);

        String hoianImagePath = projectPath + File.separator + "uploadFiles" + File.separator + "Hoi An.jpg" + "\n";
        System.out.println(hoianImagePath);
        System.out.println(hoianImagePath.trim());

    }
}
