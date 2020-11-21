// Databricks notebook source
val x = List.range(1, 46)

// COMMAND ----------

val divBy4 = x.filter(_ % 4 == 0)

// COMMAND ----------

val sumList1 = divBy4.reduce((x, y) => x + y)

// COMMAND ----------

val divBy3Less20 = x.filter(x => x % 3 == 0 && x < 20)

// COMMAND ----------

val squareList = divBy3Less20.map(x => x * x)

// COMMAND ----------

val sumList2 = squareList.reduce((x, y) => x + y)

// COMMAND ----------

def getMax(f: (Int, Int) => Int, x: Int, y: Int): Unit = {
  
  	val result = f(x, y)
  	println(result)
  
  }

// COMMAND ----------

def max(x: Int, y: Int): Int = {
		if (x > y){
			x
		}else{
			y
		}
	} 

// COMMAND ----------

getMax(max, 55, 11)
