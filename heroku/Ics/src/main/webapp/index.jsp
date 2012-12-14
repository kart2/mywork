<html>
  <head>
    <title>Agents</title>
    <link rel="stylesheet" type="text/css" media="screen" href="jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="jqgrid/css/ui.jqgrid.css" />

    <script src="jqgrid/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
    <script src="jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
  </head>
  <body>
    <script type="text/javascript">
      $(function(){ 
        $("#agent_list").jqGrid({
          url:'http://localhost:8080/ics',
          datatype: 'json',
          mtype: 'GET',
          colNames:['Id', 'Name','Description'],
          colModel :[ 
            {name:'id', index:'id', width:200}, 
            {name:'name', index:'name', width:200}, 
            {name:'description', index:'description', width:250} 
          ],
          pager: '#agent_list_pager',
          rowNum:10,
          rowList:[10,20,30],
          sortname: 'name',
          sortorder: 'desc',
          viewrecords: true,
          gridview: true,
          caption: 'Agents'
        }); 
      });
    </script>
    <h2>Agents</h2>
    <table id="agent_list"></table>
    <div id="agent_list_pager"></div>
  </body>
</html>

