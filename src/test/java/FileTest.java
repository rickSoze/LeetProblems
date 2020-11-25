import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws Exception {
        File file = new File("C://tempFile//test.txt");


        FileOutputStream file1 = new FileOutputStream(file,true);

        String a ="asdasda3";

        file1.write(a.getBytes());

        file1.close();
    }
}
