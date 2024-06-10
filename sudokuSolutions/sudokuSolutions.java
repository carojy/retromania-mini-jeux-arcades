package sudokuSolutions;

public class sudokuSolutions {

    private static final int TAILLE_GRILLE = 9; 
    public static void main(String[] args){

        int[][] grille = {
        {7,0,2,0,5,0,6,0,0},
        {0,0,0,0,0,3,0,0,0},
        {1,0,0,0,0,9,5,0,0},
        {8,0,0,0,0,0,0,9,0},
        {0,4,3,0,0,0,7,5,0},
        {0,9,0,0,0,0,0,0,8},
        {0,0,9,7,0,0,0,0,5},
        {0,0,0,2,0,0,0,0,0},
        {0,0,7,0,4,0,2,0,3}
        };

        affichageGrilleFinale(grille);

        if (solutionGrille(grille)) {
            System.out.println("\n Sudoku solutionné ! \n");
        }
        else {
            System.out.println("Aucune solution possible pour ce sudoku :'( ...");
        }

        affichageGrilleFinale(grille);
    }


    private static void affichageGrilleFinale(int[][]grille){
        for (int rangee = 0 ; rangee < TAILLE_GRILLE ; rangee++){
            if (rangee % 3 == 0 && rangee != 0) {
                System.out.println("---------");
            }
            for (int colonne = 0 ; colonne < TAILLE_GRILLE ; colonne++){
                if (colonne % 3 == 0 && colonne != 0) {
                    System.out.print("|");
                }
                System.out.print(grille[rangee][colonne]);
            }
            System.out.println();
        }
    }


    private static boolean nombreDansRangee(int[][] grille, int nombre, int rangee){
        for(int i=0; i < TAILLE_GRILLE ; i++) {
            if (grille[rangee][i] == nombre){
                return true;
            }
        }
        return false;
    }

    
    private static boolean nombreDansColonne(int[][] grille, int nombre, int colonne){
        for(int i=0; i < TAILLE_GRILLE ; i++) {
            if (grille[i][colonne] == nombre){
                return true;
            }
        }
        return false;
    }


    private static boolean nombreDansCase(int[][] grille, int nombre, int rangee, int colonne){
        int rangeeBox = rangee - rangee % 3;
        int colonneBox = colonne - colonne % 3;

        for (int i = rangeeBox; i < rangeeBox +3 ; i++){
            for (int j = colonneBox; j < colonneBox +3 ; j++){
                if (grille[i][j] == nombre) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean placementValide(int[][] grille, int nombre, int rangee, int colonne){
        return !nombreDansRangee(grille, nombre, rangee) && !nombreDansColonne(grille, nombre, colonne) && !nombreDansCase(grille, nombre, rangee, colonne);
    }


    private static boolean solutionGrille(int[][]grille){
        for (int rangee = 0; rangee < TAILLE_GRILLE ; rangee++){
            for (int colonne = 0 ; colonne < TAILLE_GRILLE ; colonne ++){
                if (grille[rangee][colonne] == 0) {
                    for (int numeroTest =1 ; numeroTest <= TAILLE_GRILLE ; numeroTest++){
                        if (placementValide(grille, numeroTest, rangee, colonne)) {
                            grille[rangee][colonne] = numeroTest;

                            if (solutionGrille(grille)){
                                return true;
                            }
                            else{
                                grille[rangee][colonne] = 0;
                            }
                        }
                    }
                    return false;    
                }
            }
        }
        return true;
    }


    
}
