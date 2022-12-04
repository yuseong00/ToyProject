package smartstore.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    public static Scanner scanner;

    public Menu() {
    }

    public static int dispMainMenu() throws InputMismatchException {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. 분류설정");
        System.out.println(" 2. 고객데이터" + "");
        System.out.println(" 3. 요약");
        System.out.println(" 4. 끝");
        System.out.println("==============================");
        System.out.print("선택: ");
        return scanner.nextInt();
    }

    static {
        scanner = new Scanner(System.in);
    }
}
