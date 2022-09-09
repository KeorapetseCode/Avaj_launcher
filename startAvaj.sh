#!/bin/bash

#rm *.class
#rm methods/*.class
#rm classes/*.class
#rm simulation.txt

classFile=methods/Tower.class
if test -f "$classFile";
then
	rm methods/*.class
	echo $'[Removed class files in methods folder]'
fi

classFile=simulation.txt
if test -f "$classFile";
then
	rm simulation.txt
	echo $'[Removed previous simulation.txt file]'
fi

classFile=classes/Baloon.class
if test -f "$classFile"; then
	rm classes/*.class
	echo $'[Removed all class files in classes folder]'
fi

classFile=Main.class
if test -f "$classFile";
then
	rm Main.class
	echo $'[Removed Main.class in root directory]\n'
fi

#echo $'\n<<< Removed all previous files >>>\n'
echo $'\n...Please wait while Compiling'

javac Main.java
java Main.java scenario.txt

echo $'Displaying simulation.txt\n'
cat simulation.txt
