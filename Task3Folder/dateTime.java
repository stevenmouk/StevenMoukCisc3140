import java.util.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;
import java.time.Period;
import  java.time.temporal.ChronoUnit;


class TimeLeft{
public static void main(String[] args){


 
 LocalDate[] labDates = new LocalDate[]{LocalDate.of(2022, 9, 28),LocalDate.of(2022, 10, 26),LocalDate.of(2022, 11, 23),LocalDate.of(2022, 12, 7) };
 LocalDate[] quizDates = new LocalDate[]{LocalDate.of(2022, 9, 14),LocalDate.of(2022, 9, 28),LocalDate.of(2022, 10, 26),LocalDate.of(2022, 11, 16), LocalDate.of(2022, 12, 7) };
 LocalDate[] finalDate = new LocalDate[]{LocalDate.of(2022, 12, 19)};

Scanner scanner = new Scanner(System.in); 

System.out.println("Choose between assignment, quiz, final, or custom: ");
String choice = scanner.nextLine(); 

if(choice.equals("assignment")){
timeUntil(labDates, "lab");

}else if(choice.equals("quiz")){
timeUntil(quizDates, "quiz");

}else if (choice.equals("final")){

timeUntil(finalDate, "final");

}else if( choice.equals("custom")){



LocalDate date1 = dateSelector("first");
System.out.print(date1);






// System.out.println("Enter first date in MM/DD/YYYY or MM-DD format");
// String secondChoice = scanner.nextLine(); 


}

}

public static void timeUntil(LocalDate[] dates, String item){
LocalDate current = LocalDate.now();
int count=1;
for(int i=0; i<dates.length;i++){
long difference = ChronoUnit.DAYS.between(current, dates[i]) + 1;

if(item.equals("final")){
System.out.println(item +" is due in " + difference  +" days");

}else{
System.out.println(item + count++ + " is due in " + difference  +" days");
}
}

}

public static LocalDate dateSelector(String dateOrder){

    Scanner scanner2 = new Scanner(System.in); 

System.out.println("Enter "+ dateOrder + "date in MM/DD/YYYY or MM-DD format");
String dateChoice = scanner2.nextLine(); 

LocalDate date = LocalDate.now();

while(!(dateChoice.matches(".*.*/.*.*/.*.*.*.*") && dateChoice.length()==10) && !(dateChoice.matches(".*.*-.*.*") && dateChoice.length()==5)){

    System.out.println("Incorrect Format, try again");
    dateChoice = scanner2.nextLine(); 

}

if(dateChoice.matches(".*.*/.*.*/.*.*.*.*") && dateChoice.length()==10){

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
 date = LocalDate.parse(dateChoice, formatter);

}
else if(dateChoice.matches(".*.*-.*.*") && dateChoice.length()==5){
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
     dateChoice = dateChoice+"-"+date.getYear();
     
 LocalDate newdate = LocalDate.parse(dateChoice, formatter);

if(newdate.isBefore(date)){
    newdate = newdate.plusYears(1);
  
}
    date = newdate;


}
return date;
}

// part 1 of lab: adding a function to print the difference of two dates
public static void dateDifference(LocalDate first, LocalDate second){

long difference = Math.abs(ChronoUnit.DAYS.between(first, second));
System.out.println(difference  +" days in between " + first +" and " + second);

}

}