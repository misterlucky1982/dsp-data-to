package by.mlend.data.to;

import java.sql.Date;

public class RemainderTO implements TransferObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private long color;
	private long contractor;
	private long storage;
	private Date dateOfArival;
	private Date dateOfLeaving;
	private int height;
	private int width;
	private int thickness;
	private String remark;
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
	public long getColor() {
		return color;
	}
	public void setColor(long color) {
		this.color = color;
	}
	public long getContractor() {
		return contractor;
	}
	public void setContractor(long contractor) {
		this.contractor = contractor;
	}
	
	public Date getDateOfArival() {
		return dateOfArival;
	}
	public void setDateOfArival(Date dateOfArival) {
		this.dateOfArival = dateOfArival;
	}
	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}
	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getStorage() {
		return storage;
	}
	public void setStorage(long storage) {
		this.storage = storage;
	}
	@Override
	public String toString() {
		return "RemainderTO [id=" + id + ", name=" + name + ", color=" + color + ", contractor=" + contractor
				+ ", storage=" + storage + ", dateOfArival=" + dateOfArival + ", dateOfLeaving=" + dateOfLeaving
				+ ", height=" + height + ", width=" + width + ", thickness=" + thickness + ", remark=" + remark + "]";
	}
	
	

}
