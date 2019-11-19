package com.mupei.tutor.service;

import java.util.ArrayList;

import com.mupei.tutor.model.Release;

public interface ReleaseService {

	public void saveRelease(Release data);

	public ArrayList<Release> getAll();

	public void delete(Integer id);

}
