
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>



#define MAX_SIZE 20 / *Maximum size of the arr can use #define MAX twenty also */



void main() {

    char arr[MAX_SIZE]; // Declare the character array

    int i, j;



    // Ask the user to input characters until a full stop is entered or the array is full

    printf("Enter characters (maximum of %d characters, end with a full stop): ", MAX_SIZE);

    for (i = 0; i < MAX_SIZE; i++) {

        scanf(" %c", &arr[i]); // Read each character from the user

        if (arr[i] == '.') break; // Stop if a full stop is entered

    }

    arr[i] = '\0'; // Add null terminator to end the string



    // Display the entered characters

    printf("Entered characters: ");

    for (j = 0; arr[j] != '\0'; j++) {

        printf("%c", arr[j]); // Print each character in the array

    }

    printf("\n");



    // Display the vowels in the entered characters

    printf("Vowels: ");

    for (j = 0; arr[j] != '\0'; j++) {

        switch (arr[j]) { // Check each character for a vowel

        case 'a':

        case 'e':

        case 'i':

        case 'o':

        case 'u':

            printf("%c", arr[j]); // Print the vowel if found

            break;

        default:

            break; // Do nothing if the character is not a vowel

        }

    }

    printf("\n");



   getchar();
   getchar();

}