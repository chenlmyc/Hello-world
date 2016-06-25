function Switch(pillar, biscuit, map, table){
	this.pillar = pillar;
	this.biscuit = biscuit;
	this.map = map;
	this.table = table;
	this.param = {
		"ip" : window.location
	};
}
function getParam(url){

}
Switch.prototype.render = function(type, option){
	if(type === 'pillar'){
		$('#pillar').show();
		$('#table').css("display", "none");
		$('#map').css("display", "none");
		$('#biscuit').css("display", "none");
		var myChart = echarts.init(document.getElementById('pillar'));
		myChart.setOption(option);
	}else if(type === 'table'){
		$('#table').show();
		$('#pillar').hide();
		$('#biscuit').hide();
		$('#map').hide();
	}else if(type === 'map'){
		$('#map').show();
		$('#table').hide();
		$('#pillar').hide();
		$('#biscuit').hide();
		var myChart = echarts.init(document.getElementById('map'));
		var geoCoordMap = {
			"北京" : [ 116.15, 39.12 ],
			"苏州" :[119.55,31.45],
			"大连" :[121.44,39.45],
			"沈阳" :[123.55,41.45]
		};

		var convertData = function(data){
			var res = [];
			for (var i = 0; i < data.length; i++){
				var geoCoord = geoCoordMap[data[i].name];
				if(geoCoord){
					res.push(geoCoord.concat(data[i].value));
				}
			}
			return res;
		};

		option = {
			backgroundColor : '#404a59',
			title : {
				text : '全国IP分布图',
				subtext : 'data from zoomeye',
				sublink : 'http://zoomeye.org',
				left : 'center',
				textStyle : {
					color : '#fff'
				}
			},
			tooltip : {
				trigger : 'item'
			},
			legend : {
				orient : 'vertical',
				top : 'bottom',
				left : 'right',
				data : [ 'pm2.5' ],
				textStyle : {
					color : '#fff'
				}
			},
			visualMap : {
				min : 0,
				max : 300,
				splitNumber : 5,
				color : [ '#d94e5d', '#eac736', '#50a3ba' ],
				textStyle : {
					color : '#fff'
				}
			},
			geo : {
				map : 'china',
				label : {
					emphasis : {
						show : false
					}
				},
				itemStyle : {
					normal : {
						areaColor : '#323c48',
						borderColor : '#111'
					},
					emphasis : {
						areaColor : '#2a333d'
					}
				}
			},
			series : [ {
				name : 'IP分布情况',
				type : 'scatter',
				coordinateSystem : 'geo',
				data : convertData([ {
					name : "北京",
					value : 9
				}, {
					name : "苏州",
					value : 12
				}, {
					name : "大连",
					value : 30
				}, {
					name : "沈阳",
					value : 100
				}/*, {
					name : "齐齐哈尔",
					value : 14
				}, {
					name : "盐城",
					value : 15
				}, {
					name : "赤峰",
					value : 16
				}, {
					name : "青岛",
					value : 18
				}, {
					name : "乳山",
					value : 18
				}, {
					name : "金昌",
					value : 19
				}*/ ]),
				symbolSize : 12,
				label : {
					normal : {
						show : false
					},
					emphasis : {
						show : false
					}
				},
				itemStyle : {
					emphasis : {
						borderColor : '#fff',
						borderWidth : 1
					}
				}
			} ]
		}
		myChart.setOption(option);
	}else if(type === 'biscuit'){
		$('#table').hide();
		$('#pillar').hide();
		$('#map').hide();
		$('#biscuit').show();
		console.log('option', option);
	}
	var myChart = echarts.init(document.getElementById('biscuit'));
	myChart.setOption(option);
};
$(function(){
	var sw = new Switch();
	$("#map").css("display", "none");
	$("#pillar").css("display", "none");
	$("#biscuit").css("display", "none");
	$('#amap').click(function(e){
		$.ajax({
			url : "MapServlet",
			dataType : "json",
			success : function(data){
				console.log(data);
				sw.render('map', data);
			},
			error : function(data){

			}
		});

	});
	$('#apillar').click(function(e){
		var ip = window.location.search.match(/ip:(\S+)(%20){0,1}/)[1];
		var os_v = window.location.search.match(/os:(\S+){0,1}/);
		var os = "linux' or os = 'windows";
		try{
			if(os_v){
				os = os_v[1];
			}
		}catch(e){

		}
		$.ajax({
			url : "PillarServlet",
			data : {
				'ip' : ip,
				'os' : os
			},
			dataType : "json",
			success : function(data){
				console.log(typeof data);
				console.log(data);
				sw.render('pillar', data)
			},
			error : function(err){
				console.log(err);
			}
		});
	});
	$('#atable').click(function(e){
		sw.render('table');
	});
	$('#abiscuit').click(function(e){
		var ip = window.location.search.match(/ip:(\S+)(%20){0,1}/)[1];
		var os_v = window.location.search.match(/os:(\S+){0,1}/);
		var os = "linux' or os = 'windows";
		try{
			if(os_v){
				os = os_v[1];
			}
		}catch(e){

		}
		$.ajax({
			url : "BiscuitServlet",
			data : {
				'ip' : ip,
				'os' : os
			},
			dataType : "json",
			success : function(data){
				console.log('biscuit');
				console.log(data);
				sw.render('biscuit', data);
			},
			error : function(err){
				console.log(err);
			}
		});
	});
})
