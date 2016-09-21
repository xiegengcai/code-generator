<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service.rpc;

import com.melinkr.common.rpc.BaseRpcService;
import com.melinkr.common.rpc.RpcService;
import ${basepackage}.${subpackage}.entity.${className};
import ${basepackage}.${subpackage}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;

<#include "java_imports.include">
@RpcService("${classNameLower}RpcSerivce")
public class ${className}RpcServiceImpl extends BaseRpcService<${className}, ${className}Service> implements ${className}RpcService{
    @Autowired
    private ${className}Service ${classNameLower}Service;

    @Override
    protected ${className}Service getService() {
        return this.${classNameLower}Service;
    }
}
