package citibank.handson.producer.partitioning_mechanism;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class MyCustomPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object k, byte[] bytes, Object value, byte[] bytes1, Cluster cluster) {
//        System.out.println("Topic:%s, Key:%s, Value:%s".formatted(topic,(String)k,(String)value));
        System.out.println("Topic:"+topic+" Key:"+k+" Value"+value);
        int numOfPartitions = cluster.partitionCountForTopic(topic);
        System.out.println("Number of partitions configured "+numOfPartitions);
        String key = (String)k;
        if(key.equals("KARNATAKA")){
            return 0;
        }else if(key.equals("TN")){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
