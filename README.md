# 代码生成器

## 基于[Rapid-Generator](https://code.google.com/archive/p/rapid-generator/)的代码生成器
## 使用方法
1. 下载并解压
1. 修改conf目录下的配置
    
    ```
    ## 基础包名。一般为公司域名
    basepackage=com.yourcompany
    ## 子包名。一般为项目模块名称
    subpackage=terminal
    hibernate_id_generator=uuid
    ## 数据库表名。多个用半角逗号分隔
    table.names=t_session,t_control_log
    ## 模板目录。自定义模板增加在该目录下
    template.dir=../template
    ## 生成代码输出目录
    outRoot=d:/temp
    ```
1. 执行bin/starup.bat
1. 将生成的文件拷贝到项目中