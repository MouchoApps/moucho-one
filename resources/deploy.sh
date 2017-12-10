#!/bin/bash

set -e

docker build -t ${ORGANIZATION_NAME}/${PROJECT_NAME}/${IMAGE_NAME}:$TRAVIS_COMMIT .
docker tag ${ORGANIZATION_NAME}/${PROJECT_NAME}/${IMAGE_NAME}:$TRAVIS_COMMIT ${ORGANIZATION_NAME}/${PROJECT_NAME}/${IMAGE_NAME}:latest

echo $GCLOUD_SERVICE_KEY | base64 --decode -i > ${HOME}/gcloud-service-key.json
gcloud auth activate-service-account --key-file ${HOME}/gcloud-service-key.json

gcloud --quiet config set project $PROJECT_NAME
gcloud --quiet config set container/cluster $CLUSTER_NAME
gcloud --quiet config set compute/zone ${CLOUDSDK_COMPUTE_ZONE}
gcloud --quiet container clusters get-credentials $CLUSTER_NAME

gcloud docker push ${ORGANIZATION_NAME}/${PROJECT_NAME}/${IMAGE_NAME}

yes | gcloud beta container images add-tag ${ORGANIZATION_NAME}/${PROJECT_NAME}/${IMAGE_NAME}:$TRAVIS_COMMIT ${ORGANIZATION_NAME}/${PROJECT_NAME}/${IMAGE_NAME}:latest

kubectl config view
kubectl config current-context

kubectl set image deployment/${IMAGE_NAME} ${IMAGE_NAME}=${ORGANIZATION_NAME}/${PROJECT_NAME}/${IMAGE_NAME}:$TRAVIS_COMMIT