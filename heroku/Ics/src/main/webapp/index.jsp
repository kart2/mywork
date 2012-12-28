<html>
  <head>
    <title>Agents</title>
    <link rel="stylesheet" type="text/css" media="screen" href="jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="jqgrid/css/ui.jqgrid.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
    <script src="jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
    <script src="jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script script type="text/javascript" src="javascript/main-controller.js">  </script>
  </head>
  <body>
    <script type="text/javascript">
      $(function() {
        var mainController = new MainController();
        mainController.agentList();
      });
    </script>
    <h2>Agents</h2>
    <table id="agent_list"></table>
    <div id="agent_list_pager"></div>
  </body>
</html>

