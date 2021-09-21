package com.github.mlb.content.biz.category.manger;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mlb.content.api.category.entity.CategoryEntity;
import com.github.mlb.content.biz.category.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

/**
 * @author JiHongYuan
 * @date 2021/9/18 10:27
 */
@Component
public class CategoryManager extends ServiceImpl<CategoryMapper, CategoryEntity> {
}
