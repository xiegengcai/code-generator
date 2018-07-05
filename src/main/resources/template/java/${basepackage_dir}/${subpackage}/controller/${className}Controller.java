<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.controller;

import cn.leta.common.utils.BeanUtil;
import cn.leta.common.vo.LetaPage;
import cn.leta.common.web.BaseController;
import ${basepackage}.${subpackage}.model.entity.${className};
import ${basepackage}.${subpackage}.service.${className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
<#include "java_imports.include">
@Api(tags = "${table.remarks}操作接口")
@RestController
public SysDepartmentController  ${className}Controller extends BaseController<${className}, ${className}Service>{
	
	@ApiOperation("按ID查询${table.remarks}")
    @GetMapping("/${classNameLower}/{id}")
    public ${className} get(@PathVariable @ApiParam(value = "ID", required = true) int id) {
        return baseService.selectById(id);
    }

    @ApiOperation("增加${table.remarks}")
    @PostMapping("/${classNameLower}")
    public void add(@RequestBody @Valid ${className} ${classNameLower}) {
        baseService.insert(${classNameLower});
    }

    @ApiOperation("按ID删除${table.remarks}")
    @DeleteMapping("/${classNameLower}/{id}")
    public void delete(@PathVariable @ApiParam(value = "ID", required = true) int id) {
        baseService.deleteById(id);
    }

    @ApiOperation("更新${table.remarks}")
    @PutMapping("/${classNameLower}")
    public void edit(@RequestBody  @Valid ${className} ${classNameLower}) {
        baseService.updateById(${classNameLower});
    }
    @ApiOperation("分页查询")
    @GetMapping("/${classNameLower}/query")
    public LetaPage<${className}> query(@RequestBody LetaPage<${className}> letaPage) {
        return BeanUtil.toLetaPage(baseService.selectPage(letaPage.toPage()));
    }
}
