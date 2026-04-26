//Amir Faraji

package org.example.car_rental_project.repos;
import org.example.car_rental_project.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {


    

    List <Car> findByBrand(String brand);

    List <Car> findByModel(String model);



@Query("SELECT c FROM Car c WHERE LOWER (c.brand) LIKE LOWER(CONCAT('%',:keyword,'%'))")
List<Car> searchByBrand (@Param("keyword") String keyword);



    @Modifying
    @Query("UPDATE Car c SET c.price = :price WHERE c.id = :id")
    int updatePriceById(@Param("id") Long id, @Param("price") Integer price);






}
