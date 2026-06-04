#!/usr/bin/env sh

# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls -ld "$PRG"
    LINK=`ls -l "$PRG" | awk '{print $NF}'`
    case "$LINK" in
    /*) PRG="$LINK" ;;
    *) PRG=`dirname "$PRG"`"/$LINK" ;;
    esac
done
SAVE="$(pwd)"
cd "`dirname \"$PRG\"`" >/dev/null
APP_HOME="$(pwd -P)"
cd "$SAVE" >/dev/null

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='" -Xmx64m" "-Xms64m"'

# Use the maximum available, or set MAX_FD != maximum.
MAX_FD="maximum"

# Tell bash to exit immediately if a command exits with a non-zero status.
set -e

# This is a source'd script, so we must use 'set +e' and execute our actual
# source script with an explicit 'bash' rather than relying on the current
# shell.
set +e

# Escape application args
save () {
    for i do printf %s\\n "$i" | sed "s/'/'\\\\''/g;1s/^/'/;\$s/\$/'" ; done
    echo " "
}
APP_ARGS=`save "$@"`

# Collect all arguments for the java command, stacking in reverse order:
set -- \
        "-Dorg.gradle.appname=$APP_BASE_NAME" \
        -classpath "$CLASSPATH" \
        org.gradle.wrapper.GradleWrapperMain \
        "$APP_ARGS"

exec "$JAVACMD" "$@"