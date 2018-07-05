<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service;
import ${basepackage}.${subpackage}.model.entity.${className};
import com.baomidou.mybatisplus.service.IService;
<#include "java_imports.include">

public interface  ${className}Service extends IService<${className}>{

}
