package com.maddogs.testdata;

import com.google.common.collect.Lists;
import com.maddogs.domain.*;
import com.maddogs.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Profile(value = "dev")
public class TestDataLoader {

    private TagTypeRepository tagTypeRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private OrganisationRepository organisationRepository;
    private NeedRepository needRepository;
    private TagRepository tagRepository;
    private InventoryRepository inventoryRepository;
    private RunRepository runRepository;
    private TestToolsRepository testToolsRepository;

    @Autowired
    public TestDataLoader(TagTypeRepository tagTypeRepository, ItemRepository itemRepository, UserRepository userRepository,
                          OrganisationRepository organisationRepository, NeedRepository needRepository, TagRepository tagRepository,
                          InventoryRepository inventoryRepository, RunRepository runRepository, TestToolsRepository testToolsRepository){
        this.tagTypeRepository = tagTypeRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.organisationRepository = organisationRepository;
        this.needRepository = needRepository;
        this.tagRepository = tagRepository;
        this.inventoryRepository = inventoryRepository;
        this.runRepository = runRepository;
        this.testToolsRepository = testToolsRepository;
    }

    @PostConstruct
    public void loadTestData(){

        // Tag Type
        TagType transientType = this.tagTypeRepository.save(tagType("Transient", Minutes.hours(6)));
        TagType settlementType = this.tagTypeRepository.save(tagType("Settlement", -1));
        TagType evictionType = this.tagTypeRepository.save(tagType("Eviction", Minutes.WEEK));

        this.testToolsRepository.flush();

        // Item
        Item sleepingBag = this.itemRepository.save(item("Sleeping Bag", Minutes.days(2)));
        Item socks = this.itemRepository.save(item("Socks", Minutes.DAY)); // 2 Days
        Item coat = this.itemRepository.save(item("Coat", Minutes.days(3)));

        this.testToolsRepository.flush();

        //User
        User user1 = this.userRepository.save(user("Bob","bob@bobmail.com","password"));
        User user2 = this.userRepository.save(user("Chris","chris@chrismail.com","password"));
        User user3 = this.userRepository.save(user("Dave","dave@davemail.com","password"));

        this.testToolsRepository.flush();

        //Organisation
        Organisation organisation1 = this.organisationRepository.save(organisation("Mad Dogs", Lists.newArrayList(user1, user3)));

        this.testToolsRepository.flush();

        //Need
        Need sleepingBagNeed = need(sleepingBag);
        Need socksNeed = need(socks);
        Need coatNeed = need(coat);

        //Tag
        Tag sleepingBagTag = this.tagRepository.save(tag(user1, transientType, 1, 0, Lists.newArrayList(sleepingBagNeed), 53.476502, -2.254252));
        Tag socksTag = this.tagRepository.save(tag(user2, transientType, 1, 1, Lists.newArrayList(socksNeed), 53.475870, -2.250840));
        Tag coatTag = this.tagRepository.save(tag(user3, settlementType, 15, 3, Lists.newArrayList(coatNeed), 53.471586, -2.238470));

        this.testToolsRepository.flush();

        //Inventory
        Inventory sleepingBagInventory = inventory(sleepingBag);
        Inventory socksInventory = inventory(socks);
        Inventory coatInventory = inventory(coat);

//        sleepingBagInventory.setFulfilled(sleepingBagNeed);

        //Run
        Run run1 = this.runRepository.save(run(user3, Lists.newArrayList(sleepingBagInventory,socksInventory,coatInventory)));
    }

    private TagType tagType(String type, int expiryTime){
        TagType tagType = new TagType();
        tagType.setType(type);
        tagType.setExpiryTime(expiryTime);
        return tagType;
    }

    private Item item(String description, int sourcingTime){
        Item item = new Item();
        item.setDescription(description);
        item.setSourcingTime(sourcingTime);
        return item;
    }

    private User user(String name, String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    private Organisation organisation(String name, List<User> users){
        Organisation organisation = new Organisation();
        organisation.setName(name);
        organisation.setUsers(users);
        return organisation;
    }

    private Need need(Item item){
        Need need = new Need();
        need.setItem(item);
        return need;
    }

    private Tag tag(User user, TagType tagType, int numberOfPeople, int numberOfDogs, List<Need> needs, double lat, double lng){
        Tag tag = new Tag();
        tag.setCreatedDateTime(LocalDateTime.now());
        tag.setCreator(user);
        tag.setTagType(tagType);
        tag.setNumberOfPeople(numberOfPeople);
        tag.setNumberOfDogs(numberOfDogs);
        tag.setNeeds(needs);
        Location position = new Location(lat, lng);
        tag.setPosition(position);
        return tag;
    }

    private Inventory inventory(Item item){
        Inventory inventory = new Inventory();
        inventory.setItem(item);
        return inventory;
    }

    private Run run(User user, List<Inventory> inventories){
        Run run = new Run();
        run.setCreatedDateTime(LocalDateTime.now());
        run.setCreator(user);
        run.setInventory(inventories);
        return run;
    }
}
