function IndexController() {

  this.agentList = agentList;

  function agentList() {
    $("#agent-list").jqGrid({
      url:'http://localhost:8080/training',
      datatype: 'json',
      mtype: 'GET',
      colNames:['Id', 'Name', 'Description'],
      colModel :[
        {name:'id', index:'id', width:50},
        {name:'name', index:'name', width:350},
        {name:'description', index:'description', width:600, cellattr: function (rowId, tv, rawObject, cm, rdata) { return 'style="white-space: normal;"' }}
      ],
      pager: '#agent-list-pager',
      rowNum:32,
      rowList:[32,64],
      sortname: 'name',
      sortorder: 'desc',
      viewrecords: true,
      gridview: true,
      caption: 'Agents',
      height:400
    });
  }

}
