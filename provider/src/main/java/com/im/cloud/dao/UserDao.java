package com.im.cloud.dao;

import com.im.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/9.
 */
@Repository
public interface UserDao extends JpaRepository<User,Long>{
}
