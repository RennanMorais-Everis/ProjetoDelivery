$( document ).ready(function() {
    showLogin();
    showCadastro();
});

function showLogin() {
    $("#login-bt").click(function() {
        $('.login-modal').show('fast');
    });

    $("#login-close").click(function() {
        $('.login-modal').hide('fast');
    }); 
}

function showCadastro() {
    $("#cadastro-bt").click(function() {
        $('.cadastro-modal').show('fast');
    });

    $("#cad-close").click(function() {
        $('.cadastro-modal').hide('fast');
    });
}