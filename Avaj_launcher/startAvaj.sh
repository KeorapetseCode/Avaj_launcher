#!/bin/bash

rm *.class
rm methods/*.class
rm classes/*.class
rm simulation.txt

echo "<<< Removed all previous files >>>"
echo "...Please wait while recompiling"

javac Main.java
java Main.java text.txt

cat simulation.txt
