<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.service;

import ${basepackage}.${subpackage}.entity.${className};
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
<#include "java_imports.include">

public class ${className}ServiceTest extends BaseTest{
	@Autowired
	private ${className}Service service;

	private static ${className} ${classNameLower};
	private static Random random = new Random();

	@BeforeClass
	public static void init(){
<#include "new_entity.include">
		${classNameLower} = t;
	}

	@Test
	public void testSaveOneWithNull() {
		int rows = service.saveOneWithNull(${classNameLower});
		Assert.isTrue(rows > 0);
	}

	@Test
	public void testSaveOneNotNull() {
		int rows = service.saveOneNotNull(${classNameLower});
		Assert.isTrue(rows > 0);
	}

	@Test
	public void testSaveList() {
		List<${className}> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
<#include "new_entity.include">
			list.add(t);
		}
		int rows = service.saveList(list);
		Assert.isTrue(rows > 0);
	}

	@Test
	public void testDeleteByKey() {
		int rows = service.deleteByKey(1);
		Assert.isTrue(rows >= 0);
	}

	@Test
	public void testDeleteList() {
		int rows = service.deleteList(${classNameLower});
		Assert.isTrue(rows >= 0);
	}


	@Test
	public void testUpdateByKeyWithNull() {
		int rows = service.updateByKeyWithNull(${classNameLower});
		Assert.isTrue(rows >= 0);
	}


	@Test
	public void testUpdateByKeyNotNull() {
		int rows = service.updateByKeyNotNull(${classNameLower});
		Assert.isTrue(rows >= 0);
	}

	@Test
	public void testSelectByKey() {
		Assert.notNull(service.selectByKey(1));
	}

	@Test
	public void testSelectOne() {
		Assert.notNull(service.selectOne(t));
	}

	@Test
	public void testSelectList() {
		Assert.notNull(service.selectList(${classNameLower}));
	}
	@Test
	public void testSelectAll() {
		Assert.notNull(service.selectAll());
	}
}
