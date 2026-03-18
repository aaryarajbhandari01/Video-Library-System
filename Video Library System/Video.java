import java.util.*;

// class Video
public class Video implements Comparable<Video>{
  // declaring instance variable
  private int vId;
  private String videoTitle;
  private boolean isAvailable = true;
  private int borrowerNumber;
  private String borrowerName;




  // constructor
  public Video(int vId, String videoTitle){
    this.vId = vId;
    this.videoTitle = videoTitle;
    // this.isAvailable = isAvailable;
  }

  //getter method to return value of instance variable vId
  public int getVId(){
    return vId;
  }

  //getter method to return value of videoTitle
  public String getVideoTitle(){
    return videoTitle;
  }


  // returns whether the video is available for borrowing.
  public boolean isAvailable(){
    return isAvailable;
  }

  // Returns the number of the borrower.
  public int getBorrowerNumber() {
        return borrowerNumber;
    }

  // returns the name of the borrower.
  public String getBorrowerName() {
        return borrowerName;
    }


  //setter method to assign value to instance variable vId
  public void setVideoId(int vId){
    this.vId = vId;
  }

  //setter method to assign value to videoTitle
  public void setVideoTitle(String videoTitle){
    this.videoTitle = videoTitle;
  }

  //setter method to set whether the video is available for borrowing.
  public void setAvailable(boolean isAvailable){
    this.isAvailable = isAvailable;

  }

  // sets the ID of the borrower
  public void setBorrowerNumber(int borrowerNumber) {
        this.borrowerNumber = borrowerNumber;
    }

  // sets the name of the borrower.
  public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

  // string representation of movie information
  public String toString(){
    // return " Video Id: " + vId + "\t" + " Video Title: " + videoTitle + "\n" ;
    return vId + "\t\t|\t " + videoTitle + "\n" ;

  }

  // Sort videos list in ID ascending order by implementing Comparable
  // Overridding compareTo
  public int compareTo (Video other) {
    int otherVId = ((Video)other).getVId();
    // ascending order
    return this.vId - otherVId;
}

}
