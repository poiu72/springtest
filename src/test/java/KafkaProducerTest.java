import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by feng on 2017/5/29.
 */
public class KafkaProducerTest
{
    private static Producer<String, String> producer;
    private final Map propertyMap = new HashMap();

    public KafkaProducerTest() {
        propertyMap.put("bootstrap.servers", "localhost:9092");
        propertyMap.put("serializer.class", "kafka.serializer.StringEncoder");
        propertyMap.put("request.required.acks", "1");

        // create instance for properties to access producer configs
        Properties props = new Properties();

        //Assign localhost id
        props.put("bootstrap.servers", "localhost:9092");

        //Set acknowledgements for producer requests.
        props.put("acks", "all");

                //If the request fails, the producer can automatically retry,
                props.put("retries", 0);

        //Specify buffer size in config
        props.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);

    }

    public static void main(String[] args) {
        new KafkaProducerTest();
        String topicName = "topicName1";
        String msgKey = "topic message key 1";
        String msgValue = "topic message value 1";

        ProducerRecord producerRecord = new ProducerRecord<>(topicName,
                msgKey, msgValue);
        producer.send(producerRecord);

        for(int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>(topicName,
                    Integer.toString(i), Integer.toString(i)));
        System.out.println("Message sent successfully");
        producer.close();
    }
}


