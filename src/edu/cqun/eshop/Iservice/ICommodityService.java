package edu.cqun.eshop.Iservice;

import edu.cqun.eshop.domain.Commodity;

public interface ICommodityService {
	boolean addCommodity(Commodity c);
	boolean deleteCommodity(Commodity c);
	boolean modifyCommodity(Commodity origin,Commodity update);
	boolean queryCommodityByExample(Commodity c);
}
