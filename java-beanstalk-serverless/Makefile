include aws.env

check-region:
	test -n "$(AWS_REGION)" || (echo "AWS_REGION must be defined in ../aws.env"; exit 1)

.PHONY: build

build:
	./gradlew build

bucketUrl: check-region
	aws --region $(AWS_REGION) cloudformation describe-stacks --stack-name JavaDeployment | jq -r '.Stacks[0].Outputs[0].OutputValue'

buildAndPublish: build check-region
	aws --region $(AWS_REGION) s3 cp build/libs/java-beanstalk-serverless-0.0.1-SNAPSHOT.jar s3://`aws --region $(AWS_REGION) cloudformation describe-stacks --stack-name JavaDeployment | jq -r '.Stacks[0].Outputs[0].OutputValue'`/backend.jar
