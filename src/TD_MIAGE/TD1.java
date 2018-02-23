package TD_MIAGE;

import java.util.Scanner;
//Ctrl R pour modifier une meme variable
//Source Format pour mettre tout bien

public class TD1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        exo7Prof();
    }

    public static void exo1() {

        System.out.println("Rentrer une valeur x :");
        int x = sc.nextInt();

        System.out.println("Rentrer une valeur y :");
        int y = sc.nextInt();
        int tmp = x;
        x = y;
        y = tmp;
        System.out.println("La valeur x = " + x + "  et la valeur y = " + y);
    }

    public static void exo2() {
        System.out.println("Rentrer une valeur x :");
        int x = sc.nextInt();

        System.out.println("Rentrer une valeur y :");
        int y = sc.nextInt();

        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("La valeur x = " + x + "\n" + "La valeur y = " + y);
    }

    public static void exo3() {
        System.out.println("Rentrer une valeur A :");
        int a = sc.nextInt();
        System.out.println("Rentrer une valeur B :");
        int b = sc.nextInt();
        System.out.println("Rentrer une valeur C :");
        int c = sc.nextInt();
        int tmp = a;
        a = b;
        b = c;
        c = tmp;
        System.out.println("La valeur A = " + a + ", la valeur B = " + b + " et la valeur de C = " + c);
    }

    public static void exo4() {
        System.out.println("Rentrer une valeur A :");
        int a = sc.nextInt();
        System.out.println("Rentrer une valeur B :");
        int b = sc.nextInt();
        System.out.println("Rentrer une valeur C :");
        int c = sc.nextInt();
        if (a >= b) {
            if (c >= a) {
                System.out.println("Le maximum est C = " + c);
            } else {
                System.out.println("Le maximum est A = " + a);
            }
        } else {
            if (c >= b) {
                System.out.println("Le maximum est C = " + c);
            } else {
                System.out.println("Le maximum est B = " + b);
            }
        }
        /*Ou utiliser max=(a>b)? a:b; */
    }

    public static void exo5() {
        System.out.println("Rentrer une valeur A :");
        int a = sc.nextInt();
        System.out.println("Rentrer une valeur B :");
        int b = sc.nextInt();
        System.out.println("Rentrer une valeur C :");
        int c = sc.nextInt();

        if (a >= b && a >= c) {//Cas ou a est le max
            int tmp = a;
            a = c;
            c = tmp;//switch entre a etc

        } else if (b >= a && b >= c) {//Cas ou b est le max
            int tmp1 = b;
            b = c;
            c = tmp1;//switch entre b et c
        }

        if (a >= b) {//switch entre a et b
            int tmp2 = a;
            a = b;
            b = tmp2;
        }

        System.out.println("Trie : A = " + a + ", B = " + b + ", C = " + c);
    }
 


    public static void exo6() {
        int a=21;
        while(a<0 || a>0){
        System.out.println("Rentrer une note sur 20 :");
        a = sc.nextInt();
        }

        System.out.println("La note est : " + a + "/20");

        if (a >= 0 && a < 10) {
            System.out.println("Mention recalé");
        } else {
            if (a < 12) {
                System.out.println("Mention passable");
            } else {
                if (a < 14) {
                    System.out.println("Mention assez bien");
                } else {
                    if (a < 16) {
                        System.out.println("Mention bien");
                    } else {
                        System.out.println("Mention très bien");
                    }
                }
            }
        }
    }

    public static void exo7 () {
        System.out.println("Rentrer un prix en euros :");
        int a = sc.nextInt();

        int b = a / 20;

        int r1 = a % 20;
        int c = a - r1;

        int r2 = r1 % 10;
        int d = r1 - r2;

        int r3 = r2 % 5;
        int e = r2 - r3;

        int r4 = r3 % 2;
        int f = r3 - r4;
        System.out.println("Le prix " + a + " = " + (c / 20) + "*20€ + " + (d / 10) + "*10€ + " + (e / 5) + "*5€ + " + (f / 2) + "*2€ + " + r4 + "*1€");                                     

    }
    
    public static void exo7Prof (){
        System.out.println("Rentrer un prix en euros :");
        int p = sc.nextInt();
        int b = 20;
        do{
            int n = p/b;
            p = p%b;
            System.out.println(n+" billets/pièces de "+b);
            b = b/2;
        }while(p!=0);
    }
}
