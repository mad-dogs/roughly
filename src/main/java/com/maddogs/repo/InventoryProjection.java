package com.maddogs.repo;

import com.maddogs.domain.*;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;

@Projection(name = "inventoryProjection", types = { Inventory.class })
public interface InventoryProjection {

    long getItemId();
}
