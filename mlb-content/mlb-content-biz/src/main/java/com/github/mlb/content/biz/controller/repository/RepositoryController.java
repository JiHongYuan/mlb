package com.github.mlb.content.biz.controller.repository;

import com.github.mlb.content.api.repository.entity.RepositoryEntity;
import com.github.mlb.content.api.repository.param.AddOrModifyRepositoryParam;
import com.github.mlb.content.api.repository.param.QueryRepositoryParam;
import com.github.mlb.content.biz.repository.service.RepositoryService;
import com.github.mlb.common.utils.AddOperate;
import com.github.mlb.common.utils.ModifyOperate;
import com.github.mlb.common.utils.Result;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JiHongYuan
 * @date 2021/9/18 9:45
 */
@AllArgsConstructor
@RestController
@RequestMapping("/repository")
public class RepositoryController {

    private final RepositoryService repositoryService;

    @GetMapping("/{repositoryId}")
    public Result<RepositoryEntity> get(@PathVariable("repositoryId") Long repositoryId) {
        return Result.ofSuccess(repositoryService.getByRepositoryId(repositoryId));
    }

    @GetMapping
    public Result<List<RepositoryEntity>> list(@RequestParam QueryRepositoryParam param) {
        return Result.ofSuccess(repositoryService.listByParam(param));
    }

    @PostMapping
    public Result<RepositoryEntity> add(@Validated(value = {AddOperate.class}) @RequestBody AddOrModifyRepositoryParam param) {
        return Result.ofSuccess(repositoryService.add(param));
    }

    @PutMapping
    public Result<RepositoryEntity> update(@Validated(value = {ModifyOperate.class}) @RequestBody AddOrModifyRepositoryParam param) {
        return Result.ofSuccess(repositoryService.updateById(param));
    }

    @DeleteMapping("/{repositoryId}")
    public Result<Long> delete(@PathVariable("repositoryId") Long repositoryId) {
        repositoryService.removeByRepositoryId(repositoryId);
        return Result.ofSuccess(repositoryId);
    }

}