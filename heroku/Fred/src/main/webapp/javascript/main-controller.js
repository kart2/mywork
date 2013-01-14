function MainController() {

  this.agentList = agentList;

  function agentList() {

    $.getJSON('/agent-list', function(data) {
      var items = [];
    
      $.each(data, function(index) {
        items.push('<li class="agent item-' + index + '"><div class="name"><a href="#">' + data[index].name + '</a></div><div class="description">' + data[index].description + '</div></li>');
      });
    
      $('#agent-list').html(items.join(''));

    });
  }
}
