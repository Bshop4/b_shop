package bshow.dao;

import java.util.List;
import java.util.Map;

import bshow.dto.Goods_classify;
import bshow.web.servlet.form.GoodsByConditionsActionForm;

public interface Basedao {
	// id为pojo对象里mapping.xml的属性值，o为实体对象
	public boolean saveObject(String id, Object o);

//	删除
	public boolean deleteObject(String id, Object o);

//	修改
	public boolean updataObject(String id, Object o);

//	选择
	public List<Object> select(String id, Object o);

	public List<Object> selectByPagesize(String id, Object o, int page, int pagesize);

	public int selectMaxPagesize(String id, Object o, int pagesize);

	public Map<String, List<Goods_classify>> selectGoodsByConditions(GoodsByConditionsActionForm form);

	public boolean insertMachTable(String id, Object o);
}
