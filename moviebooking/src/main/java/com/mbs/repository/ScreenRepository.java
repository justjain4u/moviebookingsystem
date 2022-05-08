package com.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbs.entity.Screen;

/**
 * 
 * @author vabhav.jain
 *
 */
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

}
