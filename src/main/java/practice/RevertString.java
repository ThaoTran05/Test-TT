package practice;

public class RevertString {

    /**
     * Write a program to revert inputted String to output like below
     *      String input = 'Automation'
     *     String Output = 'oitamotuAn'
     */
    public void RevertString(){
        String input = "Automation";
        String output = "";
        String output2 = "";

        // Revert the string
        for (int i = input.length() - 1; i >= 0; i--){
            output += input.charAt(i);
        }

        // Remove the first character and add it to the end
        for (int i = 1; i <= output.length() - 1; i++){
            output2 += output.charAt(i);
        }

        char lastChar = output.charAt(0);
        String Result = output2 + lastChar;

        System.out.println("Output: " + Result);
    }
}
