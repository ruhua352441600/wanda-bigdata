package org.wanda.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile("hdfs://localhost:9000/bigdata/hello/00000_0")
    //.map((_,1)).reduceByKey((a,b) => a+b)
    lineRdd.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)
    sc.stop()
  }
}
