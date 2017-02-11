$(function(){
	
	String.prototype.format = function() {
		var i = 0, args = arguments;
		return this.replace(/%s/g, function() {
			var v = args[i++];
			return v !== undefined ? v : '';
		});
	};
	
	$('.responsive-table-container').on('click','[role="delete"]',function(){
		var $this=$(this),
			url=$this.attr('href');
		$.post(url,function(data){
			alert(data.data);
			if(data.status){
				var $grid=$this.closest('table[role="grid"]');
				loadData($grid,1);
			}
		}).error(function(){
			alert('删除失败');
		});
		return false;
	});
	
	$('.pagination').on('click','li[alias="prev"]',function(){
		reload($(this),null,-1);
		return false;
	});
	$('.pagination').on('click','li[alias="next"]',function(){
		reload($(this),null,1);
		return false;
	});
	
	var reload=function($li,targetPageNo,delta){
		var pBar=$li.closest('.pagination'),
			p=pBar.data('pageInfo')||{},
			totalPage=p.totalPage|0,
			targetPageNo=targetPageNo||((p.pageNo||1)+delta);
		if(targetPageNo<1 || targetPageNo>totalPage){
			return false;
		}else{
			loadData(pBar.closest('table'),targetPageNo);
			return true;
		}
	};
	var loadData=function($grid,pageNo){
		var url=$grid.attr('url'),
			pBar=$grid.find('.pagination'),
			pageSize=pBar.attr('pageSize')||20,
			pBarControls=pBar.find('ul li:last'),
			pageNo=pageNo||1,
			html='',
			tbody=$grid.find('tbody').empty(),
			searchForm=$grid.attr('searchForm'),
			queryData=$('#'+searchForm).serialize();
		if(queryData!==''){
			queryData+='&';
		}
		queryData+=$.param({pageNo:pageNo,pageSize:pageSize});
		pBarControls.html('<a>正在加载数据...</a>');
		$.post(url,queryData,function(data){
			var headers=$grid.data('headers');
			$.each(data.list||[],function(index){
				var rowData=this;
				html+='<tr>';
				$.each(headers,function(i){
					var header=headers[i],
						clazz=header.clazz,
						cls=clazz?' class="%s"'.format(clazz):'',
						value='';
					if(header.field){
						try{
							value=eval('rowData.'+header.field);
						}catch(e){
						}
					}
					if(header.renderer){
						//function renderer(value,rowIndex,rowData)
						value=window[header.renderer].call(window,value,index,rowData);
					}
					html+='<td data-title="%s" %s>%s</td>'.format(header.label,cls,value);
				});
				;
				html+='</tr>';
			});
			tbody.append(html);
			refreshPagination(pBar,pageNo,data.count);
			pBarControls.html('<a>共<span>'+data.count+'</span>条记录</a>');
		}).error(function(){
			pBarControls.html('<a style="color:red">取数出错</a>');
		});
	};
	
	var refreshPagination=function(pBar,pageNo,count){
		var pageSize=pBar.attr('pageSize')||20,
			totalPage=count==0?0:parseInt((count-1)/pageSize+1),
			lis=pBar.find('li');
		if(pageNo==1){
			lis.eq(0).addClass('disabled');
		}else{
			lis.eq(0).removeClass('disabled');
		}
		var current=lis.eq(1);
		current.find('span:first').html(pageNo); //这里修改过
		current.find('span:last').html(totalPage);
		if(pageNo==totalPage || totalPage==0){
			lis.eq(2).addClass('disabled');
		}else{
			lis.eq(2).removeClass('disabled');
		}
		
		pBar.data('pageInfo',{pageNo:pageNo,pageSize:pageSize,count:count,totalPage:totalPage});
	}
	
	var pagingBarHtml=
		'<ul>'+
			'<li alias="prev" class="disabled"><a>«上一页</a></li>'+
			'<li alias="current" class="disabled"><a>第<span>1</span>/<span>0</span>页</a></li>'+
			'<li alias="next" class="disabled"><a>下一页 »</a></li>'+
			'<li alias="controls" class="disabled"></li>'+
		'</ul>'+
		'<div style="clear:both;"></div>';
	$('table[role="grid"]').each(function(){
		var self=this, 
			$this=$(this),
			headers=[];
		$this.addClass('table-bordered table-striped table-condensed');
		//初始化分页条
		$this.find('.pagination').html(pagingBarHtml);
		//没有tbody则加一个
		if($this.find('tbody').length==0){
			$this.append('<tbody></tbody>');
		}
		$this.find('thead th').each(function(){
			var _this=$(this);
			headers.push({
				label:_this.html(),
				clazz:_this.attr('class'),
				field:_this.attr('field'),
				renderer:_this.attr('renderer')
			});
		});
		$this.data('headers',headers);
		$this.data('orig-url',$this.attr('url'));
		loadData($this);
	});
	
	$('#search').click(function(){
		var searchForm=$(this).closest('form').attr('id'),
			$grid=$('table[searchForm="'+searchForm+'"]');
		loadData($grid,1);
	});
	
})