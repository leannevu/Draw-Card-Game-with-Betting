package TwoCards;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        Validation.java
 * Description  Provides a number of boolean methods for validating different 
 *              types using regular expressions
 * Platform	jdk 1.8.0_241; NetBeans IDE 11.3; Windows 10
 * Course	CS 142, EdCC
 * @author      <i>Leanne Vu</i>
 * Date     	3/5/2021
 * @version     1.0.0
 * @see         java.util.regex.Matcher
 * @see         java.util.regex.Pattern
 *</pre>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Validation {
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method   isDouble() 
    * Description   Validates that double value is entered
    * Date          3/5/2021
    * @return       boolean
    * @param        fieldValue: String, input
    * @author       <i>Leanne Vu</i>	
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    *</pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isDouble(String fieldValue){
        Pattern pat = Pattern.compile ("-?[0-9]+");
        Matcher mat = pat.matcher(fieldValue);
        return mat.matches();
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method   isDouble() 
    * Description   Overloaded, validates that double value is entered within
    *               the required range
    * Date          1/21/2021
    * @return       boolean
    * @param        fieldValue: String, input
    * @param        lower double, lower bound
    * @param        upper double, upper bound
    * @author       <i>Leanne Vu</i>	
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    *</pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isDouble(String fieldValue, double lower, double upper){
        boolean result = true;
        Pattern pat = Pattern.compile ("-?[0-9]+");
        Matcher mat = pat.matcher(fieldValue); 
        if (mat.matches()){
            try{
                //check range
                double num= Double.parseDouble(fieldValue);
                if(num < lower || num > upper)
                    result = false; 
            } catch(NumberFormatException ex){
                //something went wrong
                result = false;
            }
        
        }else {
            result = false;
        }
        return result;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method   isInteger() 
    * Description   Validates that entered value is an integer
    * Date          3/5/2021
    * @return       boolean
    * @param        fieldValue: String, input
    * @param        upper int
    * @param        lower int
    * @author       <i>Leanne Vu</i>	
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    *</pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isInteger(String fieldValue,int lower, int upper){
        boolean result =true;
        Pattern pat = Pattern.compile ("[+-]?[0-9][0-9]*");
        Matcher mat = pat.matcher(fieldValue);
       
        if (mat.matches()){
            try{
                //check range
                double num= Integer.parseInt(fieldValue);
                if(num < lower || num > upper)
                    result = false; 
            } catch(NumberFormatException ex){
                //something went wrong
                result = false;
            }
        
        }else {
            result = false;
        }
        return result;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        isEmpty() 
    * Description   Validates that JTextField is not empty
    * @return       boolean
    * @param        fieldValue: String, input
    * @author       <i>Leanne Vu</i>	
    * @see          java.util.regex.Matcher
    * @see          java.util.regex.Pattern
    * @see          javax.swing.JTextField
    * Date          3/5/2021
    *</pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isEmpty(JTextField fieldValue){
        String input = fieldValue.getText();
        if (input == null || input.length() <= 0 || input.equals(""))
            return true;
        else
        return false;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method        isValidName(String input) 
     * Description   Validates that JTextField is a valid Opera name
     * @return       boolean
     * @param        input: JTextField, input
     * @author       <i>Leanne Vu</i>	
     * @see          java.util.regex.Matcher
     * @see          java.util.regex.Pattern
     * @see          javax.swing.JTextField
     * Date          3/5/2021
    *</pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static boolean isValidName(String input){
        final short MAX_LENGTH = 40;
        final short MIN_LENGTH = 2;
        boolean result = true;
        Pattern pat = Pattern.compile("^[a-zA-Z\\s\\.\\-\\']{2,40}$");
        Matcher mat = pat.matcher(input);
        if (!mat.matches() || input.length()> MAX_LENGTH ||  input.length() <MIN_LENGTH)
            return false;
        return result;
    }
    
    
    
}
