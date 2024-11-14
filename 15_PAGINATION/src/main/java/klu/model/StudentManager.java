package klu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import klu.repository.UserRepository;

@Service
public class StudentManager {
	@Autowired
	UserRepository UR;
	public String getData(Long cPage,Long pSize)
	{
		List<String> slist = new ArrayList<String>();
		for(Student S : UR.findAll(PageRequest.of(cPage.intValue(), pSize.intValue())))
		{
			slist.add(toJson(S));
		}
		return slist.toString();
	}
	
	public String toJson(Object obj)
	{
		GsonBuilder GB = new GsonBuilder();
		Gson G = GB.create();
		return G.toJson(obj);
	}
	//Paging
	public List<String> getPaging(Long pSize)
	{
		Long totRec= UR.totRecords();
		Long pages = (totRec/pSize)+ ((totRec%pSize==0)?0:1);
		
		Long startIndex=1L;
		Long endIndex=pages;
		
		List<String> plist = new ArrayList<String>();
		
		for(Long i =startIndex;i<=endIndex;i++)
		{
			plist.add(i.toString());
		}
		return plist;
	}
}
