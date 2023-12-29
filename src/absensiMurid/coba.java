package absensiMurid;

import java.util.*;
import java.text.*;

public class coba {

    static Scanner input = new Scanner(System.in);
    static ArrayList muridMasuk = new ArrayList<>();
    static ArrayList muridPulang = new ArrayList<>();
    static ArrayList tanggalMasuk = new ArrayList<>();
    static ArrayList tanggalPulang = new ArrayList<>();
    static boolean isRuning = true;

    static murid obj = new murid();

    static void menu() {
        System.out.println("===============================================");
        System.out.println("                   Absensi Murid");
        System.out.println("===============================================");
        show();
        System.out.println("Menu: ");
        System.out.println("[1] Masuk");
        System.out.println("[2] Pulang");
        System.out.println("[3] Reset");
        System.out.println("[4] Exit");
        System.out.print("Pilihamu> ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                masuk();
                break;

            case 2:
                pulang();
                break;

            case 3:
                reset();
                break;

            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("Pilihan invalid!");
                break;
        }
    }

    static void show() {
        System.out.println("Murid Masuk");
        System.out.println("===============================================");
        System.out.printf("| %-2s | %-15s | %-20s | \n", "No", "Nama Murid", "Waktu Masuk");
        System.out.println("===============================================");
        for (int i = 0; i < muridMasuk.size(); i++) {
            System.out.printf("| %-2s | %-15s | %-20s | \n", (i + 1), muridMasuk.get(i), tanggalMasuk.get(i));
            System.out.println("===============================================");
        }

        System.out.println("Murid Pulang");
        System.out.println("===============================================");
        System.out.printf("| %-2s | %-15s | %-20s | \n", "No", "Nama Murid", "Waktu Pulang");
        System.out.println("===============================================");
        for (int i = 0; i < muridPulang.size(); i++) {
            System.out.printf("| %-2s | %-15s | %-20s | \n", (i + 1), muridPulang.get(i), tanggalPulang.get(i));
            System.out.println("===============================================");
        }
    }

    static void masuk() {
        System.out.print("Nama murid> ");
        obj.setNama(input.next());
        muridMasuk.add(obj.getNama());
        obj.setTanggal(new Date());
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date tanggal = obj.getTanggal();
        tanggalMasuk.add(ft.format(tanggal));
        System.out.println("Berhasil!");
    }

    static void pulang() {
        if (muridMasuk.isEmpty()) {
            System.out.println("Belum ada murid yang masuk!");
        } else {
            System.out.print("Masukkan nama murid yang sudah pulang> ");
            obj.setNama(input.next());
            if (obj.getNama().equals(obj.getNama())) {
                muridMasuk.remove(obj.getNama());
                tanggalPulang.remove(obj.getTanggal());
                muridPulang.add(obj.getNama());
                obj.setTanggal(new Date());
                SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                Date tanggal = obj.getTanggal();
                tanggalPulang.add(ft.format(tanggal));
                System.out.println("Berhasil!");
            }
        }
    }

    static void reset(){
        muridMasuk.clear();
        muridPulang.clear();
        tanggalMasuk.clear();
        tanggalPulang.clear();
        System.out.println("Berhasil!");
    }

    public static void main(String[] args) {
        do{
            menu();
        }while(isRuning);
    }

}
