package org.github.mlb.content.biz.api;

import org.github.mlb.common.utils.Result;
import org.github.mlb.content.api.repository.entity.RepositoryEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author JiHongYuan
 * @date 2021/9/21 21:22
 */

@FeignClient(name = "MLB-SEARCH", url = "127.0.0.1:8200/search")
public interface RepositoryServiceApi {

    /**
     * query by id
     *
     * @param repositoryId id
     * @return repository
     */
    @RequestMapping(method = RequestMethod.GET, value = "/repository/{id}")
    Result<RepositoryEntity> queryRepositoryById(@PathVariable("id") Integer repositoryId);

}