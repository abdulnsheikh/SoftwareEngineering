
#! /bin/sh 
for f in "$1"/*; do
  if [ -f "$f" ]; then
    WORDCOUNT="$(wc -w "${f}")"
    FILESIZE="$(wc -c "${f}")"
    echo "Processing $f file..."
    echo "Count: $WORDCOUNT"
    echo "Size: $FILESIZE"
  fi
done
