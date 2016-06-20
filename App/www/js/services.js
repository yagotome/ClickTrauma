angular.module('app.services', [])

    .factory('LoginService', function ($http, backendConfig) {
        var _login = function (usuario) {
            return $http.post(backendConfig.urlBase + '/usuario/login', usuario);
        };

        var _loginPrototipo = function () {
            return $http.get('/backend-prototipo/usuarios.json');
        };

        return {
            login: _login,
            loginPrototipo: _loginPrototipo
        };
    })

    .factory('CadastroService', function ($http, backendConfig) {
        var _cadastrar = function (usuario) {
            return $http.post(backendConfig.urlBase + '/usuario/cadastrar', usuario);
        };

        return {
            cadastrar: _cadastrar
        };
    })

    .factory('QuizService', function ($http, backendConfig) {
        var _getProximaPergunta = function (usuario) {
            return $http.get(backendConfig.urlBase + '/pergunta/proxima', usuario);
        };

        var _getPerguntasPrototipo = function () {
            return $http.get('/backend-prototipo/perguntas.json');
        };

        var _getProximaPerguntaPrototipo = function (perguntas, perguntaAtual) {
            var atual = perguntaAtual || { id: 0 };
            var nextId = atual.id + 1;
            return perguntas.find(function (item) {
                return item.id == nextId;
            });
        };

        return {
            getProximaPergunta: _getProximaPergunta,
            getPerguntasPrototipo: _getPerguntasPrototipo,
            getProximaPerguntaPrototipo: _getProximaPerguntaPrototipo
        };
    });

