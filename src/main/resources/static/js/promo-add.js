//FUNÇÃO PARA CAPTURAR AS META TAGS
$("#linkPromocao").on('change', function(){
	var url = $(this).val();
	
	if(url.length > 7){
		$.ajax({
			method: "POST",
			url: "/meta/info?url=" + url,
			cache: false, 
			success: function(data){
				console.log(data);
				$("#titulo").val(data.titulo);
				$("#site").text(data.site.replace("@" , ""));
				$("#linkImagem").attr("src", data.image);
			},
			statusCode: {
				404: function(){
					$("#alert").addClass("alert alert-danger").text("Nenhuma informação foi recuperado dessa Url.");
				}
			}
		});
	}
});