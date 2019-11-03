package np.com.madanpokharel.game.consoleui;

public class MainMenu implements Menu {

    @Override
    public void showMenu(){
        System.out.print("L for left,");
        System.out.print("R for right,");
        System.out.print("U for up,");
        System.out.print("D for down,");
        System.out.print("F for fire,");
        System.out.println("E for exit");
    }

    @Override
    public UserAction getUserInput(){
        System.out.println("please enter");
        showMenu();
        String string = InputBox.readString();
        return UserAction.safeValueOf(string);
    }
}
