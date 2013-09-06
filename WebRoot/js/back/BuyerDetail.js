dojo.addOnLoad(function() {
	dojo.event.topic.subscribe('handleModifyPasswordResult', this, function(data, type, e){
		if(data == 'success') {
			alert('Can not retrieve the book');
		} else if(data == 'success') {
			alert('Can not retrieve the book');
		}
	});
});
