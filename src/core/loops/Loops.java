package core.loops;

public class Loops {
    public static void main(String[] args){
        for(int i =0 ; i<5; i++){
            System.out.println("For loops: "+ i);
        }

        int i = 0 ;
        while(i < 5){
            System.out.println("While loops: "+ i);
            i++;
        }
        int j = 0;
        do {
            System.out.println("Do whiles loops: "+ j);
            j++;
        } while( j < 5);

    }
}
