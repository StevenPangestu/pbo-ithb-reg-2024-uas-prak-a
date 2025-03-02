package Model.Classes;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction {

    private int id;
    private int customerId;
    private String packageType;
    private double packageWeight;
    private int totalCost;
    private Date createdAt;
    private String receiptName;
    private String receiptAddress;
    private String receiptPhone;

    public Transaction(int id, int customerId, String packageType, double packageWeight, int totalCost, Date createdAt,
            String receiptName, String receiptAddress, String receiptPhone) {
        this.id = id;
        this.customerId = customerId;
        this.packageType = packageType;
        this.packageWeight = packageWeight;
        this.totalCost = totalCost;
        this.createdAt = createdAt;
        this.receiptName = receiptName;
        this.receiptAddress = receiptAddress;
        this.receiptPhone = receiptPhone;
    }

    public Transaction(String string, String string2, double double1, double double2, Timestamp timestamp,
            Timestamp timestamp2) {
                
    }

    public Transaction() {
        //TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public double getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(double packageWeight) {
        this.packageWeight = packageWeight;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public String getReceiptPhone() {
        return receiptPhone;
    }

    public void setReceiptPhone(String receiptPhone) {
        this.receiptPhone = receiptPhone;
    }

}
