import java.util.*;
import java.util.Random;



public class Badugi500310841 implements BadugiPlayer
{
    // instance variables - replace the example below with your own
    private static int count = 0;
    private int randBluf = 0;
    private int countBad = 0;
    private int id;
    private int position;
    private int handsToGo;
    private int drawsRemaining;
    private BadugiHand hand;
    private int bets;
    private int pot;
    private int toCall;
    private int opponentDrew;
    private int dealerDrew;
    private int currentScore;
    private int totalRaises;
    private int iDrew0;
    private int iDrew1;
    private int iDrew2;
    private int iDrew3;

    
    private Random rng = new Random();
    List<Card> actHand = new ArrayList<Card>();

    public Badugi500310841(){
        this.id = ++count;
    }

    /**
     * The method to tell the agent that a new hand is starting.
     * @param position 0 if the agent is the dealer in this hand, 1 if the opponent.
     * @param handsToGo The number of hands left to play in this heads-up tournament.
     * @param currentScore The current score of the tournament.
     */
    public void startNewHand(int position, int handsToGo, int currentScore){
        this.position = position;
        this.handsToGo = handsToGo;
        this.currentScore = currentScore;

    }

    /**
     * The method to ask the agent what betting action it wants to perform.
     * @param drawsRemaining How many draws are remaining after this betting round.
     * @param hand The current hand held by this player.
     * @param bets How many bets and raises there have been in this betting round.
     * @param pot The current size of the pot.
     * @param toCall The cost to call to stay in the pot.
     * @param opponentDrew How many cards the opponent drew in the previous drawing round. In the
     * first betting round, this argument will be -1.
     * @return The desired betting action given as an integer whose sign determines the action. Any negative
     * number means FOLD/CHECK, zero means CHECK/CALL, and any positive number means BET/RAISE.
     */
    public int bettingAction(int drawsRemaining, BadugiHand hand, int bets, int pot, int toCall, int opponentDrew){
        this.drawsRemaining = drawsRemaining;
        this.hand = hand;
        this.bets = bets;
        this.opponentDrew = opponentDrew;
        this.toCall = toCall;
        int highestActCard;
        int result = 0;
        int oppDrewRnd1 = 0;
        int oppDrewRnd2 = 0;
        int oppDrewRnd3 = 0;
        highestActCard = hand.getActiveRanks()[0];
        List<Card> actHand = new ArrayList<Card>();
        actHand.addAll(hand.getActiveCards());
        randBluf = rng.nextInt(99999) + 1;
        if(handsToGo == 9999){
            totalRaises=0;
            countBad = 0;
            iDrew0 = 0;
            iDrew1 = 0;
            iDrew2 = 0;
            iDrew3 = 0;
            result = 0;
        }
        if(actHand.size() == 4){
            countBad++;
        }
        if(randBluf % 1054 == 0){
            result = 1;

        }
        else if(randBluf % 544 == 0 && actHand.size() == 3 && highestActCard <=6){
            result = 1;

        }
        else if(actHand.size() == 4 && countBad % 722 == 0){
            if(drawsRemaining == 1 || drawsRemaining == 0){
                result = 1;
            }else
            {
                result = 0;
            }

        }
        else if(drawsRemaining == 3){
            if(toCall > 0){
                totalRaises++;
                if(actHand.size() == 4 && highestActCard <=8){
                    result = 1;
                }
                else if(actHand.size() == 4 && highestActCard >=9){
                    result = 0;
                }
                else if(actHand.size() == 3){
                    result = 0;
                }
                else if(actHand.size() == 1 && highestActCard >= 10){
                    result = -1;
                }
                else if(actHand.size() >= 3 && highestActCard <= 5){
                    result = 0;
                }
                else if(actHand.size() <= 2 && highestActCard <= 5){
                    result = 0;
                }
                else if(actHand.size() == 1){
                    result = -1;
                }
                else if(actHand.size() <= 2){
                    result = -1;
                }
                else if(totalRaises == 1){ //&& (actHand.size() == 4 || actHand.size() == 3) && highestActCard >=9){
                    result = -1;
                }

                else{
                    result = -1;
                }
            }
            else{
                if(actHand.size() == 4 && highestActCard <=8){
                    result = 1;
                }
                else if(actHand.size() == 4 && highestActCard >=9){
                    result = 1;
                }

                else if(actHand.size() == 3){
                    result = 0;
                }
                else if(actHand.size() >= 3 && highestActCard <= 5){
                    result = 0;
                }

                else if(actHand.size() < 1){
                    result = -1;
                }
                else if(actHand.size() <= 2){
                    result = -1;
                }

                else{
                    result = -1;
                }
            }

        }else if (drawsRemaining == 2){
            oppDrewRnd1 = opponentDrew;
            if(toCall > 0){
                totalRaises++;

                if(actHand.size() == 4 && highestActCard <=8){
                    result = 1;
                }
                else if(actHand.size() == 4 && highestActCard >=9){
                    result = 0;
                }
                else if(actHand.size() == 3 && opponentDrew >= 1 && highestActCard <= 6){
                    result = 0;
                }

                else if(actHand.size() <= 2 && highestActCard <= 5){
                    result = 0;
                }
                else if(actHand.size() <= 2){
                    result = -1;
                }
                else{
                    result = 0;
                }
            }
            else{

                if(actHand.size() == 4 && highestActCard <=8){
                    result = 1;
                }
                else if(actHand.size() == 4 && highestActCard >=9){
                    result = 1;
                }
                else if(actHand.size() <= 2 && highestActCard <= 9){
                    result = 0;
                }
                else if(actHand.size() == 3 && opponentDrew >= 1 && highestActCard <= 5){
                    result = 1;
                }
                else if(actHand.size() <= 2){
                    result = 0;
                }else{
                    result = 0;
                }
            }
        }else if(drawsRemaining == 1){
            oppDrewRnd2 = opponentDrew;
            if (toCall > 0){
                totalRaises++;
                if(actHand.size() == 4 && highestActCard <=8){
                    result = 1;
                }
                else if(actHand.size() == 4 && highestActCard >=9){
                    result = 0;
                }

                else if(actHand.size() <= 2){
                    result = -1;
                }
                else if(actHand.size() == 3 && highestActCard <= 6){
                    result = 0;
                }
                else if(totalRaises >= 2 && opponentDrew > 0){
                    result = 0;
                }
                else if(actHand.size() <= 2 && highestActCard >= 8){
                    result = -1;
                }

                else if (oppDrewRnd2 == 0 && actHand.size() <= 2){
                    result = -1;
                }
                else if(oppDrewRnd2 >= 2 && actHand.size() <= 4 && highestActCard <= 7){
                    result = 0;
                }

                else if(totalRaises >=3 && oppDrewRnd2 > 0){
                    result = -1;
                }

                else if(totalRaises >= 3){
                    result = -1;
                }

                else{
                    result = -1;
                }    
            }else{

                if(actHand.size() == 4 && highestActCard <=8){
                    result = 1;
                }
                else if(actHand.size() == 4 && highestActCard >=9){
                    result = 1;
                }
                else if(totalRaises >= 2 && opponentDrew > 0){
                    result = 0;
                }
                else if(opponentDrew == 0){
                    result = 0;
                }

                else if (actHand.size() == 3 && opponentDrew > 0 && highestActCard <= 6){
                    result = 0;
                }

                else if(oppDrewRnd1 == 1 && oppDrewRnd2 == 1 && actHand.size() == 3 && (highestActCard >= 5 && highestActCard <=9)){
                    result = 0;
                }
                else if(actHand.size() <= 2){
                    result = 0;
                }
                else if(actHand.size() <= 2 && highestActCard <= 8){
                    result = 0;
                }

                else if (oppDrewRnd2 == 0 && actHand.size() <= 2){
                    result = -1;
                }
                else if(oppDrewRnd2 >= 2 && actHand.size() <= 4 && highestActCard <= 7){
                    result = 0;
                }
                else if(actHand.size() == 3 && highestActCard <= 6){
                    result = 0;
                }

                else{
                    result = 0;
                }
            }
        }else if(drawsRemaining == 0){
            oppDrewRnd3 = opponentDrew;
            if(toCall > 0){
                totalRaises++;
                if(actHand.size() == 4 && highestActCard <=8){
                    result = 1;
                }
                else if(actHand.size() == 4 && highestActCard >=9){
                    result = 0;
                }
                else if(actHand.size() <= 2){
                    result = -1;
                }
                else if(totalRaises >= 2 && opponentDrew >= 0){
                    result = -1;
                }    
                else if (oppDrewRnd1 == 0 && oppDrewRnd2 == 0 && oppDrewRnd3 == 0 && actHand.size() != 4){
                    result = -1;
                }
                else if (oppDrewRnd2 == 0 && oppDrewRnd3 == 0 && actHand.size() != 4){
                    result = -1;
                }
                else if(oppDrewRnd3 >= 1 && actHand.size() == 3 && highestActCard <=5){
                    result = 0;
                }
                else if(oppDrewRnd3 == 0 && actHand.size() == 4 && highestActCard >=5){
                    result = 0;
                }
                else if(oppDrewRnd1 == 1 && oppDrewRnd2 == 1 && oppDrewRnd3 == 1 && actHand.size() == 3 && (highestActCard >= 5 && highestActCard <=9)){
                    result = 0;
                }

                else if(actHand.size() == 3 && highestActCard <= 6){
                    result = 1;
                }

                else if(totalRaises >=4 && (oppDrewRnd1 > 0 || oppDrewRnd2 >= 0 || oppDrewRnd3 >= 0) && (iDrew3 > 0 || iDrew0 > 0)){
                    result = -1;
                }
                else if(totalRaises >= 4){
                    result = -1;

                }else{
                    result = 0;
                }
            }else{
                if(actHand.size() == 4){
                    result = 1;
                }

                else{
                    result = 0;
                }
            }

        }
        else{
            result = -1;
        }

        if(result == 1){
            return 1;
        } else if(result == -1){
            return -1;
        }else{
            return 0;

        }

    }

    /**
     * The method to ask the agent which cards it wants to replace in this drawing round.
     * @param drawsRemaining How many draws are remaining, including this drawing round.
     * @param hand The current hand held by this player.
     * @param pot The current size of the pot.
     * @param dealerDrew How many cards the dealer drew in this drawing round. When this method is called
     * for the dealer, this argument will be -1.
     * @return The list of cards in the hand that the agent wants to replace.
     */
    public List<Card> drawingAction(int drawsRemaining, BadugiHand hand, int pot, int dealerDrew){
        this.drawsRemaining = drawsRemaining;
        this.hand = hand;
        this.pot = pot;
        this.dealerDrew = dealerDrew;
        List<Card> inactCards = new ArrayList<Card>();
        List<Card> actCards = new ArrayList<Card>();

        actCards.addAll(hand.getActiveCards());
        int highestActCard = hand.getActiveRanks()[0];
        int len = hand.getActiveRanks().length;
        int i;
        if(randBluf % 1054 == 0){
            return inactCards;
        }
        else if(randBluf % 544 == 0 && actHand.size() == 3 && highestActCard <=6){
            return inactCards;
        }

        else if(actCards.size() == 4 && countBad % 722 == 0){
            return inactCards;
        }

        else if(drawsRemaining == 1 && actCards.size() == 3 && highestActCard <= 5){
            return inactCards;
        }

        else if(actCards.size() == 4 && highestActCard >= 12){
            inactCards.add(actCards.get(0));

        }
        else{

            inactCards.addAll(hand.getInactiveCards());
            for(i=0; i<len; i++){
                if(actCards.size() < 4 && hand.getActiveRanks()[i] >= 9){
                    inactCards.add(actCards.get(i));

                }
            }
        }

        if(drawsRemaining == 3){
            if(inactCards.size() != 0){
                iDrew1++;
            }
            return inactCards;
        }else if(drawsRemaining == 2){
            if(inactCards.size() != 0){
                iDrew2++;
            }
            return inactCards;
        }else if(drawsRemaining == 1){
            if(inactCards.size() != 0){
                iDrew3++;
            }
            return inactCards;
        }else{
            if(inactCards.size() != 0){
                iDrew0++;
            }
            return inactCards;
        }
    }

    /**
     * The agent observes the showdown at the end of the hand.
     * @param yourHand The hand held by this agent.
     * @param opponentHand The hand held by the opponent.
     */
    public void showdown(BadugiHand yourHand, BadugiHand opponentHand){}

    /**
     * Returns the nickname of this agent.
     * @return The nickname of this agent.
     */
    public String getAgentName(){
        return "KingChihuahua";
    }

    /**
     * Returns the author of this agent. The name should be given in the format "Last, First".
     * @return The author of this agent.
     */
    public String getAuthor(){
        return "Medley, Jaculine";
    }
}

