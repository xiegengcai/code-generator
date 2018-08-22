<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.mapper;
import ${basepackage}.${subpackage}.entity.${className};
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * Template Created By Xie Gengcai
 * Auto Generate By Code-Generator
 */
public interface  ${className}Mapper extends BaseMapper<${className}>{

}
