'use strict';

module.exports.helloFromLambda = (event, context, callback) => {

  console.log('executing helloFromLambda ', event);

  const response = {
    statusCode: 200,
    body: JSON.stringify({
      message: 'Hello world, from lambda',
      input: event,
    }),
  };

  callback(null, response);
};

module.exports.requiresBeanstalk = (event, context, callback) => {

    var beanStalkUrl = process.env.BEANSTALK_APP;

    console.log('executing requiresBeanstalk ', beanStalkUrl);

    const response = {
        statusCode: 200,
        body: JSON.stringify({
            message: 'Lambda that knows about beanstalk ' +beanStalkUrl,
            input: event,
        }),
    };

    callback(null, response);
};