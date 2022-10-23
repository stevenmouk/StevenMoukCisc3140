import java.util.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;
import java.time.Period;
import  java.time.temporal.ChronoUnit;


class TimeLeft{
    public static void main(String[] args){

    // gets the current date and saves it in current    
    LocalDate current = LocalDate.now();

    //constants of the lab dates, quiz dates, and final exam date
    LocalDate[] labDates = new LocalDate[]{LocalDate.of(2022, 9, 28),LocalDate.of(2022, 10, 26),LocalDate.of(2022, 11, 23),LocalDate.of(2022, 12, 7) };
    LocalDate[] quizDates = new LocalDate[]{LocalDate.of(2022, 9, 14),LocalDate.of(2022, 9, 28),LocalDate.of(2022, 10, 26),LocalDate.of(2022, 11, 16), LocalDate.of(2022, 12, 7) };
    LocalDate[] finalDate = new LocalDate[]{LocalDate.of(2022, 12, 19)};

    
    Scanner scanner = new Scanner(System.in); 

    //while loop to collect inputs until no input given
    while(true){
        System.out.println("Choose between assignment, quiz, final, custom, changeDate, or resetDate : ");
       
       //saves user choice of what option they want to select
        String choice = scanner.nextLine(); 

        // if their choice is assignment, timeUntil method is called with labdates as the inputs and the current date.
        if(choice.equals("assignment")){
            timeUntil(labDates, "lab",current);

        // if their choice is quiz, quiz dates are passed in timeUntil method with the current date.
        }else if(choice.equals("quiz")){
            timeUntil(quizDates, "quiz", current);

        // if their choice is final, final date is passed in timeUntil method with current date.
        }else if (choice.equals("final")){

            timeUntil(finalDate, "final", current);

        // if their choice is custom, the dateSelector method is called to make sure date is in proper form.
        //Then the dateDifference method is called to find difference between first and second date.
        }else if( choice.equals("custom")){

            LocalDate firstDate = dateSelector("first");
            LocalDate secondDate = dateSelector("second");

            dateDifference(firstDate, secondDate);

        // if their choice is changeDate, the dateSelector method is called and current date is set to the new input.
        }else if(choice.equals("changeDate")){
            //collects new date and sets current to the new date.
            current = dateSelector("new");
            
        // if their choice is resetDate, current date is returned back to the current date.
        }else if(choice.equals("resetDate")){
            current = LocalDate.now();

         // if their choice is no input, the while program ends.    
        }else if(choice.isEmpty()){
            break;

        }

    }

}

    // This method find the time until dates entered in the dates input. 
    public static void timeUntil(LocalDate[] dates, String item, LocalDate current){

       
        int count=1;

        // runs a for loop over the dates array. 
        for(int i=0; i<dates.length;i++){

            //finds the difference between current and dates[i]. Adds 1 to include the last day as well.
            long difference = ChronoUnit.DAYS.between(current, dates[i]) + 1;

            // only for the final item, does not include count as only 1 final is present in our class.
            if(item.equals("final")){
                System.out.println(item +" is due in " + difference  +" days");

            // else prints item number and the difference found. 
            }else{
                System.out.println(item + count++ + " is due in " + difference  +" days");
            }
        }

    }

    // This method is used to collect dates and make sure they are in the correct form.
    public static LocalDate dateSelector(String dateOrder){

        Scanner scanner2 = new Scanner(System.in); 

        System.out.println("Enter "+ dateOrder + " date in MM/DD/YYYY or MM-DD format");
        //collects user input of date.
        String dateChoice = scanner2.nextLine(); 

        //gets current date.
        LocalDate date = LocalDate.now();

            //runs a while loop as long as the user input is in the incorrect format.
            while(!(dateChoice.matches(".*.*/.*.*/.*.*.*.*") && dateChoice.length()==10) && !(dateChoice.matches(".*.*-.*.*") && dateChoice.length()==5)){

            System.out.println("Incorrect Format, try again");
            dateChoice = scanner2.nextLine(); 

            }

            // if format is correct and has year, date is set to the parsed date.
            if(dateChoice.matches(".*.*/.*.*/.*.*.*.*") && dateChoice.length()==10){

                //uses date fromatter and parser to set the date.
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
                date = LocalDate.parse(dateChoice, formatter);

            // if no year is present but form is correct, this part is called to add a year.
            }else if(dateChoice.matches(".*.*-.*.*") && dateChoice.length()==5){

                
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
                 //adds the current year to the user input.
                 dateChoice = dateChoice+"-"+date.getYear();
     
                // sets newdate with the current year.
                LocalDate newdate = LocalDate.parse(dateChoice, formatter);

                // if newdate has passed, increments the year by 1 so it is the next upcoming date is the one this year passed.
                if(newdate.isBefore(date)){
                    newdate = newdate.plusYears(1);
  
                }
                //sets date to newdate.
             date = newdate;


            }
        return date;
    }

// part 1 of lab: adding a function to print the difference of two dates
    public static void dateDifference(LocalDate first, LocalDate second){

        // finds the absolute value of the day difference between the two dates
        long difference = Math.abs(ChronoUnit.DAYS.between(first, second));
        //prints out the difference
        System.out.println(difference  +" days in between " + first +" and " + second);

    }

}