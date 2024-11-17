#! /bin/bash

_HOME2_=$(dirname $0)
export _HOME2_
_HOME_=$(cd $_HOME2_;pwd)
export _HOME_

# go to the directory where this script lives. to be sure where we are
cd $_HOME_
echo $_HOME_

p=$(pwd)
echo "$p"

if [ "$1""x" == "buildx" ]; then
  TERM=dumb ./gradlew packageDistributionForCurrentOS
  TERM=dumb ./gradlew packageUberJarForCurrentOS
fi

java \
-Dcompose.application.configure.swing.globals=true \
-Dcompose.application.resources.dir="$p"/build/compose/tmp/prepareAppResources \
-Dfile.encoding=UTF-8 -Duser.country=US -Duser.language=en -Duser.variant \
-cp "$p"/build/compose/jars/small3-linux-x64-1.0.0.jar \
MainKt

