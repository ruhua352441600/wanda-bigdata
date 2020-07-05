package org.wanda.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class KafkaProducerData {
    //读取文件流以静态变量读取
    static FileInputStream fis = null;
    static InputStreamReader isr = null;
    static BufferedReader br = null;
    static String tempString = null;
    static int count = 0;
    //kafka Producer 静态变量创建对象
    static Producer<String, String> producer = null;
    static File file = null;
    public static void main(String[] args) throws IOException, InterruptedException {
        //读取文件形成一个持续写入kafka Producer的流
        Properties props = new Properties();
        //kafka BrokerList
        props.put("bootstrap.servers", "localhost:9092");
        //ack "0,1,-1 all"四种，1为文件partition leader完成写入就算完成
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        //必须设置(k,v)的序列化  详情见kafkaProducer 的构造函数
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(props);
        //指定目录
        file = new File("./src/main/resources/data");
        System.out.println(file.getAbsolutePath());
        File[] files = file.listFiles();
        for (File fileNew : files) {
            fis = new FileInputStream(fileNew);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            while ((tempString = br.readLine()) != null) {
                count++;
                //每条消息间隔2秒
                Thread.sleep(100);
                producer.send(new ProducerRecord<String, String>("aa", Integer.toString(count), tempString));
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String timeNow = df.format(new Date());// new Date()为获取当前系统时间
                //发送完成后打印发送数据
                System.out.println(count+" "+timeNow+" "+tempString);
            }
        }
        producer.close();
    }
}
