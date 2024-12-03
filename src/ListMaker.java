import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> myArrList = new ArrayList<>(); // note the diamond notation on the type parameter <> so you don’t have to repeat the type
        String menuInput = "";
        String input = "";
        int location = 0;
        boolean done = false;
        do {
            menuInput = SafeInput.getRegExString(in, "A – Add an item to the list | D – Delete an item from the list | I – Insert an item into the list | V – View the list | Q – Quit the program \n", "[AaDdIiVvQq]");
            if (menuInput.equalsIgnoreCase("A")){
                input = SafeInput.getNonZeroLenString(in, "Enter what you want to add to the list");
                myArrList.add(input);
            }
            if (menuInput.equalsIgnoreCase("D")) {
                for (int i = 0; i < myArrList.size(); i++) {
                    System.out.print(i + ": " + myArrList.get(i) + ", ");
                }
                System.out.println();
                    location = SafeInput.getRangedInt(in, "Enter the number of the item you wish to delete", 0,myArrList.size()-1);
                    myArrList.remove(location);
                }
            if (menuInput.equalsIgnoreCase("I")){
                for (int i = 0; i < myArrList.size(); i++) {
                    System.out.print(i + ": " + myArrList.get(i) + ", ");
                }
                System.out.println();
                    location = SafeInput.getRangedInt(in, "Where would you like to insert?",0,myArrList.size()-1);
                    input = SafeInput.getNonZeroLenString(in, "Enter what you want to insert");
                    myArrList.add(location, input);

            }
            if (menuInput.equalsIgnoreCase("V")){
                System.out.println(myArrList);
            }

            if (menuInput.equalsIgnoreCase("Q")) {
                done = SafeInput.getYNConfirm(in, "Are you sure you want to quit the program?");
            }
        } while (!done);


    }


}
