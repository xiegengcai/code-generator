<#include "java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service.rpc;
import com.melinkr.common.rpc.IRpcService;
import ${basepackage}.${subpackage}.entity.${className};

<#include "java_imports.include">
public interface ${className}RpcService extends IRpcService<${className}> {

}