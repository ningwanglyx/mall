package com.ke.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ke.mall.model.PmsBrand;
import com.ke.mall.service.IPmsBrandService;
import com.ke.mall.service.impl.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Summary:
 * @Author: YangxingLiu
 * @Since: 2020/2/10 14:52
 */
@RestController
@RequestMapping("/brand")
@Slf4j
@Api(tags = "PmsBrandController", description = "商品品牌管理")
public class PmsBrandController {
    @Autowired
    private IPmsBrandService pmsBrandService;

    @GetMapping("/listAll")
    @ApiOperation(value = "列表查询")
    public JSONObject getBrandList() {
        List<PmsBrand> list = pmsBrandService.listAllBrand();
        JSONObject res = new JSONObject();
        res.put("data", list);
        return res;
    }

    @PutMapping("/create")
    @ApiOperation(value = "新增品牌")
    public JSONObject createBrand(@RequestParam(value = "brand") PmsBrand pmsBrand) {
        Integer res = pmsBrandService.createBrand(pmsBrand);
        JSONObject result = new JSONObject();
        if(res == 1){
            result.put("state", "success");
            return result;
        }
        result.put("state", "shibai");
        return result;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除品牌")
    public JSONObject deleteBrand(@PathVariable("id") Long id) {
        pmsBrandService.deleteBrand(id);
        JSONObject res = new JSONObject();
        res.put("state", "success");
        return res;
    }

    @GetMapping("/detal/{id}")
    @ApiOperation(value = "品牌详情")
    public JSONObject brand(@PathVariable("id") Long id) {
        JSONObject res = new JSONObject();
        List<PmsBrand> list = pmsBrandService.findById(id);
        res.put("data", list);
        return res;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询")
    public JSONObject listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        PageInfo<PmsBrand> list = pmsBrandService.findByPage(pageNum, pageSize);
        JSONObject res = new JSONObject();
        res.put("data", list);
        return res;
    }

    /*@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = demoService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }*/






}
