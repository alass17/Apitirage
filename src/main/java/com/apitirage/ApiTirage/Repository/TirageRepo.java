package com.apitirage.ApiTirage.Repository;

import com.apitirage.ApiTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepo extends JpaRepository<Tirage,Long> {
}
