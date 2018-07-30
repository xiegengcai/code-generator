<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
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
@Data
@TableName("${table.sqlName}")
public class ${className} implements Serializable{

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
	@TableId(type = IdType.AUTO)
	<#else>
    @TableField("${column.sqlName}")
	</#if>
	private ${column.javaType.simpleName} ${column.columnNameLower};
	
	</#list>
	//columns END
}

