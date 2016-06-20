angular.module('app.controllers', [])

    .controller('cameraTabDefaultPageCtrl', function ($scope) {

    })

    .controller('cartTabDefaultPageCtrl', function ($scope) {

    })

    .controller('cloudTabDefaultPageCtrl', function ($scope) {

    })

    .controller('cadastroCtrl', function ($scope, CadastroService, $state) {
        var vm = this;
        vm.cadastrar = function (usuario) {
            $state.go('menu');
            // CadastroService.cadastrar(usuario).data(function (data) {
            //     //TO-DO
            // });
        };
    })

    .controller('loginCtrl', function ($scope, LoginService, $state, $ionicPopup) {
        var vm = this;
        vm.logar = function (usuario) {
            LoginService.loginPrototipo().success(function (data) {
                var usuarios = data;
                if (usuarios[usuario.login] == usuario.senha) {
                    $state.go('menu');
                } else {
                    var alertPopup = $ionicPopup.alert({
                        title: 'Login',
                        template: 'Usuário ou senha inválido'
                    }).then(function (res) {
                        vm.usuario.senha = "";
                    });
                }
            });
        };
    })

    .controller('menuCtrl', function ($scope) {

    })

    .controller('comoDiagnosticarCtrl', function ($scope) {

    })

    .controller('quizCtrl', function ($scope, $state, QuizService) {
        var vm = this;
        var perguntas = [];
        QuizService.getPerguntasPrototipo().success(function (data) {
            perguntas = data;
            vm.pergunta = QuizService.getProximaPerguntaPrototipo(perguntas, vm.pergunta);
        });
        vm.responder = function (alternativa) {
            var certo = alternativa == vm.pergunta.respostaCerta.id;
            var _titulo = certo ? 'Certo!' : 'Errado';
            var _texto = certo ? 'Parabéns, você acertou!' : 'Que pena, você errou!\nA resposta correta era ' + vm.pergunta.respostaCerta.texto + '.';
            var params = {
                feedback: JSON.stringify({
                    titulo: _titulo,
                    texto: _texto
                })
            };
            vm.pergunta = QuizService.getProximaPerguntaPrototipo(perguntas, vm.pergunta);
            vm.alternativaMarcada = null;
            $state.go('resposta', params);
        };
    })

    .controller('respostaCtrl', function ($scope, $state, $stateParams, QuizService) {
        var vm = this;
        vm.feedback = JSON.parse($stateParams.feedback);
        vm.proxima = function () {
            $state.go('quiz');
        };
    })
