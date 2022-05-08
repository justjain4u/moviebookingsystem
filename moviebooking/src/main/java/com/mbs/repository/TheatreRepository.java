package com.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbs.entity.Theatre;

/**
 * 
 * @author vabhav.jain
 *
 */
@Repository
public interface TheatreRepository 
        extends JpaRepository<Theatre, Long> {
}
