package com.Siakad;
import java.nio.file.ClosedWatchServiceException;
import java.util.Scanner;

public class Siakad {
    static int jumlahData = 0;
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];

    public static void tambahData() {
        System.out.println("Silahkan tambah data");
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Nama = ");
        String nama = scan.nextLine();
        System.out.print("Masukan NIM = ");
        String nim = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNama(nama);
        mahasiswa[jumlahData].setNim(nim);
        jumlahData = jumlahData + 1;

    }

    public static void caridata() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih Pencarian");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Pilih Menu = ");
        int cari = scan.nextInt();
        switch (cari) {
            case 1:
                linearSearch ();
            case 2:
                System.out.print("Masukan Nim = ");
                String filterValue=scan.next();
                Integer indexFound=binarySearch(mahasiswa,filterValue,0,jumlahData-1);
                if(indexFound!=null){
                    System.out.println("Masukan data yang anda cari :");
                    System.out.println(" "+ mahasiswa[indexFound].getNama() + mahasiswa[indexFound].getNim());
                }
                else {
                    System.out.println("Data yang dicari tidak ditemukan");
                }
        }
    }

    public static void tampilData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
            i++;
        }
    }

    public static void urutkanData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. QUICK SORT");
        System.out.println("3. SELECTION SORT");
        System.out.println("4. BUBBLE SORT");
        System.out.println("5. SHELL SORT");
        System.out.print("Pilih algoritma = ");
        int algo = scanner.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                quickSort(mahasiswa, 0, jumlahData - 1);
                break;
            }
            case 3: {
                selectionSort();
                break;
            }
            case 4: {
                bubbleSort();
                break;
            }
            case 5: {
                shellSort();
                break;
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for (j = low + 1; j <= high; j++)
            if (arr[j].getNim().compareTo(arr[low].getNim()) <= -1)
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot) {
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void exchangeSort() {

        for (int x = 0; x < jumlahData; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
        for (int x = 0; x < jumlahData - 1; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void bubbleSort() {
        for (int x = 0; x < jumlahData - 1; x++) {
            for (int y = 0; y < jumlahData - x - 1; y++) {
                if (mahasiswa[y].getNim().compareTo(mahasiswa[y + 1].getNim()) >= 1) {
                    Mahasiswa temp = mahasiswa[y];
                    mahasiswa[y] = mahasiswa[y + 1];
                    mahasiswa[y + 1] = temp;
                }
            }
        }
    }

    public static void shellSort() {
        // jarak antara elemen yang dibandingkan
        int gap = jumlahData / 2;
        while (gap > 0) {
            for (int x = gap; x < jumlahData; x++) {
                Mahasiswa current = mahasiswa[x];
                int y = x - gap;

                //posisi
                while (y >= 0 &&mahasiswa[x].getNim().compareTo(current.getNim()) >  0)  {
                    mahasiswa[y + gap] = mahasiswa[y];
                    y -= gap;
                }
                mahasiswa[y + gap] = current;
            }
            gap /= 2;
        }
    }

    public static void linearSearch(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Nama/NIM = ");
        String xdata = scan.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            String temp = mahasiswa[i].getNama();
            String temp2 = mahasiswa[i].getNim();
            if (xdata.equals(temp)){
                System.out.println("Data Ditemukan!!");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
                System.out.println(" ");
            }
            else if (xdata.equals(temp2)){
                System.out.println("Data Ditemukan!!");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
                System.out.println(" ");
            }
        }
    }

    public static Integer binarySearch(Mahasiswa []arr,String filterValue, int low, int high){

        quickSort(mahasiswa,0,jumlahData-1);
        if (low>high){
            return null;
        }

        else {
            int mid=(low+high)/2;
            int temp2 = Integer.parseInt(arr[mid].getNim());
            if(Integer.valueOf(filterValue)==temp2){

                return mid;
            }
            else if(Integer.valueOf(filterValue)>temp2){
                return binarySearch(mahasiswa,filterValue,mid+1,high);

            }
            else{
                return binarySearch(mahasiswa,filterValue,low,mid-1);
            }
        }
    }

    public static void editData(){
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i<jumlahData){
            System.out.print(i+1+ ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan nomer yang ingin Diubah = ");
        int xdata = scan.nextInt() - 1;
        System.out.print("Masukan Nama Baru = ");
        String nama = scan.next();
        System.out.print("Masukan NIM Baru = ");
        String nim = scan.next();

        mahasiswa[xdata].setNama(nama);
        mahasiswa[xdata].setNim(nim);

    }

    public static void hapusData(){

        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j;
        while (i<jumlahData){
            System.out.print(i +1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan nomer yang ingin dihapus = ");
        int xdata = scan.nextInt() - 1;

        System.out.println("Nama : "+mahasiswa[xdata].getNama());
        System.out.println("Nim : "+mahasiswa[xdata].getNim());
        System.out.println("Hapus Data ini? y/n");
        String pil= scan.next();
        if(pil.equalsIgnoreCase("y")){
            mahasiswa[xdata]=null;
            for(i=0;i<jumlahData-1;i++){
                Mahasiswa temp;
                if(mahasiswa[i]==null){
                    temp=mahasiswa[i+1];
                    mahasiswa[i]=mahasiswa[i+1];
                    mahasiswa[i+1]=null;

                }
            }
            jumlahData=jumlahData-1;

            System.out.println("Data Sudah Terhapus!");
        }
        else{

        }
    }

    public static void UAS(){
        if(jumlahData == 0){
            System.out.println("Tidak ada data");
        }else{ //O(1)
            int jarak = jumlahData - 1;
            int susut = 13;
            int urut = 0;
            while(urut == 0){
                jarak = (jarak*10)/susut;
                if(jarak <= 1){
                    jarak = 1;
                    urut = 1;
                    for(int i=0;i+jarak<jumlahData;i++){
                        int temp2 = Integer.parseInt(mahasiswa[i].getNim());
                        int temp3 = Integer.parseInt(mahasiswa[i+jarak].getNim());
                        if(temp2 >(temp3)){
                            Mahasiswa temp = mahasiswa[i];
                            mahasiswa[i] = mahasiswa[i+jarak];
                            mahasiswa[i+jarak] = temp;
                            urut = 0;
                        }
                    }
                }
            }
            System.out.println("Data telah diurutkan silahkan tampilkan data");
        }
    }


        public static void main (String[]args){
            Scanner scan = new Scanner(System.in);
            int menu;
            do {
                System.out.println("Menu Siakad");
                System.out.println("1. Tambah Data");
                System.out.println("2. Lihat Data");
                System.out.println("3. Urutkan Data");
                System.out.println("4. Cari Data");
                System.out.println("5. Edit Data");
                System.out.println("6. Hapus Data");
                System.out.println("7. UAS");
                System.out.println("8. Keluar");
                System.out.print("Pilih menu = ");
                menu = scan.nextInt();
                if (menu == 1) {
                    tambahData();
                } else if (menu == 2) {
                    tampilData();
                } else if (menu == 3) {
                    urutkanData();
                } else if (menu == 4) {
                    caridata();
                } else if (menu == 5) {
                    editData();
                } else if (menu == 6) {
                    hapusData();
                } else if (menu == 7) {
                    UAS();
                }
            } while (menu != 7);
        }
    }


