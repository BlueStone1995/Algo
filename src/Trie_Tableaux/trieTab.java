/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie_Tableaux;

import java.util.Scanner;

/**
 *
 * @author bluestone
 */
public class trieTab {
    
    static Scanner sc = new Scanner(System.in);
    
    
    public static int[] saisietab(){
        System.out.println("Entrer taille du tableau : ");
        int taille = sc.nextInt();
        int[] t = new int[taille];
        
        for(int i=0; i<t.length; i++){
            System.out.println("Entrer valeur "+i+" : ");
            t[i] = sc.nextInt();
        }
        return t;
    } 
    
    public static void afficher(int[] t){
        System.out.print("[");
        for(int i=0; i<t.length; i++){
            System.out.println(i+" : "+t[i]);
        }
        System.out.println("]");
    }
    
    public static void fusion(int[] t, int deb1, int fin1, int deb2, int fin2){
        int[] tab = new int[fin1-deb1+1];
        for(int i=deb1; i<=fin1; i++){
            tab[i-deb1]=t[i];
        }
        
        int compt1=deb1;
        int compt2=deb2;
        
        for(int j=deb1; j<=fin2; j++){
            if(compt1 == deb2){//Fin tableau de gauche 
                break;
            }else if(compt2 == (fin2+1)){//Fin tableau de droite
                t[j]=tab[compt1-deb1];
            }else if(tab[compt1-deb1] < t[compt2]){
                t[j]=tab[compt1-deb1];
                compt1++;
            }else {
                t[j]=t[compt2];
                compt2++;
            }
        }
        
    }

    public static void triFusion(int[] t, int deb, int fin){
        if(deb != fin){
            int mil = (deb+fin)/2;
            triFusion(t, deb, mil);
            triFusion(t, mil+1, fin);
            
            fusion(t, deb, mil, mil+1, fin);
        }
        
    }
    
    public static void main(String[] args) {
        int[] t = saisietab();
        afficher(t);
        triFusion(t, 0, t.length - 1);
        afficher(t);
    }
}
