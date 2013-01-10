<html>
  <head>
    <title>Agents</title>

    <!-- jQuery -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script script type="text/javascript" src="javascript/main-controller.js">  </script>
    <style>
      ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
        text-align: left;
      }
      
      li {
        vertical-align: middle;
        background-image: url(/images/vault-64.png);
        background-repeat: no-repeat;
        background-position: left top;
        padding-bottom: 10px;
        padding-top: 5px;
        padding-left: 80px;
      }
    </style>
  </head>
  <body>
    <script type="text/javascript">
      $(function() {
        var mainController = new MainController();
        mainController.agentList();
      });
    </script>

    <ul id="agent-list"></ul>

  </body>
</html>
