package com.datafirstapproach.flywaymigrationdatafirstapproach.Repository;

import com.datafirstapproach.flywaymigrationdatafirstapproach.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
