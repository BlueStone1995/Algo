/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD_MIAGE;

import java.util.Scanner;
/**
 *
 * @author Mbape
 */
import java.util.Random;

public class TD3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();*/
        //int[] t = saisietab();
        exo10();
        //exo8Prof(t);
        /*
        System.out.println("La valeur n appartient : " + appartientdicho(t, n));
        System.out.println("Le tableau est trié en ordre croissant : " + trie(t));
        System.out.println("Le tableau est un palindrome : " + palindromesep(t));
        */
    }

    public static int[] saisietab() {
        System.out.println("Entrer la taille du tableau : ");
        int n = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            /*System.out.println("Entrer la valeur " + i + " du tableau : ");
            t[i] = sc.nextInt();*/
            Random rand = new Random();
            t[i] = rand.nextInt();
        }
        return t;
    }

    public static int maxtab(int[] t) {
        int max = t[0];
        for (int i = 0; i < t.length; i++) {
            if (t[i] > max) {
                max = t[i];
            }
        }
        return max;
    }

    public static int[] base2(int n) {
        int[] t = new int[32];
        int res;
        int q = n;
        int i = 0;
        while (q != 0) {
            res = q % 2;
            t[i] = res;
            i++;
            q = q / 2;
            System.out.println("q = " + q + " res = " + res);
        }
        for (int j = i - 1; j >= 0; j--) {//Optimisation prof while(--i>=0)System.out.print(t[i] + " ");
            System.out.print(t[j] + " ");
        }
        return t;
    }

    static boolean appartient(int[] t, int x) {
        int i;
        for (i = 0; i < t.length; i++) {
            if (x == t[i]) {
                return true;
            }
        }//On regarde su quelle condition on sort de la boucle
        /* if(i<t.length){
            System.out.println("Trouvé");
            return true;
        }else {
            System.out.println("Pas trouvé");
            return false;
        }//idem on peut ecrire directement return i<t.length */
        return false;
    }

    static boolean appartientdicho(int[] t, int x) {//Algo bcq plus efficace
        int inf = 0;
        int sup = t.length - 1;
        while (inf != sup) {
            int mil = (inf + sup) / 2;
            if (x > t[mil]) {
                inf = mil + 1;
            } else {
                sup = mil;
            }
        }
        return t[inf] == x;
    }

    static boolean trie(int[] t) {
        for (int i = 1; i < t.length; i++) {
            if (t[i - 1] > t[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean palindrome(int[] t) {
        for (int i = 0; i < t.length / 2; i++) {
            if (t[i] != t[t.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    static boolean palindromesep(int[] t) {//Séparateur = 0
        int i = 0;
        int j = t.length - 1;
        while (i < j) {
            if (t[i] == 0) {
                i++;
            } else {
                if (t[j] == 0) {
                    j--;
                } else {
                    if (t[i] != t[j]) {
                        return false;
                    } else {
                        i++;
                        j++;
                    }
                }
            }
        }
        return true;
    }

    static int polynome(int[] coeff, int x) {
        int px = 1;
        int res = 0;
        for (int i = 0; i < coeff.length; i++) {
            res = coeff[i] * px;
            px = px * x;
        }
        return res;
    }

    static int polynome2(int[] coeff, int x) {//Méthode x*( x*( x*(x(0) + 2) +3) -2) +6
        int res = 0;
        for (int i = coeff.length - 1; i >= 0; i--) {
            res = x * res + coeff[i];
        }
        return res;
    }

    public static boolean isPremier(int n) {
        boolean isPremier = true;
        if (n < 0) {
            isPremier = false;
        } else if (n != 0 && n != 1) {
            for (int i = 2; i <= n / 2; i++) {
                if (n != i && n % i == 0) {
                    isPremier = false;
                    break;
                }
            }
        }
        return isPremier;
    }

    public static void nb_premier() {//Nombre barré < 0
        System.out.println("Entrer un entier max > 0 : ");
        int max = sc.nextInt();
        int[] t = new int[max + 1];
        for (int i = 0; i < t.length; i++) {//Remplit tableau
            t[i] = i;
        }

        for (int j = 0; j < t.length; j++) {
            if (t[j] != -1) {
                System.out.print(t[j] + " ");
                int q = j;
                while (q > 1 && q < t.length) {
                    t[q] = -1;
                    q = q + j;
                }
            }
        }
    }

    public static void exo7Prof(int n) {//Complexité n^2
        boolean[] estBarre = new boolean[n + 1]; //Initialisé a false
        estBarre[0] = estBarre[1] = true;
        for (int i = 2; i < estBarre.length; i++) {
            if (!estBarre[i]) {
                System.out.print(i + " ");
                for (int j = i + i; j < estBarre.length; j += i) {//j=j+i
                    estBarre[j] = true;
                }
            }
        }
        System.out.println();
    }//Cette fonction permet ensuite de savoir si un nombre est premier en regardant l'indice du tableau

    public static void exo8(int[] t) {
        int som = 0;
        int i = 0;
        int sommax = t[0];
        int inf = 0;
        int sup = t.length - 1;

        while (i < t.length) {
            som += t[i];
            if (som < 0) {
                som = 0;
                inf = i + 1;//indice début
            } else if (som > sommax) {
                sommax = som;
                sup = i;
            }
            i++;
        }
        System.out.println("Ma somme maximal = " + sommax);
        System.out.println("Indices sous-tableau : début = " + inf + " et fin = " + sup);
    }

    public static void exo8Prof(int[] t) {
        int somMax = 0;
        int debMax = 0;
        int finMax = 0;
        int deb = 0;
        int som = 0;
        for (int fin = 0; fin < t.length; fin++) {
            som += t[fin];
            if (som >= somMax) {
                somMax = som;
                debMax = deb;
                finMax = fin;
            }
            if (som < 0) {
                som = 0;
                deb = fin + 1;
            }
        }
        System.out.println("Ma somme maximal = " + somMax);
        System.out.println("Indices sous-tableau : début = " + debMax + " et fin = " + finMax);
    }

    public static void exo9Prof() {//Complexité exponentiel
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        int[] t = new int[n];
        int l = n;

        for (int i = 0; i < t.length; i++) {//Initialisation de mon tableau
            t[i] = 1;
        }

        for (;;) {//Boucle infinie

            for (int i = 0; i < l; i++) {
                System.out.print(t[i] + " ");
            }
            System.out.println();

            if (l == 1) {
                break;
            }

            l--;
            t[l - 1]++;//On incrémente l'avant dernier
            int nb1 = t[l] - 1;

            for (int k = 1; k <= nb1; k++) {
                t[l++] = 1;//Ecrit à l'indice l et incrémente l++
            }

            //Ou bien cette boucle au lieu du for
            /*
            t[l] = 1;//On met 1 seul 1 dans la droite
            l+= nb1; 
            On parle d'invariante de boucle car on a que des 1 dans le reste du tableau à droite
             */
        }
    }

    public static void exo10() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        System.out.println("Entrer un entier p : ");
        int p = sc.nextInt();
        int[] t = new int[p];

        for (int i = 0; i < t.length; i++) {//Initialisation tableau
            t[i] = i;
        }
                
        for (;;) {
            for (int i = 0; i < t.length; i++) {//Affiche sous-ensemble
                System.out.print(t[i] + " ");
            }
            System.out.println();
           
            if(t[0] == n-p){//Condition d'arrêt
                break;
            }
            
            int j = p-1;//Derniere case de mon tableau
            while(t[j] == n-p+j){//Je me decale à gauche si atteint valeur max
                j--;
            }
            t[j]++;
            for(int k=j; k<p-1; k++){//Remplace ma case juste apres pour avoir suite tj croissante
                t[k+1] = t[k]+1;
            }
        }
    }
}
