import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    private static ArrayList<String> myArrList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean done = false;
        String cmd = "";

        while (!done)
        {
            displayList();
            displayMenu();

            cmd = SafeInput.getRegExString(in, "Enter a command", "[AaDdIiPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd)
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    done = quit();
                    break;
            }
        }
    }

    private static void displayList()
    {
        System.out.println("\n----------------------------");
        System.out.println("Current List:");

        if (myArrList.size() == 0)
        {
            System.out.println("   (the list is empty)");
        }
        else
        {
            for (int i = 0; i < myArrList.size(); i++)
            {
                System.out.println("   " + (i + 1) + ": " + myArrList.get(i));
            }
        }
        System.out.println("----------------------------");
    }

    private static void displayMenu()
    {
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem()
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        myArrList.add(item);
    }

    private static void deleteItem()
    {
        if (myArrList.size() == 0)
        {
            System.out.println("The list is empty, nothing to delete.");
        }
        else
        {
            int num = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, myArrList.size());
            myArrList.remove(num - 1);
        }
    }

    private static void insertItem()
    {

        int num = SafeInput.getRangedInt(in, "Enter the location number to insert at", 1, myArrList.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        myArrList.add(num - 1, item);
    }

    private static void printList()
    {
        System.out.println("\nHere is your list:");

        if (myArrList.size() == 0)
        {
            System.out.println("   (the list is empty)");
        }
        else
        {
            for (int i = 0; i < myArrList.size(); i++)
            {
                System.out.println("   " + (i + 1) + ": " + myArrList.get(i));
            }
        }
    }

    private static boolean quit()
    {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
    }

}
