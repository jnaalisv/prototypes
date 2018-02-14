
To create backend deploy bucket

```
$ cd cloudformation
$ make stack
```

Then in project root folder

1. build and publish backend
```
$ make buildAndPublish
```

2. Deploy lambdas
```
$ sls deploy -v
```

Deployed lambda will be available at 
```
https://${SLS_API_GATEWAY}.execute-api.${AWS_REGION}.amazonaws.com/{SLS_STAGE}/hello-lambda
```

and the beanstalk application at
```
http://${AWS_BEANSTALK_APP}.${AWS_REGION}.elb.amazonaws.com/params
```
```
http://${AWS_BEANSTALK_APP}.${AWS_REGION}.elb.amazonaws.com/hello
```

#### TODO
- parametrize ```JavaDeployment```-stack name, now its hard coded to ```./serverless.yml```, ```./cloudformation/Makefile``` and ```./Makefile```
