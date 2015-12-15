package pl.edu.agh.two.console;

public interface GameConsole {

    default void display(String string){
        println(string);
    }

    void println(String string);
    String readLine();

}
