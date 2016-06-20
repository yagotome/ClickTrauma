angular.module('app.routes', [])

  .config(function ($stateProvider, $urlRouterProvider) {

    // Ionic uses AngularUI Router which uses the concept of states
    // Learn more here: https://github.com/angular-ui/ui-router
    // Set up the various states which the app can be in.
    // Each state's controller can be found in controllers.js
    $stateProvider



      .state('tabsController.cameraTabDefaultPage', {
        url: '/page2',
        views: {
          'tab1': {
            templateUrl: 'templates/cameraTabDefaultPage.html',
            controller: 'cameraTabDefaultPageCtrl'
          }
        }
      })

      .state('tabsController.cartTabDefaultPage', {
        url: '/page3',
        views: {
          'tab2': {
            templateUrl: 'templates/cartTabDefaultPage.html',
            controller: 'cartTabDefaultPageCtrl'
          }
        }
      })

      .state('tabsController.cloudTabDefaultPage', {
        url: '/page4',
        views: {
          'tab3': {
            templateUrl: 'templates/cloudTabDefaultPage.html',
            controller: 'cloudTabDefaultPageCtrl'
          }
        }
      })

      .state('tabsController', {
        url: '/page1',
        templateUrl: 'templates/tabsController.html',
        abstract: true
      })

      .state('cadastro', {
        url: '/cadastro',
        templateUrl: 'templates/cadastro.html',
        controller: 'cadastroCtrl',
        controllerAs: 'vm'
      })

      .state('login', {
        url: '/login',
        templateUrl: 'templates/login.html',
        controller: 'loginCtrl',
        controllerAs: 'vm'
      })

      .state('menu', {
        url: '/menu',
        templateUrl: 'templates/menu.html',
        controller: 'menuCtrl'
      })

      .state('comoDiagnosticar', {
        url: '/comoDiagnosticar',
        templateUrl: 'templates/comoDiagnosticar.html',
        controller: 'comoDiagnosticarCtrl'
      })

      .state('quiz', {
        url: '/quiz',
        templateUrl: 'templates/quiz.html',
        controller: 'quizCtrl',
        controllerAs: 'vm'
      })

      .state('resposta', {
        url: '/resposta/:pergunta/:feedback',
        templateUrl: 'templates/resposta.html',
        controller: 'respostaCtrl',
        controllerAs: 'vm'
      })

    $urlRouterProvider.otherwise('/login')



  });