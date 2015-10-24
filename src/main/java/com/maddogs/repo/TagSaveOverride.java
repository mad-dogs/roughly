package com.maddogs.repo;

import com.maddogs.domain.Tag;
import com.maddogs.domain.TagType;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TagSaveOverride extends AbstractRepositoryEventListener<Tag> {
    @Override
    public void onBeforeCreate(Tag tag){
        // Set the expired time to be the time set by the tagtype.
        TagType type = tag.getTagType();
        LocalDateTime expiredDateTime = LocalDateTime.now();
        expiredDateTime = expiredDateTime.plusMinutes(type.getExpiryTime());
        tag.setExpiredDateTime(expiredDateTime);
        tag.setCreatedDateTime(LocalDateTime.now());
    }
}
