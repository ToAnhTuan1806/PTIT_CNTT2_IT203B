package com.ra.bt.ex4;

import com.ra.bt.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DashboardService {

    public List<BenhNhanDTO> layDanhSachDashboard() {
        List<BenhNhanDTO> result = new ArrayList<>();
        Map<Integer, BenhNhanDTO> mapBenhNhan = new LinkedHashMap<>();

        String sql = """
                SELECT bn.maBenhNhan, bn.tenBenhNhan, bn.ngayNhapVien, dv.maDichVu, dv.tenDichVu, dv.loaiDichVu
                FROM BenhNhan bn
                LEFT JOIN DichVuSuDung dv
                    ON bn.maBenhNhan = dv.maBenhNhan
                WHERE bn.trangThai = 'DANG_DIEU_TRI'
                ORDER BY bn.maBenhNhan
                """;

        try (
                Connection conn = DBConnection.openConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                int maBenhNhan = rs.getInt("maBenhNhan");

                BenhNhanDTO benhNhan = mapBenhNhan.get(maBenhNhan);

                if (benhNhan == null) {
                    benhNhan = new BenhNhanDTO();
                    benhNhan.setMaBenhNhan(maBenhNhan);
                    benhNhan.setTenBenhNhan(rs.getString("tenBenhNhan"));
                    benhNhan.setNgayNhapVien(rs.getString("ngayNhapVien"));
                    mapBenhNhan.put(maBenhNhan, benhNhan);
                }

                // Xu ly Bay 2:
                // Neu benh nhan chua co dich vu thi LEFT JOIN van tra ra 1 dong
                // nhung cac cot cua bang DichVuSuDung se la null.
                // Can kiem tra maDichVu khac null moi tao doi tuong DichVu,
                // neu khong se de dsDichVu rong va van hien thi benh nhan.
                Integer maDichVu = rs.getObject("maDichVu", Integer.class);

                if (maDichVu != null) {
                    DichVu dichVu = new DichVu();
                    dichVu.setMaDichVu(maDichVu);
                    dichVu.setTenDichVu(rs.getString("tenDichVu"));
                    dichVu.setLoaiDichVu(rs.getString("loaiDichVu"));

                    benhNhan.getDsDichVu().add(dichVu);
                }
            }

            result = new ArrayList<>(mapBenhNhan.values());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

