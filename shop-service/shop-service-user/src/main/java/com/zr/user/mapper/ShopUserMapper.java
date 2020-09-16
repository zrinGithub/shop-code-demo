package com.zr.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zr.user.entity.ShopUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户登录表(ShopUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 15:37:44
 */
@Mapper
public interface ShopUserMapper extends BaseMapper<ShopUser> {
}