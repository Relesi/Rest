$(document).ready(function() {

	$('#btn-salvar').on('click', function() {
		var url = 'ingredientes';
		var daodsIngrediente = $('#form-ingrediente').serialize();

		$.post(url, daodsIngrediente)
		.done(function(pagina) {
			alert(pagina);

		})
		.fail(function() {
			alert('Erro ao salvar!');

		});
	});
});