package bshow.dao;

import java.util.List;

public interface Basedao {
	//id为pojo对象里mapping.xml的属性值，o为实体对象
	public void saveObject(String id ,Object o);
	public List<Object> select(String id,Object o);
}

