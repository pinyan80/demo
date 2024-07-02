package com.collect.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CollectService")
public class CollectService {

	@Autowired
	CollectRepository repository;

	@Autowired
	private SessionFactory sessionFactory;

	public void addCollect(CollectVO collectVO) {
		repository.save(collectVO);
	}

	public void updateCollect(CollectVO collectVO) {
		repository.save(collectVO);
	}

	public CollectVO getOneCollect(Integer id) {
		Optional<CollectVO> optional = repository.findById(id);
		return optional.orElse(null);
	}

	public List<CollectVO> getAll() {
		return repository.findAll();
	}

	public List<CollectVO> getAllByMember(int memNo, int favorite) {
		List<CollectVO> list;

		if (favorite == 0) {
			list = repository.findAllLikeByMemNo(memNo);
		} else {
			list = null;
		}
		return list;

	}
}
