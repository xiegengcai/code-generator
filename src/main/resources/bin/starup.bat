@echo off & setlocal enabledelayedexpansion

set LIB_JARS=""
cd ..\lib
for %%i in (*) do set LIB_JARS=!LIB_JARS!;..\lib\%%i
cd ..\bin
java -Dfile.encoding=UTF-8 -Xms64m -Xmx1024m -XX:MaxPermSize=64M -classpath ..\conf;%LIB_JARS% generator.GeneratorMain ../conf/generator.properties
goto end

:end
pause