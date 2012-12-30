function MainController() {

  this.agentList = agentList;

  function agentList() {

    $.getJSON('/ics', function(data) {
      var items = [];
    
      $.each(data, function(index) {
        items.push('<li><div style="font-weight:bold">' + data[index].name + '</div><div style="font-style:"italic">' + data[index].description + '</div><div style="font-style:"italic">' + data[index].description + '</div><div style="font-style="italic">' + data[index].description + '</div><div style="font-style="italic">' + data[index].description + '</div><div style="font-style="italic">' + data[index].description + '</div></li>');
      });
    
      $('<ul />', {
        'class': 'my-new-list',
        html: items.join('')
      }).appendTo('body');
    });
  }
}
