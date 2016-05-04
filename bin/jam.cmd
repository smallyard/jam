@echo off
rem set ASSEMBLY_DIR=H:\jam\core\target\jam-core-jar-with-dependencies.jar
set ASSEMBLY_DIR=%JAM_HOME%\lib\jam-core.jar
java -cp %ASSEMBLY_DIR% -DJAM_HOME=%JAM_HOME% cn.smallyard.jam.JamCli %*