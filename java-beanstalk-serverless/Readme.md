
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

invoke lambda with
$ sls invoke local --function hello --data '{"a":"bar"}'
