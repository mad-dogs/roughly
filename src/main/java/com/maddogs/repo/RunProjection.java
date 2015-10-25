package com.maddogs.repo;

import com.maddogs.domain.Item;
import com.maddogs.domain.Run;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "runProjection", types = {Run.class})
public interface RunProjection {

    List<Item> getInventoryItems();
}
