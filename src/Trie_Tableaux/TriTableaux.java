package Trie_Tableaux;

import java.util.Random;
import java.util.Scanner;

public class TriTableaux {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] t = saisietab();
        triFusion(t, 0, t.length - 1);
        afficher(t);
    }

    public static int[] saisietab() {
        System.out.println("Entrer la taille du tableau : ");
        int n = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < t.length; i++) {
            System.out.println("Entrer la valeur " + i + " du tableau : ");
            t[i] = sc.nextInt();
            //Random rand = new Random();
            //t[i] = rand.nextInt();
        }
        return t;
    }

    public static void afficher(int[] t) {
        System.out.print("[ ");
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.print("]");
    }

    public static void triPermutation(int[] t) {//Complexité n^2
        //Fin du tableau est trié petit à petit jusqu'au début
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i] > t[i + 1]) {
                int tmp = t[i];
                t[i] = t[i + 1];
                t[i + 1] = tmp;
            }
        }
    }

    public static void triExtraction(int[] t) {//Complexité n^2 mais plus rapide que précedent 
        for (int i = 0; i < t.length; i++) {
            int imin = i;//On cherche le numéros de case ou il y a le min  
            for (int j = i; j < t.length; j++) {
                if (t[j] > t[imin]) {
                    imin = j;
                }
            }
            //On echange le min avec la case ou l'on se trouve
            int tmp = t[i];
            t[i] = t[imin];
            t[imin] = tmp;
        }
    }

    public static void triInsertion(int[] t) {//Complexité n^2
        for (int i = 0; i < t.length; i++) {
            //Je switch à chaque case quand mon inégalité vraie
            for (int k = i - 1; k >= 0 && t[k + 1] < t[k]; k--) {
                int tmp = t[k + 1];
                t[k + 1] = t[k];
                t[k] = tmp;
            }
        }
    }

    //Tri fusion complexité nlog(n)
    public static void fusion(int[] t, int deb1, int fin1, int fin2) {
        //On récupère début et fin des deux tableaux
        int deb2 = fin1 + 1;
        
        //On crée nouveau tableau de taille équivalent à mon tab1
        int[] tab = new int[fin1 - deb1 + 1];
        for (int i = deb1; i <= fin1; i++) {
            tab[i - deb1] = t[i];
        }

        int compt1 = deb1;
        int compt2 = deb2;
        
        for (int j = deb1; j <= fin2; j++) {//Parcours tableau entier
            if (compt1 == deb2) {//Fin tableau de gauche
                break;
            } else if (compt2 == (fin2 + 1)) {//Fin tableau de droite, je recopie alors le reste dans mon tableau t
                t[j] = tab[compt1 - deb1];
                compt1++;
            } else if (tab[compt1 - deb1] < t[compt2]) {//Complète mon tableau t en foction du + petit
                t[j] = tab[compt1 - deb1];
                compt1++;
            } else {
                t[j] = t[compt2];
                compt2++;
            }
        }
    }
    
    //Méthode principale
    public static void triFusion(int[] t, int deb, int fin) {
        if (deb != fin) {
            
            //On sépare le tableaux en 2
            int mil = (deb + fin) / 2;
            
            //On sépare chaque tableaux pour se retrouver avec un seul élement de façon récursive
            triFusion(t, deb, mil);
            triFusion(t, mil + 1, fin);
            
            //On fusionne les tableaux et/ou cellule du tableaux
            fusion(t, deb, mil, fin);
        }
    }
}
