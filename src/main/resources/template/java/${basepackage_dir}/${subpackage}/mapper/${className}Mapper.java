<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.mapper;
import ${basepackage}.${subpackage}.model.entity.${className};
import com.baomidou.mybatisplus.mapper.BaseMapper;
<#include "java_imports.include">
public interface  ${className}Mapper extends BaseMapper<${className}>{

}
