$(document).ready(function(){
	
	$.ajax({
		
		url:"/getData",
		type : 'GET',
		dataType : 'json',
		success : function(data){
             if(data.message == "success"){
                    var buttonCommon = { 
                exportOptions: {
                  format: {
						body:function(data,row,column,node){
							
							return column ===5 ? 
							data.replace( /[$,]/g, ''):
							data;
						}
				  }
				}
					};
					
					//Data Table
					var table = $('#example').DataTable({
						 paging: true,
						 "aaData": data.hotList,
						 "aoColumns":[
						 {"data" : "reference"},
						 {"data" : "description"},
						 {"data" :	"remarks"},
						 ],

					dom : 'Bfrtip',
					buttons: [
							$.extend(true, {}, buttonCommon, {
                               extend : 'copyHtml5'
							}), 							  
                            $.extend(true, {}, buttonCommon, {
                               extend : 'excelHtml5',
							   title : 'RCSP_Failed_References'
							}),
                            $.extend(true, {}, buttonCommon, {
                               extend : 'pdfHtml5',
							   title : 'RCSP_Failed_references'
							})
							]
					        });							
					
					//Filter Event Handler
					$(table.table().container() ).on('keyup','tfoot input', function(){
						table
						.column($(this).data('index'))
						                     .search(this.value)
											 .draw();
					});
			 }
			 else{
                       alert("invalid file");	
			 }

		},
         error : function(request, textStatus, errorThrown) {
			alert("oops!...some thing wrong, please refresh the page and try again");
		 }
	});
});
	
					