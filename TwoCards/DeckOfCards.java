/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        DeckOfCards.java
 * Project      Project3--CardGame
 * Description  An additional class that makes it much easier to organize all
 *              the methods that are used in the drawJButton of the 
 *              CardGameGUI class. Methods include of DeckOfCards(),
 *              shuffle(), clearSeen(), checkNoMoreCards(), and more.
 * File         CardGameGUI.java
 * Platform     jdk 1.8.0_214; NetBeans IDE 11.3; Windows 10
 * Course       CS 142, Edmonds Community College
 * Hours        25 hours
 * Date         3/5/2021 
 *
 * @author	<i>Leanne Vu</i>
 * @version 	%1% %2%
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit
 * @see         java.util.TreeSet
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class DeckOfCards {
    //one array for the cards
    private final int NUM_OF_CARDS = 52;
    private final int TOTAL_POSSIBLE_CARDS = 52;
    private int[] deck;
    private List<Integer> seen;
    int picked;
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		DeckOfCards()
    *	Description     Creates an array for the deck filled with 52 cards, as
    *                   well as an array list for cards that cannot be replaced.
    *	@author         <i>Leanne Vu</i>
    *	Date            3/7/2021
    *   history log
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public DeckOfCards() {
        this.deck = new int[NUM_OF_CARDS];
        this.seen = new ArrayList<Integer>(); 
        //assign cards for each elements
        for (int i = 0; i < deck.length; i++) 
            deck[i] = i;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		shuffle()
    *	Description     Shuffles the current deck of cards by generating an index
    *                   randomly.
    *	@author         <i>Leanne Vu</i>
    *	Date            3/7/2021
    *   history log
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public void shuffle() {
        for (int i = 0; i < this.deck.length; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, 52);
            int temp = this.deck[i];
            this.deck[i] = this.deck[index];
            this.deck[index] = temp;
            this.seen.clear();  // empty the seen list
        }
    }
    
   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		clearSeen()
    *	Description     Clears out cards that cannot be replaced.
    *	@author         <i>Leanne Vu</i>
    *	Date            3/7/2021
    *   history log
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public void clearSeen() {
        this.seen.clear();
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		randomCard()
    *	Description     Somewhat similar to the shuffle(), but this method picks
    *                   cards through choosing an integer from 1 to 52 and returns
    *                   a random integer. It also keeps track of the cards
    *                   that cannot be replaced.
    *	@author         <i>Leanne Vu</i>
    *   @return         picked int
    *	Date            3/7/2021
    *   history log
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public int randomCard() {
        Random rand = new Random();
        int num = rand.nextInt(NUM_OF_CARDS); //randomly choose a number 
        
        picked = this.deck[num] + 1; //assign number to card
        while (this.seen.contains(picked)) { //check if there are any cards drawed cards
            num = rand.nextInt(NUM_OF_CARDS); //assign number to card until no drawed cards are matched
            picked = this.deck[num] + 1;
        }
        
        this.seen.add(picked); //add picked card to drawed pile
        return picked; //return chosen card
    }

   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    *	Method		checkNoMoreCards()
    *	Description     Checks if the seen array list has reached the size 
    *                   of 52. That tells us whether the user has used us all
    *                   the possible draws when all the cards have ran out.
    *	@author         <i>Leanne Vu</i>
    *   @return         picked int
    *	Date            3/7/2021
    *   history log
    *</pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public boolean checkNoMoreCards() {
        return (seen.size() == TOTAL_POSSIBLE_CARDS);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       toString()
     * Description  Override toString() method to display player object
     * @author      <i>Leanne Vu</i>
     * @return      object String
     * Date         3/5/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    @Override
    public String toString() {
        return "Result: "  +  " Name: " + 
                "\nBalance: ";
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       equals()
     * Description  Override equals() method to compare Player object equals to another
     * @author      <i>Leanne Vu</i>
     * @param       obj Object
     * @return      true or false boolean
     * Date         3/5/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
//        final Player other = (Player) obj; //checks if age is equal
//        if (this.age != other.age) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) { //checks if names are the same
//            return false;
//        }
//        if (this.balance != other.balance) { //checks if balance is equal
//            return false;
//        }
        return true;
    }

}
