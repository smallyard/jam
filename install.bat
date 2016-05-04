@echo off
setx JAM_HOME %cd%
setx PATH "%PATH%;%JAM_HOME%/bin;%JAM_HOME%/apps"
echo install success.
pause