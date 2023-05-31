package vn.funix.FX20359.java.asm1;

import java.util.Scanner;

public class Asm01 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("+------------+---------------------------+------------+");
        System.out.println("| NGAN HANG SO | FX20359@V1.0.0                       |");
        System.out.println("+------------+---------------------------+------------+");
        System.out.println("| 1. nhap CCCD                                        |");
        System.out.println("| 2. thoat                                            |");
        System.out.println("+------------+---------------------------+------------+");
        System.out.println("Chức năng : ");
        chucNang();
    }


    public static void chucNang() {
        int choose;
        while (true) {
            try {
                choose = Integer.parseInt(sc.nextLine());
                if (choose == 1 || choose == 2) {
                    break;
                } else {
                    System.out.println("vui lòng nhập 1 hoặc 2");
                }
            } catch (Exception e) {
                System.out.println("Không đúng định dạng số, vui lòng nhập 1 hoặc 2");
            }
        }

        if (choose == 1) {
            maXacThuc();
        }

        if (choose == 2) {
            System.out.println("hẹn gặp lại");
            System.exit(0);
        }
    }


    public static void maXacThuc() {
        int code = (int) ((Math.random() * 899) + 100);
        System.out.println("Vui lòng nhập mã xác thực: " + code);

        int choose;
        while (true) {
            try {
                choose = Integer.parseInt(sc.nextLine());
                if (choose == code) {
                    break;
                } else {
                    System.out.println("Mã xác nhận không đúng vui lòng nhập lại: ");
                }
            } catch (Exception e) {
                System.out.println("Không đúng định dạng số, vui lòng nhập đúng số");
            }
        }

        Check.checkCCCD();
    }

}







