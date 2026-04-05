package org.projectwork.reshare.model.services.implementations;

import org.projectwork.reshare.exceptions.EntityNotFoundException;
import org.projectwork.reshare.model.AppUser;
import org.projectwork.reshare.model.Category;
import org.projectwork.reshare.model.City;
import org.projectwork.reshare.model.Item;
import org.projectwork.reshare.model.repositories.abstractions.AppUserRepository;
import org.projectwork.reshare.model.repositories.abstractions.CategoryRepository;
import org.projectwork.reshare.model.repositories.abstractions.CityRepository;
import org.projectwork.reshare.model.repositories.abstractions.ItemRepository;
import org.projectwork.reshare.model.services.abstractions.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {
    private ItemRepository itemRepo;
    private CategoryRepository catRepo;
    private CityRepository cityRepo;
    private FileUploadService fileUploadService;

    public ItemServiceImp(ItemRepository itemRepo, CategoryRepository catRepo, CityRepository cityRepo,
            FileUploadService fileUploadService) {
        this.itemRepo = itemRepo;
        this.catRepo = catRepo;
        this.cityRepo = cityRepo;
        this.fileUploadService = fileUploadService;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Category findCategoryByName(String name) {
        return catRepo.findByName(name);
    }

    @Override
    public City findCityByName(String name) {
        return cityRepo.findByName(name);
    }

    @Override
    public Item findItemById(long id) throws EntityNotFoundException {
        Optional<Item> opItem = itemRepo.findById(id);
        if (opItem.isEmpty()) {
            throw new EntityNotFoundException(opItem.getClass(), id);
        }
        return opItem.get();
    }

    @Override
    public String saveItemCover(MultipartFile file) throws IOException {
        return fileUploadService.saveFile(file);
    }

}
