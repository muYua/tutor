package com.mupei.tutor.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mupei.tutor.dao.ReleaseDao;
import com.mupei.tutor.model.Release;
import com.mupei.tutor.service.ReleaseService;

@Service("releaseService")
public class ReleaseServiceImpl implements ReleaseService {
	@Autowired
	public ReleaseDao releaseDao; 
	
	@Override
	public void saveRelease(Release data) {
		releaseDao.save(data);
	}

	@Override
	public ArrayList<Release> getAll() {
		Iterable<Release> all = releaseDao.findAll();
		return (ArrayList<Release>) all;
	}

	@Override
	public void delete(Integer id) {
		releaseDao.deleteById(id);
	}

}
