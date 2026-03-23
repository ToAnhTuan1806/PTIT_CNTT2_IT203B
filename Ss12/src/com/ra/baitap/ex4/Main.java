package com.ra.baitap.ex4;

import com.ra.baitap.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = DBConnection.openConnection();
        if (conn == null) {
            System.out.println("Khong ket noi duoc CSDL");
            return;
        }
        List<LabResult> results = new ArrayList<>();
        results.add(new LabResult("P01", "Huyet sac to", 13.5));
        results.add(new LabResult("P02", "Bach cau", 7.2));
        results.add(new LabResult("P03", "Tieu cau", 250.0));
        LabResultImporter importer = new LabResultImporter();
        importer.importResults(conn, results);

        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
