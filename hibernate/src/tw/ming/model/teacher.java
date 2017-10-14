package tw.ming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//�H�U��hibernate���Ѧ� �W�R��d
//�O�o�粒�٭n�hhibernate.cfg.xml�W�[�t�m
@Entity //�N��M�g����
@Table(name="teacher")  //�N��n�M�g����ƪ�
public class teacher {
	private long id;
	private String name;
	
	@Id
	@GeneratedValue(generator="_native") 
	//generator�ݸ�GenericGenerator��name�̼�(�M�g)>>_native�u�O�W�٥i�H����
	//strategy="native"���ۼW��
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
