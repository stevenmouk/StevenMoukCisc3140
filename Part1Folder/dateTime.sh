# !/bin/bash


current=$(date +%s)

labDates=( "2022-09-28" "2022-10-26" "2022-11-23" "2022-12-07" )
quizDates=('2022-09-14' '2022-09-28' '2022-10-26' '2022-11-16' '2022-12-7')
finalDate=('2022-12-19')




count=0

echo Choose between assignment, quiz, or final:

read choice




if [[ "$choice" == "assignment" ]]; then



    for i in "${labDates[@]}"
    do
   
     echo lab $count is due in $(( ($(date -d $i '+%s') - $current )/(60*60*24) )) days
    ((count=count+1))
   
    done
   

       
elif [[ "$choice" == "quiz" ]]; then

        for i in "${quizDates[@]}"
    do
   
     echo quiz $count is due in $(( ($(date -d $i '+%s') - $current )/(60*60*24) )) days
    ((count=count+1))
   
    done
   
elif [[ "$choice" == "final" ]]; then
        for i in "${finalDate[@]}"
    do
   
     echo final is due in $(( ($(date -d $i '+%s') - $current )/(60*60*24) )) days
    ((count=count+1))
   
    done
   
fi





