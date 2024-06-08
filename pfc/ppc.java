package pfc;

import java.util.Random;
import java.util.Scanner;

public class ppc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String[] pfc = {"pierre","feuille","ciseaux"};
            String ordinateurMouvement = pfc[new Random().nextInt(pfc.length)];
            String joueurUn;
    
            while(true) {
                System.out.println("Que veux tu jouer ? pierre, feuille, ciseaux");
                joueurUn = scanner.nextLine();
                if (joueurUn.equals("pierre")||joueurUn.equals("feuille")|| joueurUn.equals("ciseaux")){
                    break;
                }
                System.out.println(joueurUn + " n'est pas une réponse valide");
            }
            
            System.out.println("l'ordi a joué : " + ordinateurMouvement);
            if (joueurUn.equals(ordinateurMouvement)){
                System.out.println("Egalité !");
            }
            
            else if (joueurUn.equals("pierre")){
                if (ordinateurMouvement.equals("feuille")){
                    System.out.println("Perdu snif...");
                }else if (ordinateurMouvement.equals("ciseaux")){
                    System.out.println("Yeah gagné !");
                }
            }
    
            else if (joueurUn.equals("feuille")){
                if (ordinateurMouvement.equals("pierre")){
                    System.out.println("Yeah gagné !");
                }else if (ordinateurMouvement.equals("ciseaux")){
                    System.out.println("Perdu snif...");
                }
            }
    
            else if (joueurUn.equals("ciseaux")){
                if (ordinateurMouvement.equals("feuille")){
                    System.out.println("Yeah gagné !");
                }else if (ordinateurMouvement.equals("pierre")){
                    System.out.println("Perdu snif...");
                }
            } 

            System.out.println("continuer : oui /non");
            String continuer = scanner.nextLine();

            if (continuer.equals("non")) {
                break;                
            }

    
        }
    }
}