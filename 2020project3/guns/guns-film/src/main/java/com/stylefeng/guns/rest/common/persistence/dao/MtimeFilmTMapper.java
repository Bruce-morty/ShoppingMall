package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.cinema.vo.FilmInfo;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author pined
 * @since 2020-01-08
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {

    FilmInfo getFilmInfoById(@Param("id") Integer uuid);
}
