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
            // LoginService.loginPrototipo().success(function (data) {
            // var usuarios = data;
            var usuarios = {
                "yagotome": "yago123",
                "paulo": "102030",
                "mariaberry": "pipoca123"
            };
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
            // });
        };
    })

    .controller('menuCtrl', function ($scope) {

    })

    .controller('comoDiagnosticarCtrl', function ($scope) {

    })

    .controller('traumatismoEmDenteCtrl', function ($scope) {
        var vm = this;
    })

    .controller('quizCtrl', function ($scope, $state, QuizService) {
        var vm = this;
        var perguntas = [
            {
                "id": 1,
                "texto": "Após queda no parquinho, uma menina de 3 anos de idade compareceu ao consultório com a seguinte situação clínica: queixa de sensibilidade no elemento 51, sangramento no nível do sulco gengival, mobilidade moderada, porém sem deslocamento do dente. Como é classificado o tipo de traumatismo descrito?",
                "respostas": [
                    {
                        "id": 1,
                        "texto": "Concussão"
                    },
                    {
                        "id": 2,
                        "texto": "Subluxação"
                    },
                    {
                        "id": 3,
                        "texto": "Luxação extrusiva"
                    },
                    {
                        "id": 4,
                        "texto": "Luxação lateral"
                    }
                ],
                "respostaCerta": {
                    "id": 2,
                    "texto": "Subluxação"
                }
            },
            {
                "id": 2,
                "texto": "Na dentição decídua, quando os incisivos centrais sofrem intrusão total invadindo o folículo dentário dos sucessores até os 3 anos de idade, as sequelas acometem principalmente:",
                "respostas": [
                    {
                        "id": 1,
                        "texto": "Raiz e osso alveolar"
                    },
                    {
                        "id": 2,
                        "texto": "Raiz e coroa"
                    },
                    {
                        "id": 3,
                        "texto": "Coroa"
                    },
                    {
                        "id": 4,
                        "texto": "Raiz"
                    }
                ],
                "respostaCerta": {
                    "id": 3,
                    "texto": "Coroa"
                }
            },
            {
                "id": 3,
                "texto": "Quais os tipos de lesões mais comuns causadas pelos traumatismos na dentição decídua?",
                "respostas": [
                    {
                        "id": 1,
                        "texto": "Lesões aos tecidos dentários"
                    },
                    {
                        "id": 2,
                        "texto": "Lesões aos tecidos de sustentação"
                    },
                    {
                        "id": 3,
                        "texto": "Lesões aos tecidos moles"
                    },
                    {
                        "id": 4,
                        "texto": "Lesões ao tecido ósseo"
                    }
                ],
                "respostaCerta": {
                    "id": 2,
                    "texto": "Lesões aos tecidos de sustentação"
                }
            }
        ];
        // QuizService.getPerguntasPrototipo().success(function (data) {
        // perguntas = data;
        vm.pergunta = QuizService.getProximaPerguntaPrototipo(perguntas, vm.pergunta);
        // });
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
