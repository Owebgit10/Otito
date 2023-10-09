#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>



void main() {



    /* Declaring the three integers that the users



    input will be read into */

    int num1, num2, num3;

    float average;





    //Asking the user to input the integers 

    printf("Please Enter 3 integers: ");





    /*reading the three integers from the user into the integer variables*/



    scanf("%d %d %d", &num1, &num2, &num3);





    /*Calculating average using addition and division operater*/



    average = (num1 + num2 + num3 ) / 3.0;





    //displaying a float with 2 decimal places 

    printf("The average is: %.2f\n", average);



    getchar();

}