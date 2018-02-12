.PHONY: stack events describe list clean

stack:
	aws cloudformation create-stack --stack-name JavaDeploymentBucket --capabilities "CAPABILITY_NAMED_IAM" --template-body file://create-java-bucket.yaml

events:
	aws cloudformation describe-stack-events --stack-name JavaDeploymentBucket

describe:
	aws cloudformation describe-stacks --stack-name JavaDeploymentBucket

list:
	aws cloudformation list-stacks

clean:
	aws cloudformation delete-stack --stack-name JavaDeploymentBucket
