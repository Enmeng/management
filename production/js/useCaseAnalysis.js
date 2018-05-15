$(function() {
                  var data = [
                              {name : '文学',value : 10430,color:'#4572a7'},
                              {name : '经济',value : 9579,color:'#4572a7'},
                              {name : '语言',value : 9402,color:'#4572a7'},
                              {name : '艺术',value : 8041,color:'#4572a7'},
                              {name : '历史、地理',value : 7865,color:'#4572a7'},
                              {name : '自然科学',value : 7185,color:'#4572a7'},
                              {name : '生物科学',value : 6568,color:'#4572a7'},
                              {name : '哲学',value : 5950,color:'#4572a7'},
                              {name : '军事',value : 5723,color:'#4572a7'},
                              {name : '社会科学',value : 5442,color:'#4572a7'},
                              {name : '天文学',value : 4602,color:'#4572a7'},
                              {name : '农业科学',value : 4596,color:'#4572a7'},
                              {name : '工业技术',value : 4456,color:'#4572a7'},
                              {name : '交通运输',value : 4374,color:'#4572a7'},
                              {name : '航空、航天',value : 3831,color:'#4572a7'},
                              {name : '环境科学、安全科学',value : 3732,color:'#4572a7'},
                              {name : '数理科学',value : 3632,color:'#4572a7'},
                              {name : '体育',value : 3571,color:'#4572a7'},
                              {name : '综合性图书',value : 3474,color:'#4572a7'}
                              
                        ];
                  
                  var chart = new iChart.Column2D({
                        render : 'canvasDiv',
                        data : data,
                        title : {
                              text : '本月不同类型图书借用情况',
                              color : '#3e576f'
                        },
                        subtitle : {
                              text : '图表展示了19种图书的使用情况',
                              color : '#6d869f'
                        },
                        // footnote : {
                        //       text : 'ichartjs.com',
                        //       color : '#909090',
                        //       fontsize : 11,
                        //       padding : '0 38'
                        // },
                        width : 900,
                        height : 460,
                        label : {
                              fontsize:11,
                              textAlign:'right',
                              textBaseline:'middle',
                              rotate:-45,
                              color : '#666666'
                        },
                        tip:{
                              enable:true,
                              listeners:{
                                     //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
                                    parseText:function(tip,name,value,text,i){
                                          //将数字进行千位格式化
                                          var f = new String(value);
                                          f = f.split("").reverse().join("").replace(/(\d{3})/g,"$1,").split("").reverse();
                                          if(f[0]==','){
                                                f.shift();
                                          }     
                                          f = f.join("");
                                          
                                          return name+":<br/>"+f+"本<br/>占所借出图书比重:<br/>"+(value/this.get('total') * 100).toFixed(2)+ '%';
                                    }
                              }
                        },
                        shadow : true,
                        shadow_blur : 2,
                        shadow_color : '#aaaaaa',
                        shadow_offsetx : 1,
                        shadow_offsety : 0,
                        column_width : 62,
                        sub_option : {
                              label : false,
                              border : {
                                    width : 2,
                                    color : '#ffffff'
                              }
                        },
                        coordinate : {
                              background_color : null,
                              grid_color : '#c0c0c0',
                              width : 660,
                              height:240,
                              axis : {
                                    color : '#c0d0e0',
                                    width : [0, 0, 1, 0]
                              },
                              scale : [{
                                    position : 'left',
                                    start_scale : 0,
                                    end_scale : 11000,
                                    scale_space : 1000,
                                    scale_enable : false,
                                    label : {
                                          fontsize:11,
                                          color : '#666666'
                                    },
                                    listeners:{
                                          parseText:function(t,x,y){
                                                return {text:t}
                                          }
                                     }
                              }]
                        }
                  });
                  
                  //利用自定义组件构造左侧说明文本
                  chart.plugin(new iChart.Custom({
                              drawFn:function(){
                                    //计算位置
                                    var coo = chart.getCoordinate(),
                                          x = coo.get('originx'),
                                          y = coo.get('originy');
                                    //在左上侧的位置，渲染一个单位的文字
                                    chart.target.textAlign('start')
                                    .textBaseline('bottom')
                                    .textFont('600 11px Verdana')
                                    .fillText('图书总数(本)',x-40,y-10,false,'#6d869f');
                                    
                              }
                  }));
                  
                  chart.draw();
});



$(function(){
				var flow=[];
				var number=[1000,2000,1442,1111,2311,2010,1003,2003,1200,2100,1022,1223]
				for(var i=0;i<12;i++){
					flow.push(number[i]);
				}
				
				var data = [
				         	{
				         		name : '总册数',
				         		value:flow,
				         		color:'#0d8ecf',
				         		line_width:2
				         	}
				         ];
		         
				var labels = ["01","02","03","04","05","06","07","08","09","10","11","12"];
				
				var line = new iChart.LineBasic2D({
					render : 'canvasMonth',
					data: data,
					align:'center',
					title : '本年度每月的图书使用情况',
					subtitle : '图表展示了每个月图书的借阅量(单位：本)',
					// footnote : '数据来源：模拟数据',
					width : 900,
					height : 400,
					sub_option:{
						smooth : true,//平滑曲线
						point_size:10
					},
					tip:{
						enable:true,
						shadow:true
					},
					legend : {
						enable : false
					},
					crosshair:{
						enable:true,
						line_color:'#62bce9'
					},
					coordinate:{
						width:600,
						valid_width:500,
						height:260,
						axis:{
							color:'#9f9f9f',
							width:[0,0,2,2]
						},
						grids:{
							vertical:{
								way:'share_alike',
						 		value:12
							}
						},
						scale:[{
							 position:'left',	
							 start_scale:0,
							 end_scale:3000,
							 scale_space:200,
							 scale_size:2,
							 scale_color:'#9f9f9f'
						},{
							 position:'bottom',	
							 labels:labels
						}]
					}
				});
			//开始画图
			line.draw();
		});