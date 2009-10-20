echo $1
cp -r template $1 && cd $1 && find . -name '.svn' | xargs rm -rf && grep -rl '${name}' . | xargs perl -p -i -e "s/.{name}/$1/"; cd -
