function MainController() {

  this.agentList = agentList;

  function agentList() {

    $.getJSON('/agent-list', function(data) {
      var items = [];
    
      $.each(data, function(index) {
        items.push('<li class="agent-' + index + '">' + data[index].name + '<br />' + data[index].description + '</li>');
      });
    
      $('#agent-list').html(items.join(''));

    });
  }
}
