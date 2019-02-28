//funcao para capturar as meta tags
$("#linkPromocao").on('change', function() {

	var url = $(this).val();
	
	if (url.length > 7) {
		
		$.ajax({
			method:"POST",
			url: "/meta/info?url=" + url,
			cache: false,
			beforeSend: function() {
				$("#alert").removeClass("alert alert-danger").text('');
				$("#site").text("");
				$("#titulo").val("");
	
				$("#linkImagem").attr("src", "");
				$("#loader-img").addClass("loader");
			},
			success: function( data ) {
				console.log(data);
				$("#linkTitle").val(data.title);
				$("#site").text(data.site.replace("@", ""));
				$("#linkImagem").attr("src", data.image);
			},
			statusCode: {
				404: function() {
					$("#alert").addClass("alert alert-danger").text("Nenhuma informação pode ser recuperada dessa url.");
					$("#linkImagem").attr("src", "/images/image.jpeg");
				}
			},
			error: function() {
				$("#alert").addClass("alert alert-danger").text("Ops... algo deu errado, tente mais tarde.");
				$("#linkImagem").attr("src", "/images/image.jpeg");
			},
			complete: function() {
				$("#loader-img").removeClass("loader");
			}
		});
	}
});

$("form-add-promo").submit(function(evt) {
	
	evt.preventDefault();
	
	var promo = {};
	
	promo.linkpromocao = $("#linkPromocao").val;
	promo.descricao = $("#descricao").val;
	promo.preco = $("preco").val;
	promo.titulo = $("#titulo").val;
	promo.categoria = $("#categoria").val;
	promo.linkImage = $("#linkImage").attr("src");
	promo.site= $("#site").text();
	
	console.log('promo >', promo);
	
	$.ajax({
		method: "POST",
		url: "/promocao/save",
		data: promo,
		sucsses: function(){
			$("#alert").addClass("alert alert-success").text("Ok, promoção salva !");
		},
		error: function(){
			console.log('> error: ', xhr.responseText);
			$("#alert").addClass("alert alert-danger").text("Não foi possível adicionar !");
			
		}
	});
});



