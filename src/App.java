import java.util.*;

public class App {

    public static void clearScreen() { // Cuma bisa di IDE yang support
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        ArrayList<String> userNames = new ArrayList<String>();
        ArrayList<String> passwords = new ArrayList<String>();
        ArrayList<String> phones = new ArrayList<String>();
        
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice != 4) {
            System.out.println("1. Input Data");
            System.out.println("2. Show Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Exit");

            System.out.print("Your choice: ");
            userChoice = sc.nextInt();

            if (userChoice == 4) {
                System.out.println("Bye!");
                break;
            }

            switch (userChoice) {
                case 1:
                    System.out.print("Name : ");
                    String name = sc.next();
                    System.out.print("Pass : ");
                    String pass = sc.next();
                    System.out.print("Phone : ");
                    String phone = sc.next();

                    userNames.add(name);
                    passwords.add(pass);
                    phones.add(phone);

                    System.out.println("New data is added. Continue using enter key..");

                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();

                    break;
                case 2:
                    System.out.println("------------------------------------------------------");
                    System.out.println(String.format("|%-4s|%-15s|%-15s|%-15s|", "No.", "Name", "Pass", "Phone"));
                    System.out.println("------------------------------------------------------");

                    if (userNames.size() == 0) {
                        System.out.println(String.format("%-63s", "| No Data Exists |"));
                    }

                    for (int j = 0; j < userNames.size(); j++) {
                        System.out.println(String.format("|%-4d|%-15s|%-15s|%-15s|", (j + 1), userNames.get(j),
                                passwords.get(j), phones.get(j)));
                    }
                    System.out.println("------------------------------------------------------");

                    System.out.println("Continue using enter key..");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();

                    break;
                case 3:
                    System.out.println("------------------------------------------------------");
                    System.out.println(String.format("|%-4s|%-15s|%-15s|%-15s|", "No.", "Name", "Pass", "Phone"));
                    System.out.println("------------------------------------------------------");

                    if (userNames.size() == 0) {
                        System.out.println(String.format("%-63s", "| No Data Exists |"));
                    }

                    for (int j = 0; j < userNames.size(); j++) {
                        System.out.println(String.format("|%-4d|%-15s|%-15s|%-15s|", (j + 1), userNames.get(j),
                                passwords.get(j), phones.get(j)));
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.print("Input data number to be deleted: ");
                    int deletor = sc.nextInt();

                    if (deletor > userNames.size() || deletor < 1) {
                        System.out.println("Data not found.");
                        break;
                    }

                    userNames.remove(deletor - 1);
                    passwords.remove(deletor - 1);
                    phones.remove(deletor - 1);

                    System.out.println("Continue using enter key..");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();

                    break;
            }
        }
    }
}
