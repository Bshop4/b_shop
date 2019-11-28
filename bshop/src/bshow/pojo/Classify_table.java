package bshow.pojo;

import java.io.Serializable;
/**
 * 商品分类表
 * @author 10415
 *
 */
public class Classify_table implements Serializable{
	
	private String classify_id;
	private String classify_one;
	private String classify_two;
	public String getClassify_id() {
		return classify_id;
	}
	public void setClassify_id(String classify_id) {
		this.classify_id = classify_id;
	}
	public String getClassify_one() {
		return classify_one;
	}
	public void setClassify_one(String classify_one) {
		this.classify_one = classify_one;
	}
	public String getClassify_two() {
		return classify_two;
	}
	public void setClassify_two(String classify_two) {
		this.classify_two = classify_two;
	}
	

}
