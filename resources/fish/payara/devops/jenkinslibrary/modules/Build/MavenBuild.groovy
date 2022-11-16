#! groovy
echo "Overriden Maven Build Start - Run the original one"

sh """mvn -version"""
MPLModule('Maven Build', CFG)

echo "Execution of the overriden Maven Build is done"