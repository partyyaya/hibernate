package tw.ming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//以下為hibernate註解式 增刪改查
//記得改完還要去hibernate.cfg.xml增加配置
@Entity //代表映射實體
@Table(name="teacher")  //代表要映射的資料表
public class teacher {
	private long id;
	private String name;
	
	@Id
	@GeneratedValue(generator="_native") 
	//generator需跟GenericGenerator的name依樣(映射)>>_native只是名稱可以改變
	//strategy="native"為自增長
	@GenericGenerator(name="_native",strategy="native")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "teacher [id=" + id + ", name=" + name + "]";
	}
	
}
