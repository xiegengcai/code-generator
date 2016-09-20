<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service;
import com.melinkr.common.service.IService;
import ${basepackage}.${subpackage}.entity.${className};
<#include "java_imports.include">

public interface  ${className}Service extends IService<${className}>{

}
