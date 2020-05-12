set -x

# PAYLOAD_FILE=payload.legit.json
PAYLOAD_FILE=payload.hack.json

payload=$(sed ':a;N;$!ba;s/\n//g' $PAYLOAD_FILE | sed 's/ //g')

payload=$(python -c "import urllib.parse; print(urllib.parse.quote_plus('$payload'))")

curl -X GET -sS "localhost:8080/convert?inJson=$payload"