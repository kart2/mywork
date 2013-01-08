function MainController() {

  this.productList   = productList;
  this.productCreate = productCreate;
  this.productInit   = productInit;

  function productList() {
    $("#product-list").jqGrid({
      url:'http://localhost:8080/product-list',
      datatype: 'json',
      mtype: 'GET',
      colNames:['Id', 'Name', 'Description', 'Price'],
      colModel :[ 
        {name:'id', index:'id', width:50}, 
        {name:'name', index:'name', width:350}, 
        {name:'description', index:'description', width:600, cellattr: function (rowId, tv, rawObject, cm, rdata) { return 'style="white-space: normal;"' }},
        {name:'price', index:'price', width:150, align:'right',formatter:'currency'} 
      ],
      pager: '#product-list-pager',
      rowNum:32,
      rowList:[32,64],
      sortname: 'name',
      sortorder: 'desc',
      viewrecords: true,
      gridview: true,
      caption: 'Products',
      height:400
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
          $('#product-list').trigger("reloadGrid",[{page:1}]);
        }
      });
    });
  }

  function productInit() {
    $('#product-init').click(function() {
      $.ajax({
        url:'/product-init',
        type:'post',
        dataType: 'json',
        success: function(data) {
          $('#product-init-message').text(data.message);
          $('#product-list').trigger("reloadGrid",[{page:1}]);
        }
      });
    });
  }
}
