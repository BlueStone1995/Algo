package Matrice_3x3;

public class TrieTab3x3 {

    public static void main(String[] args) {
        //int[][] matrice = new int[3][3];
        int val = 1;

        //Remplis matrice
        /*for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = val;
                val++;
            }
        }*/

        int[][] matrice = {
                {4, 3, 6},
                {2, 5, 1},
                {8, 9, 7}
        };

        afficher(matrice);
        int[][] matriceOK = trieMatrice(matrice);
        afficher(matriceOK);
    }


    //Méthode afficher
    static void afficher(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Méthode trie matrice avec ensemble des switch possible
    static int[][] trieMatrice(int[][] t) {
        int count = 0;
        do {
            //Switch condition somme = 10

            if(t[0][0] + t[2][2] != 10){
                change(t, 0, 0, 0, 1);
                change(t, 2, 1, 2, 2); //h1
            }//d1

            if(t[0][2] + t[2][0] != 10){
                change(t, 1, 0, 2, 0);
                change(t, 0, 2, 1, 2); //v2
            }//d2

            if(t[0][1] + t[2][1] != 10) {
                change(t, 0, 1, 0, 2);
                change(t, 2, 0, 2, 1); //h2
            }//v3

            if(t[1][0] + t[1][2] != 10) {
                change(t, 0, 0, 1, 0);
                change(t, 1, 2, 2, 2); //v1
            }//h4


            //change(t, 0, 0, 2, 2);//d1


            //change(t, 0, 2, 2, 0);//d2

            //change(t, 1, 0, 1, 2);//hs


            //change(t, 0, 1, 2, 1);//vs

            System.out.println("tj dans boucle while");
        } while (condition(t));
        return t;
    }

    //Méthode condition
    static boolean condition(int[][] t) {



        //Cas lignes 0 et 2
        for (int i = 0; i < t.length; i = (i + 2)) {// saute le cas i=1
            int som = 0;
            for (int j = 0; j < t[i].length; j++) {
                som += t[i][j];
            }
            if (som != 15){

                return true;
            }
        }

        //Cas colonne 0 et 2
        for (int c = 0; c < 3; c = (c + 2)) {// saute le cas c=1
            int som = 0;
            for (int i = 0; i < 3; i++) {
                som += t[i][c];
            }
            if (som != 15) return true;
        }
        return false; //arrete boucle while
    }

    //Méthode switch
    static void change(int[][] t, int i1, int i2, int j1, int j2) {
        int tmp = t[i1][i2];
        t[i1][i2] = t[j1][j2];
        t[j1][j2] = tmp;
    }
}