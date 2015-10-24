package com.maddogs.repo;

import com.maddogs.domain.*;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;

@Projection(name = "tagProjection", types = { Tag.class })
public interface TagProjection {

    int getNumberOfPeople();

    int getNumberOfDogs();

    LocalDateTime getCreatedDateTime();

    Location getPosition();

    TagType getTagType();

    List<Item> getNeedItems();
}
