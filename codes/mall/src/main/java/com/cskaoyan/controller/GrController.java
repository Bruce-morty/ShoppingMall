package com.cskaoyan.controller;

import com.cskaoyan.bean.Groupon_rules;
import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.CreateGrMsg;
import com.cskaoyan.bean.ListGrCondition;
import com.cskaoyan.service.GrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("admin/groupon")
public class GrController {

    @Autowired
    GrService grService;
@GetMapping("/list")
/**
 * 显示团购规则信息
 */
    public BaseRespVo queryGrMsg(ListGrCondition listGrCondition){
    BaseRespVo<Object> baseRespVo = new BaseRespVo<>();

        Map map = grService.queryGrMsg(listGrCondition);

        baseRespVo.setData(map);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }
    @PostMapping("/create")
    /**
     * 添加团购规则信息
     */
    public BaseRespVo insertGrMsg(@RequestBody CreateGrMsg createGrMsg){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();


        Groupon_rules grouponRules = grService.insertGrMsg(createGrMsg);
        if(grouponRules==null){
            baseRespVo.setErrno(10000);
            baseRespVo.setErrmsg("商品id输入有误");
            return baseRespVo;
        }
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setData(grouponRules);
        return baseRespVo;


    }
    @PostMapping("/delete")
    public BaseRespVo deleteGrMsg(@RequestBody Groupon_rules groupon_rules){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        boolean flag = grService.deleteGrMsg(groupon_rules);
        if(flag==true){
            baseRespVo.setErrno(0);
            baseRespVo.setErrmsg("成功");
            return baseRespVo;
        }
        baseRespVo.setErrno(10000);
        baseRespVo.setErrmsg("失败");
        return baseRespVo;
    }

    @PostMapping("/update")
    public BaseRespVo updateGrMsg(@RequestBody Groupon_rules groupon_rules){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();

        boolean flag = grService.updateGrmsg(groupon_rules);
        if(flag==true){
            baseRespVo.setErrno(0);
            baseRespVo.setErrmsg("成功");
            return baseRespVo;
        }
        baseRespVo.setErrno(10000);
        baseRespVo.setErrmsg("商品id不能修改");
        return baseRespVo;
    }
}
