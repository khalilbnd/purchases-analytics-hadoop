package com.mptei;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class AnalyticsReducer extends Reducer<Text, PurchaseInfo, Text, Text> {
    private Text result = new Text();

    @Override
    protected void reduce(Text key, Iterable<PurchaseInfo> values, Context context)
            throws IOException, InterruptedException {
        int totalPurchases = 0;
        double totalPurchaseAmount = 0.0;
        Map<String, Integer> purchasesPerType = new HashMap<>();
        Map<String, Integer> purchasesPerCity = new HashMap<>();

        for (PurchaseInfo info : values) {
            totalPurchases++;
            totalPurchaseAmount += info.getPrice();

            // Count purchases per type for each city
            String type = info.getType();
            purchasesPerType.put(type, purchasesPerType.getOrDefault(type, 0) + 1);

            String city = info.getCity();
            purchasesPerCity.put(city, purchasesPerCity.getOrDefault(city, 0) + 1);
        }

        StringBuilder output = new StringBuilder();
        output.append("Total Purchases: ").append(totalPurchases)
                .append("\nTotal Purchase Amount: ").append(totalPurchaseAmount)
                .append("\nPurchases Per Type: ").append(purchasesPerType)
                .append("\nPurchases Per City: ").append(purchasesPerCity);

        result.set(output.toString());
        context.write(key, result);
        System.out.println(result.toString());
    }
}
