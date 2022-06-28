package org.github.mlb.dms.listener;

import org.github.mlb.common.enums.QueueMessageEnum;
import org.github.mlb.common.model.BinlogDTO;
import org.github.mlb.common.model.QueueMessage;
import org.github.mlb.dms.message.MessageQueuePublisher;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventData;


/**
 * @author JiHongYuan
 * @date 2021/9/19 22:57
 */
public class BinlogEventListener implements BinaryLogClient.EventListener {

    private final MessageQueuePublisher messageQueuePublisher;
    private final EventHandlerAdapter handlerAdapter;

    public BinlogEventListener(MessageQueuePublisher messageQueuePublisher) {
        handlerAdapter = new EventHandlerAdapter();
        this.messageQueuePublisher = messageQueuePublisher;
    }

    @Override
    public void onEvent(Event event) {
        EventData data = event.getData();

        BinlogDTO binlogDTO = handlerAdapter.handler(data);
        if (binlogDTO == null) {
            return;
        }

        // MQ 发布
        QueueMessage queueMessage = new QueueMessage();
        queueMessage.setType(QueueMessageEnum.BINLOG_SYNC);
        queueMessage.setBody(binlogDTO);
        messageQueuePublisher.publish(queueMessage);
    }

}