package np.com.madanpokharel.game.consoleui;

import java.util.Scanner;

public class InputBox {

    public static final String UTF_8 = "UTF-8";

    public static String readString(){
        return new Scanner(System.in, UTF_8).next();
    }

}
