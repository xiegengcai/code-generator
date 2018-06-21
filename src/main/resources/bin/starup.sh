#!/bin/bash

if [ ! -n "$JAVA_HOME" ]; then
    export JAVA_HOME="/usr/local/jdk1.8.0_101"
fi
JAVA_BIN="$JAVA_HOME/bin"

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`

JAVA_OPTS="-Dfile.encoding=UTF-8 -Xms64m -Xmx1024m -cp $LIB_JARS:$CONF_DIR "
echo $JAVA_OPTS

java $JAVA_OPTS generator.GeneratorMain generator.properties
