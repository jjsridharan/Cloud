#!/bin/bash
javac -cp ":a.jar:aa.jar:ganymed-ssh2-build210.jar" *.java
java -cp ":a.jar:aa.jar:ganymed-ssh2-build210.jar" Main
pas=`awk '{print $3}' cre.txt`
usr=`awk '{print $2}' cre.txt`
hos=`awk '{print $1}' cre.txt`
gnome-terminal -x sshpass -p $pas ssh -Xt $usr@$hos 'echo $DISPLAY > dis.txt; bash -l'
java -cp ":a.jar:aa.jar:ganymed-ssh2-build210.jar" Display $hos $usr $pas

