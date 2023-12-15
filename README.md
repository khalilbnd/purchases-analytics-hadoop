
---

## Project Title: Purchase Analytics with Hadoop MapReduce

### Overview:

The Purchase Analytics with Hadoop MapReduce project is designed to analyze a dataset of purchases and provide valuable insights into customer behavior, transaction patterns, and other key metrics. Leveraging the power of Hadoop's MapReduce framework, the project processes large-scale purchase data to generate meaningful analytics.

### Objectives:

1. **Total Purchase Analysis:**
   - Calculate the total number of purchases.
   - Determine the overall sum of purchase amounts.

2. **Purchase Trends by City:**
   - Analyze the number of purchases made in each city.
   - Identify cities with the highest and lowest purchase activity.

3. **Purchase Types Breakdown:**
   - Classify purchases by type (e.g., online, in-store).
   - Determine the distribution of purchase types across the dataset.

4. **Payment Method Insights:**
   - Examine the prevalence of different payment methods.
   - Understand the preferred payment methods among customers.

5. **Date-wise Purchase Analytics:**
   - Break down purchases by date and time.
   - Identify trends, spikes, or patterns in purchase activity over time.

### Technology Stack:

- **Hadoop Ecosystem:**
  - Utilize the Hadoop Distributed File System (HDFS) for storage.
  - Leverage Hadoop MapReduce for parallel processing and analytics.

- **Java Programming:**
  - Implement MapReduce jobs using Java for efficient data processing.

### Project Components:

1. **Mapper (`AnalyticsMap`):**
   - Extracts relevant information from each purchase record.
   - Emits key-value pairs for further processing.

2. **Reducer (`AnalyticsReducer`):**
   - Aggregates data based on keys (e.g., city, date, type).
   - Performs calculations for total purchases, sums, and other metrics.

3. **Custom Writable (`PurchaseInfo`):**
   - Represents the structure of the data passed between Mapper and Reducer.

4. **Driver Class (`AnalyticsDriver`):**
   - Configures and orchestrates the MapReduce job.
   - Specifies input and output paths and sets up job parameters.

### Expected Output:

The output of the project will consist of detailed analytics reports, including total purchases, purchase trends by city, purchase types breakdown, payment method insights, and date-wise purchase analytics. This information can be valuable for businesses to make informed decisions, understand customer behavior, and optimize their operations.

### Future Enhancements:

Potential enhancements for the project include:
- Integration with additional data sources for a more comprehensive analysis.
- Incorporating machine learning algorithms to predict future purchase trends.
- Building a web-based dashboard for interactive visualization of analytics results.



### Step 1: Set Up Maven Project

Create a new Maven project:

```bash
mvn archetype:generate -DgroupId=com.mptei -DartifactId=purchase-analytics -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Change into the project directory:

```bash
cd purchase-analytics
```

### Download purchases.txt
[purchases.txt](https://drive.google.com/file/d/1qpjtuzJ7IP4G8_xRJC-lRZ0DfaaoC41c/view?usp=sharing)

### Step 2: Update `pom.xml`

Add the Hadoop dependencies to your `pom.xml` file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mptei</groupId>
    <artifactId>purchases</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-common</artifactId>
            <version>3.1.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-mapreduce-client-core</artifactId>
            <version>3.1.0</version>
        </dependency>
    </dependencies>
</project>
```

### Step 3: Create Package and Java Classes

Create the necessary package structure and Java classes in the `src/main/java/com/mptei` directory:

```bash
mkdir -p src/main/java/com/mptei
touch src/main/java/com/mptei/AnalyticsDriver.java
touch src/main/java/com/mptei/AnalyticsMap.java
touch src/main/java/com/mptei/AnalyticsReducer.java
touch src/main/java/com/mptei/PurchaseInfo.java

```

### Step 4: Implement Code

Add your MapReduce code to the respective Java classes (`AnalyticsDriver`, `AnalyticsMap`, `AnalyticsReducer` and `PurchaseInfo`). Adjust the logic based on your specific analytics requirements.

### Step 5: Build the Project

Build the project using Maven:

```bash
mvn clean 
```

```bash
mvn install
```

### Step 6: Upload Input Data to HDFS

Upload your `purchase.txt` file to HDFS:

```bash
hadoop fs -put purchase.txt /purchaseInput
```

### Step 7: Run MapReduce Job

Submit the MapReduce job to Hadoop:

```bash
hadoop jar target/purchase-1.0-SNAPSHOT.jar com.mptei.AnalyticsDriver /purchaseInput /purchaseOutput
```

### Step 8: View Results

Retrieve and inspect the output from HDFS:

```bash
hadoop fs -cat /purchaseOutput/part-r-00000
```

## Result :

```text
...
...
2012-02-15	Total Purchases: 11324
Total Purchase Amount: 2829955.649999986
Purchases Per Type: {Computers=630, DVDs=637, Garden=609, Women's Clothing=616, Pet Supplies=643, Sporting Goods=625, Baby=662, Men's Clothing=635, Consumer Electronics=666, Toys=623, CDs=622, Health and Beauty=650, Video Games=607, Music=612, Cameras=602, Crafts=622, Children's Clothing=632, Books=631}
Purchases Per City: {Milwaukee=130, Cincinnati=102, Fort Worth=109, Austin=125, Spokane=100, Glendale=109, San Jose=105, Aurora=114, San Diego=121, Winston–Salem=121, Lincoln=123, Las Vegas=111, Arlington=93, Boston=129, San Bernardino=108, Kansas City=115, Mesa=107, Seattle=119, Anaheim=103, St. Petersburg=88, Chula Vista=95, Nashville=120, Laredo=111, Fresno=116, Boise=99, Columbus=114, Newark=123, Norfolk=124, Virginia Beach=94, Portland=92, Gilbert=118, Louisville=119, Washington=102, Wichita=97, New Orleans=94, Denver=120, St. Louis=118, Dallas=119, Lubbock=114, Fremont=102, Corpus Christi=112, Raleigh=115, San Antonio=107, Birmingham=119, Chesapeake=133, Reno=102, Baltimore=103, Orlando=113, Toledo=91, Garland=108, Irving=88, Irvine=102, Colorado Springs=101, Henderson=126, Philadelphia=122, Riverside=96, Oklahoma City=118, Greensboro=116, Charlotte=102, Detroit=104, North Las Vegas=116, Tucson=92, Saint Paul=107, Albuquerque=124, Santa Ana=121, Oakland=123, Bakersfield=123, Lexington=110, Memphis=125, Chandler=122, Jacksonville=106, Buffalo=113, Pittsburgh=103, Sacramento=126, Baton Rouge=116, El Paso=116, Rochester=126, Tulsa=111, Hialeah=125, Tampa=121, Durham=91, Fort Wayne=87, Richmond=86, Indianapolis=93, Madison=112, Cleveland=138, Omaha=104, Minneapolis=91, Atlanta=111, Honolulu=111, Phoenix=112, Plano=105, New York=106, Chicago=99, Miami=106, San Francisco=110, Jersey City=109, Long Beach=97, Anchorage=105, Los Angeles=123, Scottsdale=80, Stockton=114, Houston=107}
...
```

### Step 9: Troubleshooting

If you encounter issues, check logs, and consider adding logging statements in your code for debugging.

This structure assumes a basic Maven project structure with the specified package names. Adjust as needed based on your specific project requirements.