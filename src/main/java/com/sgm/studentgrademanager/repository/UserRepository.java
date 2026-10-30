package com.sgm.studentgrademanager.repository;

import com.sgm.studentgrademanager.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {

}
