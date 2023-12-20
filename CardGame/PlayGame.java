import java.util.*;
public class PlayGame extends Hand{
    private LinkedList<Hand> playerHands=new LinkedList<Hand>();
    private DeckList funDeck;
    private int numPlayers;
    private int[] playerScores;

    /**
     * default constructor
     */
    public PlayGame(){}

    /**
     * the constructor that initialize the numPlayers and handSize
     * @param numPlayers the number of players
     * @param handSize the hand size
     */
    public PlayGame(int numPlayers,int handSize){
        this.numPlayers=numPlayers;
        this.playerHands=new LinkedList<Hand>();
        super.setHandSize(handSize);
        playerScores=new int[numPlayers];
        for(int i=0;i<numPlayers;i++){
            playerScores[i]=0;
        }
    }

    /**
     * get the number of players
     * @return the number of players
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * method to run the game
     * @throws InvalidCardReference
     */
    public void playNow() throws InvalidCardReference {
        boolean another;
        do {
              int menu = 0;
              boolean again = false, isStart = false;
              do {
                  Scanner in = new Scanner(System.in);
                  System.out.println("1.Start\n2.Exit");
                  if (in.hasNextInt()) {
                      menu = in.nextInt();
                  } else {
                      System.out.println("Please enter 1 to start or enter 2 to exit");
                  }
                  boolean improperNum = true;
                  switch (menu) {
                      case 1:
                          do {
                              in = new Scanner(System.in);
                              System.out.println("Enter the number of players(2 to 4):");
                              if (in.hasNextInt()) {
                                  numPlayers = in.nextInt();
                                  if (numPlayers >= 2 && numPlayers <= 4) {
                                      improperNum = false;
                                  } else {
                                      System.out.println("Please enter 2 to 4");
                                  }
                              } else {
                                  System.out.println("Please enter 2 to 4");
                              }
                          } while (improperNum);
                          isStart = true;
                          again = false;
                          break;
                      case 2:
                          System.out.println("Good Bye");
                          again = false;
                          break;
                      default:
                          System.out.println("Please enter 1 to start or enter 2 to exit");
                          again = true;
                  }
              } while (again);
              switch (numPlayers) {
                  case 2:
                      newDeck();
                      this.playerScores = new int[]{0, 0};
                      this.numPlayers = 2;
                      super.setHandSize(7);
                      Hand p1 = new Hand(7);
                      Hand p2 = new Hand(7);
                      playerHands.add(0, p1);
                      playerHands.add(1, p2);
                      for (int i = 1; i <= 7; i++) {
                          p1.addCard(funDeck.getCard());
                      }
                      for (int i = 1; i <= 7; i++) {
                          p2.addCard(funDeck.getCard());
                      }
                      do {
                          check4(p1, 1);
                          check4(p2, 2);
                          round(p1, p2, "Player1", "Player2");
                          check4(p1, 1);
                          round(p2, p1, "Player2", "Player1");
                          check4(p2, 2);
                      } while (funDeck.getCardsLeft() > 0);
                      System.out.println("Game End");
                      winner(playerScores, numPlayers);
                      break;
                  case 3:
                      newDeck();
                      this.playerScores = new int[]{0, 0, 0};
                      this.numPlayers = 3;
                      super.setHandSize(5);
                      Hand pl1 = new Hand(5);
                      Hand pl2 = new Hand(5);
                      Hand pl3 = new Hand(5);
                      playerHands.add(0, pl1);
                      playerHands.add(1, pl2);
                      playerHands.add(2, pl3);
                      for (int i = 1; i <= 5; i++) {
                          pl1.addCard(funDeck.getCard());
                      }
                      for (int i = 1; i <= 5; i++) {
                          pl2.addCard(funDeck.getCard());
                      }
                      for (int i = 1; i <= 5; i++) {
                          pl3.addCard(funDeck.getCard());
                      }
                      do {
                          check4(pl1, 1);
                          check4(pl2, 2);
                          check4(pl3, 3);
                          roundMulti(pl1, pl2, pl3, "Player1", "Player2", "Player3");
                          check4(pl1, 1);
                          if (funDeck.getCardsLeft() == 0)
                              break;
                          roundMulti(pl1, pl2, pl3, "Player2", "Player1", "Player3");
                          check4(pl2, 2);
                          if (funDeck.getCardsLeft() == 0)
                              break;
                          roundMulti(pl1, pl2, pl3, "Player3", "Player1", "Player2");
                          check4(pl3, 3);
                      } while (funDeck.getCardsLeft() > 0);
                      System.out.println("Game End");
                      winner(playerScores, numPlayers);
                  case 4:
                      newDeck();
                      this.playerScores = new int[]{0, 0, 0, 0};
                      this.numPlayers = 4;
                      super.setHandSize(5);
                      Hand plr1 = new Hand(5);
                      Hand plr2 = new Hand(5);
                      Hand plr3 = new Hand(5);
                      Hand plr4 = new Hand(5);
                      playerHands.add(0, plr1);
                      playerHands.add(1, plr2);
                      playerHands.add(2, plr3);
                      playerHands.add(3, plr4);
                      for (int i = 1; i <= 5; i++) {
                          plr1.addCard(funDeck.getCard());
                      }
                      for (int i = 1; i <= 5; i++) {
                          plr2.addCard(funDeck.getCard());
                      }
                      for (int i = 1; i <= 5; i++) {
                          plr3.addCard(funDeck.getCard());
                      }
                      for (int i = 1; i <= 5; i++) {
                          plr4.addCard(funDeck.getCard());
                      }
                      do {
                          check4(plr1, 1);
                          check4(plr2, 2);
                          check4(plr3, 3);
                          check4(plr4, 4);
                          roundMulti4(plr1, plr2, plr3, plr4, "Player1", "Player2", "Player3", "Player4");
                          check4(plr1, 1);
                          if (funDeck.getCardsLeft() == 0)
                              break;
                          roundMulti4(plr1, plr2, plr3, plr4, "Player2", "Player1", "Player3", "Player4");
                          check4(plr2, 2);
                          if (funDeck.getCardsLeft() == 0)
                              break;
                          roundMulti4(plr1, plr2, plr3, plr4, "Player3", "Player1", "Player2", "Player4");
                          check4(plr3, 3);
                          if (funDeck.getCardsLeft() == 0) {
                              break;
                          }
                          roundMulti4(plr1, plr2, plr3, plr4, "Player4", "Player1", "Player2", "Player4");
                          check4(plr4, 4);
                      } while (funDeck.getCardsLeft() > 0);
                      System.out.println("Game End");
                      winner(playerScores, numPlayers);
              }
              Scanner in2=new Scanner("System.in");
              System.out.println("Another Game?\npress 1 to continue, press else exit");
              int n= in2.nextInt();
              if(n==1){
                  another=true;
              }else{
                  another=false;
              }
          }while(another);
    }


    /**
     * one round for specific player to get others card or go fishing(for 2 players game)
     * @param p1 the player to take action
     * @param p2 the player be asked if he has the card of certain rank
     * @param name1 the name of the player to take action
     * @param name2 the name of the player who will be asked
     * @throws InvalidCardReference
     */
    public void round(Hand p1, Hand p2, String name1, String name2) throws InvalidCardReference {
        boolean isHit,hitOnce;
        int playerCall=0;
        do {
            isHit=false;
            hitOnce=false;
            boolean inRange=true;
            do {
                System.out.println(name1+", Your Turn.(Enter 1 to 14)");
                p1.showHand();
                Scanner scanner = new Scanner(System.in);
                if(scanner.hasNextInt()){
                    playerCall=scanner.nextInt();
                    if(playerCall<15&&playerCall>0){
                        System.out.println(name1+": "+name2+", do you have "+playerCall+"?");
                    }else{
                        System.out.println("Please enter 1 to 14");
                        inRange=false;
                    }
                }else{
                    System.out.println("Please enter 1 to 14");
                    inRange=false;
                }
            }while(!inRange);
            int theCard;
            for(int i=0;i<p1.getHandSize();i++) {
                 theCard = searchHand(playerCall, p2);
                if(theCard!=-1){
                    System.out.println("Yes");
                    isHit=true;
                    hitOnce=true;
                    p1.addCard(p2.removeCard(theCard));
                    check4(p1,1);
                    p1.showHand();
                    System.out.println("");
                }
            }
        }while(isHit);
        System.out.println("Go Fishing!");
        p1.addCard(funDeck.getCard());
        p1.showHand();
        System.out.println("");
    }

    /**
     * round action for 3 players game
     * @param p1 the player1
     * @param p2 the other player2
     * @param p3 the other player3
     * @param nameP1 the name of the player1
     * @param nameP2 the name of the player2
     * @param nameP3 the name of the player3
     * @throws InvalidCardReference
     */
    public void roundMulti(Hand p1, Hand p2, Hand p3,String nameP1, String nameP2, String nameP3) throws InvalidCardReference {
        boolean isHit,rightN;
        Scanner in;
        int which=0;
            do {
                isHit=false;
                in = new Scanner(System.in);
                System.out.println(nameP1 + ", Your Turn.\nWho would you like to ask to?");

                do {
                    rightN = true;
                    if (nameP1.equals("Player1")) {
                        p1.showHand();
                        System.out.println("\nPlayer2(Press2)\nPlayer3(Press3)");
                        if (in.hasNextInt()) {
                            which = in.nextInt();
                            switch (which) {
                                case 2:
                                    isHit=roundN(p1, p2, nameP1, nameP2,1);
                                    break;
                                case 3:
                                    isHit=roundN(p1, p3, nameP1, nameP3,1);
                                    break;
                                default:
                                    System.out.println("Please enter 2 or 3");
                                    rightN = false;
                            }
                        } else {
                            rightN = false;
                            System.out.println("Please enter 2 or 3");
                        }
                    } else if (nameP1.equals("Player2")) {
                        p2.showHand();
                        System.out.println("\nPlayer1(Press1)\nPlayer3(Press3)");
                        if (in.hasNextInt()) {
                            which = in.nextInt();
                            switch (which) {
                                case 1:
                                   isHit=roundN(p2, p1, "Player2", "Player1",2);
                                    break;
                                case 3:
                                    isHit=roundN(p2, p3, "Player2", "Player3",2);
                                    break;
                                default:
                                    System.out.println("Please enter 1 or 3");
                                    rightN = false;
                            }
                        } else {
                            rightN = false;
                            System.out.println("Please enter 1 or 3");
                        }
                    } else if (nameP1.equals("Player3")) {
                        p3.showHand();
                        System.out.println("\nPlayer1(Press1)\nPlayer2(Press2)");
                        if (in.hasNextInt()) {
                            which = in.nextInt();
                            switch (which) {
                                case 1:
                                    isHit=roundN(p3, p1, "Player3", "Player1",3);
                                    break;
                                case 2:
                                    isHit=roundN(p3, p2, "Player3", "Player2",3);
                                    break;
                                default:
                                    rightN=false;
                                    System.out.println("Please enter 1 or 2");
                            }
                        } else {
                            rightN = false;
                            System.out.println("Please enter the right number");
                        }
                    } else {
                        rightN = false;
                        System.out.println("Please enter the right number");
                    }
                } while (!rightN);
            }while(isHit);
        System.out.println("Go Fishing!");
        p1.addCard(funDeck.getCard());
        p1.showHand();
        System.out.println("");
    }

    /**
     * action runner for 4 players game
     * @param p1 the player1
     * @param p2 the player2
     * @param p3 the player3
     * @param p4 the player4
     * @param nameP1 the name of the player1
     * @param nameP2 the name of the player2
     * @param nameP3 the name of the player3
     * @param nameP4 the name of the player4
     * @throws InvalidCardReference
     */
    public void roundMulti4(Hand p1, Hand p2, Hand p3,Hand p4,String nameP1, String nameP2, String nameP3,String nameP4) throws InvalidCardReference {
        boolean isHit,rightN;
        Scanner in;
        int which;
        do {
            isHit=false;
            in = new Scanner(System.in);
            System.out.println(nameP1 + ", Your Turn.\nWho would you like to ask to?");

            do {
                rightN = true;
                if (nameP1.equals("Player1")) {
                    p1.showHand();
                    System.out.println("\nPlayer2(Press2)\nPlayer3(Press3)\nPlayer4(Press4)");
                    if (in.hasNextInt()) {
                        which = in.nextInt();
                        switch (which) {
                            case 2:
                                isHit=roundN(p1, p2, nameP1, nameP2,1);
                                break;
                            case 3:
                                isHit=roundN(p1, p3, nameP1, nameP3,1);
                                break;
                            case 4:
                                isHit=roundN(p1,p4,nameP1,nameP4,1);
                                break;
                            default:
                                System.out.println("Please enter 2, 3 or 4");
                                rightN = false;
                        }
                    } else {
                        rightN = false;
                        System.out.println("Please enter 2, 3 or 4");
                    }
                } else if (nameP1.equals("Player2")) {
                    p2.showHand();
                    System.out.println("\nPlayer1(Press1)\nPlayer3(Press3)\nPlayer4(Press4)");
                    if (in.hasNextInt()) {
                        which = in.nextInt();
                        switch (which) {
                            case 1:
                                isHit=roundN(p2, p1, "Player2", "Player1",2);
                                break;
                            case 3:
                                isHit=roundN(p2, p3, "Player2", "Player3",2);
                                break;
                            case 4:
                                isHit=roundN(p2,p4,"Player2","Player3",2);
                                break;
                            default:
                                System.out.println("Please enter 1, 3 or 4");
                                rightN = false;
                        }
                    } else {
                        rightN = false;
                        System.out.println("Please enter 1 or 3");
                    }
                } else if (nameP1.equals("Player3")) {
                    p3.showHand();
                    System.out.println("\nPlayer1(Press1)\nPlayer2(Press2)\nPlayer4(Press4)");
                    if (in.hasNextInt()) {
                        which = in.nextInt();
                        switch (which) {
                            case 1:
                                isHit = roundN(p3, p1, "Player3", "Player1", 3);
                                break;
                            case 2:
                                isHit = roundN(p3, p2, "Player3", "Player2", 3);
                                break;
                            case 4:
                                isHit = roundN(p3, p4, "Player3", "Player4", 3);
                                break;
                            default:
                                rightN = false;
                                System.out.println("Please enter 1, 2 or 4");
                        }
                    }
                }else if (nameP1.equals("Player4")) {
                        p4.showHand();
                        System.out.println("\nPlayer1(Press1)\nPlayer2(Press2)\nPlayer3(Press3)");
                        if(in.hasNextInt()){
                            which=in.nextInt();
                            switch (which){
                                case 1:
                                    isHit=roundN(p4,p1,"Player4","Player1",4);
                                    break;
                                case 2:
                                    isHit=roundN(p4,p2,"Player4","Player2",4);
                                    break;
                                case 3:
                                    isHit=roundN(p4,p3,"Player4","Player3",4);
                                    break;
                                default:
                                    rightN=false;
                                    System.out.println("Please enter 1, 2 or 3");
                            }
                        } else {
                                rightN = false;
                                System.out.println("Please enter the right number");
                        }
                } else {
                    rightN = false;
                    System.out.println("Please enter the right number");
                }
            } while (!rightN);
        }while(isHit);
        System.out.println("Go Fishing!");
        p1.addCard(funDeck.getCard());
        p1.showHand();
        System.out.println("");
    }

    /**
     * the exact action runner for multiple players game(more than 2 players)
     * @param p1 the player that is going to take action
     * @param p2 the player will be asked by the player that is going to take action for certain rank of cards
     * @param name1 the name of the action taker
     * @param name2 the name of the player will be asked
     * @param playerNum the ID of the player that is going to take action
     * @return true if the player be asked has the card of the rank that another player asked him/her
     * @throws InvalidCardReference
     */
    public boolean roundN(Hand p1, Hand p2, String name1, String name2,int playerNum) throws InvalidCardReference {
        boolean isHit,hitOnce;
        int playerCall=0;
        isHit=false;
        hitOnce=false;
        boolean inRange=true;
        do {
            System.out.println(name1+", Your Turn.(Enter 1 to 14)");
            p1.showHand();
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()){
                playerCall=scanner.nextInt();
                if(playerCall<15&&playerCall>0){
                    System.out.println(name1+": "+name2+", do you have "+playerCall+"?");
                }else{
                    System.out.println("Please enter 1 to 14");
                    inRange=false;
                }
            }else{
                System.out.println("Please enter 1 to 14");
                inRange=false;
            }
        }while(!inRange);
        int theCard;
        for(int i=0;i<p1.getHandSize();i++) {
            theCard = searchHand(playerCall, p2);
            if(theCard!=-1){
                System.out.println("Yes");
                isHit=true;
                hitOnce=true;
                p1.addCard(p2.removeCard(theCard));
                check4(p1,playerNum);
                p1.showHand();
                System.out.println("");
            }
        }
        return isHit;
    }

    /**
     * to check if the player's hand have 4 cards of the same rank, if so his/her scores will be added.
     * @param player the player to be checked
     * @param playNum the number of the players in this game
     * @throws InvalidCardReference
     */
    public void check4(Hand player,int playNum) throws InvalidCardReference {
        for(int j=2;j<=14;j++) {
            int count=0;
            for (int i = 0; i < player.getTotalCards(); i++) {
                if (j == player.getCard(i).getRank()) {
                    count++;
                }
            }
            if(count==4) {
                for (int k = 0; k < player.getTotalCards(); k++) {
                    if (j == player.getCard(k).getRank()) {
                        player.removeCard(k);
                        k-=1;
                    }
                }
                playerScores[playNum - 1] += 1;
                System.out.println("Player" + playNum + " score +1");
            }
            j++;
        }
    }

    /**
     * to determine the winner of the game and store their scores in an array list
     * @param playerScores the array stores the players' scores
     * @param numPlayers the number of players in the game
     * @return an array list that store the players' scores
     */
    public ArrayList<Integer> winner(int[] playerScores,int numPlayers){
        int highest=0,count=0;
        ArrayList<Integer> winner=new ArrayList<>(numPlayers);
        for(int i=0;i<numPlayers;i++){
            if (playerScores[i]>highest) {
                highest = playerScores[i];
            }
        }
        Map<Integer,Integer> map= new HashMap<Integer, Integer>();
        for(int i=1;i<=numPlayers;i++){
            map.put(i,playerScores[i-1]);
        }
        for(Integer k: map.keySet()){
            if(map.get(k)==highest){
                winner.add(k);
                count++;
            }
        }
        if(count==0){
            System.out.println("Tie");
            return null;
        }else{
            System.out.print("Winner is(are) ");
            System.out.println(winner.toString());
            return winner;
        }
    }

    /**
     * to find out if the player have cards of certain rank in his/her hand
     * @param call the rank to search
     * @param player the player to be searched
     * @return the specific index of the linked list that can find the be-searched card
     */
    public int searchHand(int call,Hand player){
        for(int i=0;i<player.getTotalCards();i++){
            if(call==player.getCard(i).getRank()){
                return i;
            }
        }
        return -1;
    }

    /**
     * to shuffle and get a new deck
     */
    public void newDeck(){
        funDeck=new DeckList();
        funDeck.shuffle();
    }

    public static void main(String[] args) throws InvalidCardReference{
        PlayGame p=new PlayGame();
        //try {
            p.playNow();
        //}catch (InvalidCardException invalid){
          //  invalid.toString();
        //} catch (InvalidCardReference e) {
          //  throw new RuntimeException(e);
        //}
    }
}
