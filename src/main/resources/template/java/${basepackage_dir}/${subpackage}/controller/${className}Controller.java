<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.controller;

import cn.leta.common.Errors;
import cn.leta.common.exception.BizException;
import cn.leta.common.utils.BeanUtil;
import cn.leta.common.vo.LetaPage;
import cn.leta.common.web.BaseController;
import ${basepackage}.${subpackage}.model.entity.${className};
import ${basepackage}.${subpackage}.model.dto.${className}DTO;
import ${basepackage}.${subpackage}.service.${className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * Template Created By Xie Gengcai
 * Auto Generate By Code-Generator
 */
@Api(tags = "${table.remarks}操作接口")
@RestController
public class ${className}Controller extends BaseController<${className}, ${className}Service>{
	
	@ApiOperation("按ID查询${table.remarks}")
    @GetMapping("/${classNameLower}/{id}")
    public ${className}DTO get(@PathVariable @ApiParam(value = "ID", required = true) int id) {
        ${className} ${classNameLower} = baseService.selectById(id);
        if (${classNameLower} == null) {
            throw new BizException(Errors.GLOBAL.DATA_NOT_EXISTED.getCode(), String.format("不存在id=%s的%s记录", id, ${className}.class));
        }
        return BeanUtil.copyProperties(${classNameLower}, new ${className}DTO());
    }

    @ApiOperation("增加${table.remarks}")
    @PostMapping("/${classNameLower}")
    public void add(@RequestBody @Valid ${className}DTO ${classNameLower}) {
        baseService.insert(BeanUtil.copyProperties(${classNameLower}, new ${className}()));
    }

    @ApiOperation("按ID删除${table.remarks}")
    @DeleteMapping("/${classNameLower}/{id}")
    public void delete(@PathVariable @ApiParam(value = "ID", required = true) int id) {
        baseService.deleteById(id);
    }

    @ApiOperation("更新${table.remarks}")
    @PutMapping("/${classNameLower}")
    public void edit(@RequestBody  @Valid ${className}DTO ${classNameLower}) {
        baseService.updateById(BeanUtil.copyProperties(${classNameLower}, new ${className}()));
    }
    // 方法参数LetaPage<${className}>中的泛型仅做toPage()转换用
    @ApiOperation("分页查询")
    @GetMapping("/${classNameLower}/query")
    public LetaPage<${className}DTO> query(@RequestBody LetaPage<${className}> letaPage) {
        return BeanUtil.toLetaPage(baseService.selectPage(letaPage.toPage()), ${className}DTO.class);
    }
}
