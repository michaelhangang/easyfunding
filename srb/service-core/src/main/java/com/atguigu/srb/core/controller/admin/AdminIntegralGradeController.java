package com.atguigu.srb.core.controller.admin;

import com.atguigu.common.exception.Assert;
import com.atguigu.common.result.R;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation("Point level list")
    @GetMapping("/list")
    public R listAll() {
        List<IntegralGrade> list = integralGradeService.list();

        return R.ok().data("list",list);
    }

    @ApiOperation(value = "Delete points level by id", notes="Logic Delete")
    @DeleteMapping("/remove/{id}")
    public R removeById(@PathVariable Long id){
        boolean result = integralGradeService.removeById(id);
        if(result){
            //return R.setResult(ResponseEnum.UPLOAD_ERROR);
            return R.ok().message("Deleted successfully");
        }else{
            return R.error().message("Deleted failed");
        }
    }

    @ApiOperation("Add points level")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "Points level object", required = true)
            @RequestBody IntegralGrade integralGrade){

        Assert.notNull(integralGrade.getBorrowAmount(), ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        boolean result = integralGradeService.save(integralGrade);
        if (result) {
            return R.ok().message("Saved successfully");
        } else {
            return R.error().message("Saved failed");
        }
    }

    @ApiOperation("Get points level by id")
    @GetMapping("/get/{id}")
    public R getById(
            @ApiParam(value = "Data id", required = true, example = "1")
            @PathVariable Long id
    ){
        IntegralGrade integralGrade = integralGradeService.getById(id);
        if(integralGrade != null){
            return R.ok().data("record", integralGrade);
        }else{
            return R.error().message("Data does not exist");
        }
    }

    @ApiOperation("Update points level")
    @PutMapping("/update")
    public R updateById(
            @ApiParam(value = "Points level object", required = true)
            @RequestBody IntegralGrade integralGrade){
        boolean result = integralGradeService.updateById(integralGrade);
        if(result){
            return R.ok().message("Successfully modified");
        }else{
            return R.error().message("failed edit");
        }
    }
}
