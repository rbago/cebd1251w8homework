// Databricks notebook source
// MAGIC %scala 
// MAGIC val df = spark.read.format("csv")
// MAGIC   .option("header", "true")
// MAGIC   .option("inferSchema", "true")
// MAGIC   .load("dbfs:/FileStore/tables/insurance.csv")
// MAGIC 
// MAGIC df.show()

// COMMAND ----------

//    Print the size
println(df.count() + " rows")

// COMMAND ----------

// Print sex and count of sex (use group by in sql)
df.createOrReplaceTempView("people")
val dfSex = spark.sql("SELECT COUNT(sex), sex FROM people GROUP BY sex")
dfSex.show()

// COMMAND ----------

// Filter smoker=yes and print again the sex,count of sex
val dfSexSmoker = spark.sql("SELECT COUNT(sex), sex FROM people WHERE smoker='yes' GROUP BY sex")
dfSexSmoker.show()

// COMMAND ----------

// Group by region and sum the charges (in each region), then print rows by descending order (with respect to sum)
val dfReg = spark.sql("SELECT region, SUM(charges) FROM people GROUP BY region ORDER BY SUM(charges) DESC")
dfReg.show()
