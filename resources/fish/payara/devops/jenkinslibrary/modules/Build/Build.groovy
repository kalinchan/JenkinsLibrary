#! groovy
if ( fileExists('Dockerfile') )
    MPLModule('Docker Build', CFG)
else 
    echo "No Dockerfile found in "
if ( fileExists('pom.xml') )
    MPLModule('Maven Build', CFG)    