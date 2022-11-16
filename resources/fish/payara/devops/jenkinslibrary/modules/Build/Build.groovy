#! groovy
if ( fileExists('Dockerfile') )
    echo "Dockerfile found"
    MPLModule('Docker Build', CFG)
else 
    echo "No Dockerfile found in "
if ( fileExists('pom.xml') )
    echo "Pom file found"
    MPLModule('Maven Build', CFG)
else
    echo "No maven file found"