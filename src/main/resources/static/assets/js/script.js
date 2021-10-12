$( document ).ready(function() {
    showLogin();
    showCadastro();
    showMask();
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

function showMask() {
    $(".money-field").mask('000.000.000.000.000,00', {
        reverse: true
    });
}