package org.github.mlb.dms.client;

import org.github.mlb.dms.message.MessageQueuePublisher;
import org.github.mlb.dms.config.properties.DataSourceProperties;
import org.github.mlb.dms.config.properties.SourcesProperties;
import org.github.mlb.dms.listener.BinlogEventListener;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/19 21:35
 */
@Setter
@Component
public class BinlogClient {
    public final SourcesProperties sourcesProperties;
    public final MessageQueuePublisher messageQueuePublisher;

    private List<BinaryLogClient> clients = new ArrayList<>();

    public void start() throws IOException {


        for (BinaryLogClient client : clients) {
            client.registerEventListener(new BinlogEventListener(messageQueuePublisher));
            client.connect();
        }

    }

    public BinlogClient(SourcesProperties sourcesProperties, MessageQueuePublisher messageQueuePublisher) {
        this.sourcesProperties = sourcesProperties;
        this.messageQueuePublisher = messageQueuePublisher;

        initClient();
    }

    void initClient() {
        for (DataSourceProperties dataSourceConfig : sourcesProperties.getSources()) {
            BinaryLogClient client = new BinaryLogClient(dataSourceConfig.getHost(), dataSourceConfig.getPort(), dataSourceConfig.getUsername(), dataSourceConfig.getPassword());
            clients.add(client);
        }
    }

}