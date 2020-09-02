package com.zr.product.web;

import com.zr.product.entity.ShopCategory;
import com.zr.product.service.IShopCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 类别表  前端控制器
 * </p>
 *
 * @author zhangr
 * @since 2020-09-02
 */
@RestController
@RequestMapping("/shopcategory")
@Api("类别")
public class ShopCategoryController {
    @Resource
    private IShopCategoryService shopCategoryService;

    @GetMapping
    @ApiOperation("查询")
    public List<ShopCategory> list() {
        return shopCategoryService.list();
    }
}
