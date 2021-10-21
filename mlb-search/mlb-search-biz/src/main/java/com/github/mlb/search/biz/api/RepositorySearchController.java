package com.github.mlb.search.biz.api;

import com.github.mlb.common.utils.Result;
import com.github.mlb.search.biz.repository.service.RepositoryService;
import org.springframework.web.bind.annotation.*;

/**
 * @author JiHongYuan
 * @date 2021/9/18 15:48
 */

@RestController
@RequestMapping("/repository")
public class RepositorySearchController {
    private final RepositoryService repositoryService;

    @GetMapping("/{id}")
    public Result<Object> getOne(@PathVariable("id") Integer id) {
        return Result.ofSuccess(repositoryService.getById(id));
    }

    @GetMapping
    public Result<Object> list(@RequestParam(value = "repositoryName", required = false) String repositoryName,
                               @RequestParam(value = "desc", required = false) String desc) {
        return Result.ofSuccess(repositoryService.listByRepositoryNameAndDesc(repositoryName, desc));
    }

    public RepositorySearchController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

}