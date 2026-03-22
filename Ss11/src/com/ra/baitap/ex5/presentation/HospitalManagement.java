package com.ra.baitap.ex5.presentation;

import com.ra.baitap.ex5.business.DoctorBusiness;
import com.ra.baitap.ex5.model.Doctor;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class HospitalManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DoctorBusiness doctorBusiness = new DoctorBusiness();

    public static void main(String[] args) {
        do {
            // hien thi menu chuc nang
            System.out.println("\n========= HE THONG QUAN LY BENH VIEN RIKKEI-CARE =========");
            System.out.println("1. Xem danh sach bac si");
            System.out.println("2. Them bac si moi");
            System.out.println("3. Thong ke chuyen khoa");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayDoctors();
                    break;
                case "2":
                    addDoctor();
                    break;
                case "3":
                    statisticSpecialization();
                    break;
                case "4":
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 1 den 4.");
            }
        } while (true);
    }

    // hien thi danh sach bac si
    public static void displayDoctors() {
        List<Doctor> doctors = doctorBusiness.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("Danh sach bac si dang trong.");
            return;
        }
        System.out.println("===== DANH SACH BAC SI =====");
        System.out.printf("%-15s %-25s %-20s%n", "Ma so", "Ho ten", "Chuyen khoa");

        // in tung bac si ra man hinh
        for (Doctor doctor : doctors) {
            System.out.printf("%-15s %-25s %-20s%n", doctor.getDoctorId(), doctor.getFullName(), doctor.getSpecialization());
        }
    }

    // nhap thong tin va them bac si moi
    public static void addDoctor() {
        try {
            Doctor doctor = new Doctor();
            System.out.print("Nhap ma bac si: ");
            doctor.setDoctorId(scanner.nextLine());
            System.out.print("Nhap ho ten bac si: ");
            doctor.setFullName(scanner.nextLine());
            System.out.print("Nhap chuyen khoa: ");
            doctor.setSpecialization(scanner.nextLine());
            System.out.print("Nhap ngay truc (yyyy-MM-dd): ");
            String dutyDateStr = scanner.nextLine();

            doctor.setDutyDate(Date.valueOf(dutyDateStr));
            boolean result = doctorBusiness.addDoctor(doctor);
            if (result) {
                System.out.println("Them bac si thanh cong.");
            } else {
                System.out.println("Them bac si that bai.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Sai dinh dang ngay. Vui long nhap theo yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Da xay ra loi: " + e.getMessage());
        }
    }
    // thong ke so luong bac si theo chuyen khoa
    public static void statisticSpecialization() {
        doctorBusiness.statisticDoctorsBySpecialization();
    }
}

// Các kịch bản lỗi có thể xảy ra
/*
1. Nhập trùng mã bác sĩ
doctor_id là khóa chính (Primary Key), nên nếu nhập mã đã tồn tại thì database sẽ báo lỗi trùng khóa

2. Nhập chuyên khoa quá dài
Nếu cột specialization trong DB có giới hạn độ dài, ví dụ VARCHAR(50), mà người dùng nhập vượt quá thì sẽ gây lỗi khi lưu dữ liệu

3. Nhập sai định dạng ngày tháng
Nếu người dùng nhập ngày trực không đúng định dạng như yyyy-MM-dd thì sẽ không chuyển được sang kiểu Date để lưu database

4. Bỏ trống thông tin bắt buộc
Nếu để trống mã bác sĩ, họ tên hoặc chuyên khoa thì dữ liệu không hợp lệ

5. Lỗi kết nối cơ sở dữ liệu
Nếu sai URL, sai tài khoản, sai mật khẩu hoặc MySQL chưa chạy thì chương trình không thể thao tác với DB

6. Nhập menu không hợp lệ
Người dùng có thể nhập chữ thay vì số hoặc nhập số ngoài phạm vi 1–4

7. Bảng Doctors chưa tồn tại
Trong trường hợp database đã tạo nhưng chưa có bảng Doctors, các chức năng xem danh sách, thêm mới hoặc thống kê đều sẽ thất bại
 */
