module.exports = function(config){
  config.set({

    basePath : '../',

    files : [
      'https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js',
      'https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-mocks.js',
      'https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.3/angular-route.js',
      'resources/**/*.js',
      'resources/testAngular/e2e/**/*.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['Chrome', 'Firefox'],

    plugins : [
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-jasmine'
            ],

    junitReporter : {
      outputFile: 'test_out/unit.xml',
      suite: 'unit'
    }

  });
};