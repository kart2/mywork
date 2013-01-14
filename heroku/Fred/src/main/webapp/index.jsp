<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <head>
    <title>Agents</title>
    <!-- jQuery -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="javascript/main-controller.js"></script>
    <script type="text/javascript">
      $(function() {
        var mainController = new MainController();
        mainController.agentList();
      });
    </script>
    <link rel="stylesheet" type="text/css" href="css/custom.css">
  </head>

  <body>

    <div id="main">
    <ul id="agent-list"></ul>
    </div>

  </body>

</html>
