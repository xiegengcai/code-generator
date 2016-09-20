<#include "java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service.rpc;
import com.melinkr.common.model.PageModel;
import com.melinkr.common.rpc.RpcPageInfo;
import ${basepackage}.${subpackage}.entity.${className};
import ${basepackage}.${subpackage}.service.rpc.${className}RpcService;
import java.io.Serializable;
import java.util.List;
<#include "java_imports.include">
public class  ${className}RpcServiceStub implements ${className}RpcService{
    
    private ${className}RpcService ${classNameLower}RpcService;

    public void set${className}RpcService(${className}RpcService ${classNameLower}RpcService) {
        this.${classNameLower}RpcService = ${classNameLower}RpcService;
    }

    @Override
    public int save(${className} ${classNameLower}) {
        return 0;
    }

    @Override
    public int saveList(List<${className}> list) {
        return 0;
    }

    @Override
    public int deleteByKey(Serializable... serializables) {
        return 0;
    }

    @Override
    public int updateByKey(${className} ${classNameLower}) {
        return 0;
    }

    @Override
    public ${className} selectByKey(Serializable serializable) {
        return null;
    }

    @Override
    public ${className} selectOne(${className} ${classNameLower}) {
        return null;
    }

    @Override
    public List<${className}> selectList(${className} ${classNameLower}) {
        return null;
    }

    @Override
    public RpcPageInfo<${className}> selectListWithPage(${className} ${classNameLower}, PageModel pageModel) {
        return null;
    }

    @Override
    public RpcPageInfo<${className}> selectAllWithPage(PageModel pageModel) {
        return null;
    }
}
