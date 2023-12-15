// PurchaseInfo.java
package com.mptei;
import java.io.DataOutput;
import java.io.DataInput;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class PurchaseInfo implements Writable {

    private Text city = new Text();
    private Text type = new Text();
    private DoubleWritable price = new DoubleWritable();
    private Text paymentMethod = new Text();

    // Getters and setters for the fields

    public String getCity() {
        return city.toString();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getType() {
        return type.toString();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public Text getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod.set(paymentMethod);
    }


    @Override
    public void write(DataOutput out) throws IOException {
        city.write(out);
        type.write(out);
        price.write(out);
        paymentMethod.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        city.readFields(in);
        type.readFields(in);
        price.readFields(in);
        paymentMethod.readFields(in);
    }
}

    
    

