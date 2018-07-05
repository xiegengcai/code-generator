<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.model.entity;

import cn.leta.common.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
/**
 * Template Created By Xie Gengcai
 * Auto Generate By Code-Generator
 */
<#list table.columns as column>
<#if column.pk>
<#assign pkType = column.javaType.simpleName>   
</#if>
</#list>
@ApiModel(value = "${className}", description = "${table.remarks}")
@Data
@TableName("${table.sqlName}")
public class ${className} extends BaseModel<${pkType}> {

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

