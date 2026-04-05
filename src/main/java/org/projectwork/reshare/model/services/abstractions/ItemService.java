package org.projectwork.reshare.model.services.abstractions;

import org.projectwork.reshare.exceptions.EntityNotFoundException;
import org.projectwork.reshare.model.AppUser;
import org.projectwork.reshare.model.Category;
import org.projectwork.reshare.model.City;
import org.projectwork.reshare.model.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ItemService {
    Item saveItem(Item item);

    Category findCategoryByName(String name);

    City findCityByName(String name);

    Item findItemById(long id) throws EntityNotFoundException;

    String saveItemCover(MultipartFile file) throws IOException;
}
