package com.mptei;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class AnalyticsMap extends Mapper<LongWritable, Text, Text, PurchaseInfo>{
    private Text date = new Text();
    private PurchaseInfo purchaseInfo = new PurchaseInfo();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split("\t");
        if (fields.length == 6) {
            date.set(fields[0]);
            purchaseInfo.setCity(fields[2]);
            purchaseInfo.setType(fields[3]);
            purchaseInfo.setPrice(Double.parseDouble(fields[4]));
            purchaseInfo.setPaymentMethod(fields[5]);
            context.write(date, purchaseInfo);
        }
    }
}
