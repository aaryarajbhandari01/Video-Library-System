import java.util.Scanner;
import java.util.*;
import java.io.*;


public class Main {



  public static void main(String[] args) throws Exception{

    // instantiating VideoLibrary object
    VideoLibrary videoLibrary = new VideoLibrary();

    Scanner scan = new Scanner(System.in);
    boolean r = true;

        while (r) {



          // Display menu and handle user input
          videoLibrary.displayMenu();

          System.out.print("Enter your menu option: ");
          int option;

          try{
            option = scan.nextInt();
            scan.nextLine(); // consume newline

          } catch (InputMismatchException e) {
                System.out.println("Invalid Option! You must enter a valid option (1-6). \nPress Enter to try again.");
                scan.nextLine();
                scan.nextLine();
                continue; // Skip to the next iteration of the loop
          }


        // switch case menu
        switch(option){
          case 1: // adds a new video to the library
          System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
          System.out.println("You Selected : Add new video ");
          System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string

          videoLibrary.addVideo();
          scan.nextLine();

          break;

          case 2: // borrow video
          System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
          System.out.println("You Selected : Borrow a video ");
          System.out.println("-".repeat(60));
          videoLibrary.borrowVideo();
          scan.nextLine();
          break;

          case 3: // update video detail
          System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
          System.out.println("You Selected : Update a video ");
          System.out.println("-".repeat(60));
          videoLibrary.updateVideo();
          scan.nextLine();
          break;

          case 4: // deletes a video
          System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
          System.out.println("You Selected : Delete a video ");
          System.out.println("-".repeat(60));
          videoLibrary.deleteVideo();
          scan.nextLine();
          break;

          case 5: // search videos
          System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
          System.out.println("You Selected : Search a video ");
          System.out.println("-".repeat(60));
          videoLibrary.searchVideo();
          //scan.nextLine();
          break;

          case 6: //displays all available video
          System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
          System.out.println("You Selected : Show all available video ");
          videoLibrary.sortVideoLib();
          videoLibrary.viewAvailabeVideo();
          scan.nextLine();
          break;

          case 0: //save and exits the program
          videoLibrary.sortVideoLib();
          videoLibrary.saveToFile();
          r = false; // exists the loop
          break;

          default:
          System.out.println("Invalid Option! You must enter a valid option (1-6). \nPress Enter to try again.");
          scan.nextLine();


          break;


        }

        }
    }
}
