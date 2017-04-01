#!/bin/bash
gnome-terminal -x sshpass -p student ssh -Xt sridharan@192.168.43.124 'echo $DISPLAY > dis.txt; bash -l'
javac -cp ":a.jar:aa.jar:ganymed-ssh2-build210.jar" *.java
java -cp ":a.jar:aa.jar:ganymed-ssh2-build210.jar" Main

