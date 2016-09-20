<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service.impl;

import com.melinkr.common.service.BaseService;
import ${basepackage}.${subpackage}.entity.${className};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

<#include "java_imports.include">
@Component("${classNameLower}Serivce")
public class ${className}ServiceImpl extends BaseService<${className}, ${className}Mapper> implements ${className}Service{
    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    protected ${className}Mapper getMapper() {
        return this.${classNameLower}Mapper;
    }
}
