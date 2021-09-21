package com.github.mlb.content.biz.controller.repository;

import com.github.mlb.content.api.repository.params.AddOrModifyRepositoryParam;
import com.github.mlb.content.biz.repository.service.RepositoryService;
import com.github.mlb.common.utils.AddOperate;
import com.github.mlb.common.utils.ModifyOperate;
import com.github.mlb.common.utils.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:45
 */
@RestController
@RequestMapping("/content/repository")
public class RepositoryController {

    private final RepositoryService repositoryService;

    @PostMapping
    public Result<Object> add(@Validated(value = {AddOperate.class}) @RequestBody AddOrModifyRepositoryParam addRepositoryParam) {
        repositoryService.addRepository(addRepositoryParam);
        return Result.ofSuccess(null);
    }

    @PutMapping
    public Result<Object> modify(@Validated(value = {ModifyOperate.class}) AddOrModifyRepositoryParam modifyRepositoryParam) {
        repositoryService.modifyRepository(modifyRepositoryParam);
        return Result.ofSuccess(null);
    }


    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

}