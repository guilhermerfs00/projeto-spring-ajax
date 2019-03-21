$(document).ready(function(){
	
	$("#table-server").DataTable({
		
		processing true,
		serverSide:true,
		responsive: true,
		lengthMenu:[10, 15, 20, 25],
		ajax:{
			url: "/promocao/datatable/server",
			data: "data"
		},
		
		columns:[
			{data: 'id'},
			{data: 'titulo'},
			{data: 'site'},
			{data: 'linkPromocao'},
			{data: 'descricao'},
			{data: 'linkImagem'},
			{data: 'preco'},
			{data: 'ctCadastro'},
			{data: 'categoria.titulo'}
		]
	})
	
});

