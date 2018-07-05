<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service;
import ${basepackage}.${subpackage}.model.entity.${className};
import com.baomidou.mybatisplus.service.IService;
/**
 * Template Created By Xie Gengcai
 * Auto Generate By Code-Generator
 */
public interface  ${className}Service extends IService<${className}>{

}
