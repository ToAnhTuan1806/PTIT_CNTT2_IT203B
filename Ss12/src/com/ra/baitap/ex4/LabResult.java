package com.ra.baitap.ex4;

public class LabResult {
    private String patientId;
    private String testName;
    private double resultValue;

    public LabResult(String patientId, String testName, double resultValue) {
        this.patientId = patientId;
        this.testName = testName;
        this.resultValue = resultValue;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getTestName() {
        return testName;
    }

    public double getResultValue() {
        return resultValue;
    }
}
