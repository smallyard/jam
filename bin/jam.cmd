@echo off
set JAM_HOME=H:\jam
set ASSEMBLY_DIR=%JAM_HOME%\core\target\classes
java -cp %ASSEMBLY_DIR% cn.smallyard.jam.JamCli %*