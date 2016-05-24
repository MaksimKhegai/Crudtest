package com.liferay.test.portlet;
import java.util.List;


public class PermissionClass {
	public boolean view;
	public boolean update;
	public boolean delete;
	public boolean add;
	
	public PermissionClass() {
		
	}
	
	public boolean getView() {
		return view;
	}
	
	public boolean getUpdate() {
		return update;
	}
	
	public boolean getDelete() {
		return delete;
	}
	
	public boolean getAdd() {
		return add;
	}
}
