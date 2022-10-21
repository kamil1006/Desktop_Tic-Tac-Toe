package tictactoe;


public class Class_przycisk {

    int numer;
    private String[] wartosc;

    public Class_przycisk(){
        wartosc = new String[1];
    }

    public void kasowanie(){
        numer=0;
        wartosc[0]= String.valueOf(0);

    }
    public void przypisanie(int a){
        numer=a;
    }
    public void przypisz( String a){
        wartosc[0]=a;
    }

}