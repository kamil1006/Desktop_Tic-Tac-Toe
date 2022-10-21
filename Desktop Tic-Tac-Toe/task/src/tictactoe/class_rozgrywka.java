package tictactoe;


import java.util.Random;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
public class class_rozgrywka
{
    int[][] tablica = new int[10][3];
    int[][] wygrane = new int[10][4];

    int licznik;
    int wybor;
    int wybor_p;
    public int wynik;
    int ktory_wynik;

    int[] losowanie_tablica = new int[10];
    int[] losowanie_tablica1 = new int[10];
    int[] losowanie_tablica2 = new int[10];
    //______________________________________________________________________________________________
    public class_rozgrywka()
    {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 3; j++)
                wygrane[i][j] = 0;
        }
        wygrane[1][1] = 1;
        wygrane[1][2] = 2;
        wygrane[1][3] = 3;

        wygrane[2][1] = 1;
        wygrane[2][2] = 4;
        wygrane[2][3] = 7;

        wygrane[3][1] = 2;
        wygrane[3][2] = 5;
        wygrane[3][3] = 8;

        wygrane[4][1] = 3;
        wygrane[4][2] = 6;
        wygrane[4][3] = 9;

        wygrane[5][1] = 4;
        wygrane[5][2] = 5;
        wygrane[5][3] = 6;

        wygrane[6][1] = 7;
        wygrane[6][2] = 8;
        wygrane[6][3] = 9;

        wygrane[7][1] = 1;
        wygrane[7][2] = 5;
        wygrane[7][3] = 9;

        wygrane[8][1] = 3;
        wygrane[8][2] = 5;
        wygrane[8][3] = 7;
    }
    //______________________________________________________________________________________________
    public int podaj_nr(int a, int b)
    { return wygrane[a][b];
    }
    //______________________________________________________________________________________________
    public void kasowanie()
    {   licznik = 0;
        wynik = 0;
        for(int i = 1;i<=9;i++){
            for(int j = 1;j<=2;j++){
                tablica[i][j] = 0;
            }
        }
    }
    //______________________________________________________________________________________________
    public void wstaw(int a, int b, int c)
    {  tablica[a][b]=c;
        if (b==1){licznik = licznik + 1;}
    }
    //______________________________________________________________________________________________
    public String wynik_slownie()
    {
        String temp;
        switch (wynik) {
            case 0:
                temp = "remis";
                return temp;
            //break;
            case 1:
                temp = "wygrana X";
                return temp;
            // break;
            case 2:
                temp = "porazka X";
                return temp;
            // break;

            default:
                throw new IllegalStateException("Unexpected value: " + wynik);
        }
    }
    //______________________________________________________________________________________________
    public void przelicz_wynik(){
        if (wybor == 1) { wybor_p = 2; }
        else    { wybor_p = 1; }

        for(int i = 1;i<=8;i++){
            if ((wybor == tablica [(wygrane[i][1])][2]) && (wybor == tablica [(wygrane[i][2])][2]) && (wybor == tablica [(wygrane[i][3])][2])  )
            {
                wynik = 1;
                ktory_wynik = i ;
            }
        }

        for(int i = 1;i<=8;i++){
            if ((wybor_p == tablica [(wygrane[i][1])][2]) && (wybor_p == tablica [(wygrane[i][2])][2]) && (wybor_p == tablica [(wygrane[i][3])][2])  )
            {
                wynik = 2;
                ktory_wynik = i ;
            }
        }
    }
    //______________________________________________________________________________________________
    public int losowanie_old() {

        int j;
        int losowanie2=0;

        for (int i = 1; i <= 9; i++) {
            losowanie_tablica[i] = 0;
        }

        j = 0;
        for (int i = 1; i <= 9; i++) {
            if(tablica[i][2] == 0){
                losowanie_tablica[j + 1] = i;
                j = j+ 1;
            }
        }

        if (j > 0){

            j = j + 1;
            int Low ;
            int High ;

            int los;
            Low = 1;
            High = j - 1;
            Random r = new Random();
            los = (int)((High - Low + 1) * r.nextDouble() + Low);
            losowanie2 = losowanie_tablica[los];
            tablica[losowanie2][ 1] = 1;
            if (wybor == 1) {   wybor_p = 2;   }
            else { wybor_p = 1;     }
            tablica[losowanie2][ 2] = wybor_p;
        }
        else{  przelicz_wynik();   }
        return losowanie2;
    }
    //______________________________________________________________________________________________
    public int losowanie() {

        int losowanie2=0;
        //'---------------------------------------------
        // ' kasowanie tablic
        for (int i = 1; i <= 9; i++) {
            losowanie_tablica[i] = 0;// ' tablica wolnych
            losowanie_tablica1[i] = 0 ;//' tablica zajętych czlowiek
            losowanie_tablica2[i] = 0 ;//' tablica zajętych 2
        }
        //'---------------------------------------------
        //'tworzenie tablicy wolnych
        int j;
        j = 0 ;//' tyle wolnych
        for (int i = 1; i <= 9; i++) {
            if (tablica [i][ 1] ==0) {
                losowanie_tablica[j + 1] = i;
                j = j + 1;
            }
        }
        //'j = j - 1
        //'---------------------------------------------
        //'tworzenie tablicy zajetych przez czlowieka
        if (wybor == 1) {      wybor_p = 2;}
        else         { wybor_p = 1;}

        int k;
        k = 1 ;//'tyle zajetych przez czlowieka
        for (int i = 1; i <= 9; i++) {
            if (tablica [i][ 2] ==wybor) {
                losowanie_tablica1[k] = i;
                k = k + 1;
            }
        }
        k = k - 1;
        //'---------------------------------------------
        //' ktora najblizsza wygrana czlowieka
        int wsk1;
        int wsk2;
        int pamiec;
        wsk1 = 0;
        wsk2 = 0;
        pamiec = 0;
        int puste;

        for (int a = 1; a <= 8; a++) {
            wsk1 = 0;

            for (int c = 1; c <= 3; c++) {

                for (int b = 1; b <= k; b++) {
                    puste = 0;
                    for (int aa = 1; aa <= 3; aa++) {

                        if (tablica [wygrane[a][ aa]][ 2] ==0) {  puste = 1;    }
                    }
                    if (wygrane [a][ c] == losowanie_tablica1[b] && puste == 1){     wsk1 = wsk1 + 1;    }

                    if (wsk1 >=wsk2) {
                        wsk2 = wsk1;
                        pamiec = a;
                    }
                }
            }
        }
        //'---------------------------------------------
        if (j > 0) {
            int kk;
            kk = 1;

            for (int xx = 1; xx <= 3; xx++) {
                for (int zz = 1;zz <= j; zz++) {

                    if (wygrane [pamiec][ xx] ==losowanie_tablica[zz]) {
                        losowanie_tablica2[kk] = losowanie_tablica[zz];
                        kk = kk + 1;
                    }

                }
            }


            if (kk > 1) {

                double Low;
                double High;
                Low = 1;
                High = kk - 1;

                int los;

                Random r = new Random();
                los = (int) ((High - Low + 1) * r.nextDouble() + Low);
                losowanie2 = losowanie_tablica2[los];
                tablica[losowanie2][1] = 1;
                if (wybor == 1) {
                    wybor_p = 2;
                }
                else {
                    wybor_p = 1;
                }
                tablica[losowanie2][ 2] = wybor_p;
            }
            else{
                losowanie_old();
            }








        }
        else{

            przelicz_wynik();
        }



        return losowanie2;
        //'---------------------------------------------
    }
    //______________________________________________________________________________________________

    //______________________________________________________________________________________________

    //______________________________________________________________________________________________

    //______________________________________________________________________________________________

}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@