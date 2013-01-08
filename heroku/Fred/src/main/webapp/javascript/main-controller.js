function MainController() {

  this.agentList = agentList;

  function agentList() {

    $.getJSON('/agent-list', function(data) {
      var items = [];
    
      $.each(data, function(index) {
        items.push('<li><div style="font-weight:bold">' + data[index].name + '</div><div style="font-style:italic">' + data[index].description + '</div>');
      });
    
      $('<ul />', {
        'class': 'my-new-list',
        html: items.join('')
      }).appendTo('body');
    });
  }
}
