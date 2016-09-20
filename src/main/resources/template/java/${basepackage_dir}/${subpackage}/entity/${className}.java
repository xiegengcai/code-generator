<#include "macro.include"/>
<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.model;

import javax.persistence.*;
import java.io.Serializable;
<#include "java_imports.include">
@Entity
@Table(name = "${table.sqlName}")
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	<#else>
	@Column(name = "${column.sqlName}")
	</#if>
	private ${column.javaType.simpleName} ${column.columnNameLower};
	</#list>
	//columns END

	// getter/setter START
	<#list table.columns as column>
	public void set${column.columnName}(${column.javaType.simpleName} value) {
		this.${column.columnNameLower} = value;
	}

	public ${column.javaType.simpleName} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#list>
	// getter/setter END
}

