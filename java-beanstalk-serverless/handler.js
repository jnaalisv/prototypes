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
