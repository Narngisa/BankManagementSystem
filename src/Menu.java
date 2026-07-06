import java.util.Scanner;

public class Menu {
    public void App() {

        Scanner input = new Scanner(System.in);

        System.out.println("----- Banking System -----");
        System.out.println("1. Sign in");
        System.out.println("2. Login");
        System.out.println("4. Exit");

        byte chioce = input.nextByte();

        switch(chioce) {
            case 1:
                System.out.println("Create");
            case 2:
                System.out.println("Login");
            case 3:
                break;
        }

        input.close();
    }
}
