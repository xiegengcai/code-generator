<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.mapper;
import com.melinkr.common.mapper.MelinkrMapper;
import ${basepackage}.${subpackage}.entity.${className};
<#include "java_imports.include">
public interface  ${className}Mapper extends MelinkrMapper<${className}>{

}
