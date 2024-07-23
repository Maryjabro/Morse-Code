import java.util.Scanner;

public class MorseCode{
    public static void main(String[] args) {
        runProgram();// run the program
    }
    public static char menu(){
        System.out.println();
        System.out.println("Hello, this program allows you to translate text to morse code or translate morse code to text.");
        System.out.println("Please, select one of the below options:");
        System.out.println("*** Enter 't' for encoding text");
        System.out.println("*** Enter 'm' for decoding morse code");
        System.out.println("*** Enter 'e' to exit the program");
        Scanner s=new Scanner(System.in);
        char input;
        input = s.next().charAt(0); //get the character
        while (!(input == 't' || input == 'm' || input == 'e')) {
            System.out.println("*** Invalid option ***");
            System.out.println("Please enter a valid option: ");
            input = s.next().charAt(0); // Get the character
        }
        return input;
    }

    public static String letterToMorse(String letters){

        String [] lettersArray = letters.split(" "); //splits by spaces

        String[] morse = {
                ".-", "-...", "-.-.", "-..", ".", ".-..", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..",".----","..---","...--","....-",
                ".....","-....","--...","---..","----.","-----"
        };
        char[] characters={'a','b','c','d','e','f','g','h','i','j','k','l'
        ,'m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        '0','1','2','3','4','5','6','7','8','9'};

        String output="";
        //for each word
        for(int i = 0; i <lettersArray.length;i++){
            //for each letter in each word
            for(int j = 0; j<lettersArray[i].length();j++){
                //for each character in characters array
                char current =lettersArray[i].charAt(j);
                for(int k = 0; k<characters.length; k++) {
                    //confirm it is a letter or digit, otherwise we cannot convert it
                    if (Character.isLetterOrDigit(current)) {
                        //if there is a space, add a space to the output
                        //if the character in the user string is equal to a character in the letters array, upper or lower case
                        if (current== characters[k] ||current== Character.toUpperCase(characters[k])) {
                            output += (morse[k] + " "); //add the corresponding morse code
                        }

                    }
                }
            }
            output+="  ";

        }
        return output;

    }
    public static String morseToLetters(String userMorse){


        String [] morseArray = userMorse.split("   "); //keeps spaces by splits by them
        //go through and count where the spaces are

        String[] morse = {
                ".-", "-...", "-.-.", "-..", ".", ".-..", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..",".----","..---","...--","....-",
                ".....","-....","--...","---..","----.","-----"
        };
        char[] characters={'a','b','c','d','e','f','g','h','i','j','k','l'
                ,'m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9'};

        String output="";
            for(int i = 0; i < morseArray.length; i++) {
                String [] current=morseArray[i].split(" ");
                for(int k = 0; k<current.length;k++) {
                    //if the character in the user string is equal to a character in the letters array, upper or lower case
                    for(int j = 0; j < morse.length; j++) {
                        if ((current[k]).equals(morse[j])) {
                            output += (characters[j]); //add the corresponding character
                        }
                    }


                }
                output+=" "; //after each word

            }
                return output;



    }

    public static void runProgram() {
        char option = menu(); //call menu
        Scanner s = new Scanner(System.in);

        if (option == 'e') {
            System.out.println("You have exited the program.");
        }

        while (option != 'e') {
            if (option == 't') {
                System.out.println("Please enter a phrase:");

                String input;
                input = s.nextLine(); //get the phrase
                String output = letterToMorse(input);
                System.out.println("Morse Code: ");
                System.out.println(output);
                option=menu();

            } else if (option == 'm') {
                System.out.println("Please enter morse code:");

                String input;
                input = s.nextLine(); //get the morse code
                String output = morseToLetters(input);
                System.out.println("Morse Code: ");
                System.out.println(output);
                option=menu();

            } else {
                System.out.println("You have exited the program.");

            }

        }
    }

}