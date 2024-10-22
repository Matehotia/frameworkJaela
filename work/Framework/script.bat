@echo off
setlocal

rem Déclaration des variables
set projet=Framework
set temp=.\temp
set lib=.\lib
set bin=.\bin
@REM set destination=C:\Users\VIOTECH\Documents\S4\Sprint1\work\Framework
set destination=C:\Users\VIOTECH\Documents\S4\Spring\Sprint Mr Naina\Sprint8\work\Test_Sprint\lib

rem Vérifier si le dossier temp existe
if exist "%temp%\" (
    rd /S /Q "%temp%"
)

rem Création d'un dossier temp avec les contenu de base si le dossier temp n'existe pas
mkdir "%temp%"

rem Copie des librairies du projet vers temp
xcopy /E /I /Y "%lib%\" "%temp%"

rem Compilation des codes Java vers le dossier temp
call compile.bat

rem Copie des classes compilées vers temp
xcopy /E /I /Y "%bin%\" "%temp%"

rem Déplacement vers le répertoire temp
cd /D "%temp%"

rem Compresser dans un fichier jar
jar -cvf "%destination%\%projet%.jar" *

endlocal
