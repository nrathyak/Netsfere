#!/bin/bash
#for pid in `ps -eo pid,args | grep appium |grep -v "grep" | cut -d " " -f1`
for pid in `ps -eo pid,args | grep node |grep -v "grep"| awk -F" " '{print $1}'`
#for pid in `ps -eo pid,args| grep node | grep -v "grep" | cut -d " " -f1`
do 
echo $pid
kill -9 $pid
done

