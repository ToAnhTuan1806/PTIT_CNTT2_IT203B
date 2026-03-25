package com.ra.bt.ex4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DashboardService service = new DashboardService();
        List<BenhNhanDTO> ds = service.layDanhSachDashboard();

        for (BenhNhanDTO bn : ds) {
            System.out.println("Benh nhan: " + bn.getTenBenhNhan());

            if (bn.getDsDichVu().isEmpty()) {
                System.out.println("  Chua co dich vu nao");
            } else {
                for (DichVu dv : bn.getDsDichVu()) {
                    System.out.println("  - " + dv.getTenDichVu() + " (" + dv.getLoaiDichVu() + ")");
                }
            }
        }
    }
}

// Phân tích và Đề xuất
/*
1. Input / Output
Input: lấy danh sách bệnh nhân đang điều trị (có thể kèm từ khóa tìm kiếm)
Output: trả về List<BenhNhanDTO>
Mỗi bệnh nhân gồm thông tin cơ bản và danh sách dịch vụ đã sử dụng
Bệnh nhân chưa có dịch vụ vẫn phải hiển thị với danh sách dịch vụ rỗng
*/

/*
2. Đề xuất 2 giải pháp
Giải pháp 1 – Query nhiều lần (N+1 Query)
    Bước 1: query lấy danh sách bệnh nhân
    Bước 2: lặp từng bệnh nhân để query danh sách dịch vụ
    Nếu có 500 bệnh nhân thì sẽ phát sinh khoảng 501 query
    Ưu điểm: code đơn giản, dễ hiểu
Nhược điểm: hiệu năng thấp, dễ gây quá tải database
Giải pháp 2 – LEFT JOIN + gom dữ liệu trong Java
    Dùng một câu SQL LEFT JOIN để lấy toàn bộ dữ liệu một lần
    Sau đó dùng Java gom các dòng cùng bệnh nhân thành một object
    Ưu điểm: giảm số lượng query, tăng tốc độ xử lý
    Ngoài ra LEFT JOIN giúp vẫn hiển thị bệnh nhân chưa có dịch vụ
 */

/*
3. So sánh & lựa chọn
Giải pháp 1:
    Số query nhiều → Network I/O cao → chậm khi dữ liệu lớn
    Code dễ viết nhưng không phù hợp hệ thống thực tế
Giải pháp 2:
    Chỉ dùng 1 query → giảm tải database → phản hồi nhanh hơn
    Xử lý dữ liệu trên Java phức tạp hơn nhưng hiệu quả hơn

Vì Dashboard cần tốc độ cao khi có nhiều bệnh nhân, nên chọn giải pháp 2 là tối ưu nhất
 */


// Thiết kế câu SQL và các bước lặp dữ liệu
/*
1. Thiết kế câu SQL
Sử dụng LEFT JOIN giữa bảng BenhNhan và DichVuSuDung.
Mục đích:
    lấy được tất cả bệnh nhân đang điều trị
    kể cả bệnh nhân chưa có dịch vụ vẫn xuất hiện trên Dashboard
Ví dụ câu SQL:
        SELECT bn.maBenhNhan, bn.tenBenhNhan, bn.ngayNhapVien,
               dv.maDichVu, dv.tenDichVu, dv.loaiDichVu
        FROM BenhNhan bn
        LEFT JOIN DichVuSuDung dv
        ON bn.maBenhNhan = dv.maBenhNhan
        WHERE bn.trangThai = 'DANG_DIEU_TRI'
        ORDER BY bn.maBenhNhan;

2. Các bước lặp dữ liệu trong Java
    B1: thực hiện câu query và lấy ResultSet
    B2: tạo Map<maBenhNhan, BenhNhanDTO> để gom dữ liệu
    B3: duyệt từng dòng trong ResultSet
    B4: nếu bệnh nhân chưa có trong Map thì tạo mới BenhNhanDTO
    B5: kiểm tra dữ liệu dịch vụ:
        nếu có maDichVu thì tạo DichVu và thêm vào dsDichVu
        nếu maDichVu = null thì bỏ qua, danh sách dịch vụ để rỗng
    B6: sau khi lặp xong, lấy toàn bộ Map.values() đưa vào List<BenhNhanDTO> để trả về
 */