#! groovy
echo "Overriden Maven Build Start - Run the original one"
echo "${JAVA_HOME}"
MPLModule('Maven Build', CFG)

echo "Execution of the overriden Maven Build is done"