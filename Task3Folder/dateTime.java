import java.util.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;
import java.time.Period;
import  java.time.temporal.ChronoUnit;

class TimeLeft{
public static void main(String[] args){

 LocalDate current = LocalDate.now();

 LocalDate[] labDates = new LocalDate[]{LocalDate.of(2022, 9, 28),LocalDate.of(2022, 10, 26),LocalDate.of(2022, 11, 23),LocalDate.of(2022, 12, 7) };

int count=1;
for(int i=0; i<labDates.length;i++){
long difference = ChronoUnit.DAYS.between(current, labDates[i]) + 1;
System.out.println("lab " + count++ + " is due in " + difference  +" days");

}

}


public static void dateDifference(LocalDate first, LocalDate second){

long difference = Math.abs(ChronoUnit.DAYS.between(first, second));
System.out.println(difference  +" days in between " + first +" and " + second);

}

}