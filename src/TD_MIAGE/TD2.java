package TD_MIAGE;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

import java.util.Scanner;

public class TD2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        exo13();
    }

    public static void exo1() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = res + i;
        }
        System.out.println("La somme = " + res);
    }

    public static void exo2() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        System.out.println("n! = " + res);
    }

    public static void exo3() {
        System.out.println("Entrer un entier positif a : ");
        int a = sc.nextInt();
        System.out.println("Entre un entier positif b : ");
        int b = sc.nextInt();
        int res = 0;
        for (int i = 0; i < b; i++) {
            res = res + a;
        }
        System.out.println(a + " * " + b + " = " + res);
    }

    public static void exo4() {// a = b*q + r
        System.out.println("Entrer un entier positif a : ");
        int a = sc.nextInt();
        System.out.println("Entre un entier positif b : ");
        int b = sc.nextInt();
        int q = 0;
        int res = a;
        while (res > b) {
            res = res - b;
            q++;
        }
        System.out.println(a + " = " + b + " * " + q + " + " + res);
    }

    public static void exo5() {
        System.out.println("Entrer un entier positif nb1 : ");
        int nb1 = sc.nextInt();
        System.out.println("Entre un entier positif nb2 : ");
        int nb2 = sc.nextInt();
        int res = 0;
        while (nb1 != nb2) {
            if (nb1 >= nb2) {
                nb1 = nb1 - nb2;
            } else {
                nb2 = nb2 - nb1;
            }
        }

        System.out.println("Le PGCD = " + nb1);
    }

    public static void exo6() {
        System.out.println("Entrer un terme n >= 2 : ");
        int n = sc.nextInt();
        int u0 = 1;
        int u1 = 1;
        int un = 0;

        for (int i = 2; i <= n; i++) {
            un = u0 + u1;
            u0 = u1;
            u1 = un;
        }
        System.out.println("Suite de Fibonacci : un = " + un);
    }

    public static void exo7() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        float res = 0;
        for (int i = 0; i <= n; i++) {
            res = (float) (res + pow(-1, i) * 1 / (1 + 2 * i));
        }
        System.out.println("Le résultat pour n = " + n + " vaut : 4 * " + res * 4);
    }

    public static void exo7Prof() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        int s = 0;
        int num = 1;
        int den = 1;
        for (int i = 1; i <= n; i++) {
            s = s + num / den;
            num = -num;
            den = den + 2;
        }
        System.out.println("Le résultat pour n = " + n + " vaut : 4 * " + s * 4);
    }

    public static float fact(int n) {
        float res = 1;
        if (n == 0) {
            return 1;
        } else {
            for (int i = 1; i <= n; i++) {
                res = res * i;
            }
            return res;
        }
    }

    public static float puiss(float x, int n) {
        float res = 1;
        if (n == 0) {
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
            return res;
        }
    }

    public static void exo8() {//Complexité importante au niveau boucle
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        System.out.println("Entrer un réel x : ");
        float x = sc.nextFloat();
        float res = 0;
        for (int i = 0; i <= n; i++) {
            res = (float) (res + pow(x, i) * (1 / fact(i)));
        }
        System.out.println("La somme pour n = " + n + " et x = " + x + " vaut : " + res);
        System.out.println("Exponentielle de x vaut : " + exp(x));
    }

    public static void exo8Prof() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        System.out.println("Entrer un réel x : ");
        float x = sc.nextFloat();
        double s = 1;
        double px = 1;
        double f = 1;
        for (int i = 1; i <= n; i++) {
            px = px * x; //idem px *=x;
            f = f * i; //f *= i;
            s = s + px / f;
        }
        System.out.println("La somme pour n = " + n + " et x = " + x + " vaut : " + s);
        System.out.println("Exponentielle de x vaut : " + exp(x));
    }

    public static void exo9() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        System.out.println("Entrer le j-ieme chiffre de l'entier n à trouver : ");
        int j = sc.nextInt();
        /* Ma version int res = (int) (n / puiss(10, (j - 1))) % 10; */
        for (int i = 1; i < j; i++) {//Version prof
            n = n / 10;
        }
        System.out.println("Le " + j + "-ieme chiffre de l'entier " + n + " à trouver est : " + (n % 10));
    }

    public static void exo10() {
        int n = 500;
        int a;
        int min = 1;
        int max = 1000;
        do {
            System.out.println("Votre entier n est : " + n + " ?");
            System.out.println("Réponse : 0 = trouvé | 1 = trop petit | 2 = trop grand");
            a = sc.nextInt();
            if (a == 1) {
                min = n;
                n = (max + n) / 2;

            } else if (a == 2) {
                max = n;
                n = (n + min) / 2;
            }
        } while (a != 0);
        System.out.println("Votre entier n est : " + n + " !");
    }

    public static void exo10Prof() {
        int inf = 1;
        int sup = 1000;
        int rep;
        int c = 0;
        do {
            int mil = (inf + sup) / 2;
            System.out.println("Je propose le nb : " + mil);
            System.out.println("Réponse : 0 = trouvé | 1 = trop petit | 2 = trop grand");
            rep = sc.nextInt();
            c++;
            if (rep == 1) {
                inf = mil + 1;//Recherche dichotomique du inf doit etre tj mis à jour
            } else {
                sup = mil;
            }
        } while (rep != 0);
        System.out.println("J'ai trouvé en " + c + " coups !");
    }

    public static void exo11() {
        System.out.println("Entrer un entier n < 1000 : ");
        int n = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= (n / 2); i++) {//Juste besoin de regarder chiffre jusqu'a n/2 reste pas besoin
            if (n % i == 0) {
                res = res + i;
            }
        }
        if (res == n) {
            System.out.println(n + " est un nombre parfait.");
        } else {
            System.out.println(n + " n'est pas un nombre parfait.");
        }
    }

    public static int cube(int n) {
        int res = n * n * n;
        return res;
    }

    public static void exo12() {
        System.out.println("Entrer un entier n compris entre 0 et 999 : ");
        int n = sc.nextInt();//n de la forme n = 153 a=1 b=5 c=3
        int a = n / 100;
        int b = ((n) / 10) % 10;
        int c = n % 10;
        if (n == cube(a) + cube(b) + cube(c)) {
            System.out.println(n + " est un nombre cube.");
        } else {
            System.out.println(n + " n'est pas un nombre cube.");
        }
    }

    public static void exo13() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {//N° de lignes
            for (int j = 1; j <= 2 * n; j++) {//Parcours la ligne i
                if (j <= i || j > 2 * n - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("Yeah bonnet d'âne !");
    }

    public static void exo14() {
        System.out.println("Entrer un entier a : ");
        int a = sc.nextInt();
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        System.out.println("Entrer un réel x0 : ");
        float x0 = sc.nextFloat();
        float xn = 0;
        for (int i = 0; i < n; i++) {
            xn = (float) 1 / 2 * (x0 + a / x0);
            x0 = xn;
        }
        System.out.println("La valeur approchée de la racine carré de " + a + " = " + xn);
        System.out.println("La valeur de la racine carré de " + a + " = " + Math.sqrt(a));
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

    public static void exo15() {
        System.out.println("Entrer un entier n > 0 : ");
        int n = sc.nextInt();
        int res = 1;
        int p = n;
        int i = 2;
        System.out.print("La décomposition en nombre premier de " + n + " = 1");
        do {
            if (p % i == 0) {
                res = res * i;
                p = p / i;
                System.out.print(" * " + i);
            } else {
                do {
                    i++;
                } while (isPremier(i));//Vérifie si i est premier   
            }
        } while (res < n && p >= 0);
        System.out.println();
    }

    public static void exo16Prof() {
        System.out.println("Entrer un entier n : ");
        int n = sc.nextInt();
        System.out.println("Entrer un réel x : ");
        int x = sc.nextInt();
        int p = 1;
        for (int i = 0; i < n; i++) {
            int m = 0;
            for (int j = 0; j < x; j++) {
                m = m + p;//Dans mon a p*x
            }//Mon 2eme for remplace l'expresion p = p*x; avec m = p*x;
            p = m;
        }
        System.out.println("Le résultat x^n = " + p);
    }

}
