<html>
  <head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" media="screen" href="jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="jqgrid/css/ui.jqgrid.css" />
    <script script type="text/javascript" src="javascript/main-controller.js">  </script>

    <script src="jqgrid/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
    <script src="jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
  </head>
  <body>
    <script type="text/javascript">
      $(function() {
        var mainController = new MainController();
        mainController.productList();
        mainController.productCreate();
        mainController.productInit();
      });
    </script>
    <h2>Products</h2>
    <table id="product-list"></table>
    <div id="product-list-pager"></div>

    <input type="button" id="product-create" value="Create Products"/>
    <p id="product-create-message"></p>

    <input type="button" id="product-init" value="Re-Create Product Database"/> 
    <p id="product-init-message"></p>
  </body>
</html>

