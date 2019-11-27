package bshow.util.ober;

import java.util.List;
import java.util.Map;

import bshow.dto.Goods_classify;
import bshow.util.MyReplace;

public interface Looker {
	public void update(Map<String,List<Goods_classify>> mymap);
}
