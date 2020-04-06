import util.Input;

public class BackToMain {
    public static int navigateToMain() {

        Input input = new Input();

        System.out.println("\nGo back to main menu? [y/n]");
        if (!input.yesNo()) {
            return 0;
        }else {
            return 5;
        }
    }
}
