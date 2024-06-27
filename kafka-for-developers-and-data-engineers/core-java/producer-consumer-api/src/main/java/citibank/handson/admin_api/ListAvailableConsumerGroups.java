package citibank.handson.admin_api;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListConsumerGroupsResult;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ListAvailableConsumerGroups {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        AdminClient adminClient = AdminClient.create(properties);
        ListConsumerGroupsResult consumerGroups = adminClient.listConsumerGroups();
        consumerGroups.all().get().forEach(group -> System.out.println(group.groupId()));
    }
}
