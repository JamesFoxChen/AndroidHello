package com.example.jarDemo;

import com.alibaba.fastjson.JSON;
import com.example.bean.Person;

public class FastJson {

	public static void Enter() {
		Person p=new Person();
		p.setAge(22);
		p.setName("James");
		String jsonString = JSON.toJSONString(p);  //ʵ����ת����json�ַ���
		
		p.setAge(33);
		p.setName("Mary");
		String maryJsonString = JSON.toJSONString(p);
		Person pd=JSON.parseObject(maryJsonString,Person.class);  //josn�ַ���ת����ʵ����
	}
}
