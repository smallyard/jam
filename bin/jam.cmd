@echo off
set JAM_HOME=H:\jam
set ASSEMBLY_DIR=%JAM_HOME%\core\target\jam-core-jar-with-dependencies.jar
java -cp %ASSEMBLY_DIR% cn.smallyard.jam.JamCli %*