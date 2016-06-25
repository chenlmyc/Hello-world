

var myChart1 = echarts.init(document.getElementById('main1'), theme);

var dataMap = {
	paonan: [{name: '广东', value: 9690},
		{name: '浙江', value: 9519},
		{name: '山东', value: 8081},
		{name: '江苏', value: 7732},
		{name: '北京', value: 7654},
		{name: '河南', value: 6731},
		{name: '湖北', value: 5697},
		{name: '陕西', value: 5420},
		{name: '辽宁', value: 5342},
		{name: '河北', value: 5233},
		{name: '上海', value: 4719},
		{name: '福建', value: 4432},
		{name: '安徽', value: 4321},
		{name: '湖南', value: 3980},
		{name: '四川', value: 3765},
		{name: '广西', value: 3320},
		{name: '山西', value: 3201},
		{name: '黑龙江', value: 3109},
		{name: '吉林', value: 2901},
		{name: '天津', value: 2884},
		{name: '江西', value: 2543},
		{name: '重庆', value: 2333},
		{name: '内蒙古', value: 2190},
		{name: '云南', value: 1953},
		{name: '贵州', value: 1722},
		{name: '甘肃', value: 1521},
		{name: '新疆', value: 1409},
		{name: '海南', value: 1182},
		{name: '宁夏', value: 938},
		{name: '青海', value: 875},
		{name: '香港', value: 665},
		{name: '台湾', value: 453},
		{name: '西藏', value: 432}],
	paonan1: {
		attributes: ['广东', '浙江', '山东', '江苏', '北京', '河南', '湖北', '陕西', '辽宁', '河北',
			'上海', '福建', '安徽', '湖南', '四川', '广西', '山西', '黑龙江', '吉林', '天津',
			'江西', '重庆', '内蒙古', '云南', '贵州', '甘肃', '新疆', '海南', '宁夏', '青海',
			'香港', '台湾', '西藏'],
		values: [5690, 5219, 5081, 4732, 4435, 4031, 3897, 3820, 3710, 3633, 3519, 3342, 3121, 2980, 2765, 2320,
			2201, 2109, 2001, 1984, 1843, 1633, 1590, 1453, 1322, 1221, 1109, 1082, 998, 876, 765, 453, 432]

	},
	quanyuan1: {
		attributes: ['浙江', '广东', '江苏', '北京', '河南', '山东', '湖南', '福建', '上海', '湖北', '四川',
			'河北', '辽宁', '广西', '安徽', '天津', '陕西', '重庆', '山西', '黑龙江', '江西', '云南',
			'贵州', '内蒙古', '海南', '甘肃', '新疆', '香港', '台湾', '宁夏', '青海', '西藏'],
		values: [5690, 5219, 5081, 4732, 4435, 4031, 3897, 3820, 3710, 3633, 3519, 3342, 3121, 2980, 2765, 2320,
			2201, 2109, 2001, 1984, 1843, 1633, 1590, 1453, 1322, 1221, 1109, 1082, 998, 876, 765, 453, 432]

	},

	quanyuan: [
		{name: '浙江', value: 5690},
		{name: '广东', value: 5219},
		{name: '江苏', value: 5081},
		{name: '北京', value: 4732},
		{name: '河南', value: 4435},
		{name: '山东', value: 4031},
		{name: '湖南', value: 3897},
		{name: '福建', value: 3820},
		{name: '上海', value: 3710},
		{name: '湖北', value: 3633},
		{name: '四川', value: 3519},
		{name: '河北', value: 3342},
		{name: '辽宁', value: 3121},
		{name: '广西', value: 2980},
		{name: '安徽', value: 2765},
		{name: '天津', value: 2320},
		{name: '陕西', value: 2201},
		{name: '重庆', value: 2109},
		{name: '山西', value: 2001},
		{name: '黑龙江', value: 1984},
		{name: '江西', value: 1843},
		{name: '吉林', value: 1633},
		{name: '云南', value: 1590},
		{name: '贵州', value: 1453},
		{name: '内蒙古', value: 1322},
		{name: '海南', value: 1221},
		{name: '甘肃', value: 1109},
		{name: '新疆', value: 1082},
		{name: '香港', value: 998},
		{name: '台湾', value: 876},
		{name: '宁夏', value: 765},
		{name: '青海', value: 453},
		{name: '西藏', value: 432}],

};

var option1 = {
	title: {
		text: '影视大数据人物画像',
		subtext: '纯属虚构',
		x: 'center'
	},
	tooltip: {
		trigger: 'item'
	},
	legend: {
		orient: 'vertical',
		x: 'left',
		data: ['奔跑吧兄弟', '全员加速中']
	},
	dataRange: {
		min: 0,
		max: 15000,
		x: 'left',
		y: 'bottom',
		text: ['高', '低'],           // 文本，默认为数值文本
		calculable: true
	},
	toolbox: {
		show: true,
		orient: 'vertical',
		x: 'right',
		y: 'center',
		feature: {
			mark: {show: true},
			dataView: {show: true, readOnly: false},
			magicType: {show: true, type: ['line', 'bar']},
			restore: {show: true},
			saveAsImage: {show: true}
		}
	},
	roamController: {
		show: true,
		x: 'right',
		mapTypeControl: {
			'china': true
		}
	},
	series: [

		{
			name: '奔跑吧兄弟',
			type: 'map',
			mapType: 'china',
			roam: false,
			itemStyle: {
				normal: {label: {show: true}},
				emphasis: {label: {show: true}}
			},
			data: dataMap.paonan
		},
		{
			name: '全员加速中',
			type: 'map',
			mapType: 'china',
			itemStyle: {
				normal: {label: {show: true}},
				emphasis: {label: {show: true}}
			},
			data: dataMap.quanyuan
		}
	]
};

myChart1.setOption(option1);

option2 = {
	calculable: true,
	xAxis: [
		{
			type: 'value',
			position: 'top',
			boundaryGap: [0, 0.01]
		}
	],
	yAxis: [
		{
			type: 'category',
			data: dataMap.paonan1.attributes.reverse()
		}
	],
	series: [
		{
			name: '奔跑吧兄弟',
			type: 'bar',
			data: dataMap.paonan1.values.reverse()
		},
		/*{
		 name:'全员加速中',
		 show:false,
		 type:'bar',
		 data:dataMap.quanyuan1.values.reverse()
		 }*/
	]

};

myChart2 = echarts.init(document.getElementById('main2'), theme);
myChart2.setOption(option2);

myChart3 = echarts.init(document.getElementById('main3'), theme);
option3 = {
	tooltip : {
		trigger: 'item',
		formatter: "{a} <br/>{b} : {c} ({d}%)"
	},
	legend: {
		orient : 'vertical',
		x : 'left',
		data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
	},
	toolbox: {
		show : true,
		feature : {
			mark : {show: true},
			dataView : {show: true, readOnly: false},
			magicType : {
				show: true,
				type: ['pie', 'funnel'],
				option: {
					funnel: {
						x: '25%',
						width: '50%',
						funnelAlign: 'center',
						max: 1548
					}
				}
			},
			restore : {show: true},
			saveAsImage : {show: true}
		}
	},
	calculable : true,
	series : [
		{
			name:'访问来源',
			type:'pie',
			radius : ['50%', '70%'],
			itemStyle : {
				normal : {
					label : {
						show : false
					},
					labelLine : {
						show : false
					}
				},
				emphasis : {
					label : {
						show : true,
						position : 'center',
						textStyle : {
							fontSize : '30',
							fontWeight : 'bold'
						}
					}
				}
			},
			data:[
				{value:335, name:'直接访问'},
				{value:310, name:'邮件营销'},
				{value:234, name:'联盟广告'},
				{value:135, name:'视频广告'},
				{value:1548, name:'搜索引擎'}
			]
		}
	]
};

myChart3.setOption(option3);
myChart4 = echarts.init(document.getElementById('main4'), theme);
option4 = {
	title : {
		text: '某电影票房情况',
		subtext: '纯属虚构'
	},
	tooltip : {
		trigger: 'axis'
	},
	legend: {
		data:['预定','票房','满意度']
	},
	toolbox: {
		show : true,
		feature : {
			mark : {show: true},
			dataView : {show: true, readOnly: false},
			magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
			restore : {show: true},
			saveAsImage : {show: true}
		}
	},
	calculable : true,
	xAxis : [
		{
			type : 'category',
			boundaryGap : false,
			data : ['周一','周二','周三','周四','周五','周六','周日']
		}
	],
	yAxis : [
		{
			type : 'value'
		}
	],
	series : [
		{
			name:'预定',
			type:'line',
			smooth:true,
			itemStyle: {normal: {areaStyle: {type: 'default'}}},
			data:[10, 12, 21, 54, 260, 830, 710]
		},
		{
			name:'票房',
			type:'line',
			smooth:true,
			itemStyle: {normal: {areaStyle: {type: 'default'}}},
			data:[30, 182, 434, 791, 390, 30, 10]
		},
		{
			name:'满意度',
			type:'line',
			smooth:true,
			itemStyle: {normal: {areaStyle: {type: 'default'}}},
			data:[1320, 1132, 601, 234, 120, 90, 20]
		}
	]
};
myChart4.setOption(option4);
