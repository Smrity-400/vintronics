package edu.rims.vintronics.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.vintronics.entity.Widget;
import edu.rims.vintronics.constant.WidgetStatus;

public interface WidgetRepository extends JpaRepository<Widget, String> {
    List<Widget> findByWidgetStatus(WidgetStatus widgetStatus, Sort sort);
}
