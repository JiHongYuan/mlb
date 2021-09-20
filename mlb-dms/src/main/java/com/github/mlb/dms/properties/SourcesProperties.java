package com.github.mlb.dms.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/19 22:23
 */
@Getter
@Setter
@Configurable
@ConfigurationProperties(prefix = "client")
public class SourcesProperties {

    public List<DataSourceProperties> sources;

    @Override
    public String toString() {
        return "SourcesConfig{" +
                "sources=" + sources +
                '}';
    }
}