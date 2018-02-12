include ../aws.env

check-region:
	test -n "$(AWS_REGION)" || (echo "AWS_REGION must be defined in ../aws.env"; exit 1)

.PHONY: stack events describe list clean

stack: check-region
	aws --region $(AWS_REGION) cloudformation create-stack --stack-name JavaDeployment --capabilities "CAPABILITY_NAMED_IAM" --template-body file://create-java-bucket.yaml

events:
	aws --region $(AWS_REGION) cloudformation describe-stack-events --stack-name JavaDeployment

describe:
	aws --region $(AWS_REGION) cloudformation describe-stacks --stack-name JavaDeployment

list:
	aws --region $(AWS_REGION) cloudformation list-stacks

clean:
	aws --region $(AWS_REGION) cloudformation delete-stack --stack-name JavaDeployment
