package com.TugasPemrograman;
import java.util.Scanner;
public class Penjumlahan {
    public static void main(String[] args) {
        int x;
        int y;
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan nilai x = ");
        x = scan.nextInt();
        System.out.print("Masukan nilai y = ");
        y = scan.nextInt();
        int hasil = x + y;
        System.out.println("Hasil penjumlahan x + y = "+hasil);
    }
}
