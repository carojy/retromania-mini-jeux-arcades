package justePrix;

import java.util.Random;
import java.util.Scanner;

public class justePrix {

    public static void main(String[] args){
        Random aleatoire = new Random();
        int justePrix = aleatoire.nextInt(200);
        int prix = 0;
        int essais = 0;

        System.out.println("Entre un nombre entre 0 et 200");
        
        while (justePrix != prix) {
            Scanner scan = new Scanner(System.in);
            prix = scan.nextInt();

            if (justePrix > prix) {
                System.out.println("C'est plus !");
            } else if (justePrix < prix) {
                System.out.println("C'est moins !");
            }

            essais ++;
        }

        System.out.println("Bravo, le juste prix est bien " + justePrix + " ! Tu as trouvé en " + essais + " essais :)");
    }
}

