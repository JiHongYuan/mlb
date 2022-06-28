package org.github.mlb.dms.config.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author JiHongYuan
 * @date 2021/9/19 22:21
 */
@Getter
@Setter
public class DataSourceProperties{
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String schema;

    @Override
    public String toString() {
        return "DataSourceConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", schema='" + schema + '\'' +
                '}';
    }
}
