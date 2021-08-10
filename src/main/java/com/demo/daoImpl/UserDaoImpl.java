package com.demo.daoImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.dao.UserDao;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{

}
