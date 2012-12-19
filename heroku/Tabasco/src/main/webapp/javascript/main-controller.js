function MainController() {

  this.productList   = productList;
  this.productCreate = productCreate;

  function productList() {
    $("#product-list").jqGrid({
      url:'http://localhost:8080/product-list',
      datatype: 'json',
      mtype: 'GET',
      colNames:['Id', 'Name','Description'],
      colModel :[ 
        {name:'id', index:'id', width:200}, 
        {name:'name', index:'name', width:200}, 
        {name:'description', index:'description', width:250} 
      ],
      pager: '#product-list-pager',
      rowNum:10,
      rowList:[10,20,30],
      sortname: 'name',
      sortorder: 'desc',
      viewrecords: true,
      gridview: true,
      caption: 'Products'
    });
  }

  function productCreate() {
    $('#product-create').click(function() {
      $.ajax({
        url:'/product-create',
        type:'post',
        dataType: 'json',
        success: function(data) {
          $('#product-create-message').text(data.message);
        }
      });
    });
  }
}
