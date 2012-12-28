function MainController() {

  this.agentList = agentList;

  function agentList() {
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
  }

}
