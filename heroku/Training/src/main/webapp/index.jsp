<html>
  <head>
    <title>Training</title>
    <link rel="stylesheet" type="text/css" media="screen" href="http://cdn.jsdelivr.net/jqgrid/4.4.1/css/ui.jqgrid.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
    <script src="http://cdn.jsdelivr.net/jqgrid/4.4.1/jquery.jqGrid.js" type="text/javascript"></script>
    <script src="http://cdn.jsdelivr.net/jqgrid/4.4.1/js/i18n/grid.locale-en.js" type="text/javascript"></script>
    <script src="javascript/index-controller.js" type="text/javascript"></script>
  </head>
  <body>
    <h2>Hello Heroku!</h2>
    <script type="text/javascript">
      $(function() {
        var indexController = new IndexController();
        indexController.agentList();
      });
    </script>
    <h2>Agents</h2>
    <table id="agent-list"></table>
    <div id="agent-list-pager"></div>

  </body>
</html>
