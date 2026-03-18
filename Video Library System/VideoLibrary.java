
//managing video records and implementing various
//functionalities like adding, borrowing, modifying,
//and deleting videos

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class VideoLibrary {

    // declaring array list for Movie object
    ArrayList<Video> videos;
    Scanner scan= new Scanner(System.in);
    // filename for input and output
    String file ="videoLibrary.txt";
    String outputFile="videolibraryAdded.txt";


    // Constructor to initialise videos in arraylist
    public VideoLibrary(){
        videos = new ArrayList<>();
        scanFile();
    }


    // public ArrayList<Video>  getVideos(){
    //   return videos;
    // }

    // reads and adds video records from input file
    public void scanFile(){
      try {
        Scanner scanfileIn = new Scanner(new File(file));

        while (scanfileIn.hasNext())
        {
          int vId = scanfileIn.nextInt();

            if(!scanfileIn.hasNextLine())
      	    {
      	       System.out.println("\n!! Incomplete record for Item " );
      	       break;
      	    }

            //ideally, scan.hasNextDouble() should be first checked here again
            String videoTitle = scanfileIn.nextLine();

          //  String line = scanfileIn.next(vId,videoTitle);
            Video item = new Video(vId, videoTitle.trim());
            videos.add(item);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Please make sure the file is actually there.");
    }

    }

    // method to save to file
    public void saveToFile() throws Exception
    {
      // write the videos list to the output file
      PrintWriter output = new PrintWriter(new FileWriter(outputFile));
      System.out.print("\n** Saving all to the output file " + outputFile + " ... ");
      int i = 0;
      while(i < videos.size())
      {
        output.print((i+1)+ " ");
        output.println(videos.get(i));
        i++;
      }
      System.out.println("\nOutput file has been saved successfully!");
      System.out.println();
      output.close();

    }

    // method to display the main menu
    public void displayMenu()
    {

        // Displaying menu
        System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
        System.out.println("\n\t\t Video Library System \n");
        System.out.println("\t Welcome to Library Management System \n \n");
        System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
        System.out.println("\t\t\t Main Menu");
        System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
        System.out.println("Enter 1: To Add new video.");
        System.out.println("Enter 2: To Borrow a video.");
        System.out.println("Enter 3: To Update a video.");
        System.out.println("Enter 4: To Delete a video.");
        System.out.println("Enter 5: To Search a video.");
        System.out.println("Enter 6: To Show all available video.");
        System.out.println("Enter 0: To Exit.");
        System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string


}



   // add new videos to the library
   public void addVideo(){

      int vId;

      while (true){
        try{
          System.out.print("Enter Video ID: ");
          vId = scan.nextInt();
          scan.nextLine(); // Consume newline character

          while (vId <=0)
          {
            System.out.print("Video ID cannot be negative. Please enter again: ");
            vId = scan.nextInt();
            scan.nextLine(); //consumer each enter
          }

          // Check for duplicate video ID
          for (int i = 0; i < videos.size(); i++){
            Video v = videos.get(i);
            if (v.getVId() == vId){
              System.out.print("\nDuplicate video ID!\nPress press enter to go back to main menu, and try again.");
             // exits the method if duplicate video is found
             return;
            }
          }



          break;

        } // end of try
          catch (InputMismatchException e) {
                System.out.println("You must enter whole numbers only. No decimals, words, or other info. Try again.");
                scan.nextLine();
            }// end of catch

          }
         System.out.print("Enter Video Title: ");
         String videoTitle = scan.nextLine();
         while (videoTitle.isEmpty()) {
            System.out.println("Invalid input. Title cannot be empty. Please enter a valid video title.");
            videoTitle = scan.nextLine();
          }



       // creating a new video object
      Video video = new Video(vId, videoTitle);
      videos.add(video);


      // success message
      System.out.println("\nVideo has been added successfully!\n\nPlease press enter to go back to the main menu.");
      System.out.println();
   }


   // update video

   public void updateVideo()
    {
      String newVideoTitle;
      int newId;

      try {
         System.out.print("Enter the ID of the video to update: ");
         int vId = scan.nextInt();
         scan.nextLine();

         for (int i = 0; i < videos.size(); i++)
         {
            Video v = videos.get(i);

            if (v.getVId() == vId)
            {
              // dealing with checking availability - returning borrowed video
              if (v.isAvailable() == false) {
                System.out.println("Video with ID " + vId + " is on loan. It cannot be updated right now.");
                System.out.print("Return the video with ID " + vId + " now? \nPress '1' to return the video to library, '0' to go back to main menu: ");
                int answer = scan.nextInt();
                //scan.nextLine();
                if (answer == 0) {
                   return; }
                if (answer == 1) {
                  v.setAvailable(true);
                  System.out.println("Video with ID " + vId + " has been returned.");
                  return; }
              } else {
                System.out.print("Enter New Video ID: ");
                newId = scan.nextInt();
                scan.nextLine();
                for (int x = 0; x < videos.size(); x++) {
                  Video v2 = videos.get(x);
                  // Ensure current video cannot be overwitten & no duplicate ID
                  if (v2.getVId() == newId) {
                  System.out.print("Existing video ID cannot be overwritten. Assign a new ID.");
                  return;
                  }
                } //end of for loop finding newId duplicate
                 v.setVideoId(newId);
                 System.out.println("Video ID updated! - " + newId + " " + v.getVideoTitle());
              }  // end of else

                  System.out.print("Enter New Video Title: ");
                  newVideoTitle = scan.nextLine();
                  while (newVideoTitle.isEmpty())
                  {
                     System.out.print("\nInvalid input. Title cannot be empty.\nPlease enter a valid video title:");
                     newVideoTitle = scan.nextLine();
                   }

                  v.setVideoTitle(newVideoTitle);
                  System.out.println("\nVideo updated successfully!\n\nPlease press enter to go back to the main menu");
                  return;
            }
          } // end of outer for loop

        System.out.println("\nVideo with ID " + vId +" does not exist.");
      }   // end of try
      catch (InputMismatchException e) {
            System.out.println("\nYou must enter whole numbers only!\nPlease go back to main menu and try again.");
            scan.nextLine();
        }// end of catch

      }

  //  public void updateVideo(){
  //    try {
  //
  //    System.out.print("Enter the ID of the video to update: ");
  //    int vId = scan.nextInt();
  //    scan.nextLine();
  //
  //    for (int i = 0; i < videos.size(); i++) {
  //       Video v = videos.get(i);
  //       if (v.getVId() == vId) {
  //             System.out.print("Enter New Video ID: ");
  //             int newId = scan.nextInt();
  //             scan.nextLine();
  //
  //             System.out.print("Enter New Video Title: ");
  //             String newVideoTitle = scan.nextLine();
  //             while (newVideoTitle.isEmpty())
  //             {
  //                System.out.print("\nInvalid input. Title cannot be empty.\nPlease enter a valid video title:");
  //                newVideoTitle = scan.nextLine();
  //            }
  //
  //             v.setVideoId(newId);
  //             v.setVideoTitle(newVideoTitle);
  //             System.out.println("\nVideo updated successfully!\n\nPlease press enter to go back to the main menu");
  //             return;
  //       }
  //   }
  //
  //   System.out.println("\nVideo with ID " + vId +" does not exist.");
  // }
  // catch (InputMismatchException e) {
  //       System.out.println("\nYou must enter whole numbers only!\nPlease go back to main menu and try again.");
  //       scan.nextLine();
  //   }// end of catch
  //  }

   // removes a video from the library
   public void deleteVideo()
   {
  try{
    System.out.print("Enter the video ID you wish to delete: ");
    int vId = scan.nextInt();
    scan.nextLine(); // Consume newline character

      for (int i = 0; i < videos.size(); i++)
      {
        Video v = videos.get(i);
        if (v.getVId() == vId)
        {
          int currentIdx = videos.indexOf(v);
          System.out.print("\nVideo with ID " + vId +" is going to be deleted. Proceeding..");
          scan.nextLine();

          videos.remove(currentIdx);
          System.out.println("\nVideo has been deleted!\n\nPlease press enter to go back to the main menu");
          return;
        }
      }

        System.out.print("\nVideo with ID " + vId +" does not exist.\nPlease press enter to go back to main menu :");
      } // end of try
      catch (InputMismatchException e) {
             System.out.println("\nYou must enter whole numbers only.\nPlease go back to main menu and try again.");
            scan.nextLine();
        }// end of catch

}

//    public void deleteVideo(){
//      try{
//             System.out.print("Enter Movie ID to delete: ");
//             int vId = scan.nextInt();
//
//              while (vId <0)
//              {
//                System.out.print("Video ID cannot be negative. Please enter again: ");
//                vId = scan.nextInt();
//                scan.nextLine(); //consumer each enter
//              }
//
//              for (int i = 0; i < videos.size(); i++){
//                 Video video = videos.get(i);
//                 if (video.getVId() == vId) {
//                      videos.remove(video);
//                      System.out.println("\nVideo has been deleted!");
//                      System.out.print("\nPlease press enter to go back to main menu :");
//                      return;
//                  }
//
//              }
// System.out.print("Video not found!\nPlease press enter to go back to main menu :");
//
//
//            } // end of try
//              catch (InputMismatchException e) {
//                    System.out.println("\nYou must enter whole numbers only.\nPlease go back to main menu and try again.");
//                    scan.nextLine();
//
//                }// end of catch
//    }

   // displays available video list
   public void viewAvailabeVideo(){
     System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
     System.out.println("\n\t\t List of Available Videos\n");
     System.out.println("-".repeat(60));
     System.out.println("Video ID\t|\t Video Title");
     System.out.println("-".repeat(60));
     int count = 0;
     for (int i=0; i< videos.size(); i++){
         Video v = videos.get(i);
         if (v.isAvailable()){
           System.out.print(v);
           count = count + 1;
         }
     }
     System.out.println("-".repeat(60));
     System.out.println("Total Available Videos : " + count);
     System.out.println("-".repeat(60));



   }

   // searches for a video by ID and displayes a submenu
   public void searchVideo(){
     try{
     System.out.print("Enter ID of the video you want to search: ");
     int searchVId = scan.nextInt();
     scan.nextLine();

     int currentIndex = -1;

     for (int i = 0; i < videos.size(); i++) {
        Video v = videos.get(i);
        if (v.getVId() == searchVId) {
            currentIndex = i;
            break;
        }
    }

    if (currentIndex == -1) // array out of index
     {
        System.out.println("\nVideo not found.\nPress enter to go back to the main menu.");
        scan.nextLine();
        return;
    }

      subMenu(currentIndex);

    }catch (InputMismatchException e) {
            System.out.println("\nYou must enter whole numbers only.\nPlease enter to go back to main menu.");
            scan.nextLine();
            scan.nextLine();

        }// end of catch

   }

   // sub menu to navigate through video in the list and displays current video detail
   public void subMenu(int currentIndex){
     boolean a = true;
     while(a){
       System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
       System.out.println("\n\t\t Video Library System \n");
       System.out.println("\t Welcome to Library Management System \n \n");
       System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
       System.out.println("\t\tCurrent Video Detail ");
       displayVideoDetail(currentIndex);
       System.out.println("1. Next Video");
       System.out.println("2. Previous Video");
       System.out.println("3. Go to Back");
       System.out.println();


       System.out.print("Enter your choice:");
       int subMenuOption;

       try{
         subMenuOption = scan.nextInt();
         scan.nextLine(); // consume newline

       } catch (InputMismatchException e) {
             System.out.print("\nInvalid option! You must enter a valid option (1-3).\nPress Enter to try again.");
             scan.nextLine();
             scan.nextLine();
             continue; // Skip to the next iteration of the loop
       }

        switch (subMenuOption) {
            case 1:
            if (currentIndex < videos.size() - 1) {
                currentIndex++;
            } else {
              System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
                System.out.println("\t!!!You have reached the end of the list!!!");

            }
                break;
            case 2:
              if (currentIndex > 0) {
                  currentIndex--;
              } else {


                  System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
                  System.out.println("\t!!!You are at the beginning of the list!!!");

              }


              break;
            case 3:
                a = false;
                break;
            default:
                System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
                System.out.println("\t!!!Invalid choice. Please try again.!!!");
        }
     }
   }

   // displays details of a specific video.
   public void displayVideoDetail(int i){
     // for (int i=0; i< videos.size(); i++){
         Video v = videos.get(i);
         System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
         System.out.println("Video ID: " +"\t|\t" + v.getVId());
         System.out.println("Video Title:" +"\t|\t" + v.getVideoTitle());
         System.out.println("Availability: " +"\t|\t"+ (v.isAvailable() ? "Available" : "Not Available") );
         System.out.println("Borrower No.: " +"\t|\t" + v.getBorrowerNumber());
         System.out.println("Borrower Name.: " +"|\t" + v.getBorrowerName());
         System.out.println("-".repeat(60)); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string

     // }
   }

   // borrow a video and updates borrower detail and video availibility
   public void borrowVideo() {
      int vId;

      while(true){
        try{
          System.out.print("Enter video ID to borrow: ");
          vId = scan.nextInt();
          scan.nextLine();
          break;
        }
        catch (InputMismatchException e)
        {
          System.out.println("You must enter whole numbers only!\nNo decimals, words, or other info. Try again.\n");
          scan.nextLine(); // Clear the invalid input
        }
      }



        for (Video video : videos) {
            if (video.getVId() == vId) {
                if (video.isAvailable()) {
                    //System.out.println("Enter borrower number:");
                    int borrowerNumber;
                    // = scan.nextInt();

                    while(true){
                      try{
                        System.out.print("Enter borrower number: ");
                        borrowerNumber = scan.nextInt();
                        scan.nextLine();
                        break;
                      }
                      catch (InputMismatchException e)
                      {
                        System.out.println("You must enter whole numbers only.\nNo decimals, words, or other info. Try again.\n");
                        scan.nextLine(); // Clear the invalid input
                      }
                    }


                    // enter borrower name
                    System.out.print("Enter borrower name: ");
                    String borrowerName = scan.nextLine();
                    while (borrowerName.isEmpty()) {
                       System.out.print("Invalid input! Name cannot be empty. \nPlease Try Again: ");
                       borrowerName = scan.nextLine();
                     }
                    video.setAvailable(false);
                    video.setBorrowerNumber(borrowerNumber);
                    video.setBorrowerName(borrowerName);

                    System.out.println("\nVideo borrowed successfully.\n\nPlease press enter to go back to the main menu");
                } else {
                    System.out.println("\nVideo is currently not available for borrowing.");
                }
                return;
            }
        }
        System.out.println("Video not found.");

    }



    public void sortVideoLib() {
           Collections.sort(videos);
         }







}
