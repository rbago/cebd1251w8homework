-- Databricks notebook source
-- MAGIC %fs ls

-- COMMAND ----------

-- MAGIC %fs ls dbfs:/FileStore/tables

-- COMMAND ----------

-- MAGIC %scala 
-- MAGIC val insurance = spark.read.format("csv")
-- MAGIC   .option("header", "true")
-- MAGIC   .option("inferSchema", "true")
-- MAGIC   .load("/FileStore/tables/insurance.csv")
-- MAGIC 
-- MAGIC display(insurance)

-- COMMAND ----------

select age, avg(charges) from insurance_csv group by age;

-- COMMAND ----------

select children, avg(charges) from insurance_csv group by children;

-- COMMAND ----------

-- MAGIC %sql
-- MAGIC -- mode "FAILFAST" will abort file parsing with a RuntimeException if any malformed lines are encountered
-- MAGIC CREATE TABLE insurance2
-- MAGIC   USING csv
-- MAGIC   OPTIONS (path "/FileStore/tables/insurance.csv", header "true", mode "FAILFAST")

-- COMMAND ----------

select sex, count(*) from insurance2 group by 1
