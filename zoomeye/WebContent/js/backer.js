function Backer(){
	this.sets = [];// 配置容器
}
Backer.prototype.init = function(){
	$('#port').hide();
	$('#ip').hide();
	$('#service').hide();
	$('#nmapupdatetime').hide();
	$('#dbupdatetime').hide();
	$('#submitbutton').hide();
	$(document).on('click', function(e){
		switch (e.target) {
		case document.querySelector('#ok'):
			console.log('kkkkkk');
			var inputs = $('.panel input');
			var values = [];
			for (var i = 0;i < inputs.length;i++) {
				values.push($(inputs[i]).val());
			}
			var property = ['port', 'ip', 'service', 'nmapTime', 'dbTime'];
			var arg = {};
			for (var i = 0;i < property.length;i++) {
				if (values[i] === '') {
					continue;
				}
				arg[property[i]] = values[i];
			}
			console.log('values',values);
			console.log('arg', arg);
			$.ajax({
				url:"BackServlet",
				data:arg,
				dataType:"json",
				success:function(data){
					console.log('biscuit');
					console.log(data);
					sw.render('biscuit', data);
				},
				error:function(err){
					console.log(err);
				}
			});
			$('#pop').show();
			$('#pop').addClass('animated fadeInDown');
			console.log('kkkkkk');

			setTimeout(function(){
				$('#pop').hide();
			}, 2000);

			break;
		}
	});
}
Backer.prototype.add = function(id){
	var self = this;
	var $dom = $('#' + id);
	self.sets.push($dom);
}
$(function(){
	var backer = new Backer();
	backer.init();
	$('.sidebar-nav').click(function(e){
		if(e.target.getAttribute('id') === 'portset'){
			$('#port').show();
			$('#port').addClass('animated rollIn');
			$('#submitbutton').show();
		}
		if(e.target.getAttribute('id') === 'ipset'){
			$('#ip').show();
			$('#ip').addClass('animated rollIn');
			$('#submitbutton').show();
		}
		if(e.target.getAttribute('id') === 'serviceset'){
			$('#service').show();
			$('#service').addClass('animated rollIn');
			$('#submitbutton').show();
		}
		if(e.target.getAttribute('id') === 'nmapset'){
			$('#nmapupdatetime').show();
			$('#nmapupdatetime').addClass('animated rollIn');
			$('#submitbutton').show();
		}
		if(e.target.getAttribute('id') === 'dbset'){
			$('#dbupdatetime').show();
			$('#dbupdatetime').addClass('animated rollIn');
			$('#submitbutton').show();
		}
	});
});
