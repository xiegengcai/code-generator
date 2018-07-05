<#include "macro.include"/>
<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.model.entity;

import cn.leta.common.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
<#include "java_imports.include">
@ApiModel(value = "${className}", description = "${table.remarks}")
@Data
@TableName("${table.sqlName}")
public class ${className} implements java.io.Serializable {

	//columns START
	<#list table.columns as column>
	<#if column.remarks??>
<#if column.remarks!="">
	/**
	 * ${column.remarks}
	 */
	</#if>
</#if>
	<#if column.pk>
	<#else>
	@ApiModelProperty(value="${column.remarks}")
    @TableField("${column.sqlName}")
	private ${column.javaType.simpleName} ${column.columnNameLower};
	</#if>
	</#list>
	//columns END
}

