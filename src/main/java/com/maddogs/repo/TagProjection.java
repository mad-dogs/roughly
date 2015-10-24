package com.maddogs.repo;

import com.maddogs.domain.Location;
import com.maddogs.domain.Need;
import com.maddogs.domain.Tag;
import com.maddogs.domain.TagType;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;

@Projection(name = "tagProjection", types = { Tag.class })
public interface TagProjection {

    List<Need> getNeeds();

    LocalDateTime getCreatedDateTime();

    int getNumberOfPeople();

    int getNumberOfDogs();

    Location getPosition();

    TagType getTagType();
}
