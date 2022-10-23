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

// part 1 of lab: adding a function to print the difference of two dates
public static void dateDifference(LocalDate first, LocalDate second){

long difference = Math.abs(ChronoUnit.DAYS.between(first, second));
System.out.println(difference  +" days in between " + first +" and " + second);

}

}