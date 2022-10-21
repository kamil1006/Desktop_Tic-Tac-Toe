package tictactoe;

import java.util.*;

public class Game {

    List<Integer> listFree;
    List<Integer> listOccupied;
    List<Integer> listOccupied_X;
    List<Integer> listOccupied_O;
    boolean endGame;
    boolean x_wins;
    boolean o_wins;
    String currentLetter;
    String currentStatus;

    List<List<Integer>> listSolutions;

    String[] literki = new String[10];

    int counter = 0;
    public String name_X;
    public String name_O;


    //----------------------------------------------------------------------
    public Game() {
        listFree=new ArrayList<>(Arrays.asList(1, 2, 3,4,5,6,7,8,9));
        listOccupied=new ArrayList<>();
        listOccupied_X=new ArrayList<>();
        listOccupied_O=new ArrayList<>();
        listSolutions = new ArrayList<>();
        endGame=false;
        x_wins=false;
        o_wins=false;
        currentLetter="X";
        currentStatus ="Game is not started";
        for(int i = 0;i<10;i++)
            literki[i]=" ";

        listSolutions.add(new ArrayList<>(Arrays.asList(1,2,3)));
        listSolutions.add(new ArrayList<>(Arrays.asList(1,4,7)));
        listSolutions.add(new ArrayList<>(Arrays.asList(2,5,8)));
        listSolutions.add(new ArrayList<>(Arrays.asList(3,6,9)));
        listSolutions.add(new ArrayList<>(Arrays.asList(4,5,6)));
        listSolutions.add(new ArrayList<>(Arrays.asList(7,8,9)));
        listSolutions.add(new ArrayList<>(Arrays.asList(1,5,9)));
        listSolutions.add(new ArrayList<>(Arrays.asList(3,5,7)));

        //listSolutions={(1,2,3),(1,4,7),(2,5,8),(3,6,9),(4,5,6),(7,8,9),(1,5,9),(3,5,7)};
    }
    //----------------------------------------------------------------------
    public void wstaw(String znak, int numer){
        if (!listFree.isEmpty()){


            listFree.remove(listFree.indexOf(numer));
            listOccupied.add(numer);
            currentStatus="Game in progress";
            literki[numer]=currentLetter;
            counter++;

            switch (znak){
                case "X":
                        listOccupied_X.add(numer);
                        currentLetter="O";
                        currentStatus="The turn of "+name_O+" Player (O)";

                    break;
                case   "O":
                    listOccupied_O.add(numer);
                    currentLetter="X";
                    currentStatus="The turn of "+name_X+" Player (X)";
                    break;
            }

        if(listFree.isEmpty()){
            endGame=true;
            if(!x_wins&&!o_wins&&endGame)
                currentStatus = "Draw";
        }

        }

   }
    //----------------------------------------------------------------------
    public int losuj(String znak){

        int randomElement=0;
        if (!listFree.isEmpty()){
            Random rand = new Random();
            randomElement = listFree.get(rand.nextInt(listFree.size()));
        }
        return randomElement;
    }

    //----------------------------------------------------------------------
    public boolean checkStatusGry(){

            for (List<Integer> listSolution : listSolutions) {
                boolean x = listOccupied_X.containsAll(listSolution);
                boolean o = listOccupied_O.containsAll(listSolution);

                    if(x){
                        endGame=true;
                        x_wins=true;
                        o_wins=false;
                        currentStatus="The "+name_X+" Player (X) wins";
                        return endGame;
                    }
                    if (o){
                        endGame=true;
                        x_wins=false;
                        o_wins=true;
                        currentStatus="The "+name_O+" Player (O) wins";
                        return endGame;
                    }
            }


        if(!x_wins&&!o_wins&&endGame)
            currentStatus = "Draw";

        return endGame;
    }
    //----------------------------------------------------------------------


}
