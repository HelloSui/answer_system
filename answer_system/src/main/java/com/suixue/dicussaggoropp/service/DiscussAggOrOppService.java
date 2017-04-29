package com.suixue.dicussaggoropp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suixue.common.BaseDao;
import com.suixue.common.BaseService;
import com.suixue.dicussaggoropp.dao.DiscussAggOrOppDao;
import com.suixue.dicussaggoropp.domain.DiscussAggOrOpp;
import com.suixue.question.domain.Type;


@Service
public class DiscussAggOrOppService extends BaseService<DiscussAggOrOpp, BaseDao<DiscussAggOrOpp>> {
	@Autowired
	private DiscussAggOrOppDao discussAggOrOppDao;
	@Autowired
	private DiscussAggOrOppService discussAggOrOppService;
	
	public int agree(DiscussAggOrOpp discussAggOrOpp){
		DiscussAggOrOpp param = new DiscussAggOrOpp();
		param.setDiscussId(discussAggOrOpp.getDiscussId());
		param.setUserId(discussAggOrOpp.getUserId());
		DiscussAggOrOpp discussAggOrOppList = discussAggOrOppService.get(discussAggOrOpp);
		if(discussAggOrOppList == null){
			param.setAgreeOrOppose(1);
			discussAggOrOppService.insert(param);
			return 1;//表示此前该记录不存在，赞同数应该加1
		}else{
			int num = discussAggOrOpp.getAgreeOrOppose();
			if(num == 1){
				return 0;//表示已赞过，赞同数不变
			}else{
				discussAggOrOppService.delete(discussAggOrOppList);
				param.setAgreeOrOppose(1);
				discussAggOrOppService.insert(param);
				return 2;//表示之前是反对票，如今改为赞同票，该回答的赞同数加1 ，反对数-1
			}
		}
	}
	
	public int oppose(DiscussAggOrOpp discussAggOrOpp){
		DiscussAggOrOpp param = new DiscussAggOrOpp();
		param.setDiscussId(discussAggOrOpp.getDiscussId());
		param.setUserId(discussAggOrOpp.getUserId());
		DiscussAggOrOpp discussAggOrOppList = discussAggOrOppService.get(discussAggOrOpp);
		if(discussAggOrOppList == null){
			param.setAgreeOrOppose(2);
			discussAggOrOppService.insert(param);
			return 1;//表示此前该记录不存在，反对数应该加1
		}else{
			int num = discussAggOrOpp.getAgreeOrOppose();
			if(num == 2){
				return 0;//表示已反对，反对数不变
			}else{
				discussAggOrOppService.delete(discussAggOrOppList);
				param.setAgreeOrOppose(2);
				discussAggOrOppService.insert(param);
				return 2;//表示之前是反对票，如今改为赞同票，该回答的反对数加1 ，赞同数-1
			}
		}
	}

}