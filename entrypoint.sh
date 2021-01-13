#!/bin/sh

if [ ! -z $RP_DB_PASS_FILE ]; then
  export RP_DB_PASS=$(cat $RP_DB_PASS_FILE)
fi

if [ ! -z $RP_BINARYSTORE_MINIO_ACCESSKEY_FILE ]; then
  export RP_BINARYSTORE_MINIO_ACCESSKEY=$(cat $RP_BINARYSTORE_MINIO_ACCESSKEY_FILE)
fi

if [ ! -z $RP_BINARYSTORE_MINIO_SECRETKEY_FILE ]; then
  export RP_BINARYSTORE_MINIO_SECRETKEY=$(cat $RP_BINARYSTORE_MINIO_SECRETKEY_FILE)
fi

exec java ${JAVA_OPTS} -jar service-authorization-5.3.3-exec.jar