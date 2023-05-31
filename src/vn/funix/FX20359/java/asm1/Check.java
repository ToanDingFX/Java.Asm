package vn.funix.FX20359.java.asm1;

import java.util.Scanner;

public class Check {
    static Scanner sc = new Scanner(System.in);

    public static void checkCCCD() {
        System.out.println("Nhập mã số căn cước công dân: ");
        String congDanId = sc.nextLine();
        String soNgauNhien;
        String queQuan;
        int gioiTinhVaNamSinh;

        while (true) {
            //Kiểm tra định dạng mã số căn cước công dân
            if (kiemTraDinhDang(congDanId)) {
                chucNangCCCD();
                int soChucNang;
                do {
                    soChucNang = sc.nextInt();
                    switch (soChucNang) {
                        case 1:
                            queQuan = kiemTraQueQuan(congDanId);
//
                            System.out.println("Quê quán: " + queQuan);
                            chucNangCCCD();
                            break;
                        case 2:
                            gioiTinhVaNamSinh = kiemTraGioiTinhVaNamSinh(congDanId);
                            System.out.println("thế kỉ: " + gioiTinhVaNamSinh);
                            chucNangCCCD();
                            break;
                        case 3:
                            soNgauNhien = soNgauNhien(congDanId);
                            System.out.println("dãy số ngẫu nhiên: " + soNgauNhien);
                            chucNangCCCD();
                            break;
                        case 0:
                            System.out.println("hẹn gặp lại");
                            System.exit(0);
                        default:
                            System.out.println("vui lòng chọn 0, 1 , 2, 3");


                    }
                } while (true);

            } else {
                System.out.println("Mã số căn cước không hợp lệ vui lòng nhập lại và nhập đúng dãy 12 số");
                congDanId = sc.nextLine();

            }
        }
    }

    public static void chucNangCCCD() {
        System.out.println("chức năng :");
        System.out.println("""
                | 1. Kiem tra noi sinh
                | 2. Kiem tra tuoi, gioi tinh
                | 3. Kiem tra so ngau nhien
                | 0. Thoat""");
        System.out.println("chức năng: ");

    }

    //Kiểm tra mã số căn cước công dân có đúng định dạng hay không
    public static boolean kiemTraDinhDang(String congDanId) {

        if (congDanId.length() != 12) { // Kiểm tra độ dài của chuỗi
            return false;
        }
        // Kiểm tra từng kí tự trong chuỗi
        for (int i = 0; i < congDanId.length(); i++) {
            if (!Character.isDigit(congDanId.charAt(i))) {
                return false;
            }
        }
        return true; // Nếu kiểm tra qua hết được các kí tự và độ dài chuỗi = 12 thì chuỗi này đúng định dạng

    }

    //Lấy thông tin về quê quán từ mã số căn cước công dân
    public static String kiemTraQueQuan(String congDanId) {
        String hometown = congDanId.substring(0, 3);
        return switch (hometown) {
            case "001" -> "Hà Nội";
            case "002" -> "Hà Giang";
            case "004" -> "Cao Bằng";
            case "006" -> "Bắc Kạn";
            case "008" -> "Tuyên Quang";
            case "010" -> "lào Cai";
            case "011" -> "Điện Biên";
            case "012" -> "Lai Châu";
            case "014" -> "Sơn La";
            case "015" -> "Yên Bái";
            case "017" -> "Hòa Bình";
            case "019" -> "Thái Nguyên";
            case "020" -> "Lạng Sơn";
            case "022" -> "Quảng Ninh";
            case "024" -> "Bắc Giang";
            case "025" -> "Phú Thọ";
            case "026" -> "Vĩnh Phúc";
            case "027" -> "Bắc Ninh";
            case "030" -> "Hải Dương";
            case "031" -> "Hải Phòng";
            case "033" -> "Hưng Yên";
            case "034" -> "Thái Bình";
            case "035" -> "Hà Nam";
            case "036" -> "Nam Định";
            case "037" -> "Ninh Bình";
            case "038" -> "Thanh Hóa";
            case "040" -> "Nghệ AN ";
            case "042" -> "Hà Tĩnh";
            case "044" -> "Quảng Bình";
            case "045" -> "Quảng Trị";
            case "046" -> "Thừa Thiên Huế";
            case "048" -> "Đà Nẵng";
            case "049" -> "Quảng Nam";
            case "051" -> "Quảng Ngãi";
            case "052" -> "Bình Định";
            case "054" -> "Phú Yên";
            case "056" -> "Khánh Hòa ";
            case "058" -> "Ninh Thuận";
            case "060" -> "Bình Thuận";
            case "062" -> "Kon Tum";
            case "064" -> "Gia Lai";
            case "066" -> "Đắk Lắk";
            case "067" -> "Đắk Nông";
            case "068" -> "Lâm Đồng";
            case "070" -> "Bình Phước";
            case "072" -> "Tây Ninh ";
            case "074" -> "Bình Dương";
            case "075" -> "Đồng Nai";
            case "077" -> "Bà Rịa-Vũng Tàu";
            case "079" -> "Hồ Chí Minh ";
            case "080" -> "Long An";
            case "082" -> "Tiền Giang";
            case "083" -> "Bến Tre";
            case "084" -> "Trà Vinh";
            case "086" -> "Vĩnh Long";
            case "087" -> "Đồng Tháp";
            case "089" -> "An Giang";
            case "091" -> "Kiên Giang";
            case "092" -> "Cần Thơ";
            case "093" -> "Hậu Giang";
            case "094" -> "Sóc Trăng";
            case "095" -> "Bạc Liêu";
            case "096" -> "Cà Mau";
            default -> "Không xác định";
        };
    }

//    laasy 6 số cuối cùng làm số ngẫu nhiên
    public static String soNgauNhien(String congDanId) {
        return congDanId.substring(6);
    }

    public static int kiemTraGioiTinhVaNamSinh(String congDanId) {


        // Lấy 2 chữ số đầu tiên làm năm sinh
        int birthYear = Integer.parseInt(congDanId.substring(4, 6));
        // Xác định giới tính dựa trên kí tự thứ 4 trong chuỗi số

        int gioiTinh = Integer.parseInt(congDanId.substring(3, 4));

        // Xác định thế kỷ dựa trên năm sinh
        int theKi = 0;
        if ((gioiTinh == 0 || gioiTinh == 1) && birthYear >= 0 && birthYear <= 99) {
            theKi = 20;
        } else if ((gioiTinh == 2 || gioiTinh == 3) && birthYear >= 0 && birthYear <= 99) {
            theKi = 21;
        } else if ((gioiTinh == 4 || gioiTinh == 5) && birthYear >= 0 && birthYear <= 99) {
            theKi = 22;
        } else if ((gioiTinh == 6 || gioiTinh == 7) && birthYear >= 0 && birthYear <= 99) {
            theKi = 23;
        } else if ((gioiTinh == 8 || gioiTinh == 9) && birthYear >= 0 && birthYear <= 99) {
            theKi = 24;
        }


//
        if (theKi == 20) {
            if (gioiTinh == 0) {
                System.out.println("Giới tính: Nam | " + (birthYear + 1900));
            } else {
                System.out.println("Giới tính: Nữ | " + (birthYear + 1900));
            }
        } else if (theKi == 21) {
            if (gioiTinh == 2) {
                System.out.println("Giới tính: Nam | " + (birthYear + 2000));
            } else {
                System.out.println("Giới tính: Nữ | " + (birthYear + 2000));
            }
        } else if (theKi == 22) {
            if (gioiTinh == 4) {
                System.out.println("Giới tính: Nam | " + (birthYear + 2100));
            } else {
                System.out.println("Giới tính: Nữ | " + (birthYear + 2100));
            }
        } else if (theKi == 23) {
            if (gioiTinh == 6) {
                System.out.println("Giới tính: Nam | " + (birthYear + 2200));
            } else {
                System.out.println("Giới tính: Nữ | " + (birthYear + 2200));
            }
        } else if (theKi == 24) {
            if (gioiTinh == 8) {
                System.out.println("Giới tính: Nam | " + (birthYear + 2300));
            } else {
                System.out.println("Giới tính: Nữ | " + (birthYear + 2300));
            }
        } else {
            System.out.println("Không thể xác định giới tính và năm sinh từ chuỗi số.");
        }
        return theKi;
    }

}






