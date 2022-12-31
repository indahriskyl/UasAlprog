package com.TugasPemrograman;
import java.util.Scanner;

public class Bintang {

    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nilai n = ");
        int n = input.nextInt();
        char cetak[][] = new char[n][n];

        for (int b = 0; b < n; b++){
            for(int k=0;k<n;k++) {
                if (b == k || b + k == n - 1) {
                    cetak[b][k] = '*';
                } else {
                    cetak[b][k] = ' ';
                }
                System.out.print(cetak[b][k]);
            }
            System.out.println ();
                }
        }
}



