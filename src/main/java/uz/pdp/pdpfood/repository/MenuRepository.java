package uz.pdp.pdpfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface MenuRepository extends JpaRepository<Menu, Long>, AbstractRepository {
}
