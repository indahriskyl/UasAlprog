package com.TugasPemrograman;
import java.util.Scanner;
public class Percabangan {
    public static void main (String[] args) {
        String nama;
        int nilai;
        String keterangan;
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukan Nama: ");
        nama = inp.next();
        System.out.print("Masukan Nilai: ");
        nilai = inp.nextInt();
        if (nilai>=60) {
            keterangan = "Lulus";
        }
        else {
            keterangan = "Tidak Lulus";
        }
        System.out.println("Nama : " + nama);
        System.out.println("Keterangan : " + keterangan);
        }
}


