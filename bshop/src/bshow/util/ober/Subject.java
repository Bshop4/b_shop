package bshow.util.ober;

import java.util.List;
import java.util.Map;

import bshow.dao.impl.Basedaoimpl;
import bshow.dto.Goods_classify;
import bshow.util.MyReplace;

public interface Subject {
	public void addLooker(Looker looker);
	public void removeLooker(Looker looker);
	public void notifyAllLooker(Map<String,List<Goods_classify>> mymap);
}
